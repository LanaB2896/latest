package com.springboot.demo.controller;
import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.env.IUpdatableModule.UpdatesByKind;
import org.hibernate.cache.spi.UpdateTimestampsCache;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.demo.model.CustomerDetails;
import com.springboot.demo.service.CustomerLogic;

@Controller
public class CustomerController {
	@Autowired
	private CustomerLogic customerLogic;
//Home page	
@RequestMapping(value="/", method=RequestMethod.GET)
public String firstPage()
{
	return "NewFile";
}

//Insert Customer
@RequestMapping(value="/add", method= RequestMethod.GET)

public String read(CustomerDetails customerDetails)
{
	return "CustomerList";
}
//Insert Customer
@RequestMapping(value="/add", method=RequestMethod.POST)
 public String read(@Valid @ModelAttribute("customerDetails")CustomerDetails customerDetails,BindingResult bindingResult, Model model)
 {
	if(bindingResult.hasErrors())
	{
		return "CustomerList";
	}
	customerLogic.fromUI(customerDetails);

	customerLogic.details(model);
	return "view";
 }

//View of the table
@RequestMapping(value="/table", method=RequestMethod.GET)
public String table(Model model)
{
//	 List<CustomerDetails> connection = customerLogic.details(model);
	 model.addAttribute("view",  customerLogic.details(model));
	return "view";
}
//UPDATE by CustomerCode
@RequestMapping(value="/update", method=RequestMethod.GET)
public String Updates(Model model, CustomerDetails customerDetails)
{
	model.addAttribute("up",customerDetails);
	return "updateRecords";
}
@RequestMapping(value="/update", method=RequestMethod.POST)
public String Updatess(Model model, CustomerDetails customerDetails)
{
	customerLogic.update(model, customerDetails);
	return "CustomerList";
}


//Search BY CUSTOMER CODE
@RequestMapping(value="/search", method=RequestMethod.GET)

public String record(Model model, CustomerDetails customerDetails)
{
	model.addAttribute("search", customerDetails);
	return "Search";
}
//Search BY CUSTOMER CODE
@RequestMapping(value="/search", method=RequestMethod.POST)
public String records(Model model, CustomerDetails customerDetails)
{
	customerLogic.search(model, customerDetails);
	return "Search";
}


//Delete GET
@RequestMapping(value="/delete", method=RequestMethod.GET)
public String delete(Model model,CustomerDetails customerDetails)
{
	// customerLogic.update(model, customerDetails);
	model.addAttribute("del",  customerDetails);
return "deleteRecord";
}
//Delete POST
@RequestMapping(value="/delete", method=RequestMethod.POST)
public String deletes(Model model, CustomerDetails customerDetails)

{
	
customerLogic.delete(model, customerDetails);
customerLogic.details(model);
return "view";
} 
}
