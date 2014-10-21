package jpaworkshop.entities;

import javax.persistence.Entity;

@Entity
public class QualityProject extends Project {
    private int qaRating;
    
    public QualityProject() {
    }

    public QualityProject(int id, String name, int qaRating) {
	super(id, name);
	this.qaRating = qaRating;
    }
    
    public int getQaRating() {
	return qaRating;
    }
}
