package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface UpdateAccountTypeFlow {

    AccountTypeDto setNewMnemonic(Long typeID);

}
