package com.javaproject;

public class Person {

	//변수 선언
	private String name;
	private String hp;
	private String company;
	private int indexOf;
		
	//생성자
	public Person() {;
	}

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	//toString
	@Override
	public String toString() {
		return name + "," + hp + "," + company;
	}
	
}
