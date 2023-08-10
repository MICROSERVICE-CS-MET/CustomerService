package com.example.customerservice.domain.dto.response

import java.util.*

class CustomerResponse(
    val id: UUID,
    var firstName: String,
    var lastName: String,
    var username: String,
    var password: String,
    var mail: String
)
