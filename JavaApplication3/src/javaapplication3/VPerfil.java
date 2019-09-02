
package javaapplication3;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VPerfil extends javax.swing.JFrame {
    

    public static Usuario user;
    
    public VPerfil(Usuario usuario) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        user = usuario;
        initComponents();
        busqueda();
        buscarPublicacion();
        jLabel3.setText("Estas en el perfil de: " + usuario.getNusuario());
        jTextArea1.setEditable(false);
        ImageIcon wallpaper=new ImageIcon("src/imagenes/614537ac-86dd-4033-9b0e-f438ade2c3ac.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icono);
        this.setBounds(0,0,icono.getIconWidth(),icono.getIconHeight()+28);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Publicacion p = new Publicacion();
        ArrayList<Publicacion> aiuda = new ArrayList<Publicacion>();
            aiuda =  Publicacion.publicasiones(perfilVisto);
            String aux = "";
            for (int i = aiuda.size()-1; i >= 0; i--){
                aux += aiuda.get(i).getPublicacion()+" "+aiuda.get(i).getFecha() + "\n";
            }
            jTextArea1.setText(aux);
        this.repaint();
    }
    public void busqueda () throws ClassNotFoundException, SQLException{
        String query = "SELECT usuario, email, id FROM "+ Usuario.TABLA;
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(mostrar);
        Connection connection = DB.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        try {
            while(rs.next()){
                textAutoAcompleter.addItem(rs.getString("usuario") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static int perfilVisto;
    public static String correoDelVato;
    public static String publicacionEliminar;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        eliminarPub = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        mostrar = new javax.swing.JTextField();
        jTextPublicacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, 30));

        jLabel3.setText("Estas en el perfil de: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 210, 20));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        eliminarPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPubActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarPub, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 240, 30));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, 30));

        jTextPublicacion.setToolTipText("¿En que piensas?");
        jTextPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPublicacionActionPerformed(evt);
            }
        });
        getContentPane().add(jTextPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 60));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Publicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 310, 90));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cerrar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPublicacionActionPerformed
        
    }//GEN-LAST:event_jTextPublicacionActionPerformed
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String publicacion = jTextPublicacion.getText();
    String comprobar = publicacion.replaceAll(" ","");
    if (!comprobar.isEmpty()){
        Publicacion p = new Publicacion();
    if (perfilVisto == VLogin.usuarioLogin){
        p.setPublicacion(publicacion);
        try {
          int result = p.create();
          if(result == 1) {
          try {
              JOptionPane.showMessageDialog(this, "Publicacion creada");
            ArrayList<Publicacion> aiuda = new ArrayList<Publicacion>();
            aiuda =  Publicacion.publicasiones(user.getId());
            String aux = "";
            for (int i = aiuda.size()-1; i >= 0; i--){
                aux += aiuda.get(i).getPublicacion()+" "+aiuda.get(i).getFecha()+ "\n";
            }
            jTextArea1.setText(aux);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
          //JOptionPane.showMessageDialog(this, "Datos almacenados correctamente");
          } else{
          JOptionPane.showMessageDialog(this, "Ocurrió un error", "Error", JOptionPane.ERROR_MESSAGE);
          }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Este no es tu perfil :c");
        }
    }else{
        JOptionPane.showMessageDialog(this, "No escribió nada para publicar");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        VLogin cerrarSesion= new VLogin();
        correoDelVato = "";
        perfilVisto = 0;
        cerrarSesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void buscar() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
        if(!mostrar.getText().isEmpty()){
            String query = "SELECT * FROM "+ Usuario.TABLA + " WHERE email = ?"; 
        correoDelVato = mostrar.getText().substring(mostrar.getText().indexOf(" "));
        correoDelVato = correoDelVato.replaceAll(" ", "");
        //Obtengo conexión
        Connection connection = DB.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, correoDelVato);
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            if(rs.getString("email").equals(correoDelVato)) {
                perfilVisto = Integer.valueOf(rs.getString("id"));
            }
        }
        ArrayList<Publicacion> aiuda = new ArrayList<Publicacion>();
            aiuda =  Publicacion.publicasiones(perfilVisto);
            String aux = "";
            for (int i = aiuda.size()-1; i >= 0; i--){
                aux += aiuda.get(i).getPublicacion() + " " + aiuda.get(i).getFecha() + "\n";
            }
            jLabel3.setText("Estas en el perfil de: " + mostrar.getText().substring(0,mostrar.getText().indexOf(" ")));
            mostrar.setText("");
            jTextArea1.setText(aux);
        }else{
            JOptionPane.showMessageDialog(this, "No hay nada en el campo de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    public void buscarPublicacion() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
        String query = "SELECT * FROM publicacion WHERE idUsuarios = ?";
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(eliminarPub);
        Connection connection = DB.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, String.valueOf(VLogin.usuarioLogin));
        ResultSet rs = pst.executeQuery();
        try {
            while(rs.next()){
                textAutoAcompleter.addItem(rs.getString("publicacion") + " " + rs.getString("hora") + " id# " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void eliminar() throws SQLException, ClassNotFoundException{
        String comprobar = eliminarPub.getText();
        if (!comprobar.isEmpty()){
            if (VLogin.usuarioLogin == perfilVisto){
            String idEliminar = eliminarPub.getText();
            if(idEliminar.contains("#")){
            idEliminar = idEliminar.substring(idEliminar.indexOf("#"));
            idEliminar = idEliminar.replaceAll("#","");
            }
            idEliminar = idEliminar.replaceAll(" ","");
            String query = "DELETE FROM publicacion WHERE id = ?"; 
        //Obtengo conexión
            Connection connection = DB.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, idEliminar);
            int h = pst.executeUpdate();
            connection.close();
            if (h == 1){
                JOptionPane.showMessageDialog(this, "Publicacion eliminada");
            }else{
                JOptionPane.showMessageDialog(this, "Error :(");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Lo sentimos, pero no puede eliminar cosas de otro perfil");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese algo para eliminar");
        }
        
        ArrayList<Publicacion> aiuda = new ArrayList<Publicacion>();
            aiuda =  Publicacion.publicasiones(perfilVisto);
            String aux = "";
            for (int i = aiuda.size()-1; i >= 0; i--){
                aux += aiuda.get(i).getPublicacion()+" "+aiuda.get(i).getFecha()+ "\n";
            }
            eliminarPub.setText("");
            mostrar.setText("");
            jTextArea1.setText(aux);
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eliminarPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarPubActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            eliminar();
        } catch (SQLException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
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
            java.util.logging.Logger.getLogger(VPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VPerfil(user).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(VPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eliminarPub;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextPublicacion;
    private javax.swing.JTextField mostrar;
    // End of variables declaration//GEN-END:variables

}
