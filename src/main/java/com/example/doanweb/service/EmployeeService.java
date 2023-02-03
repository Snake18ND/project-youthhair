package com.example.doanweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.doanweb.entity.Employee;
import com.example.doanweb.service.dto.StylistDTO;

public interface EmployeeService {

	<S extends Employee> List<S> findAll(Example<S> example, Sort sort);

	<S extends Employee> List<S> findAll(Example<S> example);

	Employee getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Employee> entities);

	Employee getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Employee entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Employee> entities);

	<S extends Employee> boolean exists(Example<S> example);

	<S extends Employee> long count(Example<S> example);

	void deleteInBatch(Iterable<Employee> entities);

	<S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Employee> S saveAndFlush(S entity);

	void flush();

	<S extends Employee> List<S> saveAll(Iterable<S> entities);

	Optional<Employee> findById(Integer id);

	List<Employee> findAllById(Iterable<Integer> ids);

	List<Employee> findAll(Sort sort);

    List<Employee> bookingByStylist();

    List<Employee> findAll();

	Page<Employee> findAll(Pageable pageable);

	<S extends Employee> Optional<S> findOne(Example<S> example);

	<S extends Employee> S save(S entity);

	Employee create(Employee employee);

	Employee update(Employee employee);

	void delete(Integer id);


	List<Employee> loadStylist();

	List<StylistDTO> findStocktotal();

	List<Employee> seachEmployee(String fullName);

	List<Employee> getAllEmployeeActive();

	Integer countNv();

	Integer countStyList();
}
