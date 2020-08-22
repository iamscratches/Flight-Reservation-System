package ProjectCollege;

public class Date {

	private int dd;
	private int mm;
	private int yy = 2016;
	private String day;
	private int value;
	public Date(String d) {
		d = d.trim();
		if(d.length()<=5)
		{
			switch(d.substring(0,3))
			{
			case "JAN":mm=1;break;
			case "FEB":mm=2;break;
			case "MAR":mm=3;break;
			case "APR":mm=4;break;
			case "MAY":mm=5;break;
			case "JUN":mm=6;break;
			case "JUL":mm=7;break;
			case "AUG":mm=8;break;
			case "SEP":mm=9;break;
			case "OCT":mm=10;break;
			case "NOV":mm=11;break;
			case "DEC":mm=12;break;
			default :mm=0; break;
			}
			dd=Integer.parseInt(d.substring(3));
		}
		else
		{
		yy=2000+Integer.parseInt(d.substring(d.length()-2,d.length()));
		dd=Integer.parseInt(d.substring(0,2));
		switch(d.substring(3,6))
		{
		case "JAN":mm=1;break;
		case "FEB":mm=2;break;
		case "MAR":mm=3;break;
		case "APR":mm=4;break;
		case "MAY":mm=5;break;
		case "JUN":mm=6;break;
		case "JUL":mm=7;break;
		case "AUG":mm=8;break;
		case "SEP":mm=9;break;
		case "OCT":mm=10;break;
		case "NOV":mm=11;break;
		case "DEC":mm=12;break;
		default :mm=0; break;
		}}
		day=findDay();
		value = yy  * 10000 + mm*100 + dd;
	}
	public String printDate()
	{
		String str=this.dd+" ";
		switch(this.mm)
		{
		case 1: str=str+"JAN";break;
		case 2: str=str+"FEB";break;
		case 3: str=str+"MAR";break;
		case 4: str=str+"APR";break;
		case 5: str=str+"MAY";break;
		case 6: str=str+"JUN";break;
		case 7: str=str+"JUL";break;
		case 8: str=str+"AUG";break;
		case 9: str=str+"SEP";break;
		case 10: str=str+"OCT";break;
		case 11: str=str+"NOV";break;
		case 12: str=str+"DEC";break;
		}
		int temp=this.yy-2000;
		str=str+" "+temp;
		return str;
	}
	public Date(int dd,int mm,int yyyy)
	{		
		this.dd = dd;
		this.mm = mm;
		this.yy = yyyy;
		day=findDay();
		value = yy  * 10000 + mm*100 + dd;
	}
	private String findDay()
	{
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
		int d = dd;
		int m = mm;
		int y = yy;
	    y -= (m < 3) ? 1 : 0; 
	    int f = ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; 
		String result="XX";
		switch(f)
		{
		case 0: result="SUN";break;
		case 1: result= "MON"; break;
		case 2: result= "TUE";break;
		case 3: result= "WED";break;
		case 4: result= "THU";break;
		case 5: result= "FRI";break;
		case 6: result= "SAT";break;
		default: result="XX";break;
		}
		return result;
	}
	public String getDay() {		return day;}
	public String nextDay() {		
		switch(getDay()) {
		case "SUN": return "MON";
		case "MON": return "TUE";
		case "TUE": return "WED";
		case "WED": return "THU";
		case "THU": return "FRI";
		case "FRI": return "SAT";
		case "SAT": return "SUN";
		default: return "XX";
		
		}
	}
	public int compareTo(Date d) {	return value - d.getV();}
	public int getY() {		return yy;}
	public int getM() {		return mm;}
	public int getD() {		return dd;}
	public int getV() {		return value;}
	
	/*
	public static void main(String[] args) {
		Date d1= new Date("12 NOV 16");
		Date d2= new Date("10 NOV 16");
		Date d3= new Date(11,11,2016);
		int result=d1.compareTo(d2);
		if(result<0)
			System.out.println("d1 is larger");
		else
			System.out.println("d2 is larger");
		System.out.println(result+"\t"+d1.getV()+"\t"+d2.getV());
		System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
		System.out.println(d1.getDay());
		System.out.println(d3.getDay());
		System.out.println(result);
	}*/

}
