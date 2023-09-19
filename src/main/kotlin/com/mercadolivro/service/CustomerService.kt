package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository, val bookService: BookService) {

    fun findAll(name: String?): List<CustomerModel> {

        name?.let {
            return customerRepository.findByNameContaining(it)
        }

        return customerRepository.findAll().toList()
    }

    fun createOrUpdate(customer: CustomerModel) {

        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {

        return customerRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {

        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INACTIVE

        createOrUpdate(customer)
    }

}
