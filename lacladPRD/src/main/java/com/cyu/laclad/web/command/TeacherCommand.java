package com.cyu.laclad.web.command;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cyu.laclad.domain.Direction;
import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.Gender;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.LacladUtils;

public class TeacherCommand extends EntityCommand {

	private Long personalId;
    private String name;
    private Long phoneNumber;
    private Set<Direction> directions = new HashSet<Direction>();
    private String lastName;
	private String secondLastName;
	private Gender gender;
	private Idiom mainLanguage;
    private String systemUser;
    private Date enroldDate;
    private Status status;
    
    public TeacherCommand() {
		super();
	}
    
	public TeacherCommand(Teacher teacher) {
		super(teacher.getId(), teacher.getVersion());
		this.personalId = teacher.getPersonalId();
		this.name = teacher.getName();
		this.phoneNumber = teacher.getPhoneNumber();
		this.directions = teacher.getDirections();
		this.lastName = teacher.getLastName();
		this.secondLastName = teacher.getSecondLastName();
		this.gender = teacher.getGender();
		this.mainLanguage = teacher.getMainLanguage();
		this.systemUser = teacher.getSystemUser().getUserName();
		this.enroldDate = teacher.getEnroldDate();
		this.status = teacher.getStatus();
	}
	
	public Teacher initTeacher() {
		Teacher teacher = new Teacher();

		teacher.setId(this.getId());
		teacher.setVersion(this.getVersion());
		teacher.setPersonalId(this.personalId);
		teacher.setName(this.name);
		teacher.setPhoneNumber(this.phoneNumber);
		teacher.setDirections(this.directions);
		teacher.setLastName(this.lastName);
		teacher.setSecondLastName(this.secondLastName);
		teacher.setGender(this.gender);
		teacher.setMainLanguage(this.mainLanguage);
		teacher.setStatus(this.status);
		teacher.setSystemUser(new SystemUser(this.systemUser, LacladUtils.generateRandomPassword(), UserType.ROLE_TEACHER, Status.ACTIVE));
		teacher.setEnroldDate(new Date());
		
		return teacher;
		
	}

    public void updateTeacher(Teacher teacher) {
    	teacher.setPersonalId(this.getPersonalId());
    	teacher.setName(this.getName());
    	teacher.setLastName(this.getLastName());
    	teacher.setSecondLastName(this.getSecondLastName());
    	teacher.setStatus(this.getStatus());
    	teacher.setGender(this.getGender());
		teacher.setMainLanguage(this.getMainLanguage());
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
	public Idiom getMainLanguage() {
		return mainLanguage;
	}
	public void setMainLanguage(Idiom mainLanguage) {
		this.mainLanguage = mainLanguage;
	}
	public String getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(String systemUser) {
		this.systemUser = systemUser;
	}
	public Date getEnroldDate() {
		return enroldDate;
	}
	public void setEnroldDate(Date enroldDate) {
		this.enroldDate = enroldDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
