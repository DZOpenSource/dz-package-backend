package com.dzpackage.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzpackage.app.domain.Customer;
import com.dzpackage.app.repository.CustomerRepository;
import com.dzpackage.app.service.CustomerService;
import com.dzpackage.app.service.dto.CustomerDTO;
import com.dzpackage.app.service.mapper.CustomerMapper;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

	private final CustomerRepository customerRepository;

	private final CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	/**
	 * Save a customer.
	 *
	 * @param customerDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		log.debug("Request to save Customer : {}", customerDTO);
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		customer = customerRepository.save(customer);
		return customerMapper.customerToCustomerDTO(customer);
	}

	/**
	 * Get all the customers.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CustomerDTO> findAll() {
		log.debug("Request to get all Customers");
		return customerMapper.customersToCustomerDTOs(customerRepository.findAll());
	}

	/**
	 * Get one customer by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<CustomerDTO> findOne(Long id) {
		log.debug("Request to get Customer : {}", id);
		return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO);
	}

	/**
	 * Delete the customer by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Customer : {}", id);
		customerRepository.deleteById(id);
	}
}
