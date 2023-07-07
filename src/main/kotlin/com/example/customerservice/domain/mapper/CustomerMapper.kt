package com.example.customerservice.domain.mapper

import com.example.customerservice.domain.dto.request.CreateCustomerRequest
import com.example.customerservice.domain.dto.request.UpdateCustomerRequest
import com.example.customerservice.domain.dto.response.CustomerResponse
import com.example.customerservice.domain.model.Customer
import org.mapstruct.Mapper

@Mapper
interface CustomerMapper {
    fun createRequestToCustomer(customerTo: CreateCustomerRequest): Customer

    fun customerToResponse(customer: Customer):CustomerResponse

    fun customersToCustomerResponse(customers: List<Customer>): List<CustomerResponse>

    fun updateCustomerRequestToCustomer(updateCustomerRequest: UpdateCustomerRequest): Customer

}