package com.example.customerservice.domain.dto.response

import java.util.*

data class CustomerResponse(
    val id: UUID?,
    var fullName: String,
    var password: String,
    var email: String
)
