package com.example.customerservice.domain.dto.request

import java.util.*

data class CreateCustomerRequest(
    val id: UUID,
    var firstname: String,
    var lastname: String,
    var username: String,
    var password: String,
    var mail: String
)
