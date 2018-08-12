package com.thoughtclan.customerseg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Filter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="group_id")
	private Integer id;
	
	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_info")
	private String groupInfo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public Filter(String groupName, String groupInfo) {
		super();
		this.groupName = groupName;
		this.groupInfo = groupInfo;
	}
	
	public Filter() {
		
	}

}
