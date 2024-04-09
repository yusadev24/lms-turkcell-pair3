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
@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE= Mappers.getMapper(LoanMapper.class);

    @Mapping(source = "bookId", target ="book", ignore = true)
    @Mapping(source = "memberId", target ="member", ignore = true)
    Loan loanFromAddLoanRequest(AddLoanRequest request);

    GetByIdLoanResponse mapToGetByIdLoanResponse(Loan loan);

    List<ListLoanResponse> loansToListLoanResponses(List<Loan> loans);


    Loan updateLoanFromRequest(UpdateLoanRequest request, @MappingTarget Loan loan);
}
