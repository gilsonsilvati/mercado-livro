package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun createOrUpdate(book: BookModel) {

        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {

        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {

        return bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
    }

    fun findById(id: Int): BookModel {

        return bookRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
    }

    fun delete(id: Int) {

        val book = findById(id)

        book.status = BookStatus.CANCELED

        createOrUpdate(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {

        val books = bookRepository.findByCustomer(customer)

        books.forEach { it.status = BookStatus.DELETED }

        bookRepository.saveAll(books)
    }

}
