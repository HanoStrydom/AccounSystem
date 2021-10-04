package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.UpdateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class UpdateAccountTransactionFlowImpl implements UpdateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public UpdateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        return accountTransactionTranslator.getAllAccountTransactions();
    }

    @Override
    public AccountTransactionDto setAccountTypeByTransactionID(Long accountTransactionID) {
        return accountTransactionTranslator.setAccountTypeByTransactionID(accountTransactionID);
    }

    @Override
    public AccountTransactionDto setAccountValueBy200(Long transID) {
        return accountTransactionTranslator.setAccountValueBy200(transID);
    }

    @Override
    public AccountTransactionDto setAccountValueMinus200(Long tranactID) {
        return accountTransactionTranslator.setAccountValueMinus200(tranactID);
    }


}