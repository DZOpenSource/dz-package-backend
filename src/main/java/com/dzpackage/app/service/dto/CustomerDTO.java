package com.dzpackage.app.service.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dzpackage.app.domain.Customer;

/**
 * A DTO for the {@link com.dzpackage.app.domain.Customer} entity.
 */
public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = -9056969846192830805L;

	private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @Email
    @NotNull
    @Size(min = 5, max = 254)
    private String email;

    @Size(min = 1, max = 50)
    private String phone;

    @Size(max = 254)
    private String address;

    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String zip;

    @Size(max = 50)
    private String country;

    private Long customerNumber;
    
    public CustomerDTO() {
        // Empty constructor needed for Jackson.
    }

    public CustomerDTO(Customer customer) {
    	this.id = customer.getId();
    	this.firstName = customer.getFirstName();
    	this.lastName = customer.getLastName();
    	this.email = customer.getEmail();
    	this.phone = customer.getPhone();
    	this.address = customer.getAddress();
    	this.city = customer.getCity();
    	this.zip = customer.getZip();
    	this.country = customer.getCountry();
    	this.customerNumber = customer.getCustomerNumber();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerDTO)) {
            return false;
        }

        return id != null && id.equals(((CustomerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", zip='" + getZip() + "'" +
            ", country='" + getCountry() + "'" +
            ", customerNumber=" + getCustomerNumber() +
            "}";
    }
}
