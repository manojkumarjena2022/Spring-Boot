package com.mj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.document.Customer;
import com.mj.repository.ICustomerRepo;
@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerRepo repo;
	@Override
	public String registerCustomer(Customer doc) {
		return "Customer registered with Id :"+repo.save(doc).getId();
		//return "Customer registered with Id :"+repo.insert(doc).getId();
	}
	@Override
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}
	@Override
	public String removeCustomerById(String id) {
		//fetch document by id
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent())
		{
			repo.delete(opt.get());
			return "Document deleted";
		}
		return "Document not found";
	}
	@Override
	public List<Customer> fetchCustomersByBillAmtRange(Double start, Double end) {
		return repo.findByBillAmtBetween(start, end);
	}
	@Override
	public List<Customer> fetchCustomersByUsingCaddAndHavingMobileNo(String... addresses) {
		return repo.findByCaddInAndMobileNoIsNotNull(addresses);
	}

}
