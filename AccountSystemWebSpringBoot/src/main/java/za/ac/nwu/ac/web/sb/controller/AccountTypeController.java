package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.service.GeneralResponse;


@RestController
@RequestMapping("account-type")
public class AccountTypeController
{
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Return list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<String>> getAll()
    {
        GeneralResponse<String> response = new GeneralResponse<>(true,"No types found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ping")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    public GeneralResponse<String> ping(@RequestParam(value="echo", defaultValue = "pong")String echo)
    {
        return new GeneralResponse<String>(true,echo);
    }

    public static void main(String[] args)
    {
        Member m1 = new Member(123456789L, "Hano", "Strydom", "0722007497");
        //System.out.println(m1.getMemberName());
    }



}

