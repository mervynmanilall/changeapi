package com.changeapi.inovapp.model

data class CustomerInfoModel (
    val CustomerId: String,
    val CustomerStatus: String,
    val Title: String,
    val FirstName: String,
    val LastName: String,
    val DateOfBirth: String,
    val preferredLanguage: String,
    val Gender: String,
    val PhoneNumber: String,
    val StreetName: String,
    val City: String,
    val PostalCode: String,
    val Country: String,
    val JobTitle: String,
    val Salary: String,
    val EmployerName: String,
    val LastKycUpdated: String
)
