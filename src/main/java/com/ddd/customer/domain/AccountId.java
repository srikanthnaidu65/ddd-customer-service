package com.ddd.customer.domain;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class AccountId {

    private UUID accountId;

    public AccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getAccountIdUUID() {
        return accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountId accountId1 = (AccountId) o;

        return accountId.equals(accountId1.accountId);
    }

    @Override
    public int hashCode() {
        return accountId.hashCode();
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "accountId=" + accountId +
                '}';
    }
}
