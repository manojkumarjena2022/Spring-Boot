package com.mj.service;

import java.util.List;

import com.mj.document.Customer;

public interface ICustomerMgmtService {
	public String registerCustomer(Customer doc);
	public List<Customer> findAllCustomers();
	public String removeCustomerById(String id);
	public List<Customer> fetchCustomersByBillAmtRange(Double start,Double end);
	public List<Customer> fetchCustomersByUsingCaddAndHavingMobileNo(String ...addresses);

}
