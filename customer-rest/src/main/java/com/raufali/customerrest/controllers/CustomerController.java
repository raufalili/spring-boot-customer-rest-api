package com.raufali.customerrest.controllers;


import com.raufali.customerrest.domain.Customer;
import com.raufali.customerrest.repositories.CustomerRepository;
import com.raufali.customerrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{billingAccountNumber}")
    public ResponseEntity<Customer> findByBillingAccountNumber(@PathVariable("billingAccountNumber") Long billingAccountNumber) {

        return new ResponseEntity<Customer>(customerService.findByBillingAccountNumber(billingAccountNumber),
                HttpStatus.OK);

    }


    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        return new ResponseEntity<Customer>(customerService.createCustomer(customer),
                HttpStatus.CREATED);

    }

    @PutMapping("/customers/{billingAccountNumber}")
    public ResponseEntity<Customer> updateByBillingAccountNumber(@PathVariable Long billingAccountNumber,
                                                   @RequestBody Customer customer) {

        return new ResponseEntity<Customer>(customerService.updateByBillingAccountNumber(billingAccountNumber, customer),
                HttpStatus.OK);

    }

    @DeleteMapping("/customers/{phoneNumber}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber,
                                                          @RequestBody Customer customer) {
        try{
            customerService.deleteByPhoneNumber(phoneNumber);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
