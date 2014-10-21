package jpaworkshop.entities;

import javax.persistence.Entity;

@Entity
public class DesignProject extends Project {
    public DesignProject() {
    }

    public DesignProject(int id, String name) {
	super(id, name);
    }
}
