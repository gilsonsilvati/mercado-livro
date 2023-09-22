package com.mercadolivro.enums

enum class Errors(val message: String, val code: String) {

    ML001("Invalid Request", "ML-001"),
    ML101("This resource book [%s] not exist", "ML-101"),
    ML102("Cannot update book with status [%s]", "ML-102"),
    ML201("This resource customer [%s] not exist", "ML-201")
}
