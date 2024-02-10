package com.mj.service;

import java.util.List;


import com.mj.entity.Customer;


public interface ICustomerMgmtService {
	public String registerCustomer(Customer cust);
	public List<Customer> getAllCustomer();
}
