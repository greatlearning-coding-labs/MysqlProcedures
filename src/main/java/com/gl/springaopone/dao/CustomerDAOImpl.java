package com.gl.springaopone.dao;

import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Repository;

import com.gl.springaopone.App;
import com.gl.springaopone.entity.AddressEntity;
import com.gl.springaopone.entity.CustomerEntity;
import com.gl.springaopone.model.Address;
import com.gl.springaopone.model.Customer;

@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Logger logger=LogManager.getLogger(this.getClass());

	@Override
	public Customer getCustomer(Integer customerId) throws Exception {
		CustomerEntity customerEntity  = entityManager.find(CustomerEntity.class, customerId);
		if(customerEntity==null)
		{
			throw new Exception("Customer Not Found");
		}
		//record the error using logger as "Customer Found"
		Customer customer = new Customer();
		customer.setCustomerId(customerEntity.getCustomerId());
		customer.setName(customerEntity.getName());
		customer.setEmailId(customerEntity.getEmailId());
		Address address = new Address();
		address.setAddressId(customerEntity.getAddressEntity().getAddressId());
		address.setCity(customerEntity.getAddressEntity().getCity());
		address.setStreet(customerEntity.getAddressEntity().getStreet());
		customer.setAddress(address);
		return customer;
	}

	@Override
	public Integer addCustomer(Customer customer) {

		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setEmailId(customer.getEmailId());
		customerEntity.setName(customer.getName());
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(customer.getAddress().getAddressId());
		addressEntity.setCity(customer.getAddress().getCity());
		addressEntity.setStreet(customer.getAddress().getStreet());
		
		customerEntity.setAddressEntity(addressEntity);
		entityManager.persist(customerEntity);
		return customerEntity.getCustomerId();
	}

	@Override
	public void updateAddress(Integer customerId, Address newAddress) throws Exception {
		CustomerEntity customerEntity  = entityManager.find(CustomerEntity.class, customerId);
		AddressEntity addressEntity = customerEntity.getAddressEntity();
		addressEntity.setCity(newAddress.getCity());
		addressEntity.setStreet(newAddress.getStreet());
		
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		CustomerEntity customerEntity  = entityManager.find(CustomerEntity.class, customerId);
		entityManager.remove(customerEntity);
	}
}
