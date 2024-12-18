CREATE SEQUENCE hibernate_sequence START WITH 1006 INCREMENT BY 1;

CREATE TABLE Address(
	address_id NUMBER(14),
	street VARCHAR2(30) NOT null,
	city VARCHAR2(10) NOT NULL,
	CONSTRAINT ps_addressid_pk PRIMARY KEY (address_id)
);

CREATE TABLE Customer (
	customer_id NUMBER(10),
	address_id NUMBER(12) UNIQUE,
	emailid VARCHAR2(25) NOT NULL,
	name VARCHAR2(10) NOT NULL,
	date_of_birth DATE NOT NULL,
	CONSTRAINT ps_customerid_pk PRIMARY KEY (customer_id),
	CONSTRAINT ps_customer_address_fk FOREIGN KEY(address_id) REFERENCES Address(address_id)
);
commit;
