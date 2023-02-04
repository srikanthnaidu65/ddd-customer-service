package com.ddd.customer.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class Customer implements Aggregate {
    private CustomerId customerId;
    private Address address;
    private List<Account> accounts = new ArrayList<>();

    public Customer(Address address) {
        this.customerId = new CustomerId(UUID.randomUUID());
        this.address = address;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.updateAddress(this.address);
    }

    public void updateAddress(Address address) {
        this.address = address;
        accounts.forEach(account -> {
            account.updateAddress(address);
        });
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public String getCustomerIdAsString() {
        return customerId.getCustomerId().toString();
    }

    public Address getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", address=" + address +
                ", accounts=" + accounts +
                '}';
    }
}
