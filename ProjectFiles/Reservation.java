package ProjectCollege;
import java.io.*;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Reservation {
	public Date d;
	public int tickets;
	public String flight;
	public String name;
	public String data="ReservedFlight.txt";
	public void setDetails(String str) {
		File folder= new File(DataManager.class.getProtectionDomain().getCodeSource().getLocation().getFile());
    	String path=folder.getParent()+File.separator+data;
    	File file= new File(path);
		//File file= new File(data);
		FileWriter fr= null;
		try {
		fr= new FileWriter(file,true);
		fr.write(str);
		}
		catch(Exception i)
		{
			i.getMessage();
		}
		finally {
			try {
				fr.close();
			}
			catch(Exception i)
			{
				i.getMessage();
			}
		}
	}
	public boolean checkDetails(String flight,Date d,int tickets,String name)
	{
		File file = new File(data);
        BufferedReader br = null;
        int count = 0;      
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String row;
            while( (row = br.readLine()) != null) {                
            	StringTokenizer out = new StringTokenizer(row,";");
            	while(out.hasMoreTokens()) {
            		StringTokenizer in = new StringTokenizer(out.nextToken(),",");
            		this.name=in.nextToken();
            		this.d= new Date(in.nextToken());
            		this.flight=in.nextToken();
            		this.tickets=Integer.parseInt(in.nextToken());
            		if(this.name.equalsIgnoreCase(name) && this.d.compareTo(d)==0 && this.flight.equalsIgnoreCase(flight))
            			return false;
            		else if(this.d.compareTo(d)==0 && this.flight.equalsIgnoreCase(flight))
            		{
            			if(this.tickets+tickets>15)
            				return false;
            		}
            		/*System.out.println(this.d.printDate());
            		System.out.println(this.name);
            		System.out.println(this.tickets);
            		System.out.println(this.flight);*/
            	}
            	return true;
            }
        } catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(null,"File not found: " + file.toString());        	
        	System.exit(0);
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null,"Unable to read file: " + file.toString());
        	System.exit(0);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null,"Unable to close file: " + file.toString());
                System.out.println("Unable to close file: " + file.toString());
                System.exit(0);
            }
            catch(NullPointerException ex) {
            }
        }        
        return true;
        
    }
	/*public static void main(String args[])
	{
		Reservation res= new Reservation();
		res.getDetails();
	}*/
}
