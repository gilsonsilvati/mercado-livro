package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.extension.toModel
import com.mercadolivro.extension.toResponse
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(val bookService: BookService, val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {

        val customer = customerService.findById(request.customerId)
        bookService.createOrUpdate(request.toModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookResponse> {

        return bookService.findAll().map { it.toResponse() }
    }

    @GetMapping("actives")
    fun findActives(): List<BookResponse> = bookService.findActives().map { it.toResponse() }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Int): BookResponse {

        return bookService.findById(id).toResponse()
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {

        bookService.delete(id)
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody request: PutBookRequest) {

        val bookSaved = bookService.findById(id)
        bookService.createOrUpdate(request.toModel(bookSaved))
    }

}
