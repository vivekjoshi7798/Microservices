package com.study.transactional.service;


import com.study.transactional.dto.AccountRequestDTO;
import com.study.transactional.dto.AccountResponseDTO;
import com.study.transactional.entity.Account;
import com.study.transactional.exceptions.AccountKycNotFound;
import com.study.transactional.exceptions.AccountNotFound;
import com.study.transactional.repository.AccountJdbcDao;
import com.study.transactional.repository.AccountRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountJdbcDao accountJdbcDao;

    @Autowired
    AccountValidationServices accountValidationServices;

    public Account fetchAccountByAccountNumber(String accountNumber) throws AccountNotFound {
        return  accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFound(accountNumber + " account not found"));


    }

    public AccountResponseDTO createAccount(@Valid AccountRequestDTO account){
        Account createdaccount = accountRepository.save(toEntity(account));
        return toResponseDTO(createdaccount);
    }

    public static AccountResponseDTO toResponseDTO(Account account) {

        AccountResponseDTO dto = new AccountResponseDTO();

        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountHolderName(account.getAccountHolderName());
        dto.setAccountType(account.getAccountType());
        dto.setBalance(account.getBalance());
        dto.setCurrency(account.getCurrency());
        dto.setBranchCode(account.getBranchCode());
        dto.setIfscCode(account.getIfscCode());
        dto.setStatus(account.getStatus());
        dto.setKycCompleted(account.getKycCompleted());
        dto.setMaskedAccountNumber(maskAccount(account.getAccountNumber()));
        dto.setCreatedAt(account.getCreatedAt());
        dto.setLastUpdatedAt(account.getUpdatedAt());

        return dto;
    }

    private static String maskAccount(String accNo) {
        return "XXXXXX" + accNo.substring(accNo.length() - 4);
    }

    public static Account toEntity(AccountRequestDTO dto) {

        Account account = new Account();

        account.setAccountNumber(UUID.randomUUID().toString()); // system generated
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setAccountType(dto.getAccountType());
        account.setBalance(dto.getInitialDeposit());
        account.setCurrency(dto.getCurrency());
        account.setBranchCode(dto.getBranchCode());
        account.setIfscCode(dto.getIfscCode());
        account.setStatus("ACTIVE");
        account.setKycCompleted(dto.getKycCompleted());
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        return account;
    }

    public  List<AccountResponseDTO> getRichAccountInfo(BigDecimal amount) {

         List<Account> account= accountRepository.findRichAccounts(amount);
        return account.stream().map(AccountService::toResponseDTO).collect(Collectors.toList());
    }
    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(@NotBlank String fromAccountNumber, @NotBlank String toAccountNumber, @NotNull @DecimalMin(value = "0.01") BigDecimal amount) {

       Account sender= accountRepository.findByAccountNumber(fromAccountNumber).orElseThrow(() -> new RuntimeException("Sender account not found"));
       Account receiver=accountRepository.findByAccountNumber(toAccountNumber).orElseThrow(() -> new RuntimeException("Receiver account not found"));


        accountValidationServices.validateMoney(sender,amount);



        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        accountValidationServices.sendNotification();

    }

    public String getAccountStatus(String accNumber) {
       return accountRepository.findStatusByAccountNumber(accNumber).orElseThrow(()->new RuntimeException("Account Not Found"));

    }

    public BigDecimal fetchMoneyByAccountNumber(String accNumber) {
        return accountRepository.findMoneyByAccountNumber(accNumber).orElseThrow(()->new RuntimeException("Account Not Found"));
    }

    public boolean fetchKycDetails(String accNumber) throws AccountKycNotFound {
        return accountRepository.findKycByAccountNumber(accNumber).orElseThrow(()->new AccountKycNotFound("Account Not Found"));
    }

    public String fetchAccountStatus(String accNo) {
        return accountJdbcDao.getAccountStatus(accNo);
    }
}
