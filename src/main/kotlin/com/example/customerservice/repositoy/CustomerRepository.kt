package com.example.customerservice.repositoy

import com.example.customerservice.domain.model.Customer
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*
import javax.print.attribute.standard.JobOriginatingUserName

interface CustomerRepository : CoroutineCrudRepository<Customer, UUID> {
    suspend fun findByUsername(userName: String): Customer?

    suspend fun findByMail(mail: String): Customer?
}