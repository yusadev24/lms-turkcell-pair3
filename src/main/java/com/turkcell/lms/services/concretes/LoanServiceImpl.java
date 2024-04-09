package com.turkcell.lms.services.concretes;

import com.turkcell.lms.core.utils.exceptions.types.BusinessException;
import com.turkcell.lms.entities.Book;
import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.entities.Member;
import com.turkcell.lms.repositories.LoanRepository;
import com.turkcell.lms.services.abstracts.BookService;
import com.turkcell.lms.services.abstracts.LoanService;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.dtos.requests.loan.AddLoanRequest;
import com.turkcell.lms.services.dtos.requests.loan.UpdateLoanRequest;
import com.turkcell.lms.services.dtos.responses.book.GetByIdBookResponse;
import com.turkcell.lms.services.dtos.responses.loan.AddLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.GetByIdLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.ListLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.UpdateLoanResponse;
import com.turkcell.lms.services.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.services.mappers.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    @Autowired
    private final LoanRepository loanRepository;
    private final MemberService memberService;
    private final BookService bookService;

    @Override
    public List<ListLoanResponse> getAll() {
        List<Loan> loans = loanRepository.findAll();
        return LoanMapper.INSTANCE.loansToListLoanResponses(loans);
    }


    public AddLoanResponse addLoan(AddLoanRequest request) {

        Optional<Member> memberOptional = memberService.getMemberEntity(request.getMemberId());
        // TODO: doğru bir şekilde kitap kontrol edilmiyor
        bookService.isIdExisted(request.getBookId());
        Optional<Book> bookOptional = bookService.getBookEntity(request.getBookId());

        Loan loan = LoanMapper.INSTANCE.loanFromAddLoanRequest(request);

        bookOptional.ifPresent(book->loan.setBook(book));
        memberOptional.ifPresent(member->loan.setMember(member));

        Loan savedLoan = loanRepository.save(loan);

        return new AddLoanResponse(
                savedLoan.getId(),
                savedLoan.getBook().getId(),
                savedLoan.getMember().getId(),
                savedLoan.getDateBorrowed(),
                savedLoan.getDueDate(),
                savedLoan.getDateReturned(),
                savedLoan.getStatus()
        );
    }

    @Override
    public void deleteLoanById(int id) {
        isIdExisted(id);
        loanRepository.deleteById(id);
    }

    @Override
    public Optional<GetByIdLoanResponse> getById(int id) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        isIdExisted(id);
        return loanOptional.map(LoanMapper.INSTANCE::mapToGetByIdLoanResponse);
    }
    @Override
    public UpdateLoanResponse updateLoan(int id, UpdateLoanRequest request) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        UpdateLoanResponse response = new UpdateLoanResponse();

        loanOptional.ifPresent(loan -> {
            Loan updatedloan = LoanMapper.INSTANCE.updateLoanFromRequest(request, loan);

            Loan savedLoan = loanRepository.save(updatedloan);

            response.setId(savedLoan.getId());
            response.setBookId(savedLoan.getBook().getId());
            response.setMemberId(savedLoan.getMember().getId());
            response.setDateBorrowed(savedLoan.getDateBorrowed());
            response.setDueDate(savedLoan.getDueDate());
            response.setDateReturned(savedLoan.getDateReturned());
            response.setStatus(savedLoan.getStatus());
        });

        return response;
    }

    private  void isIdExisted(int id){
        if (!loanRepository.existsById(id)) {
            throw new BusinessException("Loan with ID " + id + " does not exist");
        }
    }


}