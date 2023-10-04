package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.enums.Profile
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val bookService: BookService,
    private val bCrypt: BCryptPasswordEncoder
) {

    fun findAll(name: String?, pageable: Pageable): Page<CustomerModel> {

        name?.let {
            return customerRepository.findByNameContaining(it, pageable)
        }

        return customerRepository.findAll(pageable)
    }

    fun createOrUpdate(customer: CustomerModel) {

        val customerCopy = customer.copy(
            roles = setOf(Profile.CUSTOMER),
            password = bCrypt.encode(customer.password)
        )

        customerRepository.save(customerCopy)
    }

    fun findById(id: Int): CustomerModel {

        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun delete(id: Int) {

        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INACTIVE

        createOrUpdate(customer)
    }

    fun emailAvailable(email: String): Boolean {

        return !customerRepository.existsByEmail(email)
    }

}
