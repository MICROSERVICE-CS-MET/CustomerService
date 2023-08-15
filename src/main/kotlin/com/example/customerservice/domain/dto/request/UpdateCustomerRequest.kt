package com.example.customerservice.domain.dto.request

import java.util.*

data class UpdateCustomerRequest(
    val id: UUID,
    var fullName: String,
    var password: String,
    var email: String
)
