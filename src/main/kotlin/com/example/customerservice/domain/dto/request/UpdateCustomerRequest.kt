package com.example.customerservice.domain.dto.request

import java.util.*

data class UpdateCustomerRequest(
    val id: UUID,
    var fullName: String,
    var username: String,
    var password: String,
    var mail: String
)
