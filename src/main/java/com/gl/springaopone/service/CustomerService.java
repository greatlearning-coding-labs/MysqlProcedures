package com.gl.springaopone.service;

import com.gl.springaopone.model.Address;
import com.gl.springaopone.model.Customer;


public interface CustomerService {

	public Customer getCustomer(Integer customerId) throws Exception;
	public Integer addCustomer(Customer customer);
	
	public void updateAddress(Integer customerId, Address newAddress) throws Exception;
	public void deleteCustomer(Integer customerId) throws Exception;
	
}
