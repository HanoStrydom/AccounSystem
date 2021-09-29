package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    private AccountType accountTypeID;
    private Long amount;
    private LocalDate transactionDate;
    private String firstName;
    private String lastName;

    public AccountTransactionDto() {

    }

    public AccountTransactionDto(AccountType accountTypeID, Long amount, LocalDate transactionDate, String firstName, String lastName) {
        this.accountTypeID = accountTypeID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setAccountTypeID(accountTransaction.getAccountTypeID());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
        this.setFirstName(accountTransaction.getFirstName());
        this.setLastName(accountTransaction.getLastName());
    }


    //GETTERS
    public AccountType getAccountTypeID() {
        return accountTypeID;
    }

    public Long getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    //SETTERS
    public void setAccountTypeID(AccountType accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //HASH GOED
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, amount, transactionDate, firstName, lastName);
    }


    //TOSTRING
    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTypeID=" + accountTypeID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
