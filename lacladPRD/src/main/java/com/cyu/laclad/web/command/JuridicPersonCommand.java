package com.cyu.laclad.web.command;

import java.util.HashSet;
import java.util.Set;

import com.cyu.laclad.domain.Contact;
import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.JuridicPerson;

public class JuridicPersonCommand extends EntityCommand {

    private String juridicName;
	private Long personalId;
    private String name;
    private Long phoneNumber;
    private Set<Direction> directions = new HashSet<Direction>();
    private Contact contact;
    
	public JuridicPersonCommand() {
		super();
	}
    
	public JuridicPersonCommand(JuridicPerson person) {
		super(person.getId(), person.getVersion());
		this.personalId = person.getPersonalId();
		this.name = person.getName();
		this.phoneNumber = person.getPhoneNumber();
		this.directions = person.getDirections();
		this.juridicName = person.getJuridicName();
		this.contact = person.getContact();
	}

	public String getJuridicName() {
		return juridicName;
	}

	public void setJuridicName(String juridicName) {
		this.juridicName = juridicName;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Direction> getDirections() {
		return directions;
	}

	public void setDirections(Set<Direction> directions) {
		this.directions = directions;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}