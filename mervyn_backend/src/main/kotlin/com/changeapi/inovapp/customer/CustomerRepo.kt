package com.changeapi.inovapp.customer

import com.changeapi.inovapp.model.CustomerInfoModel
import com.changeapi.inovapp.model.OnlineMeeting
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class CustomerRepo {
    fun getCustomerInfo(customerNumber: String, bearerAuth: String) {
        try{
            val(request, response, result) = Fuel.get("https://mcbinovappapi.azurewebsites.net/customers/${customerNumber}")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer $bearerAuth")
                .responseString()

            when(result) {
                is Result.Success -> {
                    val responseBody = response.body()
                    println("Response body: $responseBody")
                    println(result.value)
                    val teamsCallDetail = Gson().fromJson(result.value, CustomerInfoModel::class.java)
//                    println("joinUrl: ${c.joinUrl}")

                }
                is Result.Failure -> {
                    val error = result.getException().response
                    println("Request failed: $error")
                    "Request failed: $error"
                }
            }
        }catch (e: Exception) {
            println("${e.message}")
        }

    }
}