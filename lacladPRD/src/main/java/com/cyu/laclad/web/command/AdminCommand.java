package com.cyu.laclad.web.command;

import java.util.Date;

import com.cyu.laclad.domain.Admin;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.enums.Status;
import com.cyu.laclad.enums.UserType;
import com.cyu.laclad.utils.LacladUtils;

public class AdminCommand extends PhysicalPersonCommand {

    private String systemUser;
    private Date enroldDate;
    private Status status;
    
    public AdminCommand() {
		super();
	}
    
	public AdminCommand(Admin admin) {
		super(admin);
		this.systemUser = admin.getSystemUser().getUserName();
		this.enroldDate = admin.getEnroldDate();
		this.status = admin.getStatus();
	}
	
	public Admin initAdmin() {
		Admin admin = new Admin();

		admin.setId(this.getId());
		admin.setVersion(this.getVersion());
		admin.setPersonalId(this.getPersonalId());
		admin.setName(this.getName());
		admin.setPhoneNumber(this.getPhoneNumber());
		admin.setDirections(this.getDirections());
		admin.setLastName(this.getLastName());
		admin.setSecondLastName(this.getSecondLastName());
		admin.setGender(this.getGender());
		admin.setStatus(this.status);
		admin.setSystemUser(new SystemUser(this.systemUser, LacladUtils.generateRandomPassword(), UserType.ROLE_ADMIN, Status.ACTIVE));
		admin.setEnroldDate(new Date());
		
		return admin;
		
	}

    public void updateAdmin(Admin admin) {
    	admin.setPersonalId(this.getPersonalId());
    	admin.setName(this.getName());
    	admin.setLastName(this.getLastName());
    	admin.setSecondLastName(this.getSecondLastName());
    	admin.setStatus(this.getStatus());
    	admin.setGender(this.getGender());
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