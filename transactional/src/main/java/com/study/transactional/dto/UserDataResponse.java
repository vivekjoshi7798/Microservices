package com.study.transactional.dto;

import lombok.Data;
import org.springframework.hateoas.Link;

@Data
public class UserDataResponse extends Link {


    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private String status;
}
