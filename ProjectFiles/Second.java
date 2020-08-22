
package ProjectCollege;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;
public class Second extends javax.swing.JFrame {
	flightCombo fc[];
	int count;
	DisplayManager dm;
	Reservation res= new Reservation();
    public Second(DisplayManager dm,flightCombo[] fc,int count) {
    	this.fc = fc;
    	this.count = count;
    	this.dm = dm;
        initComponents();        
        
    }
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        planeSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14= new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        planeSelect.setSelectedItem(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        String str[] = new String[20];
        for(int i = 0 ; i < count && i< 20 ; i++) {
			
			str[i] = new String("    " + (i+1) + fc[i].print());
		}
        
        planeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(str));

        planeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeSelectActionPerformed(evt);
            }
        });
        jLabel1.setText("Please Choose One: ");

        jLabel2.setText("S No.");

        jLabel3.setText("Flight1");

        jLabel4.setText("Source");

        jLabel5.setText("Dep.");

        jLabel6.setText("Stop");

        jLabel7.setText("Arrival");

        jLabel8.setText("Interval");

        jLabel9.setText("Flight 2");

        jLabel10.setText("Departure");

        jLabel11.setText("Destination");

        jLabel12.setText("Arrival");

        jLabel13.setText("Total Time");

        jButton1.setText("Proceed");
        
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1ActionPerformed(e);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jButton1))
                    .addComponent(planeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jButton1)
                .addGap(89, 89, 89))
        );
        setResizable(true);
        setLocationRelativeTo(null);
        pack();
    }                    
    private void planeSelectActionPerformed(java.awt.event.ActionEvent evt)
    {
    	jLabel14.setText(""+planeSelect.getSelectedItem());
    }
    private void b1ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	int response= JOptionPane.showConfirmDialog(this,"You have Selected option "+jLabel14.getText(),"Confirmation Box" , JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION)
        {
        	int in=planeSelect.getSelectedIndex();
        	String str=dm.name+","+dm.d.printDate()+","+fc[in].Flight1+","+dm.tickets+";"+dm.name+","+dm.d.printDate()+","+fc[in].Flight2+","+dm.tickets+";";
            res.setDetails(str);
        	dispose();
            dm.thirdControl();
        }
    }                 
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> planeSelect;                   
}
