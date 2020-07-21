package com.dzpackage.app.service;

import com.dzpackage.app.service.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.dzpackage.app.domain.Customer}.
 */
public interface CustomerService {

    /**
     * Save a customer.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Get all the customers.
     *
     * @return the list of entities.
     */
    List<CustomerDTO> findAll();


    /**
     * Get the "id" customer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
