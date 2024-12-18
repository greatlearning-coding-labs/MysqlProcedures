package com.gl.springaopone.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.springaopone.dao.CustomerDAO;
import com.gl.springaopone.model.Address;
import com.gl.springaopone.model.Customer;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer getCustomer(Integer customerId) throws Exception {
	   System.out.println(customerDAO);
		Customer customer = customerDAO.getCustomer(customerId);
		if (customer == null)
			throw new Exception("Customer Not Found with the given customer id.");
		else
			return customer;
	}

	@Override
	public Integer addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@Override
	public void updateAddress(Integer customerId, Address newAddress) throws Exception {
		Customer customer = customerDAO.getCustomer(customerId);
		if (customer == null)
			throw new Exception("Customer Not Found with the given customer id.");
		else
			customerDAO.updateAddress(customerId, newAddress);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws Exception {
		Customer customer = customerDAO.getCustomer(customerId);
		if (customer == null)
			throw new Exception("Customer Not Found with the given customer id.");
		else
			customerDAO.deleteCustomer(customerId);

	}

}
