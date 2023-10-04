package org.java.app.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Pizza> pizze = pizzaService.findAll();
		
		if(pizze.size()==0) {
			return "pizza-nothing";
		}
		
		
		model.addAttribute("pizze", pizze);
		
		
		return "pizza-index";
	}
	
	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";
	}
}