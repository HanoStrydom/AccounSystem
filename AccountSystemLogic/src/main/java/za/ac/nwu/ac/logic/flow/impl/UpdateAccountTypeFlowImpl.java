package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.UpdateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class UpdateAccountTypeFlowImpl implements UpdateAccountTypeFlow {

    private AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public UpdateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto setNewMnemonic(Long typeID) {
        return accountTypeTranslator.setNewMnemonic(typeID);
    }
}
