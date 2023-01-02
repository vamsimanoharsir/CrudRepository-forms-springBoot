package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
@Autowired//to complete auto configuration
CustomersRepo repo;//the crud repository we have created
	
@RequestMapping("/")
public String display() {
	return "course.jsp";
}

@RequestMapping("/details")
public String display(Customers cust) {
	repo.save(cust);//after submitting the form we are saving the data to h2 db
	return "course.jsp";
}

@RequestMapping("/getdetails")
public String getdetails() {
	return "view.jsp";
}

@PostMapping("/getdetails")
@ResponseBody
public ModelAndView getdetails(@RequestParam int custid)
{
	ModelAndView mv=new ModelAndView("retrieve.jsp");
	Customers cust1=repo.findById(custid).orElse(null);
	System.out.print("cust is"+cust1);
	mv.addObject(cust1);
	return mv;
}


//REST API in spring
//1. using Jparepository we can return List as well. this list takes Entity class name as an argument
@RequestMapping("/customers")//getting all customers from the db
@ResponseBody
public List<Customers> getcustomers1() {
	return repo.findAll();
}

//2. using Crud Repository we return String type
@RequestMapping("/customers/{custid}")//getting customers by id from the db
@ResponseBody
public String getcustomers2(@PathVariable("custid") int custid) {
	return repo.findById(custid).toString();
}

@PostMapping("/createcust")
public Customers getcustomers3(@RequestBody Customers cust) {
	repo.save(cust);
	return cust;
}

@DeleteMapping("/deletecust/{custid}")
public Customers getcustomers4(@PathVariable("custid") int custid) {
	Customers cust=repo.getOne(custid);
	repo.delete(cust);
	return cust;
}

@PutMapping(path="/customers", consumes= {"application/json"})
public Customers getcustomers5(@RequestBody Customers cust) {
	repo.save(cust);
	return cust;
}
}
