/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Siham
 */
public class transection_table_entry extends javax.swing.JFrame {

    /**
     * Creates new form transection_table_entry
     */
     String job_id, applicant_id;
       public Connection connection;
    public transection_table_entry() {
        initComponents();
    }
  public transection_table_entry(String job_id,String applicant_id) {
        initComponents();
        this.job_id=job_id;
        this.applicant_id=applicant_id;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT  company_contact FROM Job_Information  INNER JOIN company ON Job_Information.company_id = company.company_id WHERE Job_Information.job_id =  "+job_id);

            while (resultSet.next()) {
                mbl_banking.setText(resultSet.getString("company_contact"));
            
            }
           
        }catch (Exception e) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        mbl_banking = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        trx = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bkash = new javax.swing.JRadioButton();
        rocket = new javax.swing.JRadioButton();
        submit = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Mobile Banking Number : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));
        jPanel1.add(mbl_banking, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 180, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Trx No :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 50, 20));
        jPanel1.add(trx, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 150, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Transection By : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        buttonGroup1.add(bkash);
        bkash.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bkash.setForeground(new java.awt.Color(255, 255, 255));
        bkash.setText("Bkash");
        bkash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(bkash, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        buttonGroup1.add(rocket);
        rocket.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rocket.setForeground(new java.awt.Color(255, 255, 255));
        rocket.setText("Rocket");
        rocket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(rocket, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        submit.setBackground(new java.awt.Color(0, 0, 0));
        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/upload.png"))); // NOI18N
        submit.setText("Submit");
        submit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 140, 40));

        back_btn.setBackground(new java.awt.Color(0, 0, 0));
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/undo.png"))); // NOI18N
        back_btn.setText("Back");
        back_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel1.add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 450, 90, -1));

        jLabel2.setFont(new java.awt.Font("TATU", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText(" Transaction");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 320, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/remove.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        
            String transection = "";
            if(bkash.isSelected())
            {
                transection="bkash";
            }
            if(rocket.isSelected())
            {
                transection="Rocket";
            }
            if(transection.equals("") && trx.getText().equals(""))
            {
             JOptionPane.showMessageDialog(null, "Insert Data First");
            }
            else{try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            String query = "INSERT INTO transection(trx_id,job_id, applicant_id,transection_by) values(?,?,?,?)";
             PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, trx.getText());
            pst.setString(2,job_id);
            pst.setString(3, applicant_id);
            pst.setString(4, transection);
            
            pst.executeUpdate();
            setVisible(false);

             after_job_seeker_login f1 = new after_job_seeker_login(applicant_id);
                f1.setVisible(true);
                setVisible(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }}
            
    }//GEN-LAST:event_submitActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
         apply_for_job_frame f= new apply_for_job_frame(job_id, applicant_id);
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
            java.util.logging.Logger.getLogger(transection_table_entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transection_table_entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transection_table_entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transection_table_entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transection_table_entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JRadioButton bkash;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mbl_banking;
    private javax.swing.JRadioButton rocket;
    private javax.swing.JButton submit;
    private javax.swing.JTextField trx;
    // End of variables declaration//GEN-END:variables
}