package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {
@Autowired
private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
repo.save(new Product(10,"AA",2.2));
repo.save(new Product(11,"BB",3.3));
repo.save(new Product(12,"CC",4.4));
repo.save(new Product(13,"DD",5.5));
repo.save(new Product(14,"EE",6.6));
repo.save(new Product(15,"FF",7.7));
//update all
repo.save(new Product(13,"BG",2.5));
//bulk insert
List<Product> prds=Arrays.asList(
		new Product(101,"p",8.8),
		new Product(102,"p",8.8),
		new Product(103,"p",8.8)
		
		);
repo.saveAll(prds);
//fetch one row
Optional<Product> p=repo.findById(13);
if(p.isPresent()) {
	//avoids null pointer exception
	Product prd=p.get();
	System.out.println(prd.getProdCode());
	
}else {
	System.out.println("Row not found");
}
//fetch all rows
List<Product> list=repo.findAll();
list.forEach(System.out::println);
//delete operations
repo.deleteById(10);
//delete All rows
//repo.deleteAll();
//repo.deleteAllInBatch();
	
	}

	
}
