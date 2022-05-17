package com.jobiak.empapi.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobiak.empapi.model.Mobile;
import com.jobiak.empapi.services.MobileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/catalog")
public class Product {
 @Autowired
 MobileService service;
	
@GetMapping(value="/display",produces= MediaType.APPLICATION_JSON_VALUE)
public List<Mobile> showAll() {
	return service.getAll();
}
	
	
 @GetMapping(value="/mobile",produces= MediaType.APPLICATION_JSON_VALUE)
 public Mobile showCatalog() {
  
  Mobile mobile=new Mobile();
  
  mobile.setBrand("Samsung");
  mobile.setModel("E2FH, Dual Camera, 32GB Memory, I gou you");
  mobile.setPrice(4999);

  
  return mobile;
  
 }

 @GetMapping("/intro")
 public String introduction() {
  
  return new String("Welcome");
}
 @GetMapping("/search/{modelId}")
 public String searchModel(@PathVariable(value="modelId")String modelId) {
  
  return new String(modelId+"the product will be delivered within 24 hours");
}
 @GetMapping("/search/{modelId}/brand/{brand}")
 public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand) {
  
  return new String(modelId+brand+"the product will be delivered within 24 hours");
}
 @PostMapping(value="/create",consumes= MediaType.APPLICATION_JSON_VALUE,
   produces=MediaType.APPLICATION_JSON_VALUE)
 public Mobile addProduct(@RequestBody Mobile mobile) {
  
  //System.out.println(mobile);
  //repo.save(mobile);
  Mobile ref=service.addMobile(mobile);
  return ref;
 }
 @PutMapping(value="/modify",consumes= MediaType.APPLICATION_JSON_VALUE,
		   produces=MediaType.APPLICATION_JSON_VALUE)
		 public Mobile modifyProduct(@RequestBody Mobile mobile) {
		  
		 
		  Mobile ref=service.modifyMobile(mobile);
		  return ref;
 }
 @DeleteMapping(value="/remove/{mid}")
 public void removeProduct(@PathVariable(value="mid")Long mobileId) {
 	service.removeProduct(mobileId);
 }

 
 
}