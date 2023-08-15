package com.example.customerservice.domain.dto.request

data class CreateCustomerRequest(
    var fullName: String,
    var password: String,
    var email: String
)
