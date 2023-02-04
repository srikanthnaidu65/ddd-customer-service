package com.ddd.customer.threetier.applicationservice;

import com.ddd.customer.domain.Customer;
import com.ddd.customer.threetier.repository.CustomerRepository;
import com.ddd.customer.domain.Account;
import com.ddd.customer.domain.Address;
import com.ddd.customer.domain.CustomerId;
import org.springframework.stereotype.Service;

/**
 * @author srikanth
 * @since 04/02/2023
 */
@Service
public class CustomerAppService {

    private CustomerRepository customerRepository;

    public CustomerAppService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //@Transactional
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    //@Transactional
    public Customer updateAddress(CustomerId customerId, Address address) {
        Customer customer = customerRepository.find(customerId);
        customer.updateAddress(address);
        return customerRepository.save(customer);
    }

    //@Transactional
    public Customer addAccount(CustomerId customerId, Account account) {
        Customer customer = customerRepository.find(customerId);
        customer.addAccount(account);
        return customerRepository.save(customer);
    }
}
