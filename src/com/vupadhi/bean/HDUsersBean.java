package com.vupadhi.bean;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Table
@Entity(name="tblHDUsers")
public class HDUsersBean {

	@Id
	private String nHelpDeskID;
	private String nUserType;
	@NotEmpty (message="{NotEmpty.hdUsersBean.sUserName}")
	private String sUserName;
	
	private String sPassword;
	
	@NotEmpty(message="{NotEmpty.hdUsersBean.sMobileNo}")
	@Pattern(regexp="^[6-9][0-9]{9}$",message="{Pattern.hdUsersBean.sMobileNo}")
	private String sMobileNo;
	
	@NotEmpty(message="{NotEmpty.hdUsersBean.sName}")
	private String sName;
	
	@NotEmpty(message="{NotEmpty.hdUsersBean.sEmail}")
	@Pattern(regexp=".+@.+\\..+", message="{Pattern.hdUsersBean.sEmail}")
	private String sEmail;
	
	@NotEmpty(message="{NotEmpty.hdUsersBean.sRole}")
	private String sRole;
	private String nStatus;
	private String dtCreated;
	private String dtLastLogin;
	private String nFailCount;
	
	private String sOtpValue;
	private String sOTPStatus;
	
	
	public String getsOtpValue() {
		return sOtpValue;
	}
	public void setsOtpValue(String sOtpValue) {
		this.sOtpValue = sOtpValue;
	}
	public String getsOTPStatus() {
		return sOTPStatus;
	}
	public void setsOTPStatus(String sOTPStatus) {
		this.sOTPStatus = sOTPStatus;
	}
	public String getnHelpDeskID() {
		return nHelpDeskID;
	}
	public void setnHelpDeskID(String nHelpDeskID) {
		this.nHelpDeskID = nHelpDeskID;
	}
	public String getnUserType() {
		return nUserType;
	}
	public void setnUserType(String nUserType) {
		this.nUserType = nUserType;
	}
	public String getsUserName() {
		return sUserName;
	}
	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getsMobileNo() {
		return sMobileNo;
	}
	public void setsMobileNo(String sMobileNo) {
		this.sMobileNo = sMobileNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsRole() {
		return sRole;
	}
	public void setsRole(String sRole) {
		this.sRole = sRole;
	}
	public String getnStatus() {
		return nStatus;
	}
	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}
	public String getDtCreated() {
		return dtCreated;
	}
	public void setDtCreated(String dtCreated) {
		this.dtCreated = dtCreated;
	}
	public String getDtLastLogin() {
		return dtLastLogin;
	}
	public void setDtLastLogin(String dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}
	public String getnFailCount() {
		return nFailCount;
	}
	public void setnFailCount(String nFailCount) {
		this.nFailCount = nFailCount;
	}
	
	
	
	


	
}
