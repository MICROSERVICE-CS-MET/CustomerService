package com.example.customerservice.domain.dto.response

import java.util.*

data class CustomerResponse(
    val id: UUID,
    var fullName: String,
    var username: String,
    var password: String,
    var mail: String
)
