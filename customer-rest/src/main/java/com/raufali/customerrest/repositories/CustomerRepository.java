package com.raufali.customerrest.repositories;

import com.raufali.customerrest.domain.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByBillingAccountNumber(Long billingAcocuntNumber);

    void deleteByPhoneNumber(Long phoneNumber);

    boolean existsByBillingAccountNumber(Long billingAccountNumber);


}
