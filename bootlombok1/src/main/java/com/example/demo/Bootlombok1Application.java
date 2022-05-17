package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

@SpringBootApplication
public class Bootlombok1Application  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Bootlombok1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer cust=new Customer();
		cust.setCustId(1);
		cust.setName("John Doe");
		cust.setBalance(2000);
		
		System.out.println(cust.getBalance());
		System.out.println(cust.getName());
		System.out.println(cust.getCustId());
		System.out.println(cust);
		//hexadecimal string type hashcode
	
		Customer cust2 = new Customer(2,"Jonas Doe",3000);
		System.out.println(cust2);
		
		boolean result= cust.equals(cust2);
		System.out.println(result);
		
		Customer cust3 = new Customer(2,"Jonas Doe",3000);
        System.out.println(cust3);
		
		result= cust3.equals(cust2);
		System.out.println(result); 
		
		
		
		
		
		Product p=Product.builder()
				.productId(101)
				.description("Coke")
				.price(25.00)	
				.build();
		System.out.println(p);
	
		
	}

}
