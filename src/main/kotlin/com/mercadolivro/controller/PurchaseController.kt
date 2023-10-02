package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostPurchaseRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("purchase")
class PurchaseController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@Valid @RequestBody request: PostPurchaseRequest) {


    }

}
