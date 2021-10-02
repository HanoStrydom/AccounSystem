package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private Long amount;
    private LocalDate transactionDate;
    private String firstName;
    private String lastName;



    public AccountTransactionDto(Long amount, LocalDate transactionDate, String firstName, String lastName) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
        this.setFirstName(accountTransaction.getFirstName());
        this.setLastName(accountTransaction.getLastName());
    }



    public AccountTransactionDto(int accountTransaction) {
    }


    //GETTERS


    @ApiModelProperty(position = 1,
            value = "AccountTransaction amount",
            name = "amount",
            notes = "Uniquely idendifies the transaction amount",
            dataType = "",
            example = "450",
            required = true)
    public Long getAmount() {
        return amount;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction transactionDate",
            name = "transactionDate",
            notes = "Uniquely idendifies the transaction date",
            dataType = "",
            example = "2021-09-29",
            required = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ApiModelProperty(position = 3,
            value = "String firstName",
            name = "firstName",
            notes = "Uniquely idendifies the customer name",
            dataType = "java.lang.String",
            example = "Hano",
            required = true)
    public String getFirstName() {
        return firstName;
    }

    @ApiModelProperty(position = 4, value = "String lastName", name = "lastName", notes = "Uniquely idendifies the customer surname", dataType = "java.lang.String", example = "Strydom", required = true)
    public String getLastName() {
        return lastName;
    }


    //SETTERS

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
        return Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }


    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getAmount(), getTransactionDate(), getFirstName(),getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionDate, firstName, lastName);
    }


    //TOSTRING
    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
