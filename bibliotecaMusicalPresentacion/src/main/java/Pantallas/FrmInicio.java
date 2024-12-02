/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import dtos.IntegrantesDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import negocio.ArtistaNegocio;
import negocio.IArtistaNegocio;
import org.bson.types.ObjectId;
import util.ConversorDTO;
import static util.ConversorDTO.convertirListaAlbumDTOAAlbum;
import static util.ConversorDTO.convertirListaIntegrantesDTOAIntegrantes;

/**
 *
 * @author Arturo ITSON
 */
public class FrmInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        //
    }

    private List<ArtistaDTO> generarArtistas() {
        List<ArtistaDTO> artistas = new ArrayList<>();

        // Generar 30 solistas
        for (int i = 1; i <= 30; i++) {
            ArtistaDTO solista = new ArtistaDTO();
       //     solista.setIdDos(i);
            solista.setNombreArtista("Solista " + i);
            solista.setImagen("src/main/java/ImagenesProyecto/Solista" + i + ".jpg");
            solista.setGenero(i % 2 == 0 ? "Pop" : "Rock");
            solista.setAlbumes(convertirListaAlbumDTOAAlbum(generarAlbumes(i, false)));
            artistas.add(solista);
        }

        // Generar 30 bandas
        for (int i = 1; i <= 30; i++) {
            ArtistaDTO banda = new ArtistaDTO();
          //  banda.setIdDos(30 + i);
            banda.setNombreArtista("Banda " + i);
            banda.setImagen("src/main/java/ImagenesProyecto/Banda" + i + ".jpg");
            banda.setGenero(i % 2 == 0 ? "Metal" : "Alternative");
            banda.setIntegrantes(convertirListaIntegrantesDTOAIntegrantes(generarIntegrantes(i)));
            banda.setAlbumes(convertirListaAlbumDTOAAlbum(generarAlbumes(i, true)));
            artistas.add(banda);
        }

        return artistas;
    }

    private List<AlbumDTO> generarAlbumes(int idBase, boolean esBanda) {
        List<AlbumDTO> albumes = new ArrayList<>();

        for (int j = 1; j <= 2; j++) {
            AlbumDTO album = new AlbumDTO();
            album.setIdAlbum("ALB" + idBase + "_" + j);
            album.setNombre((esBanda ? "Álbum Banda " : "Álbum Solista ") + idBase + " - " + j);
            album.setFechaLanzamiento(new Date());
            album.setImagen("src/main/java/ImagenesProyecto/Album" + idBase + "_" + j + ".jpg");
            album.setCanciones(generarCanciones(idBase, j));
            albumes.add(album);
        }

        return albumes;
    }

    private List<CancionDTO> generarCanciones(int idBase, int albumId) {
        List<CancionDTO> canciones = new ArrayList<>();

        for (int k = 1; k <= 3; k++) {
            CancionDTO cancion = new CancionDTO();
            cancion.setIdCancion("CAN" + idBase + "_" + albumId + "_" + k);
            cancion.setNombreCancion("Canción " + k + " - Álbum " + albumId);
            cancion.setDuracion("3:" + (10 + k * 5));
            canciones.add(cancion);
        }

        return canciones;
    }

    private List<IntegrantesDTO> generarIntegrantes(int idBase) {
        List<IntegrantesDTO> integrantes = new ArrayList<>();
        integrantes.add(new IntegrantesDTO("INT" + idBase + "_1", "Vocalista", new Date(), null));
        integrantes.add(new IntegrantesDTO("INT" + idBase + "_2", "Guitarrista", new Date(), null));
        return integrantes;
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
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        btnDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnIniciarSesion.setBackground(new java.awt.Color(14, 153, 217));
        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRegistrarse.setBackground(new java.awt.Color(14, 153, 217));
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        btnDatos.setBackground(new java.awt.Color(14, 153, 217));
        btnDatos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDatos.setText("Insertar Datos");
        btnDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatos.setEnabled(false);
        btnDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(205, 205, 205))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:

        FrmIniciarSesion iniciarSesion = new FrmIniciarSesion(this);
        iniciarSesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:

        FrmRegistrarse registrarse = new FrmRegistrarse(this);
        registrarse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosActionPerformed
        // TODO add your handling code here:
        IArtistaNegocio artistaNegocio = new ArtistaNegocio();
//
//        try {
//            // Generar 60 artistas
//            List<ArtistaDTO> artistas = generarArtistas();
//
//            // Insertar cada artista
//            for (ArtistaDTO artista : artistas) {
//                artistaNegocio.agregarArtista(artista);
//            }
//
//            // Mostrar mensaje de éxito
//            JOptionPane.showMessageDialog(this, "Artistas insertados con éxito");
//        } catch (Exception ex) {
//            // Mostrar mensaje de error
//            JOptionPane.showMessageDialog(this, "Error al insertar artistas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }


        try{
        boolean resultado = artistaNegocio.InsercionArtistasArturo();
            System.out.println("Se inserto masivamanete? " + resultado);
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDatosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatos;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
