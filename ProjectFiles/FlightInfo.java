package ProjectCollege;

public class FlightInfo {
	
	private Date validFrom = new Date(1,9,2016);	
	private Date validTill = new Date(13,11,2016);
	private Date remarks[] = new Date[1];	
	private String sector;
	private String dest = "Singapore";
	private String[] days;
	private String Flight;
	private Time dept;
	private Time arr;
	
	private String via;
	
	FlightInfo(String Flight,String sector){
		this.Flight = Flight;
		this.sector = sector;
		remarks[0] = new Date(1,1,1);
	}
		
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
		//System.out.println(this.via);
	}
	
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
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

	public Date[] getRemarks() {
		return remarks;
	}
	public void setRemarks(Date[] remarks) {
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



