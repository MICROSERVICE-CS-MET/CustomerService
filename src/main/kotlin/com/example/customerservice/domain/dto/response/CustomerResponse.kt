package com.example.customerservice.domain.dto.response

import java.util.*

class CustomerResponse (
    val id: UUID,
    var firstname: String,
    var lastname: String,
    var username: String,
    var password: String,
    var mail: String
)