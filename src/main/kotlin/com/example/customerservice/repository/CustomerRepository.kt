package com.example.customerservice.repository

import com.example.customerservice.domain.model.Customer
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface CustomerRepository : CoroutineCrudRepository<Customer, UUID> {

    suspend fun findByEmail(mail: String): Customer?
}
