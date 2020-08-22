package ProjectCollege;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class DataManager {
	private int counter = 0;
	public FlightInfo infi[] = new FlightInfo[100];
	public FlightInfo nfi[] = new FlightInfo[100];
	private String silkair;
	private String spicejet;
	//private String silkair="2016.silkair.csv";
	//private String spicejet="2016.spicejet.csv";
	//private String silkair = "C:\\Users\\acer\\eclipse-workspace\\CollegeProject6\\src\\ProjectCollege\\2016.silkair.csv";
	//private String spicejet ="C:\\Users\\acer\\eclipse-workspace\\CollegeProject6\\src\\ProjectCollege\\2016.spicejet.csv";
	
	private FRSControl frs;
	public DataManager(FRSControl frs,String a, String b){
		silkair=a;
		spicejet=b;
		 this.frs = frs;
    }
    void readNationFlight() {

    	File folder= new File(DataManager.class.getProtectionDomain().getCodeSource().getLocation().getFile());
    	String path=folder.getParent()+File.separator+silkair;
    	File file= new File(path);
        //File file = new File(silkair);
        BufferedReader br = null;
        int count = 0;      
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String row;
            while( (row = br.readLine()) != null) {                
                if(count++>2) {
                	setNationFlightInfo(row);                	
                }
            }
        } catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(null,"File not found: " + file.toString());
        	frs.fileNotFound();
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null,"Unable to read file: " + file.toString());
        	frs.fileNotFound();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null,"Unable to close file: " + file.toString());
                System.out.println("Unable to close file: " + file.toString());
                frs.fileNotFound();
            }
            catch(NullPointerException ex) {
            }
        }
        counter = 0;
    }
    void setNationFlightInfo(String row) {
    	StringTokenizer st = new StringTokenizer(row,"|");   	
    	String source = st.nextToken();    	
    	String days = st.nextToken();
    	String Flight = st.nextToken();
    	String str = st.nextToken();
    	
    	nfi[counter] = new FlightInfo(Flight,source);
    	nfi[counter].setDays(days.split(","));
    	String time[] = str.split("/");
    	nfi[counter].setDept(new Time(time[0]));
    	nfi[counter].setArr(new Time(time[1]));
    	
    	
    	if(st.hasMoreTokens()) {
        	str = st.nextToken();
        	if(str.contains("Disc.") && !str.contains("Exc.")) {
    			str =str.substring(6);
    			//System.out.println(str);
    			nfi[counter].setValidTill(new Date(str));
    			//Date d1 = nfi[counter].getValidTill();
    			//System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
    		}
    		else if(str.contains("Eff")) {
    			str = str.substring(5);
    			//System.out.println(str);
    			nfi[counter].setValidFrom(new Date(str));
    			//Date d1 = nfi[counter].getValidFrom();
    			//System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
    		}
    		else if(str.contains("-")) {
    			StringTokenizer temp = new StringTokenizer(str,"-"); 
    			str = temp.nextToken();   
    			//System.out.println(str);
    			nfi[counter].setValidFrom(new Date(str));
    			str = temp.nextToken();   
    			//System.out.println(str);
    			nfi[counter].setValidTill(new Date(str));
    			//Date d1 = nfi[counter].getValidTill();
    			//System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
    			//d1 = nfi[counter].getValidFrom();
    			//System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
    		}
    		else if(str.contains("Exc.")) {
    			int k = str.indexOf("Disc.");
    			String temp2 = str.substring(k+5,k+11);
    			//System.out.println(temp2);
    			nfi[counter].setValidTill(new Date(temp2));
    			//Date d1 = nfi[counter].getValidTill();
    			//System.out.println(d1.getD()+"/"+d1.getM()+"/"+d1.getY());
    			int l = str.indexOf("Exc.") + 4;
    			str = str.substring(l);
    			StringTokenizer temp = new StringTokenizer(str,",");     			
    			Date remarks[] = new Date[3];
    			str = temp.nextToken();
    			//System.out.println(str);
    			remarks[0]= new Date(str);    			
    			str = temp.nextToken();
    			//System.out.println(str);
    			remarks[1]= new Date(str);
    			str = temp.nextToken();
    			//System.out.println(str);
    			remarks[2]= new Date(str);
    			nfi[counter].setRemarks(remarks);
    		}
    	}
    	counter++;
    }    
    void readInternFlight() {
    	File folder= new File(DataManager.class.getProtectionDomain().getCodeSource().getLocation().getFile());
    	String path=folder.getParent()+File.separator+spicejet;
    	File file= new File(path);
    	//File file = new File(spicejet);
        BufferedReader br = null;
        int count = 0;      
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String row;
            while( (row = br.readLine()) != null) {   
            	
                if(count++>4) {                	
                	setInternFlightInfo(row);                	
                }                
            }
        } catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(null,"File not found: " + file.toString());
            System.out.println("File not found: " + file.toString());
            frs.fileNotFound();
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null,"Unable to read file: " + file.toString());
            System.out.println("Unable to read file: " + file.toString());
            frs.fileNotFound();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null,"Unable to close file: " + file.toString());
                System.out.println("Unable to close file: " + file.toString());
                frs.fileNotFound();
            }
            catch(NullPointerException ex) {
            }
        }
        counter = 0;
    }
    
    void setInternFlightInfo(String row) {
    	StringTokenizer st = new StringTokenizer(row,"|");    	
    	String source = st.nextToken();
    	String destination = st.nextToken();
    	String days = st.nextToken();
    	String Flight = st.nextToken();
    	String departure = st.nextToken();
    	String arrival = st.nextToken();
    	String via = st.nextToken();
    	String from = st.nextToken();
    	String till = st.nextToken();
    	
    	infi[counter] = new FlightInfo(Flight,source);    	
    	infi[counter].setDest(destination);
    	infi[counter].setDays(days.split(","));    	
    	infi[counter].setDept(new Time(departure));
    	infi[counter].setArr(new Time(arrival));
    	infi[counter].setVia(via);
    	infi[counter].setValidFrom(new Date(from));
    	infi[counter].setValidTill(new Date(till));
    	counter++;
    }
	
}

