package jpaworkshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
    @Id
    private int id;

    private String name;

    @ManyToMany
    private Set<Employee> employees;

    public Project() {
    }

    public Project(int id, String name) {
	this.id = id;
	this.name = name;
	
	this.employees = new HashSet<Employee>();
    }

    public void assignEmployee(Employee e) {
	employees.add(e);
	e.assignProject(this);
    }
    
    public Set<Employee> getEmployees() {
	return employees;
    }
    
    public int getId() {
	return id;
    }
    
    public String getName() {
	return name;
    }
}
