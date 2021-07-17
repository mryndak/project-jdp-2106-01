package com.kodilla.ecommerce.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.smsapi.OAuthClient;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.proxy.ProxyNative;

@Configuration
public class SmsApiConfig {

    final static String urlForPlSmsapi = "http://api.smsapi.pl/";
    final static String urlForComSmsapi = "http://api.smsapi.com/";

    @SneakyThrows
    @Bean
    public SmsFactory createSmsFactory(@Value("${smsapi.ouathToken}") final String oauthToken) {
        OAuthClient client = new OAuthClient(oauthToken);
        ProxyNative proxyToPlOrComSmsapi = new ProxyNative(urlForPlSmsapi);
        SmsFactory smsApi = new SmsFactory(client, proxyToPlOrComSmsapi);

        return smsApi;

    }
}
