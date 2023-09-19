package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun createOrUpdate(book: BookModel) {

        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {

        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {

        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }

    fun findById(id: Int): BookModel {

        return bookRepository.findById(id).orElseThrow()
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
