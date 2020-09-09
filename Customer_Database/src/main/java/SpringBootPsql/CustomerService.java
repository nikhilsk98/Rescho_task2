package SpringBootPsql;

import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerrepository;
	public Model getForm(Model model) {
	        return model.addAttribute("customer", new Customer());
		}
	
    public List<Customer> getAllDetail() {
    	
    	return (List<Customer>) customerrepository.findAll();
    	
    }
    public void addDetails(Customer st) {
    	customerrepository.save(st);
    }
    
    public Customer getOneDetail(long id) {
    	return customerrepository.findOne(id);
    }
    public Customer getDatailByName(String id) {
    	return customerrepository.findBySection(id);
    }
    public Customer updateDetails(Customer customer) {
    	Customer update=customerrepository.findOne(customer.getId());
    	update.setName(customer.getName());
    	update.setSection(customer.getSection());
    	update.setAddress(customer.getAddress());
    	update.setCity(customer.getCity());
    	return customerrepository.save(update);
    }
    public void deleteDetails(long id) {
    	Customer dlt=customerrepository.findOne(id);
    	customerrepository.delete(dlt);
    }
}
