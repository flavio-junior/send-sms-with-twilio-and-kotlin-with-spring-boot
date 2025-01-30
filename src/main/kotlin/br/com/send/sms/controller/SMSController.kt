package br.com.send.sms.controller

import br.com.send.sms.model.MultipleSMSBody
import br.com.send.sms.services.SmsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sms")
class SmsController(
    @Autowired private var smsService: SmsService
) {

    @PostMapping(value = ["send/multiple/sms"])
    fun sendMultipleSMS(@RequestBody multipleSMSBody: MultipleSMSBody) {
        smsService.sendMultipleSMS(
            multipleSMSBody.contacts,
            multipleSMSBody.message
        )
    }
}
