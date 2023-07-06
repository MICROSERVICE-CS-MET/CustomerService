package com.example.customerservice.controller

import com.example.customerservice.domain.dto.request.CreateCustomerRequest
import com.example.customerservice.domain.dto.response.CustomerResponse
import com.example.customerservice.domain.mapper.CustomerMapper
import com.example.customerservice.service.CustomerService
import org.mapstruct.factory.Mappers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val customerService: CustomerService,
) {
    @GetMapping("")
    suspend fun getAll(): List<CustomerResponse>{
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        return converter.customersToCustomerResponse(customerService.getAll())
    }

    @PostMapping("")
    suspend fun save(@RequestBody customerRequest: CreateCustomerRequest): CustomerResponse{
        val converter = Mappers.getMapper(CustomerMapper::class.java)
        val savedCustomer = customerService.save(converter.createRequestToCustomer(customerRequest))
        return converter.customerToResponse(savedCustomer)
    }
}