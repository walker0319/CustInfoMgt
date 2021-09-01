package com.prog4buss.CustInfoMgt.bean;


/* Project: CustInfoMgt
 * 
 * A simple project to learn Java basic, about Customer Information Management, 
 * main function is to add, modify, delete and display customer info.
 * The project is divided into 4 module on 4 packages imitating MVC model:
 * 
 * 1. CustInfoMgt.bean: Model/Data
 *      Customer: class to record customer info, name, age, ...
 *      
 * 2. CustInfoMgt.service: Controller(+Data?)
 *      CustomerList: Customer Array to keep customer info, providing CRUD method
 *      of customer.
 *      
 * 3. CustInfoMgt.view: View of UI (+Controller?)
 *      CustomerView: Display menu, accept user input, operate data using CustomerList.
 *      
 * 4. CustInfoMgt.util(CIMUtility): utils to read and check user input, provided by 
 *      Song Hongkang from atguigu.
 */

public class Customer {

	private String name;
	private char gender;
	private int age;
	private String phone;
	private String email;
	
	public Customer(String name, char gender, int age, String phone, String email) {

		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
