package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "   SELECT " +
            "   ta" +
            "   FROM " +
            "   AccountTransaction ta" +
            "   WHERE ta.transactionID = :transactionID")
    AccountTransaction getAccountAmountByTransactionID(Long transactionID);

    //@Query



}