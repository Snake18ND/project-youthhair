package com.example.doanweb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.doanweb.service.ThongKeService;

@RestController
@RequestMapping("/rest")
public class ThongKeDTRestController {
    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/thongKeDT")
    public float thongKeDT(String monthYear) {
        return thongKeService.getDTByMonth(monthYear);
    }
    
    @GetMapping("/thongKeLichHenCPM")
    public float thongKeLichHenCPM(String monthYear) {
        return thongKeService.thongKeLichHenCPM(monthYear);
    }
    
    @GetMapping("/thongKeLichHen")
    public float thongKeLichHen(String monthYear) {
        return thongKeService.thongKeLichHenAll(monthYear);
    }
}
