package com.mercadolivro.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class PostCustomerRequest (

    @field:NotBlank
    var name: String,

    @field:NotBlank
    @field:Email
    var email: String
)
