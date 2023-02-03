package com.example.doanweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.doanweb.entity.Voucher;

public interface VoucherService {

	<S extends Voucher> List<S> findAll(Example<S> example, Sort sort);

	<S extends Voucher> List<S> findAll(Example<S> example);

	Voucher getById(String id);

	long count();

	<S extends Voucher> boolean exists(Example<S> example);

	<S extends Voucher> long count(Example<S> example);

	<S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Voucher> S saveAndFlush(S entity);

	void flush();

	<S extends Voucher> List<S> saveAll(Iterable<S> entities);

	List<Voucher> findAllById(Iterable<String> ids);

	List<Voucher> findAll(Sort sort);

	List<Voucher> findAll();

	Page<Voucher> findAll(Pageable pageable);

	<S extends Voucher> Optional<S> findOne(Example<S> example);

	<S extends Voucher> S save(S entity);

	Voucher create(Voucher voucher);

	Voucher update(Voucher voucher);

	void delete(String id);

	Voucher findById(String id);

	List<Voucher> seachVoucher(String id);
}
