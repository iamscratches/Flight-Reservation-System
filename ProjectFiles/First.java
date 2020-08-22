package ProjectCollege;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class First extends JFrame
{
	JLabel l1,l2,l3,l4,l5,l6,l11,l12,l13,l14,l15,l7;
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2,r3,r4,r5;
	JButton b1;
	DisplayManager dm; 
	public First(DisplayManager dm){
		this.dm = dm;
		initComponents();		
	}
	private void initComponents() {
		l1= new JLabel("Welcome to the Flight Reservation System!");
		l2= new JLabel("========================================================");
		l7 = new JLabel("Name : ");
		t4= new JTextField(15);
		t4.setText("Suvnkr Bhatt");
		l3= new JLabel("Please Enter Date of Travel(dd/mm/yy): ");
		t1= new JTextField(2);//day
		t1.setText("30");
		t2= new JTextField(2);//month
		t2.setText("10");
		t3= new JTextField(2);//year
		t3.setText("16");
		l4= new JLabel("Please enter source city");
		l5= new JLabel("Destination city is SINGAPORE||");
		l6= new JLabel("Please enter number of tickets");
		t5= new JTextField(2);
		t5.setText("5");
		l11= new JLabel("Proceed to search(y/n)");
		l12= new JLabel("/");
		l13= new JLabel("/20");
		l14= new JLabel("");
		r1=new JRadioButton("YES");
		r2= new JRadioButton("NO");
		r3= new JRadioButton("Delhi");
		r4= new JRadioButton("Mumbai");
		r5= new JRadioButton("Pune");
		b1= new JButton("PROCEED");
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==b1)
				{
					if(r3.isSelected())
					{
						l14.setText("DELHI");
					}
					else if(r4.isSelected())
						l14.setText("MUMBAI");
					else
						l14.setText("PUNE");
				}
				b1ActionPerformed(e);
			}
		});
		
		ButtonGroup bg= new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		ButtonGroup city= new ButtonGroup();
		city.add(r3);
		city.add(r4);
		city.add(r5);
		add(l1);
		add(l2);
		add(l7);
		add(t4);
		add(l3);
		add(t1);
		add(l12);
		add(t2);
		add(l13);
		add(t3);
		add(l4);
		add(r3);
		add(r4);
		add(r5);
		add(l5);
		add(l6);
		add(t5);
		add(l11);
		add(r1);
		add(r2);
		add(b1);
		setLayout(new FlowLayout());		
		//setVisible(true);
		setSize(425, 270);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flight Resevation System");	
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public void b1ActionPerformed(ActionEvent e) {
		if(!r1.isSelected())	
			JOptionPane.showMessageDialog(this,"Select the yes to continue!!");
		else if(!(Integer.parseInt(t3.getText())==16 || Integer.parseInt(t3.getText())==17 || (Integer.parseInt(t3.getText())>=9 && Integer.parseInt(t3.getText())==11))) {
			JOptionPane.showMessageDialog(this,"Flights are only available between 2016-2017");
			t3.setText("");
		}
		else if(Integer.parseInt(t5.getText())>10) {
			JOptionPane.showMessageDialog(this,"No.of tickets cannot exceed 10");
			t5.setText("");
		}
		else if(Integer.parseInt(t1.getText())<=31&&Integer.parseInt(t2.getText())<=12)
		{
			int response= JOptionPane.showConfirmDialog(this,"Name : "+t4.getText()+"\nDate of travel: "+t1.getText()+"/"+t2.getText()+"/"+t3.getText()+"\nSource City: "+l14.getText()+"\nNo. of Tickets: "+t5.getText(),"Confirmation Box" , JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(response==JOptionPane.YES_OPTION)
			{	
				dm.d = new Date((Integer.parseInt(t1.getText())),Integer.parseInt(t2.getText()),Integer.parseInt("20"+t3.getText()));
				dm.city = l14.getText();
				dm.tickets = Integer.parseInt(t5.getText());
				dm.name = t4.getText();
				dispose();
				dm.secondControl();
			}			
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Wrong Information.Please fillup correctly!!");
		}
		
	}
	
}
