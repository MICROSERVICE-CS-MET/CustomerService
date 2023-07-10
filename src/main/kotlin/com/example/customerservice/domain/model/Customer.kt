package com.example.customerservice.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table
data class Customer(
    @Id val id: UUID?=null,
    var firstName: String,
    var lastName: String,
    var username: String,
    var password: String,
    var mail: String
)
