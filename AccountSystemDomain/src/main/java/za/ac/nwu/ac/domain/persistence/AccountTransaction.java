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
    private Long accountTypeID;
    private Long memberID;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionID, Long accountTypeID, Long memberID, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountTypeID = accountTypeID;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", sequenceName = "ACCOUNT_SYSTEM.GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "GENERIC_SEQ")
    @Column(name = "TRANSACTION_ID")
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @Column(name = "TRANSACTION_DATE")
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeID, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeID=" + accountTypeID +
                ", memberID=" + memberID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
