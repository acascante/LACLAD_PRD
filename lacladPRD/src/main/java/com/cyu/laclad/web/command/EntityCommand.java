package com.cyu.laclad.web.command;

public class EntityCommand {
    
	private Long id;
	private Integer version;
	
    public EntityCommand() {
		super();
	}
    
    public EntityCommand(Long id, Integer version) {
		super();
		this.id = id;
		this.version = version;
	}

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
