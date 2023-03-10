package com.ddd.customer.threetier.controller.resource;

import com.ddd.customer.domain.Customer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author srikanth
 * @since 04/02/2023
 */
public class CustomerResource {
    private UUID customerId;
    private AddressData addressData;
    private List<AccountData> accountDataList;

    public CustomerResource() {
    }

    public static CustomerResource from(Customer customer) {
        CustomerResource customerResource = new CustomerResource();
        customerResource.setCustomerId(customer.getCustomerId().getCustomerId());

        customerResource.setAddressData(AddressData.from(customer.getAddress()));
        List<AccountData> accountDataList = customer.getAccounts().stream()
                .map(AccountData::from).collect(Collectors.toList());
        customerResource.setAccountDataList(accountDataList);

        return customerResource;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }

    public List<AccountData> getAccountDataList() {
        return accountDataList;
    }

    public void setAccountDataList(List<AccountData> accountDataList) {
        this.accountDataList = accountDataList;
    }
}
