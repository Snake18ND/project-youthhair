package com.example.doanweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doanweb.dao.ThongKeDAO;
import com.example.doanweb.entity.ThongKeDT;
import com.example.doanweb.service.ThongKeService;

@Service
public class ThongkeServicempl implements ThongKeService {
    @Autowired
    ThongKeDAO thongKeDAO;


    @Override
    public float getDTByMonth(String monthYear) {
        if(monthYear.equals("") || monthYear==null){
            System.out.println("Nếu không chọn tháng thì sẽ lấy tháng hiện tại");
        }
        float doanhThu=0;

        ThongKeDT thongKeDT=thongKeDAO.thongKeDT(monthYear);
        if (checkDT(thongKeDT)){
            doanhThu=thongKeDAO.doanhThuByMonth(monthYear);
        }
        return doanhThu;
    }

    @Override
    public boolean checkDT(ThongKeDT dt) {
        return dt != null ? true :false;
    }

	@Override
	public float thongKeLichHenCPM(String monthYear) {
		if(monthYear.equals("") || monthYear==null){
            System.out.println("Nếu không chọn tháng thì sẽ lấy tháng hiện tại");
        }
        
        return thongKeDAO.thongKeLichHenCPM(monthYear);
	}

	@Override
	public float thongKeLichHenAll(String monthYear) {
		if(monthYear.equals("") || monthYear==null){
            System.out.println("Nếu không chọn tháng thì sẽ lấy tháng hiện tại");
        }
        
        return thongKeDAO.thongKeLichHenAll(monthYear);
	}
}
