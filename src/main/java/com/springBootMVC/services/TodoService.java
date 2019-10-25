package com.springBootMVC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBootMVC.models.Todos;
import com.springBootMVC.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

	@Autowired
	private TodoRepository repo;
	
	public List<Todos> listAll() {
		return repo.findAll();
	}
	
	public void save(Todos product) {
		repo.save(product);
	}
	
	public Todos get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
