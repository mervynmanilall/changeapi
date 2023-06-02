package com.changeapi.inovapp.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/customerInfo")
@Component
class CustomerController @Autowired constructor(
    val customerRepo: CustomerRepo
){
    @GetMapping()
    fun getCustomerInfo(
        @RequestParam customerNumber: String,
        @RequestParam bearerAuth: String
    ){
        return customerRepo.getCustomerInfo(customerNumber, bearerAuth)
    }

}