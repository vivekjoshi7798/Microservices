package com.vpj.ToDoApp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private int mUserid;
	private String mfirstName;
	private String mLastName;
	private String iUsername;
	private String password;
	public int getmUserid() {
		return mUserid;
	}
	public void setmUserid(int mUserid) {
		this.mUserid = mUserid;
	}
	public String getMfirstName() {
		return mfirstName;
	}
	public void setMfirstName(String mfirstName) {
		this.mfirstName = mfirstName;
	}
	public String getmLastName() {
		return mLastName;
	}
	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	public String getUsername() {
		return iUsername;
	}
	public void setUsername(String username) {
		iUsername = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [mUserid=" + mUserid + ", mfirstName=" + mfirstName + ", mLastName=" + mLastName + ", Username="
				+ iUsername + ", password=" + password + "]";
	}
	public UserDetails(int mUserid, String mfirstName, String mLastName, String username, String password) {
		super();
		this.mUserid = mUserid;
		this.mfirstName = mfirstName;
		this.mLastName = mLastName;
		iUsername = username;
		this.password = password;
	}

	UserDetails(){}
	
}

