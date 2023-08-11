package com.example.customerservice.service

import com.example.customerservice.domain.dto.request.LoginRequest
import com.example.customerservice.domain.model.Customer
import com.example.customerservice.exception.NotFoundException
import com.example.customerservice.repository.CustomerRepository
import kotlinx.coroutines.flow.toList
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.UUID

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val passwordEncoder: PasswordEncoder

) {
    suspend fun getAll(): List<Customer> {
        return customerRepository.findAll().toList()
    }

    suspend fun save(customer: Customer): Customer {
        customerRepository.findByMail(customer.mail)?.let { throw RuntimeException("Customer already existed, use different mail!") }
        customerRepository.findByUsername(customer.username)?.let { throw RuntimeException("Customer already existed, use different username!") }
        customer.password = passwordEncoder.encode(customer.password)
        return customerRepository.save(customer)
    }

    suspend fun getById(id: UUID): Customer {
        return customerRepository.findById(id) ?: throw RuntimeException("Customer not found")
    }

    suspend fun delete(id: UUID) {
        return customerRepository.deleteById(id)
    }

    suspend fun update(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    suspend fun login(customer: LoginRequest): Customer {
        val optionalCustomer = customerRepository.findByUsername(customer.email) ?: throw NotFoundException("Customer not found")
        if (passwordEncoder.matches(customer.password, optionalCustomer.password)) {
            return optionalCustomer
        }
        throw RuntimeException("Password not matched!")
    }
}
