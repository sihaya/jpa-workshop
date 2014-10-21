package jpaworkshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(int id, String name) {
	this.id = id;
	this.name = name;
	
	this.employees = new HashSet<Employee>();
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public Set<Employee> getEmployees() {
	return employees;
    }
    
    public void add(Employee e) {
	employees.add(e);
	e.setDepartment(this);
    }
    
    @Override
    public String toString() {
        return String.format("Department[id=%s]", id);
    }
}
