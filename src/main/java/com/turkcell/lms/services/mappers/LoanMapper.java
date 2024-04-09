package com.turkcell.lms.services.mappers;

import com.turkcell.lms.entities.Loan;
import com.turkcell.lms.services.dtos.requests.loan.AddLoanRequest;
import com.turkcell.lms.services.dtos.requests.loan.UpdateLoanRequest;
import com.turkcell.lms.services.dtos.responses.loan.GetByIdLoanResponse;
import com.turkcell.lms.services.dtos.responses.loan.ListLoanResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;
@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE= Mappers.getMapper(LoanMapper.class);

    @Mapping(source = "bookId", target ="book", ignore = true)
    @Mapping(source = "memberId", target ="member", ignore = true)
    Loan loanFromAddLoanRequest(AddLoanRequest request);


    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "member.id", target = "memberId")
    GetByIdLoanResponse mapToGetByIdLoanResponse(Loan loan);

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "member.id", target = "memberId")
    ListLoanResponse mapToLoanResponse(Loan loan);

    default List<ListLoanResponse> loansToListLoanResponses(List<Loan> loans) {
        return loans.stream()
                .map(this::mapToLoanResponse)
                .collect(Collectors.toList());
    }

    Loan updateLoanFromRequest(UpdateLoanRequest request, @MappingTarget Loan loan);
}
