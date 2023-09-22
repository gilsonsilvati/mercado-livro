package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostBookRequest (

    @field:NotEmpty(message = "Name must be provided")
    var name: String,

    @field:NotNull(message = "Price must be provided")
    var price: BigDecimal,

    @field:NotNull(message = "Customer id must be provided")
    @JsonAlias("customer_id")
    var customerId: Int
)
