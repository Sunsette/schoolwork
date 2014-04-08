package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String description;
	
	public Product(){
		
	}
	
	public Product(String name, String description){
		this.name = name;
		this.description = description;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
