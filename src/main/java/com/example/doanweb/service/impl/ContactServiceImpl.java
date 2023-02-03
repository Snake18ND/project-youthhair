package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.ContactDAO;
import com.example.doanweb.entity.Contact;
import com.example.doanweb.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactDAO contactDAO;

	@Override
	public <S extends Contact> S save(S entity) {
		return contactDAO.save(entity);
	}

	@Override
	public <S extends Contact> Optional<S> findOne(Example<S> example) {
		return contactDAO.findOne(example);
	}

	@Override
	public Page<Contact> findAll(Pageable pageable) {
		return contactDAO.findAll(pageable);
	}

	@Override
	public List<Contact> findAll() {
		return contactDAO.findAll();
	}

	@Override
	public List<Contact> findAll(Sort sort) {
		return contactDAO.findAll(sort);
	}

	@Override
	public List<Contact> findAllById(Iterable<Integer> ids) {
		return contactDAO.findAllById(ids);
	}

	@Override
	public Optional<Contact> findById(Integer id) {
		return contactDAO.findById(id);
	}

	@Override
	public <S extends Contact> List<S> saveAll(Iterable<S> entities) {
		return contactDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		contactDAO.flush();
	}

	@Override
	public <S extends Contact> S saveAndFlush(S entity) {
		return contactDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return contactDAO.existsById(id);
	}

	@Override
	public <S extends Contact> List<S> saveAllAndFlush(Iterable<S> entities) {
		return contactDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable) {
		return contactDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Contact> entities) {
		contactDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Contact> long count(Example<S> example) {
		return contactDAO.count(example);
	}

	@Override
	public <S extends Contact> boolean exists(Example<S> example) {
		return contactDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Contact> entities) {
		contactDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return contactDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		contactDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		contactDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Contact entity) {
		contactDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		contactDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		contactDAO.deleteAllInBatch();
	}

	@Override
	public Contact getOne(Integer id) {
		return contactDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Contact> entities) {
		contactDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		contactDAO.deleteAll();
	}

	@Override
	public Contact getById(Integer id) {
		return contactDAO.getById(id);
	}

	@Override
	public <S extends Contact> List<S> findAll(Example<S> example) {
		return contactDAO.findAll(example);
	}

	@Override
	public <S extends Contact> List<S> findAll(Example<S> example, Sort sort) {
		return contactDAO.findAll(example, sort);
	}

	@Override
	public List<Contact> findContactStatus(Boolean status, String keyword) {
		return contactDAO.findContactStatus(status, keyword);
	}

	@Override
	public  List<Contact> seachContact(String fullName, boolean status){
		return contactDAO.seachContact(fullName,status);
	}
	
}
