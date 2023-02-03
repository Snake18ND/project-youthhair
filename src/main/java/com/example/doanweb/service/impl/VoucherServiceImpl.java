package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.VoucherDAO;
import com.example.doanweb.entity.Voucher;
import com.example.doanweb.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{

	@Autowired
	VoucherDAO voucherDAO;

	@Override
	public <S extends Voucher> S save(S entity) {
		return voucherDAO.save(entity);
	}

	@Override
	public <S extends Voucher> Optional<S> findOne(Example<S> example) {
		return voucherDAO.findOne(example);
	}

	@Override
	public Page<Voucher> findAll(Pageable pageable) {
		return voucherDAO.findAll(pageable);
	}

	@Override
	public List<Voucher> findAll() {
		return voucherDAO.findAll();
	}

	@Override
	public List<Voucher> findAll(Sort sort) {
		return voucherDAO.findAll(sort);
	}

	@Override
	public List<Voucher> findAllById(Iterable<String> ids) {
		return voucherDAO.findAllById(ids);
	}

	@Override
	public <S extends Voucher> List<S> saveAll(Iterable<S> entities) {
		return voucherDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		voucherDAO.flush();
	}

	@Override
	public <S extends Voucher> S saveAndFlush(S entity) {
		return voucherDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return voucherDAO.existsById(id);
	}

	@Override
	public <S extends Voucher> List<S> saveAllAndFlush(Iterable<S> entities) {
		return voucherDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Voucher> Page<S> findAll(Example<S> example, Pageable pageable) {
		return voucherDAO.findAll(example, pageable);
	}

	@Override
	public <S extends Voucher> long count(Example<S> example) {
		return voucherDAO.count(example);
	}

	@Override
	public <S extends Voucher> boolean exists(Example<S> example) {
		return voucherDAO.exists(example);
	}


	@Override
	public long count() {
		return voucherDAO.count();
	}

	@Override
	public Voucher getById(String id) {
		return voucherDAO.getById(id);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example) {
		return voucherDAO.findAll(example);
	}

	@Override
	public <S extends Voucher> List<S> findAll(Example<S> example, Sort sort) {
		return voucherDAO.findAll(example, sort);
	}

	public Voucher create(Voucher voucher) {
		return voucherDAO.save(voucher);
	}

	@Override
	public Voucher update(Voucher voucher) {
		return voucherDAO.save(voucher);
	}

	@Override
	public void delete(String id) {
		voucherDAO.deleteById(id);
	}

	@Override
	public Voucher findById(String id) {
		return voucherDAO.findById(id).get();
	}

	@Override
	public List<Voucher> seachVoucher(String id){
		return voucherDAO.seachVoucher(id);
	}
}
