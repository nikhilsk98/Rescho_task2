package SpringBootPsql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CustomerRepository extends CrudRepository<Customer,Long>{

	Customer findBySection(String section);
}
