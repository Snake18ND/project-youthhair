package com.example.doanweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.doanweb.entity.DichVuHot;
import com.example.doanweb.entity.Services;
import com.example.doanweb.service.dto.ServiceDTO;

import java.util.List;
import java.util.Optional;

public interface IServiceService {

    List<Services> findAll();

    Optional<Services> findById(Integer id);
    Services getById (Integer id);

    Page<Services> findAll(Pageable pageable);
    boolean checkService (Services services);
    ServiceDTO save(ServiceDTO serviceDTO);

    Services update(Services services);

    List<Services> seachServiceByName(String serviceName);

    List<Services> findServicesActive();

	List<DichVuHot> findServicesActiveTop3();
}
