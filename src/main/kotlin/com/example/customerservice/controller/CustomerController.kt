package com.example.customerservice.controller

import com.example.customerservice.domain.dto.request.CreateCustomerRequest
import com.example.customerservice.domain.dto.request.LoginRequest
import com.example.customerservice.domain.dto.request.UpdateCustomerRequest
import com.example.customerservice.domain.dto.response.CustomerResponse
import com.example.customerservice.domain.mapper.CustomerMapper
import com.example.customerservice.domain.model.Customer
import com.example.customerservice.service.CustomerService
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/get-all")
    suspend fun getAll(): List<CustomerResponse> {
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        return converter.customersToCustomerResponse(customerService.getAll())
    }

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable("id") id: UUID): CustomerResponse {
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        val customer = customerService.getById(id)
        return converter.customerToResponse(customer)
    }

    @GetMapping("/findByEmail/{email}")
    suspend fun findByEmail(@PathVariable("email") email: String): CustomerResponse {
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        return converter.customerToResponse(customerService.findByEmail(email))
    }

    @PostMapping("/validate-user")
    suspend fun validateUser(@RequestBody loginRequest: LoginRequest): Customer {
        return customerService.login(loginRequest)
    }

    @PostMapping("/register")
    suspend fun save(@RequestBody customerRequest: CreateCustomerRequest): CustomerResponse {
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        val savedCustomer = customerService.save(converter.createRequestToCustomer(customerRequest))
        return converter.customerToResponse(savedCustomer)
    }

    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable("id") id: UUID): ResponseEntity<String> {
        customerService.delete(id)
        return ResponseEntity.ok("Customer deleted!")
    }

    //PutMapping
    @PutMapping
    suspend fun update(@RequestBody updateCustomerRequest: UpdateCustomerRequest): CustomerResponse {
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        val updatedCustomer = customerService.update(converter.updateCustomerRequestToCustomer(updateCustomerRequest))
        return converter.customerToResponse(updatedCustomer)
    }
}
