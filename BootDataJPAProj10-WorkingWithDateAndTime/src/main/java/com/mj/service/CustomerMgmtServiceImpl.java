package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.Customer;
import com.mj.repository.ICustomerRepo;
@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(Customer cust) {
		int idVal=repo.save(cust).getCustId();
		return "Customer is saved with id::"+idVal;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

}
