package com.example.customerservice.domain.dto.request

data class CreateCustomerRequest(
    var fullName: String,
    var username: String,
    var password: String,
    var mail: String
)
