package SpringBootPsql;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	CustomerRepository repository;

	@RequestMapping("/")
	public String getName()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String getHome()
	{
		return "home";
	}
	@RequestMapping("/load")
	public String getLoad()
	{
		return "load";
	}
	@RequestMapping("/update")
	public String getSearch()
	{
		return "update";
	}
		
}
