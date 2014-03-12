package com.beans.leaveapp.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.beans.common.security.users.model.Users;
import com.beans.leaveapp.address.model.Address;
import com.beans.leaveapp.department.model.Department;
import com.beans.leaveapp.employeegrade.model.EmployeeGrade;
import com.beans.leaveapp.employeetype.model.EmployeeType;

@Entity
@Table(name="Employee")
public class Employee {

	private int id;
	private String employeeNumber;
	private String name;
	private String position;
	private String idNumber;
	private String passportNumber;
	private String gender;
	private String religion;
	private String maritalStatus;
	private String workEmailAddress;
	private String personalEmailAddress;
	private String officePhone;
	private String personalPhone;
	private String nationality;
	private Users users;
	private EmployeeGrade employeeGrade;
	private Department department;
	private EmployeeType employeeType;
	private Date joinDate;
	private Date resignationDate;
	private boolean isDeleted;
	private boolean isResigned;
	private List<Address> addresses;
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="employeenumber", nullable=false)
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="position", nullable=false)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Column(name="idNumber", nullable=true)
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	@Column(name="passportnumber", nullable=true)
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	@Column(name="gender", nullable=false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="religion", nullable=false)
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	@Column(name="maritalstatus", nullable=false)
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	@Column(name="workemailaddress", nullable=true)
	public String getWorkEmailAddress() {
		return workEmailAddress;
	}
	public void setWorkEmailAddress(String workEmailAddress) {
		this.workEmailAddress = workEmailAddress;
	}
	
	@Column(name="personalemailaddress", nullable=true)
	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}
	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}
	
	@Column(name="officephone", nullable=true)
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	@Column(name="personalphonee", nullable=true)
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	
	@Column(name="nationality", nullable=false)
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@OneToOne
	@Cascade({CascadeType.DELETE})
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@OneToOne
	public EmployeeGrade getEmployeeGrade() {
		return employeeGrade;
	}
	public void setEmployeeGrade(EmployeeGrade employeeGrade) {
		this.employeeGrade = employeeGrade;
	}
	
	@OneToOne
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@OneToOne
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
	
	@Column(name="joindate", nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Column(name="resignationdate", nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getResignationDate() {
		return resignationDate;
	}
	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}
	
	@Column(name="isdeleted", columnDefinition="TINYINT(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Column(name="isresigned", columnDefinition="TINYINT(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isResigned() {
		return isResigned;
	}
	public void setResigned(boolean isResigned) {
		this.isResigned = isResigned;
	}
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Address.class)
	@JoinColumn(name="employeeid")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
