package com.example.doanweb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.doanweb.service.LienHeTKService;

@RestController
@RequestMapping("/rest")
public class LienHeTKRestController {
    @Autowired
    LienHeTKService lienHeTKService;
    @GetMapping("/lienHeTk")
    public Integer countLH(String monthYear) {
        return lienHeTKService.countLienHeTK(monthYear);
    }
}
