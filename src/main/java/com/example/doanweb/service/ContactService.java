package com.example.doanweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.doanweb.entity.Contact;

public interface ContactService {

	<S extends Contact> List<S> findAll(Example<S> example, Sort sort);

	<S extends Contact> List<S> findAll(Example<S> example);

	Contact getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Contact> entities);

	Contact getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Contact entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Contact> entities);

	<S extends Contact> boolean exists(Example<S> example);

	<S extends Contact> long count(Example<S> example);

	void deleteInBatch(Iterable<Contact> entities);

	<S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Contact> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Contact> S saveAndFlush(S entity);

	void flush();

	<S extends Contact> List<S> saveAll(Iterable<S> entities);

	Optional<Contact> findById(Integer id);

	List<Contact> findAllById(Iterable<Integer> ids);

	List<Contact> findAll(Sort sort);

	List<Contact> findAll();

	Page<Contact> findAll(Pageable pageable);

	<S extends Contact> Optional<S> findOne(Example<S> example);

	<S extends Contact> S save(S entity);

	List<Contact> findContactStatus(Boolean status, String keyword);

	List<Contact> seachContact(String fullName, boolean status);

}
