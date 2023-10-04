package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Name must be provided")
    var name: String,

    @field:Email(message = "Email must be valid")
    @EmailAvailable(message = "Email already in use")
    var email: String,

    @field:NotEmpty(message = "Password must be provided")
    var password: String,
)
