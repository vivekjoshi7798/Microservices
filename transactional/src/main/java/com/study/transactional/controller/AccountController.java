package com.study.transactional.controller;

import com.study.transactional.aspect.LogExecutionTime;
import com.study.transactional.dto.*;
import com.study.transactional.entity.Account;
import com.study.transactional.exceptions.AccountKycNotFound;
import com.study.transactional.exceptions.AccountNotFound;
import com.study.transactional.exceptions.NoBalanceException;
import com.study.transactional.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAccount/{accountNumber}")
    public Account getAccountInfo(@PathVariable(name="accountNumber") String accNumber) throws AccountNotFound {
        return accountService.fetchAccountByAccountNumber(accNumber);
    }

    @GetMapping("/getRichAccount/{amount}")
    public List<AccountResponseDTO> getRichAccountInfo(@PathVariable(name="amount") BigDecimal amount){
        return accountService.getRichAccountInfo(amount);
    }

    @PostMapping("/createAccount")
    public AccountResponseDTO createAccount(@Valid @RequestBody AccountRequestDTO requestDTO) {
        AccountResponseDTO response= accountService.createAccount(requestDTO);
       Link link1= WebMvcLinkBuilder.linkTo(AccountController.class).slash("getAccountStatus").slash(response.getAccountNumber()).withRel("Verify").withType("GET");
       Link link2= WebMvcLinkBuilder.linkTo(AccountController.class).slash("getAccount").slash(response.getAccountNumber()).withRel("Verify").withType("GET");

        response.add(link1,link2);
      return response;
    }

    @GetMapping("/getAccountStatus/{accountNumber}")
    public String getAccountStatus(@PathVariable(name="accountNumber") String accNumber){
        return accountService.getAccountStatus(accNumber);

    }

    @GetMapping("/getMoney/{accountNumber}")
    public BigDecimal fetchMoneyByAccountNumber(@PathVariable(name="accountNumber") String accNumber) throws NoBalanceException {
        BigDecimal balance = accountService.fetchMoneyByAccountNumber(accNumber);
        if (balance.compareTo(BigDecimal.ZERO)<1){
            throw new NoBalanceException("No Balance Found with Account "+accNumber);
        }

        return balance;
    }

    @PostMapping("/transfer-money")
    @LogExecutionTime
    public List<Account> transferMoney(@Valid @RequestBody TransferRequestDTO requestDTO) throws AccountNotFound {
        accountService.transferMoney(
                requestDTO.getFromAccountNumber(),
                requestDTO.getToAccountNumber(),
                requestDTO.getAmount()
        );

        Account sender= getAccountInfo( requestDTO.getFromAccountNumber());
        Account receiver= getAccountInfo(requestDTO.getToAccountNumber());

        return List.of(sender,receiver);
    }
    @GetMapping("/isKycDone/{accountNumber}")
    public boolean isKycDone(@PathVariable(name="accountNumber") String accNumber) throws AccountKycNotFound {
        boolean isKycDone= accountService.fetchKycDetails(accNumber);
        if(!isKycDone){
            throw new AccountKycNotFound("KYC Not Done");
        }
        return  isKycDone;
    }

    @GetMapping("/fetchAccountStatus/{accountNumber}")
    public String fetchAccountStatus(@PathVariable(name="accountNumber") String accNumber) throws AccountKycNotFound {
        String status = accountService.fetchAccountStatus(accNumber);
        if(Strings.isBlank(status)){
            throw new AccountKycNotFound("KYC Not Done");
        }
        return  status;
    }




}
