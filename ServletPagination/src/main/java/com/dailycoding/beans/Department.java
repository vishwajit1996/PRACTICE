/**
 * 
 */
package com.dailycoding.beans;

import java.io.Serializable;

/**
 * @author a807228
 *
 */
public class Department implements Serializable {
	
	private int departmentId;
	private String departmentName;
	private String departManager;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartManager() {
		return departManager;
	}
	public void setDepartManager(String departManager) {
		this.departManager = departManager;
	}
	
	


}
