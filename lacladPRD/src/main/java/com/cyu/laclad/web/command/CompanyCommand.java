package com.cyu.laclad.web.command;

import java.util.Date;

import com.cyu.laclad.domain.Company;
import com.cyu.laclad.enums.Status;

public class CompanyCommand extends JuridicPersonCommand {

    private Date enroldDate;
    private Status status;
    
    public CompanyCommand() {
		super();
	}
    
	public CompanyCommand(Company company) {
		super(company);
		this.enroldDate = company.getEnroldDate();
		this.status = company.getStatus();
	}
	
	public Company initCompany() {
		Company company = new Company();

		company.setId(this.getId());
		company.setVersion(this.getVersion());
		company.setPersonalId(this.getPersonalId());
		company.setJuridicName(this.getJuridicName());
		company.setName(this.getName());
		company.setPhoneNumber(this.getPhoneNumber());
		company.setDirections(this.getDirections());
		company.setContact(this.getContact());
		company.getContact().setStatus(this.getStatus());
		company.getContact().setEnroldDate(new Date());
		company.setStatus(this.getStatus());
		company.setEnroldDate(new Date());
		
		return company;
	}

    public void updateCompany(Company company) {
    	company.setPersonalId(this.getPersonalId());
    	company.setName(this.getName());
    	company.setStatus(this.getStatus());
    	company.setJuridicName(this.getJuridicName());
    	
    	company.getContact().setPersonalId(this.getContact().getPersonalId());
    	company.getContact().setName(this.getContact().getName());
    	company.getContact().setLastName(this.getContact().getLastName());
    	company.getContact().setSecondLastName(this.getContact().getSecondLastName());
    	company.getContact().setGender(this.getContact().getGender());
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