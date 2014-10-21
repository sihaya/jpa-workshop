package jpaworkshop.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
    @Id
    private int id;

    private String name;

    private long salary;

    @ManyToOne
    private Department department;

    @OneToOne(mappedBy = "employee")
    private Address address;

    @ElementCollection
    private Map<PhoneType, Phone> phones;

    @ManyToOne
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> directs;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects;

    public Employee(int id, String name, long salary) {
	this.id = id;
	this.name = name;
	this.salary = salary;

	directs = new HashSet<Employee>();
	projects = new HashSet<Project>();
	phones = new HashMap<PhoneType, Phone>();
    }

    public Employee() {
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public long getSalary() {
	return salary;
    }

    public Department getDepartment() {
	return department;
    }

    public void addDirect(Employee e) {
	directs.add(e);
	e.manager = this;
    }

    public void addPhone(PhoneType type, String number) {
	phones.put(type, new Phone(number, type));
    }

    void setDepartment(Department department) {
	this.department = department;
    }

    public Address getAddress() {
	return address;
    }

    public Set<Employee> getDirects() {
	return directs;
    }

    public Employee getManager() {
	return manager;
    }

    public Map<PhoneType, Phone> getPhones() {
	return phones;
    }

    void assignProject(Project project) {
	projects.add(project);
    }

    public void setAddress(Address address) {
	this.address = address;
	address.setEmployee(this);
    }
    
    @Override
    public String toString() {
        return String.format("Employee[id=%s]", id);
    }
}
