package com.example.customerservice.service

import com.example.customerservice.domain.model.Customer
import com.example.customerservice.repositoy.CustomerRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
){
    suspend fun getAll(): List<Customer>{
        return customerRepository.findAll().toList()
    }

    suspend fun save(customer: Customer): Customer{
        return customerRepository.save(customer)
    }
}
