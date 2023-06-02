package com.changeapi.inovapp.login

import LoginRequestModel
import LoginResponse
import com.changeapi.inovapp.model.OnlineMeeting
import com.changeapi.inovapp.videocall.VideoCallRepo
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LoginRepo {
    companion object {
        private val logger = LoggerFactory.getLogger(VideoCallRepo::class.java)
    }
    fun login(loginInfo: LoginRequestModel): String{
        return try {
            val loginRequestBody= Gson().toJson(loginInfo)
            val(_, response, result) = Fuel.post("https://mcbinovappapi.azurewebsites.net/auth")
                .header("Content-Type","application/json")
                .body(loginRequestBody).responseString()

            when(result) {
                is Result.Success -> {
                    val responseBody = response.body()
                    println("Response body: $responseBody")
                    println(result.value)
                    val loginResponse = Gson().fromJson(result.value, LoginResponse::class.java)
                    println("token: ${loginResponse.token}")
                    loginResponse.token

                }
                is Result.Failure -> {
                    val error = result.getException().response
                    println("Request failed: $error")
                    "Request failed: $error"
                }
            }

        } catch (e: Exception){
            "error"
        }

    }
}