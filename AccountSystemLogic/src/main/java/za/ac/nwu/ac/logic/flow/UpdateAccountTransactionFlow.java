package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface UpdateAccountTransactionFlow {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto setAccountTypeByTransactionID(Long accountTransactionID);

    AccountTransactionDto setAccountValueBy200(Long transID);

    AccountTransactionDto setAccountValueMinus200(Long tranactID);
}

