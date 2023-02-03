package com.example.doanweb.service;

import com.example.doanweb.entity.LienHeTK;
import com.example.doanweb.entity.ThongKeDT;

public interface LienHeTKService {
    Integer countLienHeTK(String monthYear);

    boolean checkLH(LienHeTK lh);
}
