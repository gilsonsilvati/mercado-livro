package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {

        val errorResponse = ErrorResponse(
            400,
            exception.message!!,
            "0001"
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
