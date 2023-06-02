package com.changeapi.inovapp.videocall

import com.changeapi.inovapp.model.OnlineMeeting
import com.changeapi.inovapp.model.VideoCallModel
import com.changeapi.inovapp.model.VideoCallRequest
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import com.github.kittinunf.result.Result

@Component
class VideoCallRepo {
    fun getMeetingInfo(videoCallRequest: VideoCallRequest): String {
        return try {
            val url = "https://graph.microsoft.com/v1.0/me/onlineMeetings"
            val callBody = VideoCallModel(
                startDateTime = videoCallRequest.startDateTime,
                endDateTime = videoCallRequest.endDateTime,
                subject = "Meeting with ${videoCallRequest.requestorName} for ${videoCallRequest.reason}"
            )
            val videoCallRequestBody= Gson().toJson(callBody)
            val(request, response, result) = Fuel.post(url)
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IlFad0R0UnY2LWh3ZDBfQlpoMHVkUmVsR2pEcGE4bWh2cVRmTll2XzZLVVEiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC83YTBhYTYxZS1mYmM0LTRiZjEtYTM2Ny1kZTg4MWE1NzI4ODcvIiwiaWF0IjoxNjg1NjgyMzUyLCJuYmYiOjE2ODU2ODIzNTIsImV4cCI6MTY4NTY4NzYzNCwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFWUUFxLzhUQUFBQWtrbGU1S1lia2lNOHdEZSt3NXZsRFpnb0hKaEg5Z3BTREhXYStIUVhLem1qUU9EbGg3S09FdHp4ODhOci9pQ3p5eS9nTCtTVVNaWWgzbDVIYlNkTC8zb2dZQUtSbHU5VUhkK0h6NUY3ZFpNPSIsImFtciI6WyJwd2QiLCJtZmEiXSwiYXBwX2Rpc3BsYXluYW1lIjoiTVMtR3JhcGgtVGVhbXMtRGVtbyIsImFwcGlkIjoiMTcwMWJjMWYtNmM5My00NGRiLThiYzQtNGQ5NjdmMjRmYzI2IiwiYXBwaWRhY3IiOiIxIiwiZmFtaWx5X25hbWUiOiJNYW5pbGFsbCIsImdpdmVuX25hbWUiOiJNZXJ2eW4iLCJpZHR5cCI6InVzZXIiLCJpcGFkZHIiOiIxMDIuMTE3LjUzLjE4OSIsIm5hbWUiOiJNYW5pbGFsbCBNZXJ2eW4iLCJvaWQiOiJjNTM5ZTQ0ZS0yNzBhLTQxOTAtYWRmNy00NzVlNjI0NmRjOTciLCJvbnByZW1fc2lkIjoiUy0xLTUtMjEtMTgwMjEzOTM4MS04NjUyODE1MDAtMjA3OTYwMDgyOC01MzExMjYiLCJwbGF0ZiI6IjUiLCJwdWlkIjoiMTAwMzIwMDAzRjMwODQ3OSIsInJoIjoiMC5BUkFBSHFZS2VzVDc4VXVqWjk2SUdsY29od01BQUFBQUFBQUF3QUFBQUFBQUFBQ1hBSUUuIiwic2NwIjoiQ2FsZW5kYXJzLlJlYWRXcml0ZSBDYWxlbmRhcnMuUmVhZFdyaXRlLlNoYXJlZCBNYWlsLlJlYWQgT25saW5lTWVldGluZ3MuUmVhZFdyaXRlIG9wZW5pZCBVc2VyLlJlYWQgcHJvZmlsZSBlbWFpbCIsInN1YiI6Iko0S0xZT2M0UWoxdHZzVDV3ZE9KN0xqZ2U5dUFVaGpVMG1NSFQ4QW5JSVEiLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiQUYiLCJ0aWQiOiI3YTBhYTYxZS1mYmM0LTRiZjEtYTM2Ny1kZTg4MWE1NzI4ODciLCJ1bmlxdWVfbmFtZSI6Im1lcnZ5bi5tYW5pbGFsbEBtY2IubXUiLCJ1cG4iOiJtZXJ2eW4ubWFuaWxhbGxAbWNiLm11IiwidXRpIjoibjlZVEVGS1luRWVPSHhhZElpSm1BQSIsInZlciI6IjEuMCIsIndpZHMiOlsiYjc5ZmJmNGQtM2VmOS00Njg5LTgxNDMtNzZiMTk0ZTg1NTA5Il0sInhtc19zdCI6eyJzdWIiOiJiT2FJRlBibHFPRGU3Q1g0SmpxMVEydnZfUF9tOWhWeXQ4ZFJQX2dOaUdjIn0sInhtc190Y2R0IjoxNDI4MDU5MzU1fQ.ECZyKsTW6HhuisT3G4yGA9-XH_0PUECJrU2oNWeOKAAMxvhwFyR8kXZY-X14yTilbcynZ4202Jm9mhZYh_2D3GSZE_Kp9EcY9Lx67DF8Fa3umM5RUEbSgMvWhxKQnzdtRxg-CwGdnvmUg13Y3KeXZDuMYbIXIaHAgIkuciRi1LIYLEd9qaDW_RPqskUEPV751BCONFJ7gO4R7LRPQrlencFG6tBO6Rkj__2GgwLfb_43w_oIWWyh0DwpbmSq9h9CKT1B2d7iaZczboy7gUI_i89obUWfLzGqAAUu0qOFp_JhFrHnO_b-Mo-CkOtMnwYLXZF5l8Hjn3jV2DUsesSkig")
                .body(videoCallRequestBody).responseString()

            when(result) {
                is Result.Success -> {
                    val responseBody = response.body()
                    println("Response body: $responseBody")
                    println(result.value)
                    val teamsCallDetail = Gson().fromJson(result.value, OnlineMeeting::class.java)
//                    println("joinUrl: ${c.joinUrl}")
                    teamsCallDetail.joinUrl

                }
                is Result.Failure -> {
                    val error = result.getException().response
                    println("Request failed: $error")
                    "Request failed: $error"
                }
            }
        } catch (e: Exception) {
            "error"
        }
    }
}