package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface UpdateAccountTransactionFlow {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto setAccountTypeByTransactionID(Long accountTypeID);
}

