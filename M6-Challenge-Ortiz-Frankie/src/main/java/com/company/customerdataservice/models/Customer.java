package com.company.customerdataservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;

    private String country;

    //Getters

    public Integer getCustomerId(){ return customerId; }

    public String getFirstName(){ return firstName; }

    public String getLastName(){ return lastName; }

    public String getCompany(){ return company; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public String getAddress1() { return address1; }

    public String getAddress2() { return address2; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getPostalCode() { return postalCode; }

    public String getCountry() { return country; }

    //Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setCompany(String company) { this.company = company; }

    public void setCustomerId(Integer id) { this.customerId = id; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setEmail(String email) { this.email = email; }

    public void setAddress1(String address1) { this.address1 = address1; }

    public void setAddress2(String address2) { this.address2 = address2; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public void setCountry(String country) { this.country = country; }

    @Override
    public boolean equals(Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustomerId(), customer.getCustomerId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getAddress1(), customer.getAddress1()) &&
                Objects.equals(getAddress2(), customer.getAddress2()) &&
                Objects.equals(getCity(), customer.getCity()) &&
                Objects.equals(getState(), customer.getState()) &&
                Objects.equals(getPostalCode(), customer.getPostalCode()) &&
                Objects.equals(getCountry(), customer.getCountry());
    }

    @Override
    public int hashCode(){
    return Objects.hash(getAddress1(), getAddress2(), getCustomerId(), getCity(), getFirstName(), getCompany(), getCountry(), getEmail(), getLastName(), getPhone(), getPostalCode(), getState());
    }
}
