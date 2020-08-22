package ProjectCollege;
public class DisplayManager {
	Date d;
	String city,name;
	int tickets;
	String file1,file2;
	
	private First f;
	private Second s;
	private Third t;
	private FRSControl frs;
	
	public DisplayManager(FRSControl frs,String a, String b){
		file1=a;
		file2=b;
		 this.frs = frs;
		 
    }
	
	
	public void firstControl() {
		f = new First(frs.dm);
		f.setVisible(true);	
	}
	
	public void secondControl() {
		frs.infoAnalyse();
		s = new Second(frs.dm,frs.lm.fc,frs.lm.count);
		s.setVisible(true);
	}
	public void thirdControl() {
		t = new Third(frs,file1,file2);
		t.setVisible(true);
		
	}
}
