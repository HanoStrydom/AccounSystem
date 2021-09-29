package za.ac.nwu.ac.domain.persistence;

import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "ACCOUNT_SYSTEM")
public class AccountTransaction implements  Serializable{


    private Long transactionID;
    //private Long accountTypeID; <--This changes because it becomes a foreign key referencing the AccountType Class
    private AccountType accountTypeID;
    private Long amount;
    private LocalDate transactionDate;
    private String firstName;
    private String lastName;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionID, AccountType accountTypeID, Long amount, LocalDate transactionDate, String firstName, String lastName) {
        this.transactionID = transactionID;
        this.accountTypeID = accountTypeID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccountTransaction(AccountType accountTypeID, Long amount, LocalDate transactionDate, String firstName, String lastName) {
        this.accountTypeID = accountTypeID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //GETTERS
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", sequenceName = "ACCOUNT_SYSTEM.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "GENERIC_SEQ")
    @Column(name = "TRANSACTION_ID")
    public Long getTransactionID() {
        return transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "accountTypeID")
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountTypeID() {
        return accountTypeID;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    //SETTERS
    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public void setAccountTypeID(AccountType accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    //HASH GOED
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeID, amount, transactionDate, firstName, lastName);
    }

    //TOSTRING
    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeID=" + accountTypeID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
