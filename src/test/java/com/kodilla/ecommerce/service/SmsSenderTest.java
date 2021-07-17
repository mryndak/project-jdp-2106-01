package com.kodilla.ecommerce.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.smsapi.exception.SmsapiException;

@SpringBootTest
class SmsSenderTest {

    @Autowired
    private SmsSender smsSender;

    @Test
    void should_send_sms() throws SmsapiException {
        // given
        String phoneNumber = "";
        String message = "To jest sms z naszej aplikacji eCommerce";

        // when
        smsSender.sendMessage(phoneNumber, message);

        // then
    }

}