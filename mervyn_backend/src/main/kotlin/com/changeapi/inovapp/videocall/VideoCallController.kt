package com.changeapi.inovapp.videocall

import com.changeapi.inovapp.model.VideoCallRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/videocall")
@Component
class VideoCallController @Autowired constructor(
    val videoCallRepo: VideoCallRepo
){
    @GetMapping()
    fun getCallLink(
        @RequestBody videoCallRequest: VideoCallRequest
    ): String {
        return videoCallRepo.getMeetingInfo(videoCallRequest)
    }
}