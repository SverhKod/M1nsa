/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author moise
 */
public class RegistrarCita extends javax.swing.JFrame {

   int IDPaciente_update = 0;
   String user = "", nom_paciente = "";

   /**
    * Creates new form RegistrarCita
    */
   public RegistrarCita() {
      initComponents();
      user = Login.user;
      IDPaciente_update = GestionarPacientes.IDPaciente_update;

      try {
         Connection cn = Conexion.conectar();
         PreparedStatement pst = cn.prepareStatement("SELECT nombre_obstetra FROM obstetras");
         ResultSet rs = pst.executeQuery();
         while (rs.next()) {
            cmb_obstetras.addItem(rs.getString("nombre_obstetra"));
         }
         cn.close();
      } catch (Exception e) {
         System.err.println("Error al cargar obstetras: " + e);
      }

      try {
         Connection cn = Conexion.conectar();
         PreparedStatement pst = cn.prepareStatement("SELECT nombre FROM programas");
         ResultSet rs = pst.executeQuery();
         while (rs.next()) {
            cmb_programas.addItem(rs.getString("nombre"));
         }
         cn.close();
      } catch (Exception e) {
         System.err.println("Error al cargar programas: " + e);
      }

      try {
         Connection cn = Conexion.conectar();
         PreparedStatement pst = cn.prepareStatement(
               "select nombre from pacientes where id_paciente = '" + IDPaciente_update + "'");
         ResultSet rs = pst.executeQuery();

         if (rs.next()) {
            nom_paciente = rs.getString("nombre");
         }
      } catch (SQLException e) {
         System.err.println("Error al consultar el nombre del paciente");
      }

      setTitle("Registrar nueva cita para " + nom_paciente);
      setSize(644, 420);
      setResizable(false);
      setLocationRelativeTo(null);

      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

      ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
      Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
            jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));

      jLabel_wallpaper.setIcon(icono);
      this.repaint();

      txt_nombrePaciente1.setText(nom_paciente);
   }

   private void limpiarCampos() {
      txt_fechapaciente.setText("");
      jTextPane_observacion.setText("");
      cmb_obstetras.setSelectedIndex(0);
      cmb_programas.setSelectedIndex(0);
   }

   private boolean esFechaValida(String fecha) {
      try {
         java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
         sdf.setLenient(false); // No permite fechas inválidas como 32/01/2024
         sdf.parse(fecha);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   @Override
   public Image getIconImage() {
      Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
      return retValue;
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated
   // Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel_Titulo = new javax.swing.JLabel();
      jLabel_fecha = new javax.swing.JLabel();
      jLabel_Nombre1 = new javax.swing.JLabel();
      jLabel_Nombre2 = new javax.swing.JLabel();
      jLabel_Nombre5 = new javax.swing.JLabel();
      txt_fechapaciente = new javax.swing.JTextField();
      cmb_obstetras = new javax.swing.JComboBox<>();
      cmb_programas = new javax.swing.JComboBox<>();
      jScrollPane1 = new javax.swing.JScrollPane();
      jTextPane_observacion = new javax.swing.JTextPane();
      jButton_Registrar = new javax.swing.JButton();
      jLabel_Nombre3 = new javax.swing.JLabel();
      txt_nombrePaciente1 = new javax.swing.JTextField();
      jLabel_wallpaper = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setIconImage(getIconImage());
      getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

      jLabel_Titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
      jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_Titulo.setText("Registro de Citas");
      getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

      jLabel_fecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel_fecha.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_fecha.setText("Fecha de la cita:");
      getContentPane().add(jLabel_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

      jLabel_Nombre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_Nombre1.setText("Obstetra");
      getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

      jLabel_Nombre2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_Nombre2.setText("Programa");
      getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

      jLabel_Nombre5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_Nombre5.setText("Observaciones:");
      getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

      txt_fechapaciente.setBackground(new java.awt.Color(153, 153, 255));
      txt_fechapaciente.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
      txt_fechapaciente.setForeground(new java.awt.Color(255, 255, 255));
      txt_fechapaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txt_fechapaciente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      getContentPane().add(txt_fechapaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 210, -1));

      getContentPane().add(cmb_obstetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

      getContentPane().add(cmb_programas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

      jScrollPane1.setViewportView(jTextPane_observacion);

      getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

      jButton_Registrar.setBackground(new java.awt.Color(255, 102, 102));
      jButton_Registrar.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
      jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
      jButton_Registrar.setText("Regisrar cita");
      jButton_Registrar.setBorder(null);
      jButton_Registrar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_RegistrarActionPerformed(evt);
         }
      });
      getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 210, 35));

      jLabel_Nombre3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
      jLabel_Nombre3.setText("Nombre del paciente: ");
      getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

      txt_nombrePaciente1.setBackground(new java.awt.Color(153, 153, 255));
      txt_nombrePaciente1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
      txt_nombrePaciente1.setForeground(new java.awt.Color(255, 255, 255));
      txt_nombrePaciente1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txt_nombrePaciente1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      getContentPane().add(txt_nombrePaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));
      getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 380));

      pack();
   }// </editor-fold>//GEN-END:initComponents

   public String convertirFecha(String fecha) {
      try {
         java.text.SimpleDateFormat formatoEntrada = new java.text.SimpleDateFormat("dd/MM/yyyy");
         java.text.SimpleDateFormat formatoSQL = new java.text.SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = formatoEntrada.parse(fecha);
         return formatoSQL.format(date);
      } catch (Exception e) {
         return null;
      }
   }

   private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_RegistrarActionPerformed
      int validacion = 0;
      String obstetra, programa, fechaCita, status, observaciones, dia_cita, mes_cita, anio_cita;

      obstetra = cmb_obstetras.getSelectedItem().toString();
      programa = cmb_programas.getSelectedItem().toString();

      observaciones = jTextPane_observacion.getText().trim();
      status = "Nuevo ingreso";

      Calendar calendar = Calendar.getInstance();

      dia_cita = Integer.toString(calendar.get(Calendar.DATE));
      mes_cita = Integer.toString(calendar.get(Calendar.MONTH));
      anio_cita = Integer.toString(calendar.get(Calendar.YEAR));

      if (observaciones.equals("")) {
         jTextPane_observacion.setText("Sin observaciones");
      }

      String textoFecha = txt_fechapaciente.getText().trim();
      if (!esFechaValida(textoFecha)) {
         JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Usa dd/MM/yyyy");
         txt_fechapaciente.setBackground(Color.red);
         return;
      }
      fechaCita = convertirFecha(textoFecha);

      if (validacion == 0) {
         try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                  "insert into cita values(?, ?, ?, ?, ?, ?)");

            pst.setInt(1, 0);
            pst.setInt(2, IDPaciente_update);
            pst.setString(3, fechaCita);
            pst.setString(4, obstetra);
            pst.setString(5, programa);
            pst.setString(6, observaciones);

            pst.executeUpdate();
            cn.close();

            txt_nombrePaciente1.setBackground(Color.green);
            txt_fechapaciente.setBackground(Color.green);

            JOptionPane.showMessageDialog(null, "Registro exitoso");
            limpiarCampos();

            this.dispose();

         } catch (SQLException e) {
            System.err.println("Error en registrar cita" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar cita");
         }
      } else {
         JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
      }
   }// GEN-LAST:event_jButton_RegistrarActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
      // (optional) ">
      /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the default
       * look and feel.
       * For details see
       * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(RegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null,
               ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(RegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null,
               ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(RegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null,
               ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(RegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null,
               ex);
      }
      // </editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new RegistrarCita().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JComboBox<String> cmb_obstetras;
   private javax.swing.JComboBox<String> cmb_programas;
   private javax.swing.JButton jButton_Registrar;
   private javax.swing.JLabel jLabel_Nombre1;
   private javax.swing.JLabel jLabel_Nombre2;
   private javax.swing.JLabel jLabel_Nombre3;
   private javax.swing.JLabel jLabel_Nombre5;
   private javax.swing.JLabel jLabel_Titulo;
   private javax.swing.JLabel jLabel_fecha;
   private javax.swing.JLabel jLabel_wallpaper;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextPane jTextPane_observacion;
   private javax.swing.JTextField txt_fechapaciente;
   private javax.swing.JTextField txt_nombrePaciente1;
   // End of variables declaration//GEN-END:variables
}
