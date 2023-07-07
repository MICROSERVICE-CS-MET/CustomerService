package com.example.customerservice.service

import com.example.customerservice.domain.model.Customer
import com.example.customerservice.exception.NotFoundException
import com.example.customerservice.repositoy.CustomerRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import java.util.UUID

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

    suspend fun getById(id:UUID): Customer{
        return customerRepository.findById(id) ?: throw NotFoundException("Customer not found")
    }

    suspend fun delete(id:UUID){
        return customerRepository.deleteById(id)
    }

    suspend fun update(customer: Customer):Customer{
        return customerRepository.save(customer)
    }
}
