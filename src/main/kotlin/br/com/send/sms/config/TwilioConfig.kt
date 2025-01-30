package br.com.send.sms.config

import com.twilio.Twilio
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class TwilioConfig(
    @Value("\${twilio.account-sid}") val accountSid: String,
    @Value("\${twilio.auth-token}") val authToken: String,
    @Value("\${twilio.phone-number}") val phoneNumber: String
) {
    @PostConstruct
    fun twilioInit() {
        Twilio.init(
            accountSid,
            authToken
        )
    }
}
