package com.example.datasource;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class personpojo {
	@Id
	private int pid;
	private String pname;
	private int page;
	private String pqual;
	public int getPid() {
		return pid;
	}
	
	public personpojo() {
		super();
	}
	public personpojo(int pid, String pname, int page, String pqual) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.page = page;
		this.pqual = pqual;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPqual() {
		return pqual;
	}
	public void setPqual(String pqual) {
		this.pqual = pqual;
	}
	@Override
	public String toString() {
		return "personpojo [pid=" + pid + ", pname=" + pname + ", page=" + page + ", pqual=" + pqual + "]";
	}
	

}
