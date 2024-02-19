package com.mj.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mj.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	@Query(fields = "{cno:1,cname:1,cadd:1}",value = "{cadd:?0}")
	public List<Object[]> getCustomersDataByCadd(String cadd);
	
	//@Query(fields = "{}",value = "{cadd:?0}")
	@Query(value = "{cadd:?0}")
	public List<Object[]> getCustomersByCadd(String cadd);
	
	@Query(fields = "{cno:1,cname:1,cadd:1,billAmt:1}",value = "{cadd:?0,cname:?1}")
	public List<Object[]> getCustomersByCaddAndCname(String cadd,String cname);
	
	@Query(fields = "{cno:1,cname:1,cadd:1,billAmt:1}",value = "{$or:[{cadd:?0},{cname:?1}]}")
	public List<Object[]> getCustomersByCaddOrCname(String cadd,String cname);
	
	@Query(fields = "{id:0,cno:1,cname:1,cadd:1,billAmt:1}",value = "{billAmt:{$gte:?0,$lte:?1}}")
	public List<Object[]> getCustomersByBillAmtRange(Double start,Double end);
	
	@Query(value = "{cadd:{$regex:?0}}")
	public List<Customer> getCustomersByRegexCadd(String cAddReg);
	
	@Query(value = "{billAmt:{$gte:?0,$lte:?1}}",count = true)
	public int getCustomersCountByBillAmtRange(Double start,Double end);
	
	//@Query(value = "{}",sort = "{billAmt:-1}")
	@Query(value = "{}",sort = "{billAmt:1}")
	public List<Customer> getCustomersSortedByBillAmt();
	
	@Query(value = "{billAmt:null}",delete = true)
	public int deleteCustomersWithNoBillAmt();
	
	@Query(value = "{billAmt:{$gte:?0,$lte:?1}}",exists = true)
	public boolean areThereCustomersWithBillAmtRange(Double start,Double end);
}
