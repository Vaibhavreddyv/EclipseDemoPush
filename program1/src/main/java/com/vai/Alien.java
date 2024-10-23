package com.vai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Alien {
	
	@Id
	private int Aid;
	private String Aname;
	private String Acolor;
	private int Marks;
	
	
	public Alien() {};
		
	


public Alien(int aid, String aname, String acolor, int marks) {
		super();
		this.Aid = aid;
		this.Aname = aname;
		this.Acolor = acolor;
		this.Marks = marks;
	}


	public int getAid() {
		return Aid;
	}


	public void setAid(int aid) {
		Aid = aid;
	}


	public String getAname() {
		return Aname;
	}


	public void setAname(String aname) {
		Aname = aname;
	}


	public String getAcolor() {
		return Acolor;
	}


	public void setAcolor(String acolor) {
		Acolor = acolor;
	}

	
	public int getMarks() {
		return Marks;
	}


	public void setMarks(int marks) {
		Marks = marks;
	}
	
	
	public String toString() {
		return Aid + " "+ Aname +" "+Acolor+" "+Marks;
	}
	
	



	
	

}
