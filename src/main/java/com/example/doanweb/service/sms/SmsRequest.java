package com.example.doanweb.service.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {
    @NotBlank
    private final String phoneNumber;

    @NotBlank
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        String sdt = "+84";
        char[] chuoi = phoneNumber.toCharArray();
        for(int i = 1; i < chuoi.length; i++){
            sdt = sdt + chuoi[i];
        }
        System.out.println("so dien thoai sau khi da chuyen doi: " + sdt);
        this.phoneNumber = sdt;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
