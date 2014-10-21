package jpaworkshop.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
    private String number;
    private PhoneType type;

    public Phone() {
    }

    public Phone(String number, PhoneType type) {
	this.number = number;
	this.type = type;
    }

    public String getNumber() {
	return number;
    }

    public PhoneType getType() {
	return type;
    }
}
