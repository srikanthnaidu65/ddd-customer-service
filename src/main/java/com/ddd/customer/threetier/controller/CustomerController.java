package com.ddd.customer.threetier.controller;

import com.ddd.customer.domain.Customer;
import com.ddd.customer.threetier.applicationservice.CustomerAppService;
import com.ddd.customer.threetier.controller.resource.CustomerResource;
import com.ddd.customer.threetier.controller.viewmodel.AccountRequest;
import com.ddd.customer.threetier.controller.viewmodel.AddressRequest;
import com.ddd.customer.threetier.controller.viewmodel.CustomerRequest;
import com.ddd.customer.domain.Account;
import com.ddd.customer.domain.Address;
import com.ddd.customer.domain.CustomerId;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@RestController
public class CustomerController {

    private final CustomerAppService customerAppService;

    public CustomerController(CustomerAppService customerAppService) {
        this.customerAppService = customerAppService;
    }

    @PostMapping("/customers")
    public CustomerResource create(@RequestBody CustomerRequest request) {
        System.out.println("request = " + request);

        Customer customer = customerAppService.createCustomer(
                new Customer(new Address(request.getAddressRequest().getCity())));

        return CustomerResource.from(customer);
    }

    @PutMapping("/customers/{customerId}/accounts")
    public CustomerResource createAccount(@RequestBody AccountRequest request, @PathVariable String customerId) {
        System.out.println("request = " + request);
        System.out.println("PathVariable = " + customerId);

        Customer customer = customerAppService.addAccount(new CustomerId(UUID.fromString(customerId)), new Account());

        return CustomerResource.from(customer);
    }

    @PutMapping("/customers/{customerId}/address")
    public CustomerResource updateAddress(@RequestBody AddressRequest request, @PathVariable String customerId) {
        System.out.println("request = " + request);
        System.out.println("PathVariable = " + customerId);

        Customer customer = customerAppService.updateAddress(new CustomerId(UUID.fromString(customerId)),
                new Address(request.getCity()));

        return CustomerResource.from(customer);
    }
}
