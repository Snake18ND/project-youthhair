package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.CustomerDAO;
import com.example.doanweb.entity.Customer;
import com.example.doanweb.entity.Voucher;
import com.example.doanweb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public <S extends Customer> S save(S entity) {
		return customerDAO.save(entity);
	}

	@Override
	public <S extends Customer> Optional<S> findOne(Example<S> example) {
		return customerDAO.findOne(example);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerDAO.findAll(pageable);
	}

	@Override
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return customerDAO.findAll(sort);
	}

	@Override
	public List<Customer> findAllById(Iterable<Integer> ids) {
		return customerDAO.findAllById(ids);
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return customerDAO.findById(id);
	}

	@Override
	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
		return customerDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		customerDAO.flush();
	}

	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		return customerDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return customerDAO.existsById(id);
	}

	@Override
	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return customerDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return customerDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		customerDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Customer> long count(Example<S> example) {
		return customerDAO.count(example);
	}

	@Override
	public <S extends Customer> boolean exists(Example<S> example) {
		return customerDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Customer> entities) {
		customerDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return customerDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		customerDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		customerDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Customer entity) {
		customerDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		customerDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		customerDAO.deleteAllInBatch();
	}

	@Override
	public Customer getOne(Integer id) {
		return customerDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Customer> entities) {
		customerDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		customerDAO.deleteAll();
	}

	@Override
	public Customer getById(Integer id) {
		return customerDAO.getById(id);
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		return customerDAO.findAll(example);
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		return customerDAO.findAll(example, sort);
	}
	
	
	public Customer create(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public List<Customer> seachCustomer(String fullName){
		return customerDAO.seachCustomer(fullName);
	}

}
