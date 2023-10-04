package org.java.app.db.serv;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepo PizzaRepo;
	
	public void save(Pizza Pizza) {
		
		PizzaRepo.save(Pizza);
	}
	public List<Pizza> findAll() {
		
		return PizzaRepo.findAll();
	}
	public Pizza findById(int id) {
		
		return PizzaRepo.findById(id).get();
	}
}