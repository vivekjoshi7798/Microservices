package com.study.jpa.entity;

import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class WalletAccountId implements Serializable {

    private  Long accountID;
    private  String pan ;

    public WalletAccountId() {
    }

    public WalletAccountId(Long accountID, String pan) {
        this.accountID = accountID;
        this.pan = pan;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WalletAccountId accountId)) return false;
        return Objects.equals(accountID, accountId.accountID) && Objects.equals(pan, accountId.pan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, pan);
    }
}
