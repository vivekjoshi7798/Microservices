package com.study.transactional.repository;

import jakarta.validation.constraints.Null;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountJdbcDao {


    private final JdbcTemplate jdbcTemplate;


    public AccountJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getAccountStatus(String accountNumber){
        String sql= "select status from accounts where account_number= ?";

        try{
            String status= jdbcTemplate.queryForObject(sql,new Object[]{accountNumber},String.class);

           return  Strings.isBlank(status) ? null : status;
        }catch (Exception e){
            return null;
        }

    }
}
