package com.example.doanweb.service.impl;

import java.math.BigInteger;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.EmployeeDAO;
import com.example.doanweb.entity.Employee;
import com.example.doanweb.service.EmployeeService;
import com.example.doanweb.service.dto.StylistDTO;

import javax.persistence.Tuple;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public <S extends Employee> S save(S entity) {
		return employeeDAO.save(entity);
	}

	@Override
	public <S extends Employee> Optional<S> findOne(Example<S> example) {
		return employeeDAO.findOne(example);
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		return employeeDAO.findAll(pageable);
	}

	@Override
	public List<Employee> bookingByStylist() {
		return employeeDAO.bookingByStylist();
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public List<Employee> findAll(Sort sort) {
		return employeeDAO.findAll(sort);
	}

	@Override
	public List<Employee> findAllById(Iterable<Integer> ids) {
		return employeeDAO.findAllById(ids);
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return employeeDAO.findById(id);
	}

	@Override
	public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
		return employeeDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		employeeDAO.flush();
	}

	@Override
	public <S extends Employee> S saveAndFlush(S entity) {
		return employeeDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return employeeDAO.existsById(id);
	}

	@Override
	public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
		return employeeDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
		return employeeDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Employee> entities) {
		employeeDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Employee> long count(Example<S> example) {
		return employeeDAO.count(example);
	}

	@Override
	public <S extends Employee> boolean exists(Example<S> example) {
		return employeeDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Employee> entities) {
		employeeDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return employeeDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		employeeDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		employeeDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Employee entity) {
		employeeDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		employeeDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		employeeDAO.deleteAllInBatch();
	}

	@Override
	public Employee getOne(Integer id) {
		return employeeDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		employeeDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employeeDAO.deleteAll();
	}

	@Override
	public Employee getById(Integer id) {
		return employeeDAO.getById(id);
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example) {
		return employeeDAO.findAll(example);
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
		return employeeDAO.findAll(example, sort);
	}

	@Override
	public Employee create(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeDAO.deleteById(id);
		
	}
	public List<Employee> loadStylist(){

		return employeeDAO.bookingByStylist();
	}

	public List<StylistDTO> findStocktotal() {
		List<Tuple> stockTotalTuples = employeeDAO.getAllStylistST();
		List<StylistDTO> stockTotalDto = stockTotalTuples.stream()
				.map(t -> new StylistDTO(
						t.get(0, Integer.class),
						t.get(1, String.class),
						t.get(2, String.class),
						//t.get(3, Time.class),
						t.get(3, String.class)
				))
				.collect(Collectors.toList());

		return stockTotalDto;
	}

	@Override
	public List<Employee> seachEmployee(String fullName){
		return employeeDAO.seachEmployee(fullName);
	}

	@Override
	public List<Employee> getAllEmployeeActive() {
		return employeeDAO.getAllEmployeeActive();
	}

	@Override
	public Integer countNv() {
		Integer countNV= employeeDAO.countNv();
		return countNV;
	}

	@Override
	public Integer countStyList() {
		Integer countStyList= employeeDAO.countStyList();
		return countStyList;
	}

}
