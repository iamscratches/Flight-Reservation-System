package ProjectCollege;
//import java.util.*;
public class nationFlightInfo extends internFlightInfo {
	private String dest,via;
	Date eTill,eFrom;
	
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
		//System.out.println(this.dest);
	}
	
	public String getVia() {
		return dest;
	}
	public void setVia(String via) {
		this.via = via;
		//System.out.println(this.via);
	}
	
	public Date getTill() {
		return eTill;
	}
	public void setTill(Date eTill) {
		this.eTill = eTill;
		//System.out.println(this.eTill);
	}
	
	public Date getFrom() {
		return eFrom;
	}
	public void setFrom(Date eFrom) {
		this.eFrom = eFrom;
		//System.out.println(this.eFrom);
	}
	
	/*public static void main(String args[]) {
		nationFlightInfo ob = new nationFlightInfo();
		ob.show();
	}
	*/
	
	
}
