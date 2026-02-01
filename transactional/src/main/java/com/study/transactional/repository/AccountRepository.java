package com.study.transactional.repository;

import com.study.transactional.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    List<Account> findByStatus(String status);

    List<Account> findByKycCompleted(Boolean kycCompleted);

    List<Account> findByAccountType(String accountType);

    @Query("SELECT a FROM Account a WHERE a.balance > :amount")
    List<Account> findRichAccounts(@Param("amount") BigDecimal amount);

    Optional<String> findStatusByAccountNumber(String accountNumber);


    @Query("SELECT a.balance FROM Account a WHERE a.accountNumber = :accountNumber")
    Optional<BigDecimal> findMoneyByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query("SELECT a.kycCompleted FROM Account a WHERE a.accountNumber = :accountNumber")
    Optional<Boolean> findKycByAccountNumber(@Param("accountNumber") String accNumber);
}
