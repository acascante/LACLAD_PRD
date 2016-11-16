package com.cyu.laclad.web.command;

import java.util.Date;

import com.cyu.laclad.domain.ClassGroup;
import com.cyu.laclad.domain.Student;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.LacladUtils;

public class StudentCommand extends PhysicalPersonCommand {

    private String systemUser;
    private Date enroldDate;
    private Status status;
    private ClassGroup classGroup;
    
    public StudentCommand() {
		super();
	}
    
	public StudentCommand(Student student) {
		super(student);
		this.systemUser = student.getSystemUser().getUserName();
		this.enroldDate = student.getEnroldDate();
		this.status = student.getStatus();
		this.classGroup = student.getClassGroup();
	}
	
	public Student initStudent() {
		Student student = new Student();

		student.setId(this.getId());
		student.setVersion(this.getVersion());
		student.setPersonalId(this.getPersonalId());
		student.setName(this.getName());
		student.setPhoneNumber(this.getPhoneNumber());
		student.setDirections(this.getDirections());
		student.setLastName(this.getLastName());
		student.setSecondLastName(this.getSecondLastName());
		student.setGender(this.getGender());
		student.setStatus(this.getStatus());
		student.setClassGroup(this.getClassGroup());
		student.setSystemUser(new SystemUser(this.systemUser, LacladUtils.generateRandomPassword(), UserType.ROLE_STUDENT, Status.ACTIVE));
		student.setEnroldDate(new Date());
		
		return student;
		
	}

    public void updateStudent(Student student) {
    	student.setPersonalId(this.getPersonalId());
    	student.setName(this.getName());
    	student.setLastName(this.getLastName());
    	student.setSecondLastName(this.getSecondLastName());
    	student.setStatus(this.getStatus());
    	student.setGender(this.getGender());
    	student.setClassGroup(this.getClassGroup());
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
	public ClassGroup getClassGroup() {
		return classGroup;
	}
	public void setClassGroup(ClassGroup classGroup) {
		this.classGroup = classGroup;
	}
}