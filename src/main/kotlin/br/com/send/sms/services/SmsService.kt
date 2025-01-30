package br.com.send.sms.services

import br.com.send.sms.config.TwilioConfig
import br.com.send.sms.model.Contact
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmsService(
    @Autowired private var twilioConfig: TwilioConfig
) {

    fun sendMultipleSMS(
        contactList: List<Contact>,
        message: String
    ) {
        contactList
            .parallelStream()
            .forEach { user ->
                Message.creator(
                    PhoneNumber(user.phoneNumber),
                    PhoneNumber(twilioConfig.phoneNumber),
                    message
                ).create()
            }
    }
}
