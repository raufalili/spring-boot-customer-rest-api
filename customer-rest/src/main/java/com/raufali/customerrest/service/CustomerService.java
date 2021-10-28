package com.raufali.customerrest.service;

import com.raufali.customerrest.domain.Customer;
import com.raufali.customerrest.exception.CustomerBadRequestException;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer updateByBillingAccountNumber(Long billingAccountNumber, Customer customer);

    void deleteByPhoneNumber(Long phoneNumber);

    Customer findByBillingAccountNumber(Long billingAccountNumber);
}
