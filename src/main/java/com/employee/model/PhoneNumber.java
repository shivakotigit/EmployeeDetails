package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PhoneNumber")
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long phoneId;

	private Long homeNbr;

	private Long officeNbr;

	public Long getHomeNbr() {
		return homeNbr;
	}

	public Long getOfficeNbr() {
		return officeNbr;
	}

	public void setHomeNbr(Long homeNbr) {
		this.homeNbr = homeNbr;
	}

	public void setOfficeNbr(Long officeNbr) {
		this.officeNbr = officeNbr;
	}

}
