package com.changeapi.inovapp.branch

import com.changeapi.inovapp.login.LoginRepo
import com.changeapi.inovapp.model.BranchModel
import com.changeapi.inovapp.model.ExposedBranchesInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/branches")
@Component
class BranchController @Autowired constructor(
    val branchRepo: BranchRepo
){
    @GetMapping()
    fun getCallLink(): List<BranchModel>? {
        return branchRepo.getBranchesInfo()
    }
}