package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import java.util.*;
import java.time.LocalDate;
import javax.transaction.Transactional;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "   SELECT " +
            "   ta" +
            "   FROM " +
            "   AccountTransaction ta" +
            "   WHERE ta.transactionID = :transactionID")
    AccountTransaction getAccountAmountByTransactionID(Long transactionID);



    @Modifying
    @Query(value = "UPDATE AccountTransaction SET accountTypeID = 1 WHERE transactionID = :accountTransactionID")
    int setAccountTypeByTransactionID(Long accountTransactionID);

    LocalDate date = LocalDate.now();
    String dateString = date.toString();

    @Modifying
    @Query(value = "UPDATE AccountTransaction set amount = amount + 200, transactionDate = current_date WHERE transactionID = :transID")
    int setAccountValueBy200(Long transID);


    @Modifying
    @Query(value = "UPDATE AccountTransaction set amount = amount - 200, transactionDate = current_date WHERE transactionID = :transactID")
    int setAccountValueMinus200(Long transactID);
}