package com.example.customerservice.domain.dto.request

import java.util.*

data class CreateCustomerRequest(
    var firstName: String,
    var lastName: String,
    var username: String,
    var password: String,
    var mail: String
)
