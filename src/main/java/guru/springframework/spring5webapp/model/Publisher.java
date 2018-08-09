package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Publisher publisher = (Publisher) obj;
		
		return id != null ? id.equals(publisher.id) : publisher.id == null;
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	
}
