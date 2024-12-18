package com.gl.springaopone;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.gl.springaopone.model.Customer;
import com.gl.springaopone.service.CustomerService;

/**
 * Hello world!
 *
 */
public class App
{
	
	private static final Logger logger = Logger.getLogger(App.class.getName());
	
    public static void main( String[] args ) throws Exception
    {
    	logger.info("Application started");
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        CustomerService customerService = context.getBean(CustomerService.class);


        Customer customer = customerService.getCustomer(1);

		System.out.println("*****Customer Details*****");
		System.out.println("Customer ID: " + customer.getCustomerId());
		System.out.println("Name: " + customer.getName());
		System.out.println("Emailid: " + customer.getEmailId());
		System.out.println("DOB: " + customer.getDateOfBirth());

		System.out.println("Address id: " + customer.getAddress().getAddressId());
		System.out.println("Street: " + customer.getAddress().getStreet());
		System.out.println("City: " + customer.getAddress().getCity());
		
    }
}
