/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.collegeit.screen;

/**
 *
 * @author Katia Moreno - Student Number: 2015255
 * @since July 2018
 * 
 */
import java.sql.*;
import ie.collegeit.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class AdminDashboard extends javax.swing.JInternalFrame {
/**
 * creating special variables for connecting to the database
 * prepared statement and resultSet are frameworks of the java.sql package, 
 * which is used to prepare and execute the sql statements
 */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // constructor
    public AdminDashboard() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // method to search user
    private void search() {
        String sql = "select * from user where id_user=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUseId.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtUseName.setText(rs.getString(2));
                txtUseCont.setText(rs.getString(3));
                txtUseLogin.setText(rs.getString(4));
                txtUsePassword.setText(rs.getString(5));
                cboUseProfile.setSelectedItem(rs.getString(6));
                txtUseAddress.setText(rs.getString(7));
                txtUseEmail.setText(rs.getString(8));
                txtUseNat.setText(rs.getString(9));
                cboUseGender.setSelectedItem(rs.getString(10));
                txtUseCourse.setText(rs.getString(11));
                txtUseCourseName.setText(rs.getString(12));

            } else {
                JOptionPane.showMessageDialog(null, "User Not Registered");
                txtUseName.setText(null);
                txtUseCont.setText(null);
                txtUseLogin.setText(null);
                txtUsePassword.setText(null);
                // cboUseProfile.setSelectedItem(null); // can debug a code
                txtUseAddress.setText(null);
                txtUseEmail.setText(null);
                txtUseNat.setText(null);
                //cboUseGender.setSelectedItem(null); // can debug a code
                txtUseCourse.setText(null);
                txtUseCourseName.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method to add user
    private void addUser() {
        String sql = "insert into user(id_user ,name_user ,contact ,login,password_user ,profile_user,address ,email ,nationality ,gender,course_current,course)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUseId.getText());
            pst.setString(2, txtUseName.getText());
            pst.setString(3, txtUseCont.getText());
            pst.setString(4, txtUseLogin.getText());
            pst.setString(5, txtUsePassword.getText());
            pst.setString(6, cboUseProfile.getSelectedItem().toString());
            pst.setString(7, txtUseAddress.getText());
            pst.setString(8, txtUseEmail.getText());
            pst.setString(9, txtUseNat.getText());
            pst.setString(10, cboUseGender.getSelectedItem().toString());
            pst.setString(11, txtUseCourse.getText());
            pst.setString(12, txtUseCourseName.getText());

            //Required
            if ((txtUseId.getText().isEmpty()) || (txtUseName.getText().isEmpty())
                    || (txtUseCont.getText().isEmpty()) || (txtUseLogin.getText().isEmpty())
                    || (txtUsePassword.getText().isEmpty()) || (txtUseCourseName.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Field all the Required");
            } else {

                //the line below will use the database with the data entered in the form.
                //the structure below is to confirm the add of the data in the table
                int added = pst.executeUpdate();
                // next line to understand the logic of the code
                // System.out.println(added);
                // 
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, " User Registration Successful");
                    txtUseId.setText(null);
                    txtUseName.setText(null);
                    txtUseCont.setText(null);
                    txtUseLogin.setText(null);
                    txtUsePassword.setText(null);
                    //cboUseProfile.setSelectedItem(null); // can debug a code
                    txtUseAddress.setText(null);
                    txtUseEmail.setText(null);
                    txtUseNat.setText(null);
                    // cboUseGender.setSelectedItem(null); // can debug a code
                    txtUseCourse.setText(null);
                    txtUseCourseName.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method to update user
    private void update() {
        String sql = "update user set name_user=?,contact=?,login=?,password_user=?,profile_user=?,address=?,email=?,nationality=?,gender=?,course_current=?, course=? where id_user=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUseName.getText());
            pst.setString(2, txtUseCont.getText());
            pst.setString(3, txtUseLogin.getText());
            pst.setString(4, txtUsePassword.getText());
            pst.setString(5, cboUseProfile.getSelectedItem().toString());
            pst.setString(6, txtUseAddress.getText());
            pst.setString(7, txtUseEmail.getText());
            pst.setString(8, txtUseNat.getText());
            pst.setString(9, cboUseGender.getSelectedItem().toString());
            pst.setString(10, txtUseCourse.getText());
            pst.setString(11, txtUseCourseName.getText());
            pst.setString(12, txtUseId.getText());
            
//Required
            if ((txtUseId.getText().isEmpty()) || (txtUseName.getText().isEmpty())
                    || (txtUseCont.getText().isEmpty()) || (txtUseLogin.getText().isEmpty())
                    || (txtUsePassword.getText().isEmpty())|| (txtUseCourseName.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Field all the Required");
            } else {

                //the line below will use the database with the data entered in the form.
                //the structure below is to confirm the update of the data in the table
                int added = pst.executeUpdate();
                // next line to understand the logic of the code
                // System.out.println(added);
                // 
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    txtUseId.setText(null);
                    txtUseName.setText(null);
                    txtUseCont.setText(null);
                    txtUseLogin.setText(null);
                    txtUsePassword.setText(null);
                    //cboUseProfile.setSelectedItem(null); // can debug a code
                    txtUseAddress.setText(null);
                    txtUseEmail.setText(null);
                    txtUseNat.setText(null);
                    // cboUseGender.setSelectedItem(null); // can debug a code
                    txtUseCourse.setText(null);
                    txtUseCourseName.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method to delete user
    private void delete() {
        //confirm option to delete
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Sure", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "delete from user where id_user=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUseId.getText());

                //the structure below is to confirm the update of the data in the table
                int del = pst.executeUpdate();
                if (del > 0) {
                    JOptionPane.showMessageDialog(null, "Delete Successful");
                    txtUseId.setText(null);
                    txtUseName.setText(null);
                    txtUseCont.setText(null);
                    txtUseLogin.setText(null);
                    txtUsePassword.setText(null);
                    //cboUseProfile.setSelectedItem(null); // can debug a code
                    txtUseAddress.setText(null);
                    txtUseEmail.setText(null);
                    txtUseNat.setText(null);
                    // cboUseGender.setSelectedItem(null); // can debug a code
                    txtUseCourse.setText(null);
                    txtUseCourseName.setText(null);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        txtUseId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboUseProfile = new javax.swing.JComboBox<>();
        txtUseCourse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUseName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUseCont = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUseNat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUseAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUseEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUseLogin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUsePassword = new javax.swing.JTextField();
        btnUseCreate = new javax.swing.JButton();
        btnUseRead = new javax.swing.JButton();
        btnUseUpdate = new javax.swing.JButton();
        btnUseDelete = new javax.swing.JButton();
        lblRequired = new javax.swing.JLabel();
        cboUseGender = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtUseCourseName = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Administrator Dashboard");
        setPreferredSize(new java.awt.Dimension(640, 480));

        txtUseId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel1.setText("*User Id");

        jLabel2.setText("*Course Id");

        jLabel3.setText("*Profile");

        cboUseProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "student" }));

        jLabel4.setText("*Name");

        txtUseName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtUseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUseNameActionPerformed(evt);
            }
        });

        jLabel5.setText("*Contact");

        jLabel6.setText("Nationality ");

        jLabel7.setText("Address");

        jLabel8.setText("Email");

        jLabel9.setText("Gender");

        jLabel10.setText("*Login");

        jLabel11.setText("*Password");

        btnUseCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/createUser.png"))); // NOI18N
        btnUseCreate.setToolTipText("Add User");
        btnUseCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseCreateActionPerformed(evt);
            }
        });

        btnUseRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/readUser.png"))); // NOI18N
        btnUseRead.setToolTipText("Search");
        btnUseRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseReadActionPerformed(evt);
            }
        });

        btnUseUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/updateUser.png"))); // NOI18N
        btnUseUpdate.setToolTipText("Update");
        btnUseUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseUpdateActionPerformed(evt);
            }
        });

        btnUseDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/deleteUser.png"))); // NOI18N
        btnUseDelete.setToolTipText("Delete");
        btnUseDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUseDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUseDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseDeleteActionPerformed(evt);
            }
        });

        lblRequired.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblRequired.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRequired.setText("* Required ");

        cboUseGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel12.setText("*Name Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(txtUseId, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 45, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboUseProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUseCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblRequired, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 11, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(30, 30, 30))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUseAddress)
                            .addComponent(txtUseName)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUseLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnUseCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUseRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUsePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(btnUseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnUseDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUseCont, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUseNat, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUseEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboUseGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRequired)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboUseProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtUseId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtUseCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUseCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUseNat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUseAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUseEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(cboUseGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUseLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUseRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnUseCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUseUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUseDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUseNameActionPerformed

    private void btnUseReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseReadActionPerformed
        //call the method search
        search();
    }//GEN-LAST:event_btnUseReadActionPerformed

    private void btnUseCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseCreateActionPerformed
        // call the method add User
        addUser();
    }//GEN-LAST:event_btnUseCreateActionPerformed

    private void btnUseUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseUpdateActionPerformed
        // call the method update User
        update();
    }//GEN-LAST:event_btnUseUpdateActionPerformed

    private void btnUseDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseDeleteActionPerformed
        // call the method delete user
        delete();
    }//GEN-LAST:event_btnUseDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUseCreate;
    private javax.swing.JButton btnUseDelete;
    private javax.swing.JButton btnUseRead;
    private javax.swing.JButton btnUseUpdate;
    private javax.swing.JComboBox<String> cboUseGender;
    private javax.swing.JComboBox<String> cboUseProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblRequired;
    private javax.swing.JTextField txtUseAddress;
    private javax.swing.JTextField txtUseCont;
    private javax.swing.JTextField txtUseCourse;
    private javax.swing.JTextField txtUseCourseName;
    private javax.swing.JTextField txtUseEmail;
    private javax.swing.JTextField txtUseId;
    private javax.swing.JTextField txtUseLogin;
    private javax.swing.JTextField txtUseName;
    private javax.swing.JTextField txtUseNat;
    private javax.swing.JTextField txtUsePassword;
    // End of variables declaration//GEN-END:variables
}
