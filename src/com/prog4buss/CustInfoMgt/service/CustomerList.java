package com.prog4buss.CustInfoMgt.service;

import com.prog4buss.CustInfoMgt.bean.Customer;


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

public class CustomerList {

	private Customer[] customerList;
	private int total;
	
	public CustomerList(int totalCustomers) {

		this.total = 0;
		this.customerList = new Customer[totalCustomers];

	}

	public boolean addCustomer(Customer customer) {
		
		// protect program
		if (total >= customerList.length) {
			System.out.println("no more room for new customer. ");
			return false;
		} 
		
		// add customer to the last element of array
		customerList[total] = customer;
		total ++;
		return true;
		
	}
	
	public boolean replaceCustomer(int index, Customer customer) {
		
		// protect program
		if (index >= total || index < 0) {
			System.out.println("index is out of range 0 - "+ total);
			return false;
		};
		
		customerList[index] = customer;
		return true;
	}
	
	public boolean deleteCustomer(int index) {
		
		// protect program
		if (index >= total || index < 0) {
			System.out.println("index is out of range 0 - "+ total);
			return false;
		};
		
		// If to delete the last customer, no need to shift; 
		if (index == total-1) {
			customerList[total-1] = null;
			total --;
			return true;
		}

		// otherwise, shift the right customer to the left;
		for (int i=index; i<total-1; i++) {
			customerList[i] = customerList[i+1]; // the right customer shift left one by one
		}
		customerList[total-1] = null; // set the last element to null
		total --;
		return true;	
		
	}
	
	public Customer[] getAllCustomers() {
		
		Customer[] custList = new Customer[total];
		for (int i=0; i<total; i++) {
			custList[i] = customerList[i];
		}
		return custList; // the null customer won't be returned
		
	}
	
	public Customer getCustomer(int index) {
		
		// protect program
		if (index >= total || index < 0) {
			System.out.println("index is out of range 0 - "+ total);
			return null;
		};
		
		return customerList[index];
		
	}

	public int getTotal() {
		
		return total;
		
	}
	
}
