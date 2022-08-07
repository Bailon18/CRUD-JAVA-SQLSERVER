
package PKGUI;

import PKDAO.DocenteDAO;
import PKENTIDAD.Docente;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Bailon
 */
public final class FrmCRUDD extends javax.swing.JFrame {

    DefaultComboBoxModel modelEspe = new DefaultComboBoxModel();
    DefaultComboBoxModel modelPais = new DefaultComboBoxModel();
    DocenteDAO dao = new DocenteDAO();
    String ficheroo = "";
    
    public FrmCRUDD() {
        initComponents();
        setLocationRelativeTo(null);
        dao.CrearColumnas(tablaDocentes);
        cboEspeci.setModel(modelEspe);
        cboPais.setModel(modelPais);
        llenarEspecialidades();
        llenarPais();
        llenarTabla();    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        cboPais = new javax.swing.JComboBox<>();
        cboEspeci = new javax.swing.JComboBox<>();
        chekEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocentes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroDocentes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "INGRESO DE DATOS"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 68, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Codigo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 36, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Especialidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 132, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 201, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Pais");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 164, -1, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 170, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 170, -1));

        txtCodigo.setEditable(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 170, -1));

        jPanel1.add(cboPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 170, -1));

        jPanel1.add(cboEspeci, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 170, -1));
        jPanel1.add(chekEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 440, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE DATOS DE DOCENTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 160, 180));

        btnBuscarFoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarFoto.setText("Subir");
        btnBuscarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 110, 20));

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        bntActualizar.setText("Actualizar");
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bntActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        tablaDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDocentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDocentes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 660, 350));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Numero de Docentes");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 710, -1, -1));

        txtNumeroDocentes.setEditable(false);
        getContentPane().add(txtNumeroDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 710, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        
        JFileChooser fc = new JFileChooser();
        
        // Validamos que solo pueda buscar "jpg", "png"
        fc.addChoosableFileFilter(new FileNameExtensionFilter
        ("Image Files", "jpg", "png"));
        
        // abrimos la ventana
        int seleccion = fc.showOpenDialog(this);
        
        // si da el boton aceptar
        if(seleccion == JFileChooser.APPROVE_OPTION){
            
            File fichero = fc.getSelectedFile();
            ficheroo = fichero.getAbsolutePath();
            System.out.println("llego aqui");
            
            ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(fichero.getAbsolutePath())
                    .getImage().getScaledInstance(lblFoto.getWidth()
                            , lblFoto.getHeight(), Image.SCALE_DEFAULT));
            
            // seteamos el icon en el label
            lblFoto.setIcon(imageIcon);
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        
        if (txtCodigo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un docente "
                    + "para actualizar", "Actualizar", JOptionPane.WARNING_MESSAGE);
        }else{
            
            if(validarCampos().length() > 0){
                JOptionPane.showMessageDialog(null, validarCampos());
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int idEspec = cboEspeci.getSelectedIndex();
            int idPais = cboPais.getSelectedIndex();
            int estado = chekEstado.isSelected()? 1:0;
            String image = ficheroo;

            dao.ActualizarDatosdelDocenteDAL(new Docente(codigo, nombre, apellidos,
                    idEspec, idPais, estado, image));


            llenarTabla();
            limpiarCajas();

            }
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if(validarCampos().length() > 0){
                JOptionPane.showMessageDialog(null,validarCampos(),"Registro",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String nombre = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        int idEspec = cboEspeci.getSelectedIndex();
        int idPais = cboPais.getSelectedIndex();
        int estado = chekEstado.isSelected()? 1:0;
        String image = ficheroo;
        dao.RegistrarDocenteDAL(new Docente(nombre, apellidos,
                idEspec, idPais, estado, image));

        llenarTabla();
        limpiarCajas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tablaDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDocentesMouseClicked
        
        int codigo = (int) tablaDocentes.getModel()
                .getValueAt(tablaDocentes.getSelectedRow(), 0);
        try {
            llenarCamposEditar(codigo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        btnRegistrar.setEnabled(false);
    }//GEN-LAST:event_tablaDocentesMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if (txtCodigo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un docente "
                    + "para eliminar", "Eliminar", JOptionPane.WARNING_MESSAGE);
        }else{
            
            int opcion =JOptionPane.showConfirmDialog(null, 
                    "¿Desea eliminar el docente?"
                    ,"Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (opcion==JOptionPane.YES_OPTION) {
                
                int codigo = Integer.parseInt(txtCodigo.getText());
                
                txtNumeroDocentes.setText(""+dao.EliminarDocente(codigo));
                llenarTabla();
                limpiarCajas();
                btnRegistrar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    
    /*========================== Funciones =============================*/
    
    public String validarCampos(){
            
        String mensaje = "";
        
        if(txtNombres.getText().trim().length() == 0 || 
             txtApellidos.getText().trim().length() == 0 ||
                cboEspeci.getSelectedIndex() == 0 ||
                cboPais.getSelectedIndex() == 0){
            mensaje += "*Completo los campos\n";
        }
        
        if(lblFoto.getIcon()== null){
            mensaje += "*Seleccione una Imagen";
        }

        return mensaje;
    }
    
    public void llenarCamposEditar(int codigo) throws IOException{
        
        try {
            
            ResultSet resul = dao.BuscarDocente(codigo);
            
            while(resul.next()){
               
                
                txtCodigo.setText(""+resul.getInt(1));
                txtNombres.setText(""+resul.getString(2));
                txtApellidos.setText(""+resul.getString(3));
                cboEspeci.setSelectedIndex(resul.getInt(4));
                cboPais.setSelectedIndex(resul.getInt(5));
                boolean res = resul.getInt(6) == 1;
                chekEstado.setSelected(res);
                
                Blob blob=resul.getBlob(7);
                Image fotodoc=ImageIO.read(blob.getBinaryStream());
                fotodoc=fotodoc.getScaledInstance(lblFoto.getWidth(),
                        lblFoto.getHeight(),Image.SCALE_DEFAULT);

                ImageIcon icon=new ImageIcon(fotodoc);
                lblFoto.setIcon(icon);
  
            }
            
        } catch (SQLException ex) {
            
        }
    }
    
    public void llenarTabla(){
        try {  
            txtNumeroDocentes.setText(""+dao.AgregarFilasenJable());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void limpiarCajas() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        llenarEspecialidades();
        llenarPais();
        chekEstado.setSelected(false);
        lblFoto.setIcon(null);
        ficheroo = "";
    }

    public void llenarEspecialidades() {
        modelEspe.removeAllElements();
        try {
            ResultSet resultado = dao.Especialidades();
            while (resultado.next()) {
                modelEspe.addElement(resultado.getString(2));
            }
        } catch (SQLException ex) {
        }
    }

    public void llenarPais() {
        modelPais.removeAllElements();
        try {
            ResultSet resultado = dao.Paies();
            while (resultado.next()) {
                modelPais.addElement(resultado.getString(2));
            }
        } catch (SQLException ex) {
        }
    }

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
            java.util.logging.Logger.getLogger(FrmCRUDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCRUDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCRUDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCRUDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCRUDD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboEspeci;
    private javax.swing.JComboBox<String> cboPais;
    private javax.swing.JCheckBox chekEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tablaDocentes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumeroDocentes;
    // End of variables declaration//GEN-END:variables
}
