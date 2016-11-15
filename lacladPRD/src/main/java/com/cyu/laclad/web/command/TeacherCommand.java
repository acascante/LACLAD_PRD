package com.cyu.laclad.web.command;

import java.util.Date;

import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.LacladUtils;

public class TeacherCommand extends PhysicalPersonCommand {

	private Idiom mainLanguage;
    private String systemUser;
    private Date enroldDate;
    private Status status;
    
    public TeacherCommand() {
		super();
	}
    
	public TeacherCommand(Teacher teacher) {
		super(teacher);
		this.mainLanguage = teacher.getMainLanguage();
		this.systemUser = teacher.getSystemUser().getUserName();
		this.enroldDate = teacher.getEnroldDate();
		this.status = teacher.getStatus();
	}
	
	public Teacher initTeacher() {
		Teacher teacher = new Teacher();

		teacher.setId(this.getId());
		teacher.setVersion(this.getVersion());
		teacher.setPersonalId(this.getPersonalId());
		teacher.setName(this.getName());
		teacher.setPhoneNumber(this.getPhoneNumber());
		teacher.setDirections(this.getDirections());
		teacher.setLastName(this.getLastName());
		teacher.setSecondLastName(this.getSecondLastName());
		teacher.setGender(this.getGender());
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