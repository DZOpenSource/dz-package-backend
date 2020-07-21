package com.dzpackage.app.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dzpackage.app.domain.Customer;
import com.dzpackage.app.service.dto.CustomerDTO;

public class CustomerMapperTest {

	private static final String FIRST_NAME_VALUE = "test";

	private static final String LAST_NAME_VALUE = "test";

	private static final String EMAIL_VALUE = "test@test.com";

	private static final String PHONE_VALUE = "+213777777777";

	private static final String ADDRESS_VALUE = "1 RUE DE TEST";

	private static final String CITY_VALUE = "TEST";

	private static final String COUNTRY_VALUE = "TEST";

	private static final String ZIP_VALUE = "40000";

	private static final Long CUSTOMER_NUMBER_VALUE = 1L;

	private static final Long CUSTOMER_ID = 1L;

	private CustomerMapper customerMapper;
	private Customer customer;
	private CustomerDTO customerDTO;

	@BeforeEach
	public void setUp() {
		customerMapper = new CustomerMapper();

		customer = new Customer();
		customer.setId(CUSTOMER_ID);
		customer.setFirstName(FIRST_NAME_VALUE);
		customer.setLastName(LAST_NAME_VALUE);
		customer.setEmail(EMAIL_VALUE);
		customer.setPhone(PHONE_VALUE);
		customer.setAddress(ADDRESS_VALUE);
		customer.setCity(CITY_VALUE);
		customer.setZip(ZIP_VALUE);
		customer.setCountry(COUNTRY_VALUE);
		customer.setCustomerNumber(CUSTOMER_NUMBER_VALUE);

		customerDTO = new CustomerDTO(customer);
	}

	@Test
	public void customerToCustomerDTOShouldMapRightAttributes() {
		assertThat(customerDTO.getId()).isEqualTo(customer.getId());
		assertThat(customerDTO.getFirstName()).isEqualTo(customer.getFirstName());
		assertThat(customerDTO.getLastName()).isEqualTo(customer.getLastName());
		assertThat(customerDTO.getEmail()).isEqualTo(customer.getEmail());
		assertThat(customerDTO.getPhone()).isEqualTo(customer.getPhone());
		assertThat(customerDTO.getAddress()).isEqualTo(customer.getAddress());
		assertThat(customerDTO.getCity()).isEqualTo(customer.getCity());
		assertThat(customerDTO.getZip()).isEqualTo(customer.getZip());
		assertThat(customerDTO.getCountry()).isEqualTo(customer.getCountry());
		assertThat(customerDTO.getCustomerNumber()).isEqualTo(customer.getCustomerNumber());
	}
	
	@Test
	public void customerDTOToCustomerShouldMapRightAttributes() {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		assertThat(customer.getId()).isEqualTo(customerDTO.getId());
		assertThat(customer.getFirstName()).isEqualTo(customerDTO.getFirstName());
		assertThat(customer.getLastName()).isEqualTo(customerDTO.getLastName());
		assertThat(customer.getEmail()).isEqualTo(customerDTO.getEmail());
		assertThat(customer.getPhone()).isEqualTo(customerDTO.getPhone());
		assertThat(customer.getAddress()).isEqualTo(customerDTO.getAddress());
		assertThat(customer.getCity()).isEqualTo(customerDTO.getCity());
		assertThat(customer.getZip()).isEqualTo(customerDTO.getZip());
		assertThat(customer.getCountry()).isEqualTo(customerDTO.getCountry());
		assertThat(customer.getCustomerNumber()).isEqualTo(customerDTO.getCustomerNumber());
	}
	
	@Test
	public void customersToCustomerDTOsShouldMapOnlyNonNullCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(null);

		List<CustomerDTO> customerDTOs = customerMapper.customersToCustomerDTOs(customers);

		assertThat(customerDTOs).isNotEmpty();
		assertThat(customerDTOs).size().isEqualTo(1);
	}

	@Test
	public void customerDTOsToCustomersShouldMapOnlyNonNullCustomers() {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		customerDTOs.add(customerDTO);
		customerDTOs.add(null);

		List<Customer> customers = customerMapper.customerDTOsToCustomers(customerDTOs);

		assertThat(customers).isNotEmpty();
		assertThat(customers).size().isEqualTo(1);
	}

	@Test
	public void customerDTOToCustomerMapWithNullCustomerShouldReturnNull() {
		assertThat(customerMapper.customerDTOToCustomer(null)).isNull();
	}

	@Test
	public void testCustomerFromId() {
		assertThat(customerMapper.userFromId(CUSTOMER_ID).getId()).isEqualTo(CUSTOMER_ID);
		assertThat(customerMapper.userFromId(null)).isNull();
	}
}
