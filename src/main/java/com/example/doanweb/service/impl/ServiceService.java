package com.example.doanweb.service.impl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.DichVuHotDAO;
import com.example.doanweb.dao.ServiceDAO;
import com.example.doanweb.entity.DichVuHot;
import com.example.doanweb.entity.Services;
import com.example.doanweb.service.IServiceService;
import com.example.doanweb.service.dto.ServiceDTO;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    ServiceDAO serviceDAO;
    @Autowired
    DichVuHotDAO dichVuHotDAO;


    @Override
    public List<Services> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public Optional<Services> findById(Integer id) {
        return serviceDAO.findById(id);
    }

    @Override
    public Services getById(Integer id) {
        return serviceDAO.getById(id);
    }


    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceDAO.findAll(pageable);
    }

    @Override
    public boolean checkService(Services services) {
        return services != null ? true :false;
    }


    @Override
    public ServiceDTO save(ServiceDTO serviceDTO) {
        Services services=serviceDAO.selectById(serviceDTO.getId());
        //Time time = null;
        //get time
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(serviceDTO.getTime());
            //time = new Time(date1.getTime());
            System.out.println("tostring: " + date1.toString());
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (checkService(services)){
            System.out.println(services.getServiceName());
            services.setServiceName(serviceDTO.getServiceName());
//            services.setTime(time);
            services.setImage(serviceDTO.getImage());
            services.setNote(serviceDTO.getNote());
            services.setStatus(serviceDTO.getStatus());
            services.setPrice(serviceDTO.getPrice());
            serviceDAO.save(services);
        }
        else {
            //set dữ liệu vào entity services
            Services servicesadd= new Services();
            servicesadd.setServiceName(serviceDTO.getServiceName());
//            servicesadd.setTime(time);
            servicesadd.setImage(serviceDTO.getImage());
            servicesadd.setNote(serviceDTO.getNote());
            servicesadd.setStatus(serviceDTO.getStatus());
            servicesadd.setPrice(serviceDTO.getPrice());
            serviceDAO.save(servicesadd);
//            System.out.println("2:" + servicesadd.getTime() + "3 : " + time);
        }
        return serviceDTO;
    }

    @Override
    public Services update(Services services) {
        return null;
    }

    @Override
    public List<Services> seachServiceByName(String serviceName) {
        return serviceDAO.seachSericesByName(serviceName);
    }

	@Override
	public List<Services> findServicesActive() {
		return serviceDAO.findServicesActive();
	}

	@Override
	public List<DichVuHot> findServicesActiveTop3() {
		return dichVuHotDAO.findServicesActiveTop3();
	}
}
