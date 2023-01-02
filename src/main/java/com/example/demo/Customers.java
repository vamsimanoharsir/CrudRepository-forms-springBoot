package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//with Entity annotation table will be created automatically when we run the project
public class Customers {
	@Id
	private int custid;
	private String cname;
	private String cemail;

	public int getCustid() {
		return custid;
	}
	public String getCname() {
		return cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	@Override
	public String toString() {
		return "Customers [custid=" + custid + ", cname=" + cname + ", cemail=" + cemail + "]";
	}


}
