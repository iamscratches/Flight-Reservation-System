package ProjectCollege;

public class Time {

	private int hrs;
	private int min;
	
	public Time()
	{
		hrs=0;
		min=0;
	}
	public Time(Time t) {
		this.hrs = t.hrs;
		this.min = t.min;
	}
	public Time(int hrs, int min) {
		this.hrs=hrs;
		this.min=min;
	}
	public Time(String t)
	{
		t = t.trim();
		if(t.contains("AM")) //for time like 9:15 AM
		{
			hrs=Integer.parseInt(t.substring(0, 2));
			min=Integer.parseInt(t.substring(3,5));
		}
		else if(t.contains("PM")) //for time like 9:15 PM
		{
			hrs=12+Integer.parseInt(t.substring(0, 2));
			min=Integer.parseInt(t.substring(3,5));
		}
		else //for time like 2340
		{
			hrs=Integer.parseInt(t.substring(0, 2));
			min= Integer.parseInt(t.substring(2, 4));
		}
		if(t.contains("+")) //for time like 0640+1
		{
			hrs+=24;
		}
	}
	public void setHrs(int hrs)
	{
		this.hrs=hrs;
	}
	public void setMin(int min)
	{
		this.min=min;
	}
	public Time difference(Time t2)
	{
		int m1=hrs*60+min;
		int m2=t2.getHr()*60+t2.getMin();
		int res=m1-m2;
		Time temp= new Time();
		temp.setMin(res%60);
		temp.setHrs(res/60);
		return temp;
		
	}
	public int getHr()
	{
		return hrs;
	}
	public int getMin()
	{
		return min;
	}
	/*
	public Time getActual(Time t2)
	{
		Time temp= new Time();
		int m=t2.getHr()*60+t2.getMin();
		temp.setMin(m%60);
		temp.setHrs(m/60);
		return temp;
	}*/
	public Time total(Time t2)
	{
		Time temp=new Time();
		int m1=hrs*60+min;
		int m2=t2.getHr()*60+t2.getMin();
		//int m3=t3.getHr()*60+t3.getMin();
		int res=m1+m2;//+m3;
		temp.setMin(res%60);
		temp.setHrs(res/60);
		return temp;
	}
	public static void main(String[] args) {
		Time t1= new Time("2350");
		Time t2= new Time("09:15 PM");
		Time t4= new Time("0640+1");
		Time t5= new Time("0120");
		Time t6= new Time("0030");
		Time t7= new Time("0100");
		System.out.println(t1.getHr()+":"+t1.getMin());
		System.out.println(t2.getHr()+":"+t2.getMin());
		Time t3= t1.difference(t2);
		System.out.println(t3.getHr()+":"+t3.getMin());
		System.out.println(t4.getHr()+":"+t4.getMin());
		System.out.println(t5.getHr()+":"+t5.getMin());
		System.out.println(t6.getHr()+":"+t6.getMin());
		System.out.println(t7.getHr()+":"+t7.getMin());
		Time ex= t5.total(t6);
		System.out.println(ex.getHr()+":"+ex.getMin());
		
	}

}
