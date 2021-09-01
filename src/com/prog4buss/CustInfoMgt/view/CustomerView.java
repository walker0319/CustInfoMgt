package com.prog4buss.CustInfoMgt.view;

import com.prog4buss.CustInfoMgt.bean.Customer;
import com.prog4buss.CustInfoMgt.service.CustomerList;
import com.prog4buss.CustInfoMgt.util.CIMUtility;

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

public class CustomerView {

	private CustomerList customerList = new CustomerList(10);

	public static void main(String[] args) {

		CustomerView customerView = new CustomerView();
		customerView.enterMainMenu();
	}

	public void enterMainMenu() {

		boolean exitFlag = true;
		while (exitFlag) {

			System.out.println("\n-------------Customer Information Management----------");
			System.out.println("\n                 1 Add new user");
			System.out.println("\n                 2 Modify user info");
			System.out.println("\n                 3 Delete a user");
			System.out.println("\n                 4 Show user list");
			System.out.println("\n                 5 Exit\n");
			System.out.print("                   Please choose 1-5: ");

			char choice = CIMUtility.readMenuSelection();
			switch (choice) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				System.out.println("Are you confirmed: y(es) or n(no): ");
				char confirmChoice = CIMUtility.readConfirmSelection();
				if (confirmChoice == 'Y') {
					exitFlag = false;
				}
				break;
			}
		}

	}

	private void addNewCustomer() {

		System.out.print("Input name: ");
		String name = CIMUtility.readString(10);

		System.out.print("Input gender: ");
		char gender = CIMUtility.readChar();

		System.out.print("Input age: ");
		int age = CIMUtility.readInt();

		System.out.print("Input phone: ");
		String phone = CIMUtility.readString(20);

		System.out.print("Input email: ");
		String email = CIMUtility.readString(30);

		Customer cust = new Customer(name, gender, age, phone, email);
		// no need to index customerList like following, just use addCustomer method of
		// the object.
		// int index = customerList.getAllCustomers().length;
		customerList.addCustomer(cust);

	}

	private void modifyCustomer() {

		System.out.print("Input number of Customers to modify: 1 - " + customerList.getTotal() + " : ");
		int custIndex = CIMUtility.readInt();

		// protect program
		if (custIndex < 0 || custIndex > customerList.getTotal()) {
			System.out.println("input number is out of range. ");
			return;
		}

		Customer updCust = customerList.getCustomer(custIndex - 1);

		System.out.print("Input name: " + updCust.getName());
		String name = CIMUtility.readString(10, updCust.getName());
		updCust.setName(name);

		System.out.print("Input gender: " + updCust.getGender());
		char gender = CIMUtility.readChar(updCust.getGender());
		updCust.setGender(gender);

		System.out.print("Input age: " + updCust.getAge());
		int age = CIMUtility.readInt(updCust.getAge());
		updCust.setAge(age);

		System.out.print("Input phone: " + updCust.getPhone());
		String phone = CIMUtility.readString(20, updCust.getPhone());
		updCust.setPhone(phone);

		System.out.print("Input email: " + updCust.getEmail());
		String email = CIMUtility.readString(30, updCust.getEmail());
		updCust.setEmail(email);

		customerList.replaceCustomer(custIndex - 1, updCust);
		/*
		 * can't do like this: customerList[custIndex-1] = updCust, because customerList
		 * doesn't provide this type of access.
		 */

	}

	private void deleteCustomer() {

		System.out.print("Input Index of Customers to Delete: 1 - " + customerList.getTotal() + " : ");
		int delIndex = CIMUtility.readInt();

		// protect program
		if (delIndex < 0 || delIndex > customerList.getTotal()) {
			System.out.println("input number out of range. ");
			return;
		}

		Customer delCust = customerList.getCustomer(delIndex - 1);

		System.out.print("customer info: name " + delCust.getName());
		System.out.print("Are you sure to delete customer No " + delIndex + "Y(es) or N(o) : ");

		char confirmChoice = CIMUtility.readConfirmSelection();
		if (confirmChoice == 'N')
			return;

		customerList.deleteCustomer(delIndex - 1);

	}

	private void listAllCustomer() {

		int countCust = customerList.getTotal();

		// protect program
		if (countCust <= 0) {
			System.out.println("no customer yet. ");
			return;
		}

		System.out.println("No\tName\tGender\tAge\tPhone\tEmail");
		Customer[] custList = customerList.getAllCustomers();
		for (int i = 0; i < countCust; i++) {
			Customer cust = custList[i];
			System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" 
							+ cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
		}
	
	}

}
