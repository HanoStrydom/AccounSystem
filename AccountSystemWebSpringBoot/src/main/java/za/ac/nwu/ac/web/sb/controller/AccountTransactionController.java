package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;

import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.UpdateAccountTransactionFlow;

import java.util.*;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController
{
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final UpdateAccountTransactionFlow updateAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlow,
                                        @Qualifier("createAccountTransactionFlowName") CreateAccountTransactionFlow createAccountTransactionFlow, UpdateAccountTransactionFlow updateAccountTransactionFlow) {
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.updateAccountTransactionFlow = updateAccountTransactionFlow;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Transactions.", notes = "Return list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> accountTransaction = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true,accountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new AccountTransaction", notes =  "Creates a new Account Transaction in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
            @RequestBody AccountTransactionDto accountTransaction){
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionID}")
    @ApiOperation(value =  "Fetches the specified Account", notes = "Fetches the specified Amount for a given TransactionID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "FOUND"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountAmount(
            @ApiParam(value = "TransactionID that uniquely identifies the AccountTransaction",
                    example = "37",
                    name = "transactionID",
                    required = true)
            @PathVariable("transactionID") final Long transactionID){

        AccountTransactionDto accountTransaction = fetchAccountTransactionFlow.getAccountAmountByTransactionID(transactionID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{accountTransactionID}" )
    @ApiOperation(value =  "Sets the new ID", notes = "Sets the new AccountTypeID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "FOUND"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> setAccountTypeID(
            @ApiParam(value = "Changes to new accountTransaction",
                    example = "40",
                    name = "accountTransactionID",
                    required = true)
            @PathVariable("accountTransactionID") final Long accountTransactionID){

        AccountTransactionDto accountTransaction = updateAccountTransactionFlow.setAccountTypeByTransactionID(accountTransactionID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //TODO: This wont work unless I comment out the above @PutMapping
    @PutMapping("/{TransID}" )
    @ApiOperation(value =  "Adds 200 to the new to the selected account", notes = "Adds 200 to the new to the selected account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "FOUND"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> setAccountAmount(
            @ApiParam(value = "Adds 200 to selected account",
                    example = "40",
                    name = "TransID",
                    required = true)
            @PathVariable("TransID") final Long TransID){

        AccountTransactionDto accountTransaction = updateAccountTransactionFlow.setAccountValueBy200(TransID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}