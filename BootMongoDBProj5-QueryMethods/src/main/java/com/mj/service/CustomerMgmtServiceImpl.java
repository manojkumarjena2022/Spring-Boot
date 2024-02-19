package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.document.Customer;
import com.mj.repo.ICustomerRepo;
@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	ICustomerRepo repo;
	
	@Override
	public List<Object[]> fetchCustomersDataByCadd(String cadd) {
		return repo.getCustomersDataByCadd(cadd);
	}

	@Override
	public List<Object[]> fetchCustomersByCadd(String cadd) {
		return repo.getCustomersByCadd(cadd);
	}

	@Override
	public List<Object[]> fetchCustomersByCaddAndCname(String cadd, String cname) {
		return repo.getCustomersByCaddAndCname(cadd, cname);
	}

	@Override
	public List<Object[]> fetchCustomersByCaddOrCname(String cadd, String cname) {
		return repo.getCustomersByCaddOrCname(cadd, cname);
	}

	@Override
	public List<Object[]> fetchCustomersByBillAmtRange(Double start, Double end) {
		return repo.getCustomersByBillAmtRange(start, end);
	}

	@Override
	public List<Customer> fetchCustomersByRegCadd(String caddReg) {
		return repo.getCustomersByRegexCadd(caddReg);
	}

	@Override
	public int fetchCustomersCountByBillAmtRange(Double start, Double end) {
		return repo.getCustomersCountByBillAmtRange(start, end);
	}

	@Override
	public List<Customer> fetchCustomersSortedByBillAmt() {
		return repo.getCustomersSortedByBillAmt();
	}

	@Override
	public int removeCustomersWithNoBillAmt() {
		return repo.deleteCustomersWithNoBillAmt();
	}

	@Override
	public boolean checkCustomersExistanceWithBillAmtRange(Double start, Double end) {
		return repo.areThereCustomersWithBillAmtRange(start, end);
	}

}
