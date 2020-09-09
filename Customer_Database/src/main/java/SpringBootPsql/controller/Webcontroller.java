package SpringBootPsql.controller;

import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootPsql.Customer;
import SpringBootPsql.CustomerRepository;
import SpringBootPsql.CustomerService;



@Controller
public class Webcontroller {
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	CustomerService srvc;
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        srvc.getForm(model);
        return "form";
    }
 
	
	@RequestMapping(value="/formss", method=RequestMethod.POST)
    public String AddDetails(@RequestBody Customer customer) {
		customer.setId(customer.getId());
		customer.setName(customer.getName());
		customer.setSection(customer.getSection());
		customer.setAddress(customer.getAddress());
		customer.setCity(customer.getCity());
       srvc.addDetails(customer);
        return "result";
    }
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
    public String AddDetailsd(@ModelAttribute Customer customer) {
       srvc.addDetails(customer);
        return "result";
    }
     
   @RequestMapping(value="/loadsss", method=RequestMethod.GET)
   @ResponseBody
    public List<Customer> getDetail() {
    	return srvc.getAllDetail();
    }
    
   
  
    @RequestMapping(value="/loads", method=RequestMethod.GET)
    @ResponseBody
    public Customer customerSubmit(@RequestParam("id") long id) {//@RequestParam("id") long id, 
    	
    	return srvc.getOneDetail(id);
       
    }
    @RequestMapping(value="/updateDetails", method=RequestMethod.PUT)
    public String updateCustomer(@RequestBody Customer customer) {
        srvc.updateDetails(customer);
         return "result";
     }
   @RequestMapping(value="/deleteDetails", method=RequestMethod.DELETE)
   public @ResponseBody String deleteCustomer(@RequestParam("id") Long id) {
        srvc.deleteDetails(id);
         return "return";
     }

}
