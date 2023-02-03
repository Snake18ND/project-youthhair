package com.example.doanweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.doanweb.entity.Statusbooking;

public interface StatusBookingService {

	<S extends Statusbooking> List<S> findAll(Example<S> example, Sort sort);

	<S extends Statusbooking> List<S> findAll(Example<S> example);

	Statusbooking getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Statusbooking> entities);

	Statusbooking getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Statusbooking entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<Statusbooking> entities);

	<S extends Statusbooking> boolean exists(Example<S> example);

	<S extends Statusbooking> long count(Example<S> example);

	void deleteInBatch(Iterable<Statusbooking> entities);

	<S extends Statusbooking> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Statusbooking> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Statusbooking> S saveAndFlush(S entity);

	void flush();

	<S extends Statusbooking> List<S> saveAll(Iterable<S> entities);

	Optional<Statusbooking> findById(String id);

	List<Statusbooking> findAllById(Iterable<String> ids);

	List<Statusbooking> findAll(Sort sort);

	List<Statusbooking> findAll();

	Page<Statusbooking> findAll(Pageable pageable);

	<S extends Statusbooking> Optional<S> findOne(Example<S> example);

	<S extends Statusbooking> S save(S entity);

    Statusbooking StatusbookingbyIdWFC();
}
