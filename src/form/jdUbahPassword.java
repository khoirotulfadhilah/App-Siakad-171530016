
package Form;

import Tool.KoneksiDB;
import java.sql.*;
import javax.swing.JOptionPane;

public class jdUbahPassword extends javax.swing.JDialog {

    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String vid_user, vpasslama, vpassbaru;
    String sqlselect, sqlinsert;
    
    public jdUbahPassword(java.awt.Frame parent, boolean modal, String iduser) {
        super(parent, modal);
        initComponents();
        
        vid_user = iduser;
        txtIDUser.setText(vid_user);
        txtIDUser.setEditable(false);
        txtPassLama.requestFocus(true);
        setLocationRelativeTo(this);
    }
    
    private void updatePassword(){
        vpasslama = txtPassLama.getText().replaceAll("'", "");
        vpassbaru = txtPassBaru.getText().replaceAll("'", "");
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "SELECT * from tbuser " + " where id_user= '"+vid_user+"' and pass ='"+vpasslama+"' ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            
            if(res.first()){
                
                sqlinsert = "update tbuser set pass='"+vpasslama+"' " 
                        + " where id_user= '"+vid_user+"' ";
                Statement stat1 = _Cnn.createStatement(); 
                JOptionPane.showMessageDialog(null, "Password Berhasil Diubah",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
                txtPassLama.setText("");
                txtPassBaru.setText("");
                
            }else{
                JOptionPane.showMessageDialog(null, "Passwordlama tidak sesuai",
                        "informasi", JOptionPane.INFORMATION_MESSAGE); 
                txtPassLama.setText(""); txtPassLama.requestFocus(true);
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(this, "Error method updatePassword() : "+se);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIDUser = new javax.swing.JTextField();
        txtPassLama = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPassBaru = new javax.swing.JEditorPane();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:Form : Ubah Password");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Form Ubah Password");

        jLabel4.setText("Form ini digunakan untuk mengubah password user");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Input"));
        jPanel1.setOpaque(false);

        txtIDUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "ID. User :"));
        txtIDUser.setOpaque(false);

        txtPassLama.setBorder(javax.swing.BorderFactory.createTitledBorder("Password Lama :"));
        txtPassLama.setOpaque(false);
        txtPassLama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassLamaActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Password Baru"));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewportView(txtPassBaru);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtIDUser)
                    .addComponent(txtPassLama))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassLama, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/aktif-small.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setOpaque(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassLamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassLamaActionPerformed
        txtPassBaru.requestFocus(true);
    }//GEN-LAST:event_txtPassLamaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       if(txtPassLama.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Password lama belum diisi", 
                   "Informasi", JOptionPane.INFORMATION_MESSAGE);
           
       }else if(txtPassBaru.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Password Baru Belum diisi",
                   "Informasi", JOptionPane.INFORMATION_MESSAGE);
           
       }else{
           updatePassword();
       }
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JEditorPane txtPassBaru;
    private javax.swing.JPasswordField txtPassLama;
    // End of variables declaration//GEN-END:variables
}
