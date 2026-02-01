package com.study.transactional.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequestDTO {

    @NotBlank(message = "Account holder name is required")
    @Size(min = 3, max = 50)
    private String accountHolderName;

    @NotBlank(message = "Account type is required")
    @Pattern(regexp = "SAVINGS|CURRENT|SALARY", message = "Invalid account type")
    private String accountType;

    @NotNull(message = "Initial deposit is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than zero")
    private BigDecimal initialDeposit;

    @NotBlank
    @Size(min = 3, max = 10)
    private String currency;

    @NotBlank
    private String branchCode;

    @NotBlank
    @Size(min = 11, max = 11, message = "IFSC must be 11 characters")
    private String ifscCode;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull
    private Boolean kycCompleted;

    @Size(max = 250)
    private String address;

    // Getters & Setters
}
