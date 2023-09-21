package com.mercadolivro.enums

enum class Errors(val message: String, val code: String) {

    ML101("This resource Book [%s] not exist", "ML-101"),
    ML201("This resource Customer [%s] not exist", "ML-201")
}
