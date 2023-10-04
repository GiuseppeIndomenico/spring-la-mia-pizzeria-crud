package org.java.app;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pizza pizza1= new Pizza("margherita", "pomodoro, mozzarella, origano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5R6cg5cYUsFZzQlOtdQhGB9C3d395_y17YzSo1PxU_kuvGJMNWDEHkIV2dITYkowpcmQ&usqp=CAU", 4);
		Pizza pizza2= new Pizza("biancaneve", "mozzarella, olio, origano", "https://www.menupizza.it/cmsportal/common/cache/content_manager/images/1785/500x500/ricetta-pizza-biancaneve-foto.jpg", 4);
		Pizza pizza3= new Pizza("norma", "pomodoro, mozzarella, origano, melanzane fritte, ricotta salata", "https://blog.giallozafferano.it/dolcesalatomiky/wp-content/uploads/2017/07/DSC_0024-3.jpg", 6);
		Pizza pizza4= new Pizza("capricciosa", "pomodoro, mozzarella, prosciutto cotto, funghi, uovo, olive", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGsaaLUAHMGlAidQtg77kwfMrY2WRET2ikHg&usqp=CAU", 7);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		
		System.out.println("Insert OK!");
	}
}


