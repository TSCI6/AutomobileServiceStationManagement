 

import java.awt.event.KeyEvent;
import java.sql.*;
//import java.io.File;
//import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Vehicle extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddNewVehicle
     */
    
    java.util.Date dnow= new java.util.Date();
    Connection con=null;
    String d = null;
    boolean avaiable=false;
    String duedate=null;
    
    public Vehicle() {
        initComponents();
        jTextField3.setVisible(false);
        jTextField9.setVisible(false);
            java.util.Date dnow= new java.util.Date();
            SimpleDateFormat ft= new SimpleDateFormat("yyyy.MM.dd");
            d=ft.format(dnow.getTime());
            jTextField7.setText(d);
            String sixmonth="";
                                   
            if((dnow.getMonth()+1)<7)
            sixmonth=(dnow.getYear()+1900)+"."+(dnow.getMonth()+1-6)+"."+dnow.getDate();
            else if((dnow.getMonth()+1)==8 && dnow.getDate()>28)
                sixmonth=(dnow.getYear()+1900+1)+"."+(dnow.getMonth()-12+8)+".1";
            else
                sixmonth=(dnow.getYear()+1900+1)+"."+(dnow.getMonth()-12+7)+"."+dnow.getDate();
  
    
            duedate=sixmonth;
    //jTextArea1.setText(sixmonth);
    }
    
    public boolean checkAvailabilty(){
        String regis=jTextField10.getText();
        try
        {
        if(regis.equals(""))
        {
                JOptionPane.showMessageDialog(null, "Enter Vehicle Number");
        }
        else
        {
        disable();
        con=ConnectionProvider.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("Select * from addnewvehicle where Vehicleno='"+ regis +"'");
        if(rs.next())
        {
           jTextField6.setText(rs.getString(2));
           jTextField1.setText(rs.getString(3));
           jTextField11.setText(rs.getString(4));
           jComboBox3.setSelectedItem(rs.getString(5));
           jTextArea1.setText(rs.getString(6));
           jTextField5.setText(rs.getString(7));
           jTextField8.setText(rs.getString(8));
           jTextField4.setText(rs.getString(9));
           jTextField2.setText(rs.getString(10));
           disable();
           return true;
           
        }
        else
        {
            
            enable();
            reset();
            //JOptionPane.showMessageDialog(null, "This Vehicle No. is Vaild");
            return false;
         
        }
            }
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
        }
        enable();
        return false;
    }
   
   public void enable()
   {
              jTextField1.setEnabled(true);
              jTextField2.setEnabled(true);
              jTextField10.setEnabled(true);
              jTextField4.setEnabled(true);
              jTextField5.setEnabled(true);
              jTextField6.setEnabled(true);
              jTextField8.setEnabled(true);
              jTextField11.setEnabled(true);
              jTextArea1.setEnabled(true);
   }

   public void disable() {
             // jTextField1.setEnabled(false);
              jTextField2.setEnabled(false);
          //    jTextField10.setEnabled(false);
              jTextField4.setEnabled(false);
              jTextField6.setEnabled(false);
              //jTextArea1.setEnabled(false);
              jTextField7.setEnabled(false);
            //  jTextField8.setEnabled(false);
             // jTextField9.setEnabled(false);
   } 
   public void reset()
   {
                 jTextField1.setText(null);
                 jTextField2.setText(null);
                 jTextField4.setText(null);
                 jTextField5.setText(null);
                 jTextArea1.setText(null);
                 jTextField6.setText(null);
                 jTextField8.setText(null);
                 jTextField11.setText(null);
                 jComboBox3.setSelectedItem("Select");
   }
    public void newvehicle()
    {
        enable();
        String name=jTextField1.getText().trim();
        String model=jTextField2.getText().trim();
        String vehicle=jTextField10.getText().trim();
        String year=jTextField4.getText().trim();
        String location=jTextField5.getText().trim();
        String regno=jTextField6.getText().trim();
        String date=jTextField7.getText().trim();
        String kilometer=jTextField8.getText().trim();
        String contact=jTextField11.getText().trim();
        String requ=jTextArea1.getText().trim();
        String cate=jComboBox3.getSelectedItem().toString();
        try
        {            
                 con=ConnectionProvider.getConnection();
                 if(name.equals("")||model.equals("")||vehicle.equals("")||year.equals("")||location.equals("")||regno.equals("")||date.equals("")||kilometer.equals("")||contact.equals("")||requ.equals(""))
                 {
                     javax.swing.JOptionPane.showMessageDialog(null,"(*) These are compulsory to fill.");
                 }
                else if(cate.equals("Select"))
                         {
                          javax.swing.JOptionPane.showMessageDialog(null,"Select your Category.");
                         } 
                     
                 else
                 {
                 PreparedStatement ps=con.prepareStatement("insert into addnewvehicle values(?,?,?,?,?,?,?,?,?,?,?,?)");
                 ps.setString(1, vehicle);
                 ps.setString(2, regno);
                 ps.setString(3, name);
                 ps.setString(4, contact);
                 ps.setString(5, cate);
                 ps.setString(6, requ);
                 ps.setString(7, location);
                 ps.setString(8, kilometer);
                 ps.setString(9, year);
                 ps.setString(10, model);
                 ps.setString(11, date);
                 ps.setString(12, duedate);
                 ps.execute();
                 System.out.println("KKKKKKKKKKKKK"+ps);
                 javax.swing.JOptionPane.showMessageDialog(null, "Your Data Add is  Successfully...");
                 
                 jTextField1.setText(null);
                 jTextField2.setText(null);
                 jTextField10.setText(null);
                 jTextField4.setText(null);
                 jTextField5.setText(null);
                 jTextArea1.setText(null);
                 jTextField6.setText(null);
                 jTextField8.setText(null);
                // jTextField7.setText(null);
                 jTextField11.setText(null);
                 jComboBox3.setSelectedItem("Select");
                 con.close();
        
                 }
        }
        catch(Exception e)
        {
            System.err.println("Error" + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Your Vehicle No. is Duplicate Entry '"+ vehicle +"'");
            reset();
            jTextField10.setText(null);
            
        }
    }
    public void oldVehicle()
    {
        String cate=jComboBox3.getSelectedItem().toString();
        String vehicle=jTextField10.getText();
        String name=jTextField1.getText().trim();
        String kilometer=jTextField8.getText().trim();
        String contact=jTextField11.getText().trim();
        String requ =jTextArea1.getText().trim();
        try
        {
        if(vehicle.equals(""))
        {
                JOptionPane.showMessageDialog(null, "Enter Vehicle Number");
        }
        
        else if(cate.equals("Select"))
           {
           javax.swing.JOptionPane.showMessageDialog(null,"Select your Category.");
           }
        else if(name.equals("")||kilometer.equals("")||contact.equals("")||requ.equals(""))
                 {
                     javax.swing.JOptionPane.showMessageDialog(null,"These are compulsory to fill.");
                 }
        else
        {
        String cmd="UPDATE addnewvehicle SET name='"+jTextField1.getText()+"',model='"+jTextField2.getText()+"',year='"+jTextField4.getText()+"',location='"+jTextField5.getText()+"',regno='"+jTextField6.getText()+"',date='"+jTextField7.getText()+"',kilometers='"+jTextField8.getText()+"',contactno='"+jTextField11.getText()+"',Requirement='"+jTextArea1.getText()+"',Category='"+jComboBox3.getSelectedItem().toString()+"' where Vehicleno='"+ vehicle +"'";
        con=ConnectionProvider.getConnection();
        Statement st=con.createStatement();
        System.out.println(cmd);
        st.executeUpdate(cmd);
        reset();
        
        jTextField10.setText(null);
        reset();
        enable();
        javax.swing.JOptionPane.showMessageDialog(null, "Your Data Save is  Successfully...");
        }
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Add Vehicle");

        jLabel2.setText("Registration No.");

        jLabel3.setText("Vehicle no");

        jLabel4.setText("Name");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jLabel5.setText("Location");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jLabel7.setText("Kilometers");

        jLabel8.setText("Category");

        jLabel9.setText("Year");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jLabel10.setText("Requirement");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setText("Date");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Model");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setEnabled(false);

        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });

        jLabel13.setText("Contact Number");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Servicing", "Mechanical job", "Denting painting", "Break down", "Extra" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton3FocusLost(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/02.jpg"))); // NOI18N

        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });

        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 162, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField10)
                            .addComponent(jTextField11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel11)))
                                        .addGap(21, 21, 21))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField10.setText(null);
        reset();
        enable();
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
            char key=evt.getKeyChar();
            int k=key;
            String aa=jTextField8.getText();
            int l=aa.length();
            if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'||k==KeyEvent.VK_BACK_SPACE||k==KeyEvent.VK_TAB||k==KeyEvent.VK_SPACE||k==KeyEvent.VK_ENTER||k==KeyEvent.VK_ALT||k==KeyEvent.VK_SHIFT)
            {
                jTextField8.setEditable(true);
            }
            else 
            {               
                jTextField8.setEditable(false);
                javax.swing.JOptionPane.showMessageDialog(null, "* Enter only numeric digit(0-9)");
                //jLabel10.setText("* Enter only numeric digit(0-9)");
             }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyPressed
 
    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
            char key=evt.getKeyChar();
            int k=key;
            String aa=jTextField4.getText();
            int l=aa.length();
            if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'||k==KeyEvent.VK_BACK_SPACE||k==KeyEvent.VK_TAB||k==KeyEvent.VK_SPACE||k==KeyEvent.VK_ENTER||k==KeyEvent.VK_ALT||k==KeyEvent.VK_SHIFT)

            {
                jTextField4.setEditable(true);
            }
            else 
            {               
                jTextField4.setEditable(false);
                javax.swing.JOptionPane.showMessageDialog(null, "* Enter only numeric digit(0-9)");
                //jLabel10.setText("* Enter only numeric digit(0-9)");
             }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost

        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        char key=evt.getKeyChar();
        int k=key;
        String aa=jTextField9.getText();
            int l=aa.length();
            if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'||k==KeyEvent.VK_BACK_SPACE||k==KeyEvent.VK_TAB||k==KeyEvent.VK_SPACE||k==KeyEvent.VK_ENTER||k==KeyEvent.VK_ALT||k==KeyEvent.VK_SHIFT)
            {
                jTextField9.setEditable(true);
            }
            else 
            {               
                jTextField9.setEditable(false);
                javax.swing.JOptionPane.showMessageDialog(null, "* Enter only numeric digit(0-9)");
                //jLabel10.setText("* Enter only numeric digit(0-9)");
             }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
    
    
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField3FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        newvehicle();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    char key=evt.getKeyChar();
        int k=key;
        if(evt.getKeyChar()>='A' && evt.getKeyChar()<='Z'||k==KeyEvent.VK_SPACE  ||k==KeyEvent.VK_SHIFT)
        {
            
            jTextField1.setEditable(true);
            
            
        }
        else if(evt.getKeyChar()>='a' && evt.getKeyChar()<='z'||k==KeyEvent.VK_SPACE ||k==KeyEvent.VK_SHIFT)
        {
            jTextField1.setEditable(true);
            
        }
        else if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
            {
                jTextField1.setEditable(false);
                javax.swing.JOptionPane.showMessageDialog(null, "*Only Alphabet");

            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
    char key=evt.getKeyChar();
        int k=key;
        if(evt.getKeyChar()>='A' && evt.getKeyChar()<='Z'||k==KeyEvent.VK_SPACE  ||k==KeyEvent.VK_SHIFT)
        {
            
            jTextField5.setEditable(true);
            
            
        }
        else if(evt.getKeyChar()>='a' && evt.getKeyChar()<='z'||k==KeyEvent.VK_SPACE ||k==KeyEvent.VK_SHIFT)
        {
            jTextField5.setEditable(true);
            
        }
        else if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
            {
                jTextField5.setEditable(false);
                javax.swing.JOptionPane.showMessageDialog(null, "*Only Alphabet");

            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusLost

        jButton1.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3FocusLost

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost

      
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        String str="";
    str=jTextField10.getText();
    if(str.length()<8 || str.length()>10)
    {
        JOptionPane.showMessageDialog(null,"Vehicle Number must be 8 to 10 Digits");
        jTextField10.setText("");
        reset();
        
    }
    avaiable=checkAvailabilty();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost

            String str="";
    str=jTextField11.getText();
    if(str.length()<10 || str.length()>12)
    {
        JOptionPane.showMessageDialog(null,"Phone No must be 10 to 12 Digits");
        jTextField11.setText("");
    }
    
    String phon="";
        phon=jTextField11.getText();
        try
        {
        con=ConnectionProvider.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from addnewvehicle where Contactno='"+phon+"'");
        if(rs.next())
        {
           
           JOptionPane.showMessageDialog(null, "Your Contactno is Duplicate='"+phon+"'");
           jTextField11.setText(null);
        }
        else
        {
           
        }
        
        }
        catch(Exception e)
        {
        System.out.println(e.getMessage());
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
