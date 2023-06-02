package com.changeapi.inovapp.login

import LoginRequestModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/login")
@Component
class LoginController @Autowired constructor(
    val loginRepo: LoginRepo
){
    @PostMapping()
    fun getCallLink(
        @RequestBody loginRequestModel: LoginRequestModel
    ): String {
        return loginRepo.login(loginRequestModel)
    }
}