package Form;

import Tool.KoneksiDB;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrMenu extends javax.swing.JFrame {
    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;
    
    
    public FrMenu() {
        initComponents();
        Image image = new ImageIcon(getClass().getResource("/Image/Admin-Schoolar.png")).getImage();
                        setIconImage(image);
              this.setExtendedState(this.getExtendedState() | FrMenu.MAXIMIZED_BOTH);
              
              disableMenu();
              txtIdUser.requestFocus(true);
        
    }
    
    private void disableMenu(){
        menuSistem(false);
        menuMaster(false);
        menuAkademik(false);
        menuMahasiswa(false);
        menuPegawai(false);
        menuUKT(false);
        
    }
    
    private void enableMenu(){
        
    }
    
    protected void aksiLogin(){
        vid_user = txtIdUser.getText().replaceAll("'","");
        vpass = txtPass.getText().replaceAll("'", "");
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from tbuser where id_user='"+vid_user+"' " 
                    + " and pass='"+vpass+"' ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            if(res.first()){
                vnama_user = res.getString("nama_user");
                vlev_user = res.getString("lev_user");
                lbKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+ 
                        "| Lev. User : "+vlev_user);
                panelLogin.setVisible(false);
                if(vlev_user.equals("Administrator")){
                    userAdmin();
                }else if(vlev_user.equals("Staf Akademik")){
                    userAkademik(); 
                }else if(vlev_user.equals("Staf Kepegawaian")){
                    userKepegawaian();
                }else if(vlev_user.equals("Staf Kemahasiswaan")){
                    userKemahasiswaan();
                }else if(vlev_user.equals("Staf Bag. Pembayaran UKT")){
                    userPembayaranUKT();
                }
            }else{
                JOptionPane.showMessageDialog(this, "ID. User dan Password salah",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiLogin() : " + ex);
        }
    }
    
    void menuSistem(Boolean sta){
        mnSistem.setVisible(sta);
    }
    
    void menuMaster(Boolean sta){
        mnMaster.setVisible(sta);
    }
    
    void menuAkademik(Boolean sta){
        mnAkademik.setVisible(sta);
    }
    
    void menuMahasiswa(Boolean sta){
        mnMahasiswa.setVisible(sta);
    }
    
    void menuPegawai(Boolean sta){
        mnPegawai.setVisible(sta);
    }
    
    void menuUKT(Boolean sta){
        mnUKT.setVisible(sta);
    }
    void userAdmin(){
      menuSistem(true);
      menuMaster(true);
      menuAkademik(true);
      menuMahasiswa(true);
      menuPegawai(true);
      menuUKT(true);
    }
    
    void userAkademik(){
      menuSistem(true);
      mnUser.setText("Ubah Password");
      mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png")));
      menuMaster(true);
      menuAkademik(true);
      menuMahasiswa(false);
      menuPegawai(false);
      menuUKT(false);
    }
    
    void userKemahasiswaan(){
      menuSistem(true);
      mnUser.setText("Ubah Password");
      mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png")));
      menuMaster(false);
      menuAkademik(false);
      menuMahasiswa(true);
      menuPegawai(false);
      menuUKT(false);
    }
    
    void userKepegawaian(){
      menuSistem(true);
      mnUser.setText("Ubah Password");
      mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png")));
      menuMaster(false);
      menuAkademik(false);
      menuMahasiswa(false);
      menuPegawai(true);
      menuUKT(false);
    }
    
    void userPembayaranUKT(){
      menuSistem(true);
      mnUser.setText("Ubah Password");
      mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png")));
      menuMaster(false);
      menuAkademik(false);
      menuMahasiswa(false);
      menuPegawai(false);
      menuUKT(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JDesktopPane();
        panelLogin = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtIdUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbKeterangan = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSistem = new javax.swing.JMenu();
        mnUser = new javax.swing.JMenuItem();
        mnKeluar = new javax.swing.JMenuItem();
        mnMaster = new javax.swing.JMenu();
        mnTAA = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnJurusan = new javax.swing.JMenuItem();
        mnProdi = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnAkademik = new javax.swing.JMenu();
        mnSetThAkademik = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnKelompokMK = new javax.swing.JMenuItem();
        mnMasterMK = new javax.swing.JMenuItem();
        mnMKSemesterAktf = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnJadwalMK = new javax.swing.JMenuItem();
        mnPegawai = new javax.swing.JMenu();
        mnDataPegawai = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnPegawaiMutasi = new javax.swing.JMenuItem();
        mnPegawaiKeluar = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        mnTransJabatan = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        mnLapPegawai = new javax.swing.JMenuItem();
        mnMahasiswa = new javax.swing.JMenu();
        mnDataMhs = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnDataNilaiMhs = new javax.swing.JMenuItem();
        mnDataMhsCuti = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnDataMhsDO = new javax.swing.JMenuItem();
        mnDataMhsMD = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnDataMhsAlumni = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnLapDataMhs = new javax.swing.JMenuItem();
        mnUKT = new javax.swing.JMenu();
        mnMasterUKT = new javax.swing.JMenuItem();
        mnUKTMahasiswa = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        mnTransUKT = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnLapTransUKT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIAKAD v.1.0.1");

        txtIdUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "ID. User :"));
        txtIdUser.setOpaque(false);

        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Password :"));
        txtPass.setOpaque(false);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/login-blue.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/small_logout.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jButton4.setText("Batal");

        jButton5.setText("Batal");

        jButton6.setText("Login");

        jButton7.setText("Batal");

        jButton8.setText("Login");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN SIAKAD v.1.0.1");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-{ Sistem Informasi Oemah Codinger }-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdUser)
                            .addComponent(txtPass)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        panelLogin.addTab("Login User", new javax.swing.ImageIcon(getClass().getResource("/Image/Admin-Schoolar-Icon.png")), jPanel2); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 0, 10)); // NOI18N
        jLabel3.setText("oemahcodinger.com");

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel4.setText("SEKOLAH TINGGI OEMAH CODINGER");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel9.setText("SISTEM INFORMASI AKADEMIK");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbKeterangan.setText("ID. User :... | Lev user :....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jpMenu.setLayer(panelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 486, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mnSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1 - Sistem.png"))); // NOI18N
        mnSistem.setText("Sistem");

        mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1 - user.png"))); // NOI18N
        mnUser.setText("User");
        mnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserActionPerformed(evt);
            }
        });
        mnSistem.add(mnUser);

        mnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/small_logout.png"))); // NOI18N
        mnKeluar.setText(" Keluar");
        mnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKeluarActionPerformed(evt);
            }
        });
        mnSistem.add(mnKeluar);

        jMenuBar1.add(mnSistem);

        mnMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - Master.png"))); // NOI18N
        mnMaster.setText("Master");
        mnMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMasterActionPerformed(evt);
            }
        });

        mnTAA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnTAA.setText("Tahun Angkatan");
        mnTAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTAAActionPerformed(evt);
            }
        });
        mnMaster.add(mnTAA);
        mnMaster.add(jSeparator1);

        mnJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnJurusan.setText("Jurusan");
        mnJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJurusanActionPerformed(evt);
            }
        });
        mnMaster.add(mnJurusan);

        mnProdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnProdi.setText("Program Studi");
        mnProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdiActionPerformed(evt);
            }
        });
        mnMaster.add(mnProdi);
        mnMaster.add(jSeparator10);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        jMenuItem10.setText("Jabatan Pegawai");
        mnMaster.add(jMenuItem10);

        jMenuBar1.add(mnMaster);

        mnAkademik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - Akademik.png"))); // NOI18N
        mnAkademik.setText("Akademik");

        mnSetThAkademik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - tahun akademik.png"))); // NOI18N
        mnSetThAkademik.setText("Set Tahun Akademik");
        mnSetThAkademik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSetThAkademikActionPerformed(evt);
            }
        });
        mnAkademik.add(mnSetThAkademik);
        mnAkademik.add(jSeparator6);

        mnKelompokMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnKelompokMK.setText("Data Kelompok Matakuliah");
        mnAkademik.add(mnKelompokMK);

        mnMasterMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnMasterMK.setText("Data Master Matakuliah");
        mnAkademik.add(mnMasterMK);

        mnMKSemesterAktf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnMKSemesterAktf.setText("Data Matakuliah Semester Aktif");
        mnAkademik.add(mnMKSemesterAktf);
        mnAkademik.add(jSeparator7);

        mnJadwalMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnJadwalMK.setText("Data Jadwal Matakuliah ");
        mnJadwalMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJadwalMKActionPerformed(evt);
            }
        });
        mnAkademik.add(mnJadwalMK);

        jMenuBar1.add(mnAkademik);

        mnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - Pegawai.png"))); // NOI18N
        mnPegawai.setText("Pegawai");

        mnDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnDataPegawai.setText("Data Pegawai");
        mnPegawai.add(mnDataPegawai);
        mnPegawai.add(jSeparator8);

        mnPegawaiMutasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnPegawaiMutasi.setText("Data Pegawai Mutasi");
        mnPegawai.add(mnPegawaiMutasi);

        mnPegawaiKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnPegawaiKeluar.setText("Data Pegawai Keluar");
        mnPegawai.add(mnPegawaiKeluar);
        mnPegawai.add(jSeparator9);

        mnTransJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnTransJabatan.setText("Data Transaksi Jabatan");
        mnPegawai.add(mnTransJabatan);
        mnPegawai.add(jSeparator13);

        mnLapPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapPegawai.setText("Laporan Data Pegawai");
        mnPegawai.add(mnLapPegawai);

        jMenuBar1.add(mnPegawai);

        mnMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - Mahasiswa.png"))); // NOI18N
        mnMahasiswa.setText("Mahasiswa");

        mnDataMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhs.setText("Data Mahasiswa");
        mnDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMhs);
        mnMahasiswa.add(jSeparator4);

        mnDataNilaiMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nilai-mahasiswa-small.png"))); // NOI18N
        mnDataNilaiMhs.setText("Data Nilai Mahasiswa");
        mnMahasiswa.add(mnDataNilaiMhs);

        mnDataMhsCuti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhsCuti.setText("Data Mahasiswa Cuti");
        mnDataMhsCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsCutiActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMhsCuti);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        jMenu1.setText("Data Mahasiswa Keluar");

        mnDataMhsDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhsDO.setText("Drop Out (DO)");
        mnDataMhsDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsDOActionPerformed(evt);
            }
        });
        jMenu1.add(mnDataMhsDO);

        mnDataMhsMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhsMD.setText("Mengundurkan Diri");
        mnDataMhsMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsMDActionPerformed(evt);
            }
        });
        jMenu1.add(mnDataMhsMD);

        mnMahasiswa.add(jMenu1);
        mnMahasiswa.add(jSeparator2);

        mnDataMhsAlumni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhsAlumni.setText("Data Mahasiswa Alumni ");
        mnDataMhsAlumni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsAlumniActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMhsAlumni);
        mnMahasiswa.add(jSeparator5);

        mnLapDataMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapDataMhs.setText("Laporan Data Mahasiswa");
        mnLapDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLapDataMhsActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnLapDataMhs);

        jMenuBar1.add(mnMahasiswa);

        mnUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - UKT.png"))); // NOI18N
        mnUKT.setText("Uang Kuliah");

        mnMasterUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - master-ukt.png"))); // NOI18N
        mnMasterUKT.setText("Master Uang Kuliah ");
        mnUKT.add(mnMasterUKT);

        mnUKTMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - ukt-mahasiswa-small.png"))); // NOI18N
        mnUKTMahasiswa.setText("Data UKT Mahasiswa");
        mnUKT.add(mnUKTMahasiswa);
        mnUKT.add(jSeparator11);

        mnTransUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - transaksi-ukt-small.png"))); // NOI18N
        mnTransUKT.setText("Data Transaksi UKT");
        mnUKT.add(mnTransUKT);
        mnUKT.add(jSeparator12);

        mnLapTransUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapTransUKT.setText("Laporan Transaksi UKT");
        mnUKT.add(mnLapTransUKT);

        jMenuBar1.add(mnUKT);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnTAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTAAActionPerformed
        IfrTahunAngkatan fr = new IfrTahunAngkatan();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnTAAActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       if(txtIdUser.getText().equals("") || txtPass.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Silahkan lengkapi data !", "Informasi",
                   JOptionPane.INFORMATION_MESSAGE);
       }else{
           aksiLogin();
       }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        txtIdUser.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed
    
    private void mnMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnMasterActionPerformed

    private void mnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserActionPerformed
        if(mnUser.getText().equals("Ubah Password")){
            jdUbahPassword fr = new jdUbahPassword(this, true, vid_user);
            fr.setVisible(true);
        }else{
            IfrUser fr = new IfrUser();
            jpMenu.add(fr);
            fr.setVisible(true);
        }
        
    }//GEN-LAST:event_mnUserActionPerformed

    private void mnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKeluarActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah anda akan keluar dari sistem?", "Informasi",
                JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            System.exit(0);
        }
                
    }//GEN-LAST:event_mnKeluarActionPerformed

    private void mnJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJurusanActionPerformed
        IfrJurusan fr = new IfrJurusan();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnJurusanActionPerformed

    private void mnProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdiActionPerformed
        IfrProdi fr = new IfrProdi();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnProdiActionPerformed

    private void mnDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsActionPerformed
       IfrMahasiswa fr = new IfrMahasiswa();
       jpMenu.add(fr);
       fr.setVisible(true);
    }//GEN-LAST:event_mnDataMhsActionPerformed

    private void mnLapDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLapDataMhsActionPerformed
        IfrLapMahasiswa fr = new IfrLapMahasiswa();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnLapDataMhsActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
       if(txtIdUser.getText().equals("")){
           JOptionPane.showMessageDialog(this, "ID. User belum diisi !", "Informasi",
                   JOptionPane.INFORMATION_MESSAGE);
       }else if(txtPass.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Password belum diisi !", "Informasi",
                   JOptionPane.INFORMATION_MESSAGE);  
       }else{
           aksiLogin();
       }    
    }//GEN-LAST:event_txtPassActionPerformed

    private void mnDataMhsCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsCutiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMhsCutiActionPerformed

    private void mnDataMhsDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMhsDOActionPerformed

    private void mnDataMhsMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMhsMDActionPerformed

    private void mnDataMhsAlumniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsAlumniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMhsAlumniActionPerformed

    private void mnSetThAkademikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSetThAkademikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnSetThAkademikActionPerformed

    private void mnJadwalMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJadwalMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnJadwalMKActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) throws UnsupportedLookAndFeelException,
           IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        try{
            
            //com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Default", "Java Swing", "");
            com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme("Default", "Java Swing", "");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.MoWinLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new FrMenu());
        }finally {
            new FrMenu().setVisible(true);
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JDesktopPane jpMenu;
    private javax.swing.JLabel lbKeterangan;
    private javax.swing.JMenu mnAkademik;
    private javax.swing.JMenuItem mnDataMhs;
    private javax.swing.JMenuItem mnDataMhsAlumni;
    private javax.swing.JMenuItem mnDataMhsCuti;
    private javax.swing.JMenuItem mnDataMhsDO;
    private javax.swing.JMenuItem mnDataMhsMD;
    private javax.swing.JMenuItem mnDataNilaiMhs;
    private javax.swing.JMenuItem mnDataPegawai;
    private javax.swing.JMenuItem mnJadwalMK;
    private javax.swing.JMenuItem mnJurusan;
    private javax.swing.JMenuItem mnKelompokMK;
    private javax.swing.JMenuItem mnKeluar;
    private javax.swing.JMenuItem mnLapDataMhs;
    private javax.swing.JMenuItem mnLapPegawai;
    private javax.swing.JMenuItem mnLapTransUKT;
    private javax.swing.JMenuItem mnMKSemesterAktf;
    private javax.swing.JMenu mnMahasiswa;
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenuItem mnMasterMK;
    private javax.swing.JMenuItem mnMasterUKT;
    private javax.swing.JMenu mnPegawai;
    private javax.swing.JMenuItem mnPegawaiKeluar;
    private javax.swing.JMenuItem mnPegawaiMutasi;
    private javax.swing.JMenuItem mnProdi;
    private javax.swing.JMenuItem mnSetThAkademik;
    private javax.swing.JMenu mnSistem;
    private javax.swing.JMenuItem mnTAA;
    private javax.swing.JMenuItem mnTransJabatan;
    private javax.swing.JMenuItem mnTransUKT;
    private javax.swing.JMenu mnUKT;
    private javax.swing.JMenuItem mnUKTMahasiswa;
    private javax.swing.JMenuItem mnUser;
    private javax.swing.JTabbedPane panelLogin;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
//Keterangan
/*
1. Deklarasikan terlebih dahulu variabel-variabl nama pada form login dan menu
2. import file class library yang dibutuhkan 
3. Deklarasikan oobjek koneksi database dan class Connection
4. Deklarasikan variabel-variabel yang dibutuhkan untuk operasi login
5. Buat method disableMenu() dan enableMenu()
6. Buat method aksiLogin()
7.Tambahkan beberapa sintak pada method constructor
8. Ubah sintax method main 
9. Tambahkan data untuk tbUser
10. Tambahkan sintak untuk tombol login dan batal
*/

