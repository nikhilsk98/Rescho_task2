package SpringBootPsql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//@Column(name = "id")
	
	@Column(name = "name")
	private String name;

	@Column(name = "section")
	private String section;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setSection(String section) {
		this.section=section;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getName() {
		return name;
	}
	public String getSection() {
		return section;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	
	public Customer() {
	}
	
	public Customer(long id,String name,String section,String address,String city) {
		this.id=id;
		this.name=name;
		this.section=section;
		this.address=address;
		this.city=city;
	}
	
	@Override
	public String toString() {
		return String.format("Customer[id=%d, name='%s', section='%s', address='%s', city='%s']", id, name, section,address,city);
	}

}
