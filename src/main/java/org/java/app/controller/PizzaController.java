package org.java.app.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
	    if (pizza == null) {
	        return "pizza-nothing";
	    }
	    model.addAttribute("pizza", pizza);
	    return "pizza-show";
	}
	
	@GetMapping("/search")
	public String searchPizzeBynome(@RequestParam(name = "nome") String nome, Model model) {
	    List<Pizza> pizze = pizzaService.findPizzeByNome(nome);
	    if (pizze.isEmpty()) {
	        return "pizza-nothing"; 
	    }
	    model.addAttribute("pizze", pizze);
	    return "pizza-index";
	}
	@GetMapping("/create")
	public String getCreateForm(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "pizza-create";
	}
	
	@PostMapping("/create")
	public String storePizza(
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult,
			Model model
			) {
		
		System.out.println("New pizza: " + pizza);
		
		if (bindingResult.hasErrors()) {
			System.out.println("Error:");
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "pizza-create";
		} else 
			System.out.println("No error");
		
		try {
			pizzaService.save(pizza);
		} catch (Exception e) {
			
			// CONSTRAIN VALIDATION (unique)
			System.out.println("Errore constrain: " + e.getClass().getSimpleName());
			
			model.addAttribute("isbn_unique", "isbn deve essere unique");
			
			return "pizza-create";
		}
		
		return "redirect:/pizze";
	}

}