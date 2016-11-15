package com.cyu.laclad.web.command;

import java.util.HashSet;
import java.util.Set;

import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.PhysicalPerson;
import com.cyu.laclad.enums.Gender;

public class PhysicalPersonCommand extends EntityCommand {

	private Long personalId;
    private String name;
    private Long phoneNumber;
    private Set<Direction> directions = new HashSet<Direction>();
    private String lastName;
	private String secondLastName;
	private Gender gender;

	public PhysicalPersonCommand() {
		super();
	}
    
	public PhysicalPersonCommand(PhysicalPerson person) {
		super(person.getId(), person.getVersion());
		this.personalId = person.getPersonalId();
		this.name = person.getName();
		this.phoneNumber = person.getPhoneNumber();
		this.directions = person.getDirections();
		this.lastName = person.getLastName();
		this.secondLastName = person.getSecondLastName();
		this.gender = person.getGender();
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}