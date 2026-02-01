package com.study.transactional.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AccountResponseDTO extends RepresentationModel<AccountResponseDTO> {

    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private BigDecimal balance;
    private String currency;
    private String branchCode;
    private String ifscCode;
    private String status;
    private boolean kycCompleted;
    private String maskedAccountNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdatedAt;

    // Getters & Setters
}
