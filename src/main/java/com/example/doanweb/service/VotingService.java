package com.example.doanweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.doanweb.entity.Voting;

public interface VotingService {

	<S extends Voting> List<S> findAll(Example<S> example, Sort sort);

	<S extends Voting> List<S> findAll(Example<S> example);

	Voting getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Voting> entities);

	Voting getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Voting entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Voting> entities);

	<S extends Voting> boolean exists(Example<S> example);

	<S extends Voting> long count(Example<S> example);

	void deleteInBatch(Iterable<Voting> entities);

	<S extends Voting> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Voting> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Voting> S saveAndFlush(S entity);

	void flush();

	<S extends Voting> List<S> saveAll(Iterable<S> entities);

	Optional<Voting> findById(Integer id);

	List<Voting> findAllById(Iterable<Integer> ids);

	List<Voting> findAll(Sort sort);

	List<Voting> findAll();

	Page<Voting> findAll(Pageable pageable);

	<S extends Voting> Optional<S> findOne(Example<S> example);

	<S extends Voting> S save(S entity);

}
