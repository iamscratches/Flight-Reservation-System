package ProjectCollege;

class flightCombo {
	public String Flight1;
	public String Flight2;
	public String Source;
	public String Stop;
	//public Time[] Departure1,Departure2,Arrival1,Arrival2,Interval,TotalTime
	public Time Departure1;
	public Time Departure2;
	public Time Arrival1;
	public Time Arrival2;
	public Time Interval;
	public Time TotalTime;
	
	public String print() {
		String str;
		str =  "            " + Flight1 + "   " + Source + "         ";
		String temp;
		temp = " " + Departure1.getHr()%24+":" + Departure1.getMin()%60;
		//System.out.println(temp.length());
		if(temp.length()==4)
			temp+="   ";
		else if(temp.length()==5)
			temp+="  ";
		str +=temp+"    ";
		str +=Stop;
		//System.out.println(Stop.length());
		if(Stop.length()==7)
			str +="     ";
		temp = "     " + Arrival1.getHr()%24+":" + Arrival1.getMin()%60;
		//System.out.println(temp.length());
		if(temp.length()==9)
			temp+="  ";
		else if(temp.length()==10)
			temp+=" ";
		str +=temp+"    ";
		temp = " " + Interval.getHr()+":"+Interval.getMin();
		//System.out.println(temp.length());
		if(temp.length()==4)
			temp+="   ";
		else if(temp.length()==5)
			temp+="  ";
		str +=temp+"    ";
		str +="    "+Flight2+ "          ";
		temp = " " + Departure2.getHr()%24+":" + Departure2.getMin()%60;
		//System.out.println(temp.length());
		
		if(temp.length()==4)
			temp+="   ";
		else if(temp.length()==5)
			temp+="  ";
		str +=temp+"    ";
		temp = Arrival2.getHr()%24+":" + Arrival2.getMin()%60;
		str +="        SINGAPORE           ";
		//System.out.println(temp.length());
		if(temp.length()==4)
			temp+="   ";
		else if(temp.length()==5)
			temp+="  ";
		str +=temp +"      " +  TotalTime.getHr() + ":" + TotalTime.getMin();	
		//System.out.println("-----------------");
		
		/*
		str = "            " + Flight1 + "   " + Source + "         " + Departure1.getHr()%24+":" + Departure1.getMin()%60
				+ "        " + Stop + "        " + Arrival1.getHr()%24+":"+Arrival1.getMin()%60 + "             " + Interval.getHr()+":"+Interval.getMin()
				+ "           " + Flight2 + "            " + Departure2.getHr()%24+":" + Departure2.getMin()%60 + "               " + "SINGAPORE" + "          " + 
				Arrival2.getHr()%24+":" + Arrival2.getMin()%60 + "          " + TotalTime.getHr() + ":" + TotalTime.getMin();
		str= str + " ";*/
		
		
		return str;
	}
}
