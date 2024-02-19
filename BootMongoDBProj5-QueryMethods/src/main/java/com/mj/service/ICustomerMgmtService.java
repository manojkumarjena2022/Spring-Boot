package com.mj.service;

import java.util.List;

import com.mj.document.Customer;

public interface ICustomerMgmtService {
	public List<Object[]> fetchCustomersDataByCadd(String cadd);
	public List<Object[]> fetchCustomersByCadd(String cadd);
	public List<Object[]> fetchCustomersByCaddAndCname(String cadd,String cname);
	public List<Object[]> fetchCustomersByCaddOrCname(String cadd,String cname);
	public List<Object[]> fetchCustomersByBillAmtRange(Double start,Double end);
	
	public List<Customer> fetchCustomersByRegCadd(String caddReg);
	public int fetchCustomersCountByBillAmtRange(Double start,Double end);
	public List<Customer> fetchCustomersSortedByBillAmt();
	public int removeCustomersWithNoBillAmt();
	public boolean checkCustomersExistanceWithBillAmtRange(Double start,Double end);
}
