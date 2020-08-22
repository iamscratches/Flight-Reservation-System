package ProjectCollege;
//import java.util.*;
public class internFlightInfo {
	
	private Date validFrom = new Date(1,9,2016);	
	private Date validTill = new Date(13,11,2016);
	
	private String sector;
	private String[] days;
	private String Flight;
	private Time dept;
	private Time arr;
	private String remarks;
		
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
		//System.out.println(this.sector);
	}
	
	public String[] getDays() {
		//System.out.println(days.length);
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
		//for(String str : this.days)
			//System.out.println(str);
	}
	
	public String getFlight() {
		return Flight;
	}
	public void setFlight(String flight) {
		Flight = flight;
		//System.out.println(Flight);
	}
	
	public Time getDept() {
		return dept;
	}
	public void setDept(Time dept) {
		this.dept = dept;
		//System.out.println(this.dept);
	}
	
	public Time getArr() {
		return arr;
	}
	public void setArr(Time arr) {
		this.arr = arr;
		//System.out.println(this.arr);
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
		//System.out.println(remarks);
	}
	
	
	/*
	public static void main(String args[]) {
		internFlightInfo ob = new internFlightInfo();
		ob.show();		
	}
	
	void show() {
		if(validTill.compareTo(validTill)==0)
			System.out.println("its greater");
		else
			System.out.println("its not greater");
		System.out.println(validFrom);
		System.out.println(validTill);
	}	*/
}


