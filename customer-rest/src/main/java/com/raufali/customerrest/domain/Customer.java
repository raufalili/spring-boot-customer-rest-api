package com.raufali.customerrest.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("Customer")
public class Customer {

    @PrimaryKey
    private Long billingAccountNumber;


    private String firstName;
    private String lastName;
    private String address;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private Long zip;
    private String state;
    private Long phoneNumber;
    private String emailId;
    private Long conversationId;

    public Customer(String firstName, String lastName, String address, String addressLine1, String addressLine2,
                    String city, Long zip, String state, Long phoneNumber, String emailId, Long conversationId,
                    Long billingAccountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.conversationId = conversationId;
        this.billingAccountNumber = billingAccountNumber;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public Long getBillingAccountNumber() {
        return billingAccountNumber;
    }

    public void setBillingAccountNumber(Long billingAccountNumber) {
        this.billingAccountNumber = billingAccountNumber;
    }
}
