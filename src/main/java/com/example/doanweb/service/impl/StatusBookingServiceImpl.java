package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.StatusBookingDAO;
import com.example.doanweb.entity.Statusbooking;
import com.example.doanweb.service.StatusBookingService;

@Service
public class StatusBookingServiceImpl implements StatusBookingService {

	@Autowired
	StatusBookingDAO statusBookingDAO;

	@Override
	public <S extends Statusbooking> S save(S entity) {
		return statusBookingDAO.save(entity);
	}

	@Override
	public <S extends Statusbooking> Optional<S> findOne(Example<S> example) {
		return statusBookingDAO.findOne(example);
	}

	@Override
	public Page<Statusbooking> findAll(Pageable pageable) {
		return statusBookingDAO.findAll(pageable);
	}

	@Override
	public List<Statusbooking> findAll() {
		return statusBookingDAO.findAll();
	}

	@Override
	public List<Statusbooking> findAll(Sort sort) {
		return statusBookingDAO.findAll(sort);
	}

	@Override
	public List<Statusbooking> findAllById(Iterable<String> ids) {
		return statusBookingDAO.findAllById(ids);
	}

	@Override
	public Optional<Statusbooking> findById(String id) {
		return statusBookingDAO.findById(id);
	}

	@Override
	public <S extends Statusbooking> List<S> saveAll(Iterable<S> entities) {
		return statusBookingDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		statusBookingDAO.flush();
	}

	@Override
	public <S extends Statusbooking> S saveAndFlush(S entity) {
		return statusBookingDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return statusBookingDAO.existsById(id);
	}

	@Override
	public <S extends Statusbooking> List<S> saveAllAndFlush(Iterable<S> entities) {
		return statusBookingDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Statusbooking> Page<S> findAll(Example<S> example, Pageable pageable) {
		return statusBookingDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Statusbooking> entities) {
		statusBookingDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Statusbooking> long count(Example<S> example) {
		return statusBookingDAO.count(example);
	}

	@Override
	public <S extends Statusbooking> boolean exists(Example<S> example) {
		return statusBookingDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Statusbooking> entities) {
		statusBookingDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return statusBookingDAO.count();
	}

	@Override
	public void deleteById(String id) {
		statusBookingDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		statusBookingDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Statusbooking entity) {
		statusBookingDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		statusBookingDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		statusBookingDAO.deleteAllInBatch();
	}

	@Override
	public Statusbooking getOne(String id) {
		return statusBookingDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Statusbooking> entities) {
		statusBookingDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		statusBookingDAO.deleteAll();
	}

	@Override
	public Statusbooking getById(String id) {
		return statusBookingDAO.getById(id);
	}

	@Override
	public <S extends Statusbooking> List<S> findAll(Example<S> example) {
		return statusBookingDAO.findAll(example);
	}

	@Override
	public <S extends Statusbooking> List<S> findAll(Example<S> example, Sort sort) {
		return statusBookingDAO.findAll(example, sort);
	}
	@Override
	public Statusbooking StatusbookingbyIdWFC() {
		return statusBookingDAO.StatusbookingbyIdWFC();
	}
}
