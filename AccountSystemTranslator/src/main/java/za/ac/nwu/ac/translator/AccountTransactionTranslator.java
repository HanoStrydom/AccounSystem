package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTransactionTranslator {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    AccountTransactionDto getAccountAmountByTransactionID(Long transactionID);

    AccountTransactionDto setAccountTypeByTransactionID(Long accountTransactionID);

    AccountTransactionDto setAccountValueBy200(Long transID);
}
