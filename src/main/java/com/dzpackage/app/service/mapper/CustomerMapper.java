package com.dzpackage.app.service.mapper;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dzpackage.app.domain.Customer;
import com.dzpackage.app.service.dto.CustomerDTO;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Service
public class CustomerMapper {

	public List<CustomerDTO> customersToCustomerDTOs(List<Customer> customers) {
        return customers.stream()
            .filter(Objects::nonNull)
            .map(this::customerToCustomerDTO)
            .collect(Collectors.toList());
    }

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        return new CustomerDTO(customer);
    }

    public List<Customer> customerDTOsToCustomers(List<CustomerDTO> customerDTOs) {
        return customerDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::customerDTOToCustomer)
            .collect(Collectors.toList());
    }

    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        } else {
            Customer customer = new Customer();
            
            customer.setId(customerDTO.getId());
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
            customer.setAddress(customerDTO.getAddress());
            customer.setCity(customerDTO.getCity());
            customer.setZip(customerDTO.getZip());
            customer.setCountry(customerDTO.getCountry());
            customer.setCustomerNumber(customerDTO.getCustomerNumber());
            
            return customer;
        }
    }

    public Customer userFromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
