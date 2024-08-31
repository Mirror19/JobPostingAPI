package com.example.jobpostingapi;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String location;
    private String company;
    private String salaryRange;

    @ElementCollection
    private List<String> requiredSkills;
    
    @Temporal(TemporalType.DATE)
    private Date applicationDeadline;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public List<String> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

    // Getters and Setters
    
}
