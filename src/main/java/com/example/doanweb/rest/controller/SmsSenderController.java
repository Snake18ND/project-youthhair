package com.example.doanweb.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.doanweb.service.sms.SmsRequest;
import com.example.doanweb.service.sms.SmsService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class SmsSenderController {
    private final SmsService smsService;

    public SmsSenderController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
//        SmsRequest smsRequest = new SmsRequest("+84974806341", "hello con vo duong");
        smsService.sendSms(smsRequest);
    }
}
