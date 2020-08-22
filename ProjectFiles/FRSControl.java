package ProjectCollege;

public class FRSControl{
	DataManager dam;		
	DisplayManager dm;
	LogicManager lm;
	
	public static void main(String args[]) {	
		FRSControl frs = new FRSControl();
		if(args.length==0) {
			frs.dam = new DataManager(frs,"2016.silkair.csv","2016.spicejet.csv");
			frs.dm = new DisplayManager(frs,"2016.silkair.csv","2016.spicejet.csv");
			frs.lm = new LogicManager(frs);
			frs.infoCollect();		
		}
		else if(args.length!=2)
		{
			System.out.println("Wrong parameters");
			System.exit(0);
		}
		else
		{
		frs.dam = new DataManager(frs,args[0],args[1]);
		frs.dm = new DisplayManager(frs,args[0],args[1]);
		frs.lm = new LogicManager(frs);
		frs.infoCollect();		
		}
	}
	public void infoCollect() {			
		dam.readInternFlight();
		dam.readNationFlight();	
		dm.firstControl();
	}
	public void infoAnalyse() {
		lm.search(dm,dam);
		lm.sort();		
	}
	public void fileNotFound() {
		System.exit(0);
	}
	
}
