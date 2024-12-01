/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import static Pantallas.FrmRegistrarse.selectedFile;
import dtos.UsuarioDTO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import negocio.IUsuarioNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Arturo ITSON
 */
public class FrmEditarPerfil extends javax.swing.JFrame {

    
    FrmUsuarioPerfil usuarioPerfil;
    UsuarioDTO usuarioDTO;
    
    /**
     * Creates new form FrmEditarPerfil
     */
    public FrmEditarPerfil(FrmUsuarioPerfil usuarioPerfil, UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
        this.usuarioPerfil = usuarioPerfil;
        
        initComponents();
        
        cargarDatos();
    }

    
    public void cargarDatos(){
    
        setImagenLabel(jblImagen, usuarioDTO.getImagen());
        
        txtNombres.setText(usuarioDTO.getNombres());
        txtApellidoP.setText(usuarioDTO.getApellidoP());
        txtApellidoM.setText(usuarioDTO.getApellidoM());
        txtCorreo.setText(usuarioDTO.getCorreo());
        txtContrasena.setText(usuarioDTO.getContrasena());
                
                
                
    }
    
     /**
     * Metodo que coloca una imagen en la interfaz
     * @param nombreJlb el jlabel que sera reemplazado por una imagen
     * @param ruta la direccion donde se encuentra la imagen
     */
    private void setImagenLabel(JLabel nombreJlb, String ruta){
    
        ImageIcon image = new ImageIcon(ruta);
        
        Icon icon = new ImageIcon(
        image.getImage().getScaledInstance(nombreJlb.getWidth(), nombreJlb.getHeight(), Image.SCALE_DEFAULT));
        
        nombreJlb.setIcon(icon);
        
        this.repaint();
   
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
        jblNombres = new javax.swing.JLabel();
        jblApellidoP = new javax.swing.JLabel();
        jblApellidoM = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        jblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jblImagen = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Perfil");
        setPreferredSize(new java.awt.Dimension(650, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jblNombres.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblNombres.setForeground(new java.awt.Color(0, 0, 0));
        jblNombres.setText("Nombres");

        jblApellidoP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        jblApellidoP.setText("Apellido Paterno");

        jblApellidoM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        jblApellidoM.setText("Apellido Materno");

        txtNombres.setBackground(new java.awt.Color(255, 255, 255));
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        txtApellidoP.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        txtApellidoM.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jblCorreo.setText("Correo");

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jblContrasena.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblContrasena.setForeground(new java.awt.Color(0, 0, 0));
        jblContrasena.setText("Contraseña");

        txtContrasena.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasena.setForeground(new java.awt.Color(0, 0, 0));
        txtContrasena.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jblImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(14, 153, 217));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(30, 243, 11));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jblCorreo)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena)
                            .addComponent(txtCorreo)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblNombres)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblApellidoP)
                                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jblContrasena))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jblApellidoM)
                                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(btnCargar)))
                                .addGap(50, 50, 50))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblNombres)
                    .addComponent(jblApellidoP)
                    .addComponent(jblApellidoM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jblContrasena))
                            .addComponent(jblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecciona una imagen");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();

                // Mostrar la imagen
                ImageIcon image = new ImageIcon(selectedFile.getPath());
                Icon icon = new ImageIcon(
                    image.getImage().getScaledInstance(jblImagen.getWidth(), jblImagen.getHeight(), Image.SCALE_DEFAULT));

                jblImagen.setIcon(icon);
                jblImagen.setText("");

            }
        }

        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + ex.getMessage());

        }

    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        usuarioPerfil.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        try{

            String nombres = txtNombres.getText();
            String apellidoP = txtApellidoP.getText();
            String apellidoM = txtApellidoM.getText();
            String correo = txtCorreo.getText();
            String contra = txtContrasena.getText();

            UsuarioDTO usuarioEditarDTO = new UsuarioDTO();

            if(selectedFile == null && usuarioDTO.getImagen().equalsIgnoreCase("src/main/java/ImagenesProyecto/NoImagen.jpg")){

                usuarioEditarDTO.setApellidoM(apellidoM);
                usuarioEditarDTO.setApellidoP(apellidoP);
                usuarioEditarDTO.setContrasena(contra);
                usuarioEditarDTO.setCorreo(correo);
                usuarioEditarDTO.setImagen("src/main/java/ImagenesProyecto/NoImagen.jpg");
                usuarioEditarDTO.setNombres(nombres);
                usuarioEditarDTO.setId(usuarioDTO.getId());

                IUsuarioNegocio negocio = new UsuarioNegocio();
                negocio.editarUsuario(usuarioEditarDTO);

                JOptionPane.showMessageDialog(this,"Usuario actualizado con exito", "Mensaje de resultado ", JOptionPane.INFORMATION_MESSAGE );
                System.out.println(usuarioEditarDTO.toString());

            }

            else{

                // Crear un nombre único para el archivo (usar timestamp)
                String fileExtension = getFileExtension(selectedFile);
                if(fileExtension.equalsIgnoreCase("")){
                    usuarioEditarDTO.setApellidoM(apellidoM);
                    usuarioEditarDTO.setApellidoP(apellidoP);
                    usuarioEditarDTO.setContrasena(contra);
                    usuarioEditarDTO.setCorreo(correo);
                    usuarioEditarDTO.setImagen("src/main/java/ImagenesProyecto/NoImagen.jpg");
                    usuarioEditarDTO.setNombres(nombres);
                    usuarioEditarDTO.setId(usuarioDTO.getId());

                    IUsuarioNegocio negocio = new UsuarioNegocio();
                    negocio.editarUsuario(usuarioEditarDTO);

                    JOptionPane.showMessageDialog(this,"Usuario actualizado con exito", "Mensaje de resultado ", JOptionPane.INFORMATION_MESSAGE );
                    System.out.println(usuarioEditarDTO.toString());

                    usuarioPerfil.setVisible(true);
                    this.dispose();
                    
                }
                else{
                String uniqueFileName = System.currentTimeMillis() + "." + fileExtension;

                // Ruta donde se guardará la imagen
                String destinationPath = "src/main/java/ImagenesUsuario/" + uniqueFileName;
                File destinationFile = new File(destinationPath);

                // Crear directorio si no existe
                destinationFile.getParentFile().mkdirs();

                // Copiar la imagen seleccionada
                if(selectedFile.toPath() == null){
                }
                Files.copy(selectedFile.toPath(), destinationFile.toPath());

                // Guardar la ruta en una variable
                String savedImagePath = destinationFile.getAbsolutePath();
                System.out.println("Imagen guardada en: " + savedImagePath);

                usuarioEditarDTO.setApellidoM(apellidoM);
                usuarioEditarDTO.setApellidoP(apellidoP);
                usuarioEditarDTO.setContrasena(contra);
                usuarioEditarDTO.setCorreo(correo);
                usuarioEditarDTO.setImagen(destinationPath);
                usuarioEditarDTO.setNombres(nombres);
                usuarioEditarDTO.setId(usuarioDTO.getId());

                IUsuarioNegocio negocio = new UsuarioNegocio();
                negocio.editarUsuario(usuarioEditarDTO);

                JOptionPane.showMessageDialog(this,"Usuario actualizado con exito", "Mensaje de resultado ", JOptionPane.INFORMATION_MESSAGE );
                System.out.println(usuarioEditarDTO.toString());

                usuarioPerfil.setVisible(true);
                this.dispose();
                }
            }
        }

        catch(IOException ex){
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + ex.getMessage());

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Método para obtener la extensión del archivo
    private static String getFileExtension(File file) {
        
        try{
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex > 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(lastIndex + 1).toLowerCase();
        }
        }
        catch(Exception e){
              System.out.println(e.getMessage());  
        }
        
        return ""; // Sin extensión
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jblApellidoM;
    private javax.swing.JLabel jblApellidoP;
    private javax.swing.JLabel jblContrasena;
    private javax.swing.JLabel jblCorreo;
    private javax.swing.JLabel jblImagen;
    private javax.swing.JLabel jblNombres;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
