/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_portal;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Siham
 */
public class after_job_seeker_login extends javax.swing.JFrame {

    /**
     * Creates new form after_job_seeker_login
     */
    public Connection connection;
    String rd_status;
    String msg_for_msg="",j_id_for_msg="",company_name_for_msg="";
    String education= "";
    String applicant_id="";
    public after_job_seeker_login() {
        initComponents();
       
    }
    public after_job_seeker_login(String id){
        initComponents();
        applicant_id=id;
        check_msg(id);
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT image,applicant_name,applicant_phone,applicant_email,applicant_id,education FROM applicant where applicant_id="+id);
            
            
            while (resultSet.next()) {
                byte[] img =resultSet.getBytes("image");
                System.out.println(""+img);
                /*System.out.println("Customer NAME:" + 
                        resultSet.getString("applicant_name"));*/
                 ImageIcon imageicon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(dis_img.getWidth(), dis_img.getHeight(), Image.SCALE_SMOOTH));
                education=resultSet.getString("education");
                System.out.println(""+education);
                 dis_img.setIcon(imageicon);
                dis_name.setText(resultSet.getString("applicant_name"));
                dis_phn.setText(resultSet.getString("applicant_phone"));
                dis_email.setText(resultSet.getString("applicant_email"));
                dis_id.setText(resultSet.getString("applicant_id"));     
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        show_user();
    }
        public void check_msg(String id)
        {
              try {
                  // String msg_for_msg="",j_id_for_msg="",company_name_for_msg="";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM msg where applicant_id= "+id);
                        
         
            while (resultSet.next()) {
                j_id_for_msg=resultSet.getString("job_id");
                msg_for_msg=resultSet.getString("msg");
                 rd_status = resultSet.getString("rd");
                if(rd_status.equals("0"))
                {
                 msg_btn.setBackground(Color.red);
                }
               
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
    /*table Code*/
     public ArrayList<job_table_info_class> userList(){
        ArrayList<job_table_info_class> usersList = new ArrayList<>();
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            String query1="SELECT * FROM Job_Information";
            Statement st1= connection.createStatement();
            ResultSet rs1= st1.executeQuery(query1);
            job_table_info_class user;
            while(rs1.next()){
                user=new job_table_info_class(rs1.getString("job_category"),rs1.getString("job_requirements"),rs1.getString("job_type"),
                rs1.getString("No_of_vacancy"),rs1.getString("salary"),rs1.getString("age"),rs1.getString("job_posting"),
                rs1.getString("form_fee"),rs1.getString("application_LastDate"),rs1.getString("company_id"),rs1.getString("job_id"));
                
                boolean validation=valid_job(rs1.getString("job_requirements"));
               // System.out.println(""+validation);
                //System.out.println(""+rs1.getString("job_requirements"));
                if(validation)
                {
                 usersList.add(user);
                }
            }
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         return usersList;
    }
     int edu_job=0,edu_applicant=0;
     public boolean  valid_job(String job_req)
     {
         int edu_job=11,edu_applicant=10;
         boolean valid=false; //education

         if(education.equals("SSC")  || education.equals("ssc") )
         {
         edu_applicant=1;
         }
         else  if(education.equals("HSC"))
         {
         edu_applicant=2;
         }
         else  if(education.equals("Honors"))
         {
         edu_applicant=3;
         }
         else  if(education.equals("Masters"))
         {
         edu_applicant=4;
         }
         
         if(job_req.equals("SSC")|| job_req.equals("ssc"))
         {
         edu_job=1;
         }
         else if(job_req.equals("HSC")|| job_req.equals("hsc"))
         {
         edu_job=2;
         }
         else if(job_req.equals("Honors") || job_req.equals("honors"))
         {
         edu_job=3;
         }
         else if(job_req.equals("Masters") || job_req.equals("masters"))
         {
         edu_job=4;
         }
         System.out.println(""+edu_job);
         if(edu_job<=edu_applicant)
         {
             valid= true;
         return valid;
         }
         else{
          return valid;
         }
     }
        
public void show_user(){
        ArrayList<job_table_info_class> list = userList();
        DefaultTableModel model = (DefaultTableModel)job_table.getModel();
        Object[] row = new Object[11];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getJob_Category();
            row[1]=list.get(i).getRequirements();
            row[2]=list.get(i).getEmployment_Status();
            row[3]=list.get(i).getVacancy();
            row[4]=list.get(i).getSalary();
            row[5]=list.get(i).getMaximum_age();
            row[6]=list.get(i).getJob_Location();
            row[7]=list.get(i).getApplication_fee();
            row[8]=list.get(i).getLastDate();
            row[9]=list.get(i).getcompany_id();
            row[10]=list.get(i).getJob_id();
            model.addRow(row);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        logout_btn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        dis_id = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dis_name = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dis_email = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dis_phn = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        msg_btn = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        applied_job = new javax.swing.JButton();
        apply_for_job = new javax.swing.JButton();
        dis_mail = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        job_loc = new javax.swing.JLabel();
        max_age = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        appli_fee = new javax.swing.JLabel();
        salary = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lastdate_show = new javax.swing.JLabel();
        job_req = new javax.swing.JLabel();
        dis_sal = new javax.swing.JLabel();
        job_id_show = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        job_table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dis_img = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        logout_btn.setBackground(new java.awt.Color(153, 153, 255));
        logout_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/logout (1).png"))); // NOI18N
        logout_btn.setText("Logout");
        logout_btn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 260, 60));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel20.setBackground(new java.awt.Color(153, 153, 255));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("ID : ");

        dis_id.setBackground(new java.awt.Color(153, 153, 255));
        dis_id.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dis_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dis_id, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dis_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 260, 60));

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Name : ");

        dis_name.setBackground(new java.awt.Color(153, 153, 255));
        dis_name.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dis_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dis_name, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dis_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 260, 60));

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Email : ");

        dis_email.setBackground(new java.awt.Color(153, 153, 255));
        dis_email.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dis_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dis_email, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dis_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 260, 60));

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("Phone : ");

        dis_phn.setBackground(new java.awt.Color(153, 153, 255));
        dis_phn.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dis_phn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dis_phn, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dis_phn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 260, 60));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        msg_btn.setBackground(new java.awt.Color(153, 153, 255));
        msg_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        msg_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/letter (1).png"))); // NOI18N
        msg_btn.setText("Messages");
        msg_btn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        msg_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(msg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(msg_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, 60));

        jPanel11.setBackground(new java.awt.Color(153, 153, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        applied_job.setBackground(new java.awt.Color(153, 153, 255));
        applied_job.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        applied_job.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/job.png"))); // NOI18N
        applied_job.setText("Applied Job");
        applied_job.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        applied_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applied_jobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(applied_job, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(applied_job, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 260, 60));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 830));

        apply_for_job.setBackground(new java.awt.Color(0, 0, 0));
        apply_for_job.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        apply_for_job.setForeground(new java.awt.Color(255, 255, 255));
        apply_for_job.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/tap.png"))); // NOI18N
        apply_for_job.setText("Apply For This Job");
        apply_for_job.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        apply_for_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apply_for_jobActionPerformed(evt);
            }
        });
        jPanel3.add(apply_for_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 360, 50));
        jPanel3.add(dis_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 150, 20));

        job_loc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(job_loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, 20));

        max_age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(max_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("JOB ID : ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 130, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Requirements : ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Application Fee : ");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Job location : ");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Maximum age : ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Application Last Date : ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 110, 50));

        appli_fee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(appli_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 120, 30));

        salary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 140, 20));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -280, 150, -1));

        lastdate_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(lastdate_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 180, 20));

        job_req.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(job_req, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, 20));

        dis_sal.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jPanel4.add(dis_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, 20));

        job_id_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(job_id_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 100, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Salary : ");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/businessman (1).png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 100, 70, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/magnifying-glass.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 80, 70));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/job.png"))); // NOI18N
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 30, 50));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/analysis.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 50, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 830, 190));

        job_table.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        job_table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        job_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Category", "Requirements", "Employment Status", "Vacancy", "Salary", "Maximum age", "Job Location", "Application fee", "Application Deadline", "Company ID", "Job ID"
            }
        ));
        job_table.setRowHeight(32);
        job_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                job_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(job_table);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 900, 290));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/abc.jpg"))); // NOI18N
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 830));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1970, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dis_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job_portal/profile (2).png"))); // NOI18N
        jPanel1.add(dis_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 120));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 153, 255));
        jLabel18.setText("Hello, Seeker");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 240, 40));

        jLabel19.setFont(new java.awt.Font("TATU", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText(" Information of Job Seeker");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 630, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void job_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_job_tableMouseClicked
        // TODO add your handling code here:
        int i = job_table.getSelectedRow();
        TableModel model =job_table.getModel();
        salary.setText(model.getValueAt(i,4).toString());
        job_req.setText(model.getValueAt(i,1).toString());
        max_age.setText(model.getValueAt(i,5).toString());
        job_loc.setText(model.getValueAt(i,6).toString());
        appli_fee.setText(model.getValueAt(i,7).toString());
        job_id_show.setText(model.getValueAt(i,10).toString());
        lastdate_show.setText(model.getValueAt(i,8).toString());
    }//GEN-LAST:event_job_tableMouseClicked

    private void apply_for_jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apply_for_jobActionPerformed
        // TODO add your handling code here:
        if(job_id_show.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select a job First");
        }
        else
        {
             apply_for_job_frame f= new apply_for_job_frame(job_id_show.getText(),dis_id.getText());
             f.setVisible(true);
             setVisible(false);
        }
       
    }//GEN-LAST:event_apply_for_jobActionPerformed

    private void msg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_btnActionPerformed
        // TODO add your handling code here:
        if(j_id_for_msg.equals(""))
        {
          JOptionPane.showMessageDialog(null, "You Have No message");
        }
        else
        {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=job_portal;selectMethod=cursor", "sa", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT company.company_name FROM company  INNER JOIN Job_Information ON company.company_id = Job_Information.company_id WHERE Job_Information.job_id ="+j_id_for_msg);
                        
         
            while (resultSet.next()) {
                 company_name_for_msg = resultSet.getString("company_name");
                 JOptionPane.showMessageDialog(null, "Message From "+company_name_for_msg+"\n\n\n"+msg_for_msg);
                 msg_btn.setBackground(Color.WHITE);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_msg_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
         login_selection f= new login_selection();
             f.setVisible(true);
             setVisible(false);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void applied_jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applied_jobActionPerformed
        // TODO add your handling code here:
         already_applied_job f= new already_applied_job(applicant_id);
             f.setVisible(true);
             setVisible(false);
    }//GEN-LAST:event_applied_jobActionPerformed

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
            java.util.logging.Logger.getLogger(after_job_seeker_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(after_job_seeker_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(after_job_seeker_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(after_job_seeker_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new after_job_seeker_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appli_fee;
    private javax.swing.JButton applied_job;
    private javax.swing.JButton apply_for_job;
    private javax.swing.JTextField dis_email;
    private javax.swing.JTextField dis_id;
    private javax.swing.JLabel dis_img;
    private javax.swing.JLabel dis_mail;
    private javax.swing.JTextField dis_name;
    private javax.swing.JTextField dis_phn;
    private javax.swing.JLabel dis_sal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel job_id_show;
    private javax.swing.JLabel job_loc;
    private javax.swing.JLabel job_req;
    private javax.swing.JTable job_table;
    private javax.swing.JLabel lastdate_show;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel max_age;
    private javax.swing.JButton msg_btn;
    private javax.swing.JLabel salary;
    // End of variables declaration//GEN-END:variables
}
