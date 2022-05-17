package com.jobiak.empapi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class Product {
	
	@GetMapping("/mobile")
	public String showCatalog() {
		return new String("Samsung,dual,70,000,i got you");
	}
	@GetMapping("/info")
	public String introduction() {
		return new String("The manufacturing mobile company in asia");
	}
	@GetMapping("/search/{modelId}")
	public String searchModel(@PathVariable(value="modelId")String modelId) {
		return new String(modelId +"is available only in blue and black colors, can be delivered");
	}
	@GetMapping("/search/{modelId}/brand/{brand}")
	public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand) {
		return new String(modelId + brand +"currently not available");
	}

}
