package com.kodilla.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.api.response.StatusResponse;
import pl.smsapi.exception.SmsapiException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsSender {

    private final SmsFactory smsFactory;

    public void sendMessage(String phoneNumber, String content) throws SmsapiException {

        StatusResponse response = smsFactory.actionSend()
                .setText(content)
                .setTo(phoneNumber)
                .execute();

    }
}
