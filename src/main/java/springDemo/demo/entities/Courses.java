package springDemo.demo.entities;

import jakarta.annotation.Generated;

//Entity paketi içinde istediğimiz ürünlerin özelliklerini ekleyeceğimiz veri tiplerini
public class Courses {

	private int id;
	private String name;
	
	public Courses() {
	}

	public Courses(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
