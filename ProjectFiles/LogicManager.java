package ProjectCollege;

public class LogicManager {
	private FRSControl mgr;
	public LogicManager(FRSControl mgr){
		 this.mgr = mgr;
    }
	flightCombo fc[] = new flightCombo[100];
	int count=0;
	public void search(DisplayManager dm,DataManager dam) {
		Time temp;
		Reservation rf = new Reservation();
		for(int i=0;i<57;i++) {			
			if(dam.infi[i].getSector().toUpperCase().contains(dm.city.toUpperCase()) && (dm.d.compareTo(dam.infi[i].getValidFrom())>=0) && (dm.d.compareTo(dam.infi[i].getValidTill())<=0)) {//checking infi for source availability
				
				if(check(dam.infi[i].getDays(),dm.d.getDay())) {
					for(int j = 0; j<16;j++) {
						temp = dam.nfi[j].getDept().difference(dam.infi[i].getArr());
						if((temp.getHr()>=2 && temp.getHr()<6 ||(temp.getHr()==6 && temp.getMin()==0)) && (dm.d.compareTo(dam.nfi[j].getValidFrom())>=0) && (dm.d.compareTo(dam.nfi[j].getValidTill())<=0) && checkRemarks(dm.d,dam.nfi[j].getRemarks())) {
							if(dam.nfi[j].getSector().toUpperCase().contains(dam.infi[i].getDest().toUpperCase()) && check(dam.nfi[j].getDays(),dm.d.getDay()) ){//checking for nfi flights for infi dest flights and day availability												
									if(rf.checkDetails(dam.nfi[j].getFlight(),dm.d,dm.tickets,dm.name)&&
											rf.checkDetails(dam.infi[j].getFlight(),dm.d,dm.tickets,dm.name)) {
										fc[count] = new flightCombo();
										fc[count].Interval = temp;									
										put(dam,i,j);
									}
							}	
						}
						else if((((24+temp.getHr())>2 && ((24+temp.getHr()) <=6)) || ((24+temp.getHr())==2 && temp.getMin()>=0)) && (dm.d.compareTo(dam.nfi[j].getValidFrom())>=-1) && (dm.d.compareTo(dam.nfi[j].getValidTill())<0) && checkRemarks(dm.d,dam.nfi[j].getRemarks())){
							if(dam.nfi[j].getSector().toUpperCase().contains(dam.infi[i].getDest().toUpperCase()) && check(dam.nfi[j].getDays(),dm.d.nextDay())) {
								if(rf.checkDetails(dam.nfi[j].getFlight(),dm.d,dm.tickets,dm.name)&&
										rf.checkDetails(dam.infi[j].getFlight(),dm.d,dm.tickets,dm.name)) {	
									fc[count] = new flightCombo();
									fc[count].Interval = new Time(24+temp.getHr(),(60+temp.getMin())%60);
									put(dam,i,j);
								}
							}
						}
					}
				}
			}
		}
	}
	public void sort() {
		Time temp;
		String str;
		for(int i = 0 ; i<count-1 ; i++) {
			for(int j = 1;j<count-i;j++) {
				if(fc[j-1].TotalTime.difference(fc[j].TotalTime).getHr()>0||(fc[j-1].TotalTime.difference(fc[j].TotalTime).getHr()==0 && fc[j-1].TotalTime.difference(fc[j].TotalTime).getMin()>0)) {					
					temp = fc[j-1].TotalTime;
					fc[j-1].TotalTime = fc[j].TotalTime;
					fc[j].TotalTime = temp;
					
					temp = fc[j-1].Interval;
					fc[j-1].Interval = fc[j].Interval;
					fc[j].Interval = temp;
					
					temp = fc[j-1].Arrival2;
					fc[j-1].Arrival2 = fc[j].Arrival2;
					fc[j].Arrival2 = temp;
					
					temp = fc[j-1].Departure2;
					fc[j-1].Departure2 = fc[j].Departure2;
					fc[j].Departure2 = temp;
					
					temp = fc[j-1].Arrival1;
					fc[j-1].Arrival1 = fc[j].Arrival1;
					fc[j].Arrival1 = temp;
					
					temp = fc[j-1].Departure1;
					fc[j-1].Departure1 = fc[j].Departure1;
					fc[j].Departure1 = temp;
					
					str = fc[j-1].Flight2;
					fc[j-1].Flight2 = fc[j].Flight2;
					fc[j].Flight2 = str;
					
					str = fc[j-1].Flight1;
					fc[j-1].Flight1 = fc[j].Flight1;
					fc[j].Flight1 = str;
					
					str = fc[j-1].Source;
					fc[j-1].Source = fc[j].Source;
					fc[j].Source = str;
					
					str = fc[j-1].Stop;
					fc[j-1].Stop = fc[j].Stop;
					fc[j].Stop = str;
				}
			}
		}
	}
	private boolean checkRemarks(Date d, Date[] remarks) {		
		for(Date t :remarks) {
			if(d.compareTo(t)==0)
				return false;
		}
		return true;
	}
	private boolean check(String[] str1, String str2) {
		for(String str : str1) {
			if(str.toUpperCase().contains(str2.toUpperCase())||str.equalsIgnoreCase("daily")) 
				return true;
		}
		return false;
	}
	void put(DataManager dam,int i,int j) {
		fc[count].Flight1 = dam.infi[i].getFlight();
		fc[count].Source = dam.infi[i].getSector();
		fc[count].Departure1 = dam.infi[i].getDept();
		fc[count].Stop = dam.infi[i].getDest();
		fc[count].Arrival1 = dam.infi[i].getArr();
		fc[count].Flight2 = dam.nfi[j].getFlight();
		fc[count].Departure2 = dam.nfi[j].getDept();
		fc[count].Arrival2 = dam.nfi[j].getArr();
		fc[count].TotalTime = fc[count].Arrival1.difference(fc[count].Departure1).total(fc[count].Arrival2.difference(fc[count].Departure2));// Departure1[count].total(Arrival2[count]);
		fc[count].TotalTime = fc[count].TotalTime.total(fc[count].Interval);
		count++;
	}

}
