/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.collegeit.screen;

/**
 *
 * @author Katia Moreno - Student Number: 2015255
 * 
 */
import java.sql.*;
import ie.collegeit.dal.ModuloConexao;
import javax.swing.JOptionPane;
//The line below imports resources from the rs2xml.jar library.
import net.proteanit.sql.DbUtils;

public class AdminDashboardCourse extends javax.swing.JInternalFrame {
// creating special variables for connecting to the database
//prepared statement and resultSet are frameworks of the java.sql package, 
//which is used to prepare and execute the sql statements

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // constructor
    public AdminDashboardCourse() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
// method to add Couser

    private void addCourse() {

        String sql = "insert into course(name_course,time_course,lecture)values(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCourseName.getText());
            pst.setString(2, txtCourseTime.getText());
            pst.setString(3, txtCourseLecture.getText());

            //Required
            if ((txtCourseName.getText().isEmpty()) || (txtCourseTime.getText().isEmpty())
                    || (txtCourseLecture.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Field all the Required");
            } else {

                //the line below will use the database with the data entered in the form.
                //the structure below is to confirm the add of the data in the table
                int added = pst.executeUpdate();
                // next line to understand the logic of the code
                // System.out.println(added);
                // 
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, " Course Registration Successful");
                    txtCourseName.setText(null);
                    txtCourseTime.setText(null);
                    txtCourseLecture.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method to search course by name course with filter.
    private void searchCouser() {
     
        String sql = "select *from course where name_course like ?";
        try {
            pst = conexao.prepareStatement(sql);
            // sending the contents of the search box to the "?"
            // attention: the % that is the continuation of the string sql.
            pst.setString(1, txtCouserSearch.getText() + "%");
            rs = pst.executeQuery();

            //The line below use the resources from the rs2xml.jar library to field the table.
            tblCourse.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method below is to send the form fields to the table contents.
    public void fieldForm() {
        int field = tblCourse.getSelectedRow();
        txtCourseId.setText(tblCourse.getModel().getValueAt(field, 0).toString());
        txtCourseName.setText(tblCourse.getModel().getValueAt(field, 1).toString());
        txtCourseTime.setText(tblCourse.getModel().getValueAt(field, 2).toString());
        txtCourseLecture.setText(tblCourse.getModel().getValueAt(field, 3).toString());
        // next line disabled the add buttom
        bntCreateCourse.setEnabled(false);
    }

    // method to update user
    private void updateCourse() {
        String sql = "update course set name_course=?,time_course=?,lecture=? where id_course=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCourseName.getText());
            pst.setString(2, txtCourseTime.getText());
            pst.setString(3, txtCourseLecture.getText());
            pst.setString(4, txtCourseId.getText());

            if ((txtCourseName.getText().isEmpty()) || (txtCourseTime.getText().isEmpty())
                    || (txtCourseLecture.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Field all the Required");
            } else {

                //the line below will use the database with the data entered in the form.
                //the structure below is to confirm the add of the data in the table
                int added = pst.executeUpdate();
                // next line to understand the logic of the code
                // System.out.println(added);
                // 
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, " Course Update Successful");
                    txtCourseName.setText(null);
                    txtCourseTime.setText(null);
                    txtCourseLecture.setText(null);
                    // next line enabled the add buttom
                    bntCreateCourse.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // method to delete course
    private void deleteCourse() {
        //confirm option to delete
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Sure", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "delete from course where id_course=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCourseId.getText());
                
                //the structure below is to confirm the update of the data in the table
                int del=pst.executeUpdate();
                if(del>0){
                    JOptionPane.showMessageDialog(null, "Course Delete Successful");
                    txtCourseName.setText(null);
                    txtCourseTime.setText(null);
                    txtCourseLecture.setText(null);
                    // next line enabled the add buttom
                    bntCreateCourse.setEnabled(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        bntCreateCourse = new javax.swing.JButton();
        bntUpdateCourse = new javax.swing.JButton();
        bntDeleteCourse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtCourseTime = new javax.swing.JTextField();
        txtCourseLecture = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        txtCouserSearch = new javax.swing.JTextField();
        lblCourseSearch = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCourseId = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Couses");

        bntCreateCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/create.png"))); // NOI18N
        bntCreateCourse.setToolTipText("Course  ADD");
        bntCreateCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCreateCourse.setPreferredSize(new java.awt.Dimension(80, 80));
        bntCreateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCreateCourseActionPerformed(evt);
            }
        });

        bntUpdateCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/update.png"))); // NOI18N
        bntUpdateCourse.setToolTipText("Course Update");
        bntUpdateCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntUpdateCourse.setPreferredSize(new java.awt.Dimension(80, 80));
        bntUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdateCourseActionPerformed(evt);
            }
        });

        bntDeleteCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/delete.png"))); // NOI18N
        bntDeleteCourse.setToolTipText("Delete Course");
        bntDeleteCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntDeleteCourse.setPreferredSize(new java.awt.Dimension(80, 80));
        bntDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeleteCourseActionPerformed(evt);
            }
        });

        jLabel2.setText("*Course Name");

        jLabel3.setText("*Course Time");

        jLabel4.setText("Lecture");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setText("* Required ");

        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Id", "Course Name", "Course Time", "Lecture"
            }
        ));
        tblCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCourse);

        txtCouserSearch.setToolTipText("Search");
        txtCouserSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCouserSearchKeyReleased(evt);
            }
        });

        lblCourseSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/collegeit/icons/Search.png"))); // NOI18N

        jLabel1.setText("  Course Id");

        txtCourseId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCourseTime, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                            .addComponent(txtCourseName)
                            .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(bntCreateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntUpdateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(bntDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCouserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCourseSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(txtCourseLecture)))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCouserSearch)
                    .addComponent(lblCourseSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCourseId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseLecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntCreateCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntUpdateCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCreateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCreateCourseActionPerformed
        // call method add course
        addCourse();
    }//GEN-LAST:event_bntCreateCourseActionPerformed

    //the event below is of the type as it is typed
    private void txtCouserSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCouserSearchKeyReleased
        // call method search course
        searchCouser();
    }//GEN-LAST:event_txtCouserSearchKeyReleased

    // event that will be used to send the table fields (by clicking with the mouse)
    private void tblCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseMouseClicked
        // call method to field Form
        fieldForm();
    }//GEN-LAST:event_tblCourseMouseClicked

    private void bntUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdateCourseActionPerformed
        // call method to update course
        updateCourse();
    }//GEN-LAST:event_bntUpdateCourseActionPerformed

    private void bntDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeleteCourseActionPerformed
        // call method to delete course
        deleteCourse();
    }//GEN-LAST:event_bntDeleteCourseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCreateCourse;
    private javax.swing.JButton bntDeleteCourse;
    private javax.swing.JButton bntUpdateCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCourseSearch;
    private javax.swing.JTable tblCourse;
    private javax.swing.JLabel txtCourseId;
    private javax.swing.JTextField txtCourseLecture;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCourseTime;
    private javax.swing.JTextField txtCouserSearch;
    // End of variables declaration//GEN-END:variables
}
