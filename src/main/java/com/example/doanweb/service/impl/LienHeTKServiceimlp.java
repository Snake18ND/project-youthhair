package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doanweb.dao.LienHeTKDAO;
import com.example.doanweb.entity.LienHeTK;
import com.example.doanweb.entity.ThongKeDT;
import com.example.doanweb.service.LienHeTKService;

@Service
public class LienHeTKServiceimlp implements LienHeTKService {
    @Autowired
    LienHeTKDAO lienHeTKDAO;

    @Override
    public Integer countLienHeTK(String monthYear) {
        if(monthYear.equals("") || monthYear==null){
            System.out.println("Nếu không chọn tháng thì sẽ lấy tháng hiện tại");
        }
        Integer countLH=0;

        LienHeTK lienHeTK=lienHeTKDAO.getLienHeTK(monthYear);
        if (checkLH(lienHeTK)){
            countLH=lienHeTKDAO.countLienHeTK(monthYear);
        }
        return countLH;
    }

    @Override
    public boolean checkLH(LienHeTK lh) {
        return lh != null ? true :false;
    }
}
