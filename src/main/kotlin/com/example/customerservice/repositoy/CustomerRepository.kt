package com.example.customerservice.repositoy

import com.example.customerservice.domain.model.Customer
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface CustomerRepository : CoroutineCrudRepository<Customer, UUID> {
}