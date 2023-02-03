package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.VotingDAO;
import com.example.doanweb.entity.Voting;
import com.example.doanweb.service.VotingService;

@Service
public class VotingServiceImpl implements VotingService {

	@Autowired
	VotingDAO votingDAO;

	@Override
	public <S extends Voting> S save(S entity) {
		return votingDAO.save(entity);
	}

	@Override
	public <S extends Voting> Optional<S> findOne(Example<S> example) {
		return votingDAO.findOne(example);
	}

	@Override
	public Page<Voting> findAll(Pageable pageable) {
		return votingDAO.findAll(pageable);
	}

	@Override
	public List<Voting> findAll() {
		return votingDAO.findAll();
	}

	@Override
	public List<Voting> findAll(Sort sort) {
		return votingDAO.findAll(sort);
	}

	@Override
	public List<Voting> findAllById(Iterable<Integer> ids) {
		return votingDAO.findAllById(ids);
	}

	@Override
	public Optional<Voting> findById(Integer id) {
		return votingDAO.findById(id);
	}

	@Override
	public <S extends Voting> List<S> saveAll(Iterable<S> entities) {
		return votingDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		votingDAO.flush();
	}

	@Override
	public <S extends Voting> S saveAndFlush(S entity) {
		return votingDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return votingDAO.existsById(id);
	}

	@Override
	public <S extends Voting> List<S> saveAllAndFlush(Iterable<S> entities) {
		return votingDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Voting> Page<S> findAll(Example<S> example, Pageable pageable) {
		return votingDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Voting> entities) {
		votingDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Voting> long count(Example<S> example) {
		return votingDAO.count(example);
	}

	@Override
	public <S extends Voting> boolean exists(Example<S> example) {
		return votingDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Voting> entities) {
		votingDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return votingDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		votingDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		votingDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Voting entity) {
		votingDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		votingDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		votingDAO.deleteAllInBatch();
	}

	@Override
	public Voting getOne(Integer id) {
		return votingDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Voting> entities) {
		votingDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		votingDAO.deleteAll();
	}

	@Override
	public Voting getById(Integer id) {
		return votingDAO.getById(id);
	}

	@Override
	public <S extends Voting> List<S> findAll(Example<S> example) {
		return votingDAO.findAll(example);
	}

	@Override
	public <S extends Voting> List<S> findAll(Example<S> example, Sort sort) {
		return votingDAO.findAll(example, sort);
	}
	
	
}
