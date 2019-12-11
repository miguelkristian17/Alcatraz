package com.ryan.study.Alcatraz.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=0,max=200,message="Name must be present!")
    private String projectName;
	@Size(min=8,max=200,message="Description must be greater than 8 characters!")
    private String description;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projID = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="developer_id")
    private Developer developer;
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
    private List<UserPool> userpools;
	
	public Project() {
		
	}
	public Project(String projectName, String description){
		this.projectName = projectName;
		this.description = description;	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Long getProjID() {
		return projID;
	}
	public void setProjID(Long projID) {
		this.projID = projID;
	}
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public List<UserPool> getUserpools() {
		return userpools;
	}

	public void setUserpools(List<UserPool> userpools) {
		this.userpools = userpools;
	}

	
}
