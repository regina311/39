package com.example.tests;

public class ContacnData implements Comparable <ContacnData> {
	String fname;
	String lname;
	public String address1;
	public String hnumber;
	public String mnumber;
	public String wnumber;
	public String mail1;
	public String mail2;
	public String year;
	public String address2;
	public String phonenumber;

	public ContacnData() {
		
	}
	
	public ContacnData(String fname, String lname, String address1,
			String hnumber, String mnumber, String wnumber, String mail1,
			String mail2, String year, String address2, String phonenumber) {
		this.fname = fname;
		this.lname = lname;
		this.address1 = address1;
		this.hnumber = hnumber;
		this.mnumber = mnumber;
		this.wnumber = wnumber;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.year = year;
		this.address2 = address2;
		this.phonenumber = phonenumber;
	}

	

	@Override
	public String toString() {
		return "ContacnData [fname=" + fname + ", lname=" + lname
				+ ", hnumber=" + hnumber + ", mail1=" + mail1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContacnData other = (ContacnData) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContacnData other) {
		if (this.lname.toLowerCase().equals(other.lname.toLowerCase())) {  
				if (this.fname.toLowerCase().equals(other.fname.toLowerCase())) {  
			 				if (this.mail1.toLowerCase().equals(other.mail1.toLowerCase())) {  
			 					return this.hnumber.replace(" ", "").toLowerCase().compareTo(other.hnumber.replace(" ", "").toLowerCase());  
			 				} else {  
								return this.mail1.toLowerCase().compareTo(other.mail1.toLowerCase());  
			 				}  
			 			} else {  
			 				return this.fname.toLowerCase().compareTo(other.fname.toLowerCase());  
			 			}  
			 	} else {  
			 			return this.lname.toLowerCase().compareTo(other.lname.toLowerCase());  
			 		}  
			 	}

	public ContacnData withFname(String fname) {
		// TODO Auto-generated method stub
		
		this.fname = fname;
		return this;
	}

	public ContacnData withLname(String lname) {
		this.lname = lname;
		// TODO Auto-generated method stub
		return this;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getAddress1() {
		return address1;
	}

	public String getHnumber() {
		return hnumber;
	}

	public String getMnumber() {
		return mnumber;
	}

	public String getWnumber() {
		return wnumber;
	}

	public String getMail1() {
		return mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public String getYear() {
		return year;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhonenumber() {
		return phonenumber;
	}  
	

	}
	
	
	
