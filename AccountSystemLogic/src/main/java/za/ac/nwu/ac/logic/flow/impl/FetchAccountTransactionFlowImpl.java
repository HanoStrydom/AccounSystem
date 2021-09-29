package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow{

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {

        List<AccountTransactionDto> accountTransactionsDtos = new ArrayList<>();
        AccountType plays = new AccountType(47800000L,"PLAYS","plays",LocalDate.now());
        accountTransactionsDtos.add(new AccountTransactionDto(plays, 40000L, LocalDate.now(), "Hano", "Strydom"));

        return accountTransactionsDtos;
    }
}

