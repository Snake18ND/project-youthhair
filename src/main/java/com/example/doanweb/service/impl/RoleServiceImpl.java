package com.example.doanweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.doanweb.dao.RoleDAO;
import com.example.doanweb.entity.Role;
import com.example.doanweb.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;

	@Override
	public <S extends Role> S save(S entity) {
		return roleDAO.save(entity);
	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		return roleDAO.findOne(example);
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleDAO.findAll(pageable);
	}

	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return roleDAO.findAll(sort);
	}

	@Override
	public List<Role> findAllById(Iterable<Integer> ids) {
		return roleDAO.findAllById(ids);
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return roleDAO.findById(id);
	}

	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities) {
		return roleDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		roleDAO.flush();
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return roleDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return roleDAO.existsById(id);
	}

	@Override
	public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roleDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		roleDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return roleDAO.count(example);
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return roleDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Role> entities) {
		roleDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return roleDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		roleDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		roleDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Role entity) {
		roleDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		roleDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		roleDAO.deleteAllInBatch();
	}

	@Override
	public Role getOne(Integer id) {
		return roleDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		roleDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roleDAO.deleteAll();
	}

	@Override
	public Role getById(Integer id) {
		return roleDAO.getById(id);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return roleDAO.findAll(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return roleDAO.findAll(example, sort);
	}
	
	
	
}
