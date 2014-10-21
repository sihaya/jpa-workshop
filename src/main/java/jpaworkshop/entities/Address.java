package jpaworkshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;

    @OneToOne(optional = false)
    private Employee employee;

    public Address() {
    }

    public Address(int id, String street, String city, String state, String zip) {
	this.id = id;
	this.street = street;
	this.city = city;
	this.state = state;
	this.zip = zip;
    }

    void setEmployee(Employee employee) {
	this.employee = employee;
    }

    public String getCity() {
	return city;
    }

    public Employee getEmployee() {
	return employee;
    }

    public int getId() {
	return id;
    }

    public String getState() {
	return state;
    }

    public String getStreet() {
	return street;
    }

    public String getZip() {
	return zip;
    }
}
