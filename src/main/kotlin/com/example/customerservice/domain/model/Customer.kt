package com.example.customerservice.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table
data class Customer(
    @Id val id: UUID? = null,
    var fullName: String,
    var password: String,
    var email: String
)
