package com.changeapi.inovapp.branch

import com.changeapi.inovapp.model.BranchModel
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Component

@Component
class BranchRepo {
    fun getBranchesInfo(): List<BranchModel>?{
        return try {
            val(request, response, result) = Fuel.get("https://mcbinovappapi.azurewebsites.net/bank/branches/")
                .header("Content-Type","application/json")
                .responseString()

            when(result) {
                is Result.Success -> {
                    val responseBody = response.body()
                    println("Response body: $responseBody")
                    println(result.value)
                    val branchListType = object : TypeToken<List<BranchModel>>() {}.type
                    val branchesDetail: List<BranchModel> = Gson().fromJson(result.value, branchListType)
//                    val branchesDetail: List<BranchModel> = listOf(Gson().fromJson(result.value, BranchModel::class.java))
//                    println("joinUrl: ${c.joinUrl}")
                    branchesDetail

                }
                is Result.Failure -> {
                    val error = result.getException().response
                    println("Request failed: $error")
                    null
                }
            }
        } catch (e: Exception){
            println("${e.message}")
            null
        }
    }
}