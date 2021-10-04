package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
                "   at" +
                "   FROM " +
                "   AccountType at" +
                "   WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);



    @Modifying
    @Query(value = "UPDATE AccountType at SET at.mnemonic = 'Zar' WHERE at.accountTypeID = :typeID")
    int setNewMnemonic(Long typeID);

}

