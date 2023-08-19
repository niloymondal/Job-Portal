package job_portal;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class display_applicant_details extends javax.swing.JFrame {
      public Connection connection;
      int count=0,select_image=0;
      boolean not_empty[]=new boolean[6];
      byte [][] image ;
      byte [] img1,img2,img3,img4,img5,img6;
      String id,Job_ID,company_id;
    public display_applicant_details() {
        initComponents();
    }
      public display_applicant_details(String applicant_id,String Job_ID,String company_id) {
        initComponents();
        this.Job_ID=Job_ID;
        id=applicant_id;
        this.company_id=company_id;
        get_data_from_applicant(applicant_id);
        get_data_from_applicantion_details(applicant_id);
        get_image_from_database(applicant_id);
       // get_image_from_database(applicant_id);
      
      }
      public void get_data_from_applicant(String applicant_id)
      {
      try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM applicant where applicant_id= "+applicant_id);
            
            
            while (resultSet.next()) {
                 byte[] img =resultSet.getBytes("image");
                /*System.out.println("Customer NAME:" + 
                        resultSet.getString("applicant_name"));*/
                ImageIcon imageicon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(dis_img.getWidth(), dis_img.getHeight(), Image.SCALE_SMOOTH));
                dis_img.setIcon(imageicon);
                appli_name.setText(resultSet.getString("applicant_name"));
                appli_dob.setText(resultSet.getString("date_of_birth"));
                appli_age.setText(resultSet.getString("applicant_age"));  
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
       public void get_data_from_applicantion_details(String applicant_id)
      {
      try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM application_details where applicant_id= "+applicant_id);
            
            
            while (resultSet.next()) {
                skill.setText(resultSet.getString("skills"));
                rfh.setText(resultSet.getString("reason_for_hiring"));
                experience.setText(resultSet.getString("experience"));  
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    public void get_image_from_database(String applicant_id)
    {
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT image1,image2,image3,image4,image5,image6,doc_name_1,doc_name_2,doc_name_3,doc_name_4,doc_name_5,doc_name_6 FROM applicant_credential where applicant_id = "+applicant_id+" AND job_id = "+Job_ID);
            
            
            while (resultSet.next()) {
                 img1 =resultSet.getBytes("image1");
                ImageIcon imageicon=new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
                img_label.setIcon(imageicon);
                 img2 =resultSet.getBytes("image2");
                img3 =resultSet.getBytes("image3");
                img4 =resultSet.getBytes("image4");
                 img5 =resultSet.getBytes("image5");
                 img6 =resultSet.getBytes("image6");
                
                String doc1=resultSet.getString("doc_name_1");
                String doc2=resultSet.getString("doc_name_2");
                String doc3=resultSet.getString("doc_name_3");
                String doc4=resultSet.getString("doc_name_4");
                String doc5=resultSet.getString("doc_name_5");
                String doc6=resultSet.getString("doc_name_6");
                
             /*   System.out.println(""+img1);
                System.out.println(""+img2);*/
             
             if(img1 != null)
             {
             count++;
             }
             if(img2 != null)
             {
             count++;
             }
             if(img3 != null)
             {
             count++;
             }
             if(img4 != null)
             {
             count++;
             }
             if(img5 != null)
             {
             count++;
             }if(img6 != null)
             {
             count++;
             }
                System.out.println(""+count);
            }  
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        img_label = new javax.swing.JLabel();
        next_btn = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        select_btn = new javax.swing.JButton();
        reject_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dis_img = new javax.swing.JLabel();
        appli_name = new javax.swing.JLabel();
        appli_dob = new javax.swing.JLabel();
        appli_age = new javax.swing.JLabel();
        skill = new javax.swing.JLabel();
        rfh = new javax.swing.JLabel();
        experience = new javax.swing.JLabel();
        msg = new javax.swing.JTextField();
        send_msg = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 1060));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_label.setBackground(new java.awt.Color(204, 255, 255));
        img_label.setForeground(new java.awt.Color(153, 255, 255));
        img_label.setText("jLabel1");
        img_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(img_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 370, 260));

        next_btn.setBackground(new java.awt.Color(0, 0, 0));
        next_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        next_btn.setForeground(new java.awt.Color(255, 255, 255));
        next_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/right-arrow.png"))); // NOI18N
        next_btn.setText("Next");
        next_btn.setBorder(new javax.swing.border.MatteBorder(null));
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });
        jPanel1.add(next_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 90, 40));

        name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        name.setText("Applicant Name : ");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Date of Birth : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("              Age : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        select_btn.setBackground(new java.awt.Color(0, 204, 51));
        select_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        select_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/headhunter.png"))); // NOI18N
        select_btn.setText("Selected");
        select_btn.setBorder(new javax.swing.border.MatteBorder(null));
        select_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_btnActionPerformed(evt);
            }
        });
        jPanel1.add(select_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 497, 100, 40));

        reject_btn.setBackground(new java.awt.Color(255, 102, 102));
        reject_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        reject_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/rejected.png"))); // NOI18N
        reject_btn.setText("Rejected");
        reject_btn.setBorder(new javax.swing.border.MatteBorder(null));
        reject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_btnActionPerformed(evt);
            }
        });
        jPanel1.add(reject_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 497, 100, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("          Skills : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Reason for Hiring : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("   Experience : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, 20));

        dis_img.setBackground(new java.awt.Color(51, 153, 255));
        dis_img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(dis_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 130, 110));

        appli_name.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(appli_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 120, 30));

        appli_dob.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(appli_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 130, 30));

        appli_age.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(appli_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 130, 20));

        skill.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(skill, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 140, 20));

        rfh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(rfh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 160, 20));

        experience.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(experience, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 170, 20));

        msg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 300, 70));

        send_msg.setBackground(new java.awt.Color(0, 0, 0));
        send_msg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        send_msg.setForeground(new java.awt.Color(255, 255, 255));
        send_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/send-mail.png"))); // NOI18N
        send_msg.setText("send");
        send_msg.setBorder(new javax.swing.border.MatteBorder(null));
        send_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_msgActionPerformed(evt);
            }
        });
        jPanel1.add(send_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 487, 70, 40));

        back_btn.setBackground(new java.awt.Color(0, 0, 0));
        back_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/undo.png"))); // NOI18N
        back_btn.setText("Back");
        back_btn.setBorder(new javax.swing.border.MatteBorder(null));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel1.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 655, 80, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 10, 220));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 10, 220));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 10, 220));

        jLabel7.setFont(new java.awt.Font("TATU", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("  Details of Applicant");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 330, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/Computer.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -280, 1600, 1070));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(749, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 380, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       int j = 2;
    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed

       if(j>count)
       {
       j=1;
       }
        if(j==1 && j<=count)
       {
        ImageIcon imageicon=new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon);
        j++;
        System.out.println(""+j);
       }
       else if(j==2 && j<=count)
       {
        ImageIcon imageicon1=new ImageIcon(new ImageIcon(img2).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon1);
        j++;
        System.out.println(""+j);
       }
        else if(j==3 && j<=count)
       {
        ImageIcon imageicon1=new ImageIcon(new ImageIcon(img3).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon1);
        j++;
        System.out.println(""+j);
       }
        else if(j==4 && j<=count)
       {
        ImageIcon imageicon1=new ImageIcon(new ImageIcon(img4).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon1);
        j++;
        System.out.println(""+j);
       }
        else if(j==5 && j<=count)
       {
        ImageIcon imageicon1=new ImageIcon(new ImageIcon(img5).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon1);
        j++;
        System.out.println(""+j);
       }
        else if(j==6 && j<=count)
       {
        ImageIcon imageicon1=new ImageIcon(new ImageIcon(img6).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH));
        img_label.setIcon(imageicon1);
        j++;
        System.out.println(""+j);
       }
    }//GEN-LAST:event_next_btnActionPerformed

    private void reject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_btnActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            String query = "UPDATE application_details set emp_status = ?  where applicant_id= "+id ;
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "Rejected");
            pst.executeUpdate();
             applicant_list f= new applicant_list(Job_ID);
             f.setVisible(true);
             setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_reject_btnActionPerformed

    private void select_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_btnActionPerformed
        // TODO add your handling code here:
        selected_for_job f = new selected_for_job(Job_ID,id);
         f.setVisible(true);
         setVisible(false);
        
    }//GEN-LAST:event_select_btnActionPerformed

    private void send_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_msgActionPerformed
        // TODO add your handling code here:
        try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            String query = "INSERT INTO msg(job_id,applicant_id, msg,rd) values(?,?,?,?)";
             PreparedStatement pst = connection.prepareStatement(query);
             
            pst.setString(1, Job_ID);
            pst.setString(2, id);
            pst.setString(3, msg.getText());
            pst.setString(4, "0");
            
            pst.executeUpdate();
               msg.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_send_msgActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
         applicant_list f= new applicant_list(Job_ID,company_id);
             f.setVisible(true);
             setVisible(false);
    }//GEN-LAST:event_back_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(display_applicant_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(display_applicant_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(display_applicant_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(display_applicant_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display_applicant_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appli_age;
    private javax.swing.JLabel appli_dob;
    private javax.swing.JLabel appli_name;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel dis_img;
    private javax.swing.JLabel experience;
    private javax.swing.JLabel img_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField msg;
    private javax.swing.JLabel name;
    private javax.swing.JButton next_btn;
    private javax.swing.JButton reject_btn;
    private javax.swing.JLabel rfh;
    private javax.swing.JButton select_btn;
    private javax.swing.JButton send_msg;
    private javax.swing.JLabel skill;
    // End of variables declaration//GEN-END:variables
}
