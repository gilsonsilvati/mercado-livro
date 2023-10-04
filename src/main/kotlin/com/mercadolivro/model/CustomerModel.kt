package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    var name: String,
    var email: String,
    var password: String
)
