package com.raufali.customerrest.service;

import com.raufali.customerrest.domain.Customer;
import com.raufali.customerrest.exception.CustomerBadRequestException;
import com.raufali.customerrest.exception.CustomerNotFoundException;
import com.raufali.customerrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService{



    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Value("#{${map.of.state}}")
    Map<String, String> simpleMap;



    @Override
    public Customer createCustomer(Customer customer) throws CustomerBadRequestException{

        //check phone number
        int length = String.valueOf(customer.getPhoneNumber()).length();
        if(length != 10){
            throw new CustomerBadRequestException("Invalid phone number");
        }

        //check for state
        if(simpleMap.containsKey(customer.getState())){
            customer.setState(simpleMap.get(customer.getState()));
        } else if(simpleMap.containsValue(customer.getState())) {
            customer.getState();
        } else
            throw new CustomerBadRequestException("Invalid state");

        //check zip code
        int lengthZip = String.valueOf(customer.getZip()).length();
        if(lengthZip != 5){
            throw new CustomerBadRequestException("Invalid Zipcode");
        }

        //generate 9 digit random number
        Long billingNumber = (long) ((Math.random() * 899999999) + 10000000);
        if(!customerRepository.existsByBillingAccountNumber(billingNumber)){
            customer.setBillingAccountNumber(billingNumber);
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateByBillingAccountNumber(Long billingAccountNumber, Customer customer) {

        List<Customer> customerData = customerRepository.findByBillingAccountNumber(billingAccountNumber);

        if (!customerData.isEmpty()) {
            Customer customer1 = customerData.get(Math.toIntExact(billingAccountNumber));
            customer1.setBillingAccountNumber(customer.getBillingAccountNumber());
            customer1.setAddress(customer.getAddress());
            customer1.setAddressLine1(customer.getAddressLine1());
            customer1.setAddressLine2(customer.getAddressLine2());
            customer1.setCity(customer.getCity());
            customer1.setZip(customer.getZip());
            customer1.setState(customer.getState());
            customer1.setEmailId(customer.getEmailId());
            return customerRepository.save(customer1);
        } else
            throw new CustomerNotFoundException("Invalid request");
    }

    @Override
    public void deleteByPhoneNumber(Long phoneNumber) {
        customerRepository.deleteByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer findByBillingAccountNumber(Long billingAccountNumber) {
        return (Customer) customerRepository.findByBillingAccountNumber(billingAccountNumber);
    }
}
