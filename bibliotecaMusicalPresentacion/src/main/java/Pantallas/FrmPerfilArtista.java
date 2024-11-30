/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import negocio.ArtistaNegocio;
import negocio.IArtistaNegocio;

/**
 *
 * @author Arturo ITSON
 */
public class FrmPerfilArtista extends javax.swing.JFrame {

    
    ArtistaDTO artista;
    
    static int indiceAlbumA = 0;
    static int indiceAlbumB = 1;
    static int indiceAlbumC = 2;
    
    static int indiceCancionA = 0;
    static int indiceCancionB = 1;
    static int indiceCancionC = 2;
    
    
    static List<AlbumDTO> albumes;
    static List<CancionDTO> canciones;
    
    String idAlbum;
    String idCancion;
    
    
    /**
     * Creates new form FrmPerfilArtista
     */
    public FrmPerfilArtista(ArtistaDTO artista, String idAlbum, String idCancion) {
        this.artista = artista;
        this.idAlbum = idAlbum;
        this.idCancion = idCancion;
        
        initComponents();
        
        cargarDatos();
    }

    
    public void cargarDatos(){
    
        IArtistaNegocio negocio = new ArtistaNegocio();
        
        albumes = negocio.obtenerTodosAlbumesEnArtistaEspecifico(artista.getId());
        canciones = negocio.obtenerTodasCancionesEnArtistaEspecifico(artista.getId());
        
        
        setImagenLabel(jblImagenArtista, artista.getImagen());
        jblNombreArtista.setText(artista.getNombreArtista());
        jblGenero.setText("Genero: " + artista.getGenero());
        
        String nombresIntegrantes = "";
        
        for(int i = 0; i < artista.getIntegrantes().size(); i++){
            nombresIntegrantes = nombresIntegrantes + ", " + artista.getIntegrantes().get(i).getIdPersona();
        
        }
        
        jblNombresIntegrantes.setText(nombresIntegrantes);
        
        System.out.println("id al" + idAlbum);
        if(idAlbum == null){
                jblNombreAlbumA.setText(artista.getAlbumes().get(indiceAlbumA).getNombre());
                setImagenLabel(jblImagenAlbumA, artista.getAlbumes().get(indiceAlbumA).getImagen());

                try{
                    jblNombreAlbumB.setText(artista.getAlbumes().get(indiceAlbumB).getNombre());
                    setImagenLabel(jblImagenAlbumB, artista.getAlbumes().get(indiceAlbumB).getImagen());

                }
                catch(Exception e){
                    jblNombreAlbumB.setText("n/a");
                    setImagenLabel(jblImagenAlbumB, "src\\main\\java\\ImagenesProyecto\\NoImagen.jpg");
                }

                try{
                    jblNombreAlbumC.setText(artista.getAlbumes().get(indiceAlbumC).getNombre());
                    setImagenLabel(jblImagenAlbumC, artista.getAlbumes().get(indiceAlbumC).getImagen());
                }
                catch(Exception e){
                    jblNombreAlbumC.setText("n/a");
                    setImagenLabel(jblImagenAlbumC, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                }

                jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));

                jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));

                jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                
            
        }
        if (idAlbum != null){
            System.out.println("entro al id no es nulo de albume");
            System.out.println("toestri" + negocio.buscarAlbumPorId(idAlbum).toString());
            
            eliminarAlbumPorNombre(albumes, negocio.buscarAlbumPorId(idAlbum).getNombre());
            
            albumes.add(0,negocio.buscarAlbumPorId(idAlbum));
            System.out.println(albumes.get(0).toString());

                jblNombreAlbumA.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblImagenAlbumA, albumes.get(indiceAlbumA).getImagen());

                try{
                    jblNombreAlbumB.setText(albumes.get(indiceAlbumB).getNombre());
                    setImagenLabel(jblImagenAlbumB, albumes.get(indiceAlbumB).getImagen());

                }
                catch(Exception e){
                    jblNombreAlbumB.setText("n/a");
                    setImagenLabel(jblImagenAlbumB, "src\\main\\java\\ImagenesProyecto\\NoImagen.jpg");
                }

                try{
                    jblNombreAlbumC.setText(albumes.get(indiceAlbumC).getNombre());
                    setImagenLabel(jblImagenAlbumC, albumes.get(indiceAlbumC).getImagen());
                }
                catch(Exception e){
                    jblNombreAlbumC.setText("n/a");
                    setImagenLabel(jblImagenAlbumC, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                }
        
        }    
        
        if(idCancion == null){


                jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));

                jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));

                jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                  
            }

        if(idCancion != null){
                System.out.println("entro al else de canciones");
                
                eliminarCancionPorNombre(canciones, negocio.buscarCancionPorId(idCancion).getNombreCancion());
                System.out.println("canc" + canciones.get(0).toString());
                
                canciones.add(0, negocio.buscarCancionPorId(idCancion));
                

                jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));

                jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));

                jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
             
            } 
    }
    
    
    
    public static boolean eliminarAlbumPorNombre(List<AlbumDTO> albumes, String nombreAlbum) {
        Iterator<AlbumDTO> iterator = albumes.iterator();

        while (iterator.hasNext()) {
            AlbumDTO album = iterator.next();
            if (album.getNombre().equalsIgnoreCase(nombreAlbum)) { // Ignora mayúsculas y minúsculas
                iterator.remove();
                return true; // Indica que se eliminó el álbum
            }
        }
        
        return false;
    }    
    
    public static boolean eliminarCancionPorNombre(List<CancionDTO> canciones, String nombreCancion) {
        Iterator<CancionDTO> iterator = canciones.iterator();

        while (iterator.hasNext()) {
            CancionDTO cancion = iterator.next();
            if (cancion.getNombreCancion().equalsIgnoreCase(nombreCancion)) { // Ignora mayúsculas y minúsculas
                iterator.remove();
                return true; // Canción eliminada
            }
        }
        return false; // No se encontró la canción
    }
    
    
    
     /**
     * Metodo que coloca una imagen de el logo de cinepolis en la interfaz
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jblImagenArtista = new javax.swing.JLabel();
        jblNombreArtista = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jblNombresIntegrantes = new javax.swing.JLabel();
        jblGenero = new javax.swing.JLabel();
        btnMostrarTodosIntegrantes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jblImagenAlbumA = new javax.swing.JLabel();
        jblImagenAlbumB = new javax.swing.JLabel();
        jblImagenAlbumC = new javax.swing.JLabel();
        btnRetrocederAlbum = new javax.swing.JButton();
        btnAvanzarAlbum = new javax.swing.JButton();
        jblNombreAlbumA = new javax.swing.JLabel();
        jblNombreAlbumB = new javax.swing.JLabel();
        jblNombreAlbumC = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jblImagenCancionA = new javax.swing.JLabel();
        jblImagenCancionB = new javax.swing.JLabel();
        jblImagenCancionC = new javax.swing.JLabel();
        btnRetrocederCancion = new javax.swing.JButton();
        btnAvanzarCancion = new javax.swing.JButton();
        jblNombreCancionA = new javax.swing.JLabel();
        jblNombreCancionB = new javax.swing.JLabel();
        jblNombreCancionC = new javax.swing.JLabel();
        jblAlbumes = new javax.swing.JLabel();
        jblCanciones = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil Artista");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblImagenArtista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblNombreArtista.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jblNombreArtista.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreArtista.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblNombreArtista.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Integrantes");

        jblNombresIntegrantes.setForeground(new java.awt.Color(0, 0, 0));
        jblNombresIntegrantes.setText("jLabel2");

        jblGenero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jblGenero.setForeground(new java.awt.Color(0, 0, 0));
        jblGenero.setText("Genero:");

        btnMostrarTodosIntegrantes.setBackground(new java.awt.Color(8, 148, 249));
        btnMostrarTodosIntegrantes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMostrarTodosIntegrantes.setForeground(new java.awt.Color(0, 0, 0));
        btnMostrarTodosIntegrantes.setText("Todos los integrantes");
        btnMostrarTodosIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosIntegrantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jblImagenArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblNombresIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jblNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarTodosIntegrantes)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jblNombreArtista)
                            .addComponent(jblGenero))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnMostrarTodosIntegrantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblNombresIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jblImagenArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblImagenAlbumA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblImagenAlbumB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblImagenAlbumC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnRetrocederAlbum.setBackground(new java.awt.Color(8, 148, 249));
        btnRetrocederAlbum.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnRetrocederAlbum.setForeground(new java.awt.Color(0, 0, 0));
        btnRetrocederAlbum.setText("<");
        btnRetrocederAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederAlbumActionPerformed(evt);
            }
        });

        btnAvanzarAlbum.setBackground(new java.awt.Color(8, 148, 249));
        btnAvanzarAlbum.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnAvanzarAlbum.setForeground(new java.awt.Color(0, 0, 0));
        btnAvanzarAlbum.setText(">");
        btnAvanzarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarAlbumActionPerformed(evt);
            }
        });

        jblNombreAlbumA.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreAlbumA.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreAlbumA.setText("jLabel2");

        jblNombreAlbumB.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreAlbumB.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreAlbumB.setText("jLabel2");

        jblNombreAlbumC.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreAlbumC.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreAlbumC.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRetrocederAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblImagenAlbumA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jblNombreAlbumA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblNombreAlbumB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenAlbumB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblImagenAlbumC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreAlbumC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvanzarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblImagenAlbumC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenAlbumB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenAlbumA, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jblNombreAlbumB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreAlbumC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreAlbumA, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAvanzarAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(btnRetrocederAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblImagenCancionA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblImagenCancionB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblImagenCancionC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnRetrocederCancion.setBackground(new java.awt.Color(8, 148, 249));
        btnRetrocederCancion.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnRetrocederCancion.setForeground(new java.awt.Color(0, 0, 0));
        btnRetrocederCancion.setText("<");
        btnRetrocederCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederCancionActionPerformed(evt);
            }
        });

        btnAvanzarCancion.setBackground(new java.awt.Color(8, 148, 249));
        btnAvanzarCancion.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        btnAvanzarCancion.setForeground(new java.awt.Color(0, 0, 0));
        btnAvanzarCancion.setText(">");
        btnAvanzarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarCancionActionPerformed(evt);
            }
        });

        jblNombreCancionA.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreCancionA.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreCancionA.setText("jLabel2");

        jblNombreCancionB.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreCancionB.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreCancionB.setText("jLabel2");

        jblNombreCancionC.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jblNombreCancionC.setForeground(new java.awt.Color(0, 0, 0));
        jblNombreCancionC.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRetrocederCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblImagenCancionA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreCancionA, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblNombreCancionB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenCancionB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblImagenCancionC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreCancionC, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvanzarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblImagenCancionC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenCancionB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblImagenCancionA, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblNombreCancionA, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreCancionB, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreCancionC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRetrocederCancion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAvanzarCancion, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jblAlbumes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jblAlbumes.setForeground(new java.awt.Color(0, 0, 0));
        jblAlbumes.setText("Albumes");

        jblCanciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jblCanciones.setForeground(new java.awt.Color(0, 0, 0));
        jblCanciones.setText("Canciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblCanciones)
                    .addComponent(jblAlbumes)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jblAlbumes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jblCanciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 302, Short.MAX_VALUE)))
        );

        btnRegresar.setBackground(new java.awt.Color(8, 148, 249));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnRegresar)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMostrarTodosIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosIntegrantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarTodosIntegrantesActionPerformed

    private void btnRetrocederAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederAlbumActionPerformed
        // TODO add your handling code here:
        try{
            
            btnAvanzarAlbum.setEnabled(true);
            indiceAlbumA = indiceAlbumA - 3;
            if(albumes.get(indiceAlbumA) != null){ 

                jblNombreAlbumA.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblImagenAlbumA, albumes.get(indiceAlbumA).getImagen());
            
                try{
                    System.out.println("indice album a" + indiceCancionA);
                    indiceAlbumB = indiceAlbumB - 3;
                    if(albumes.get(indiceAlbumB) != null){ 

                        jblNombreAlbumB.setText(albumes.get(indiceAlbumB).getNombre());
                        setImagenLabel(jblImagenAlbumB, albumes.get(indiceAlbumB).getImagen());
                        
                        try{
                            indiceAlbumC = indiceAlbumC - 3;
                            if(albumes.get(indiceAlbumC) != null){ 

                                jblNombreAlbumC.setText(albumes.get(indiceAlbumC).getNombre());
                                setImagenLabel(jblImagenAlbumC, albumes.get(indiceAlbumC).getImagen());
                            }
                        }
                        
                        catch(Exception e){
                            btnRetrocederAlbum.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceAlbumC = indiceAlbumC + 3;
                            jblNombreAlbumC.setText(albumes.get(indiceAlbumC).getNombre());
                            setImagenLabel(jblImagenAlbumC, albumes.get(indiceAlbumC).getImagen());
                        }
                    
                    }
            }
            
                catch(Exception e){
                    System.out.println("Album b");
                    btnRetrocederAlbum.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceAlbumB = indiceAlbumB + 3;
                    jblNombreAlbumB.setText(albumes.get(indiceAlbumB).getNombre());
                    setImagenLabel(jblImagenAlbumB, albumes.get(indiceAlbumB).getImagen());
            }
            
            
            }

        }
        
        catch(Exception e){
            System.out.println("Album A");
            btnRetrocederAlbum.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas albumes", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
            indiceAlbumA = indiceAlbumA + 3;
            jblNombreAlbumA.setText(albumes.get(indiceAlbumA).getNombre());
            setImagenLabel(jblImagenAlbumA, albumes.get(indiceAlbumA).getImagen());

        }
    }//GEN-LAST:event_btnRetrocederAlbumActionPerformed

    private void btnAvanzarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarAlbumActionPerformed
        // TODO add your handling code here:
        try{
            
            btnRetrocederAlbum.setEnabled(true);
            indiceAlbumA = indiceAlbumA + 3;
            if(albumes.get(indiceAlbumA) != null){ 

                jblNombreAlbumA.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblImagenAlbumA, albumes.get(indiceAlbumA).getImagen());
            
                try{
                    System.out.println("indice album a" + indiceAlbumA);
                    indiceAlbumB = indiceAlbumB + 3;
                    if(albumes.get(indiceAlbumB) != null){ 

                        jblNombreAlbumB.setText(albumes.get(indiceAlbumB).getNombre());
                        setImagenLabel(jblImagenAlbumB, albumes.get(indiceAlbumB).getImagen());
                        
                        try{
                            indiceAlbumC = indiceAlbumC + 3;
                            if(albumes.get(indiceAlbumC) != null){ 

                                jblNombreAlbumC.setText(albumes.get(indiceAlbumC).getNombre());
                                setImagenLabel(jblImagenAlbumC, albumes.get(indiceAlbumC).getImagen());
                            }
                        }
                        
                        catch(Exception e){
                            btnAvanzarAlbum.setEnabled(false);
                            System.out.println("albumC " + e.getMessage());
                            indiceAlbumC = indiceAlbumC - 3;
                            jblNombreAlbumC.setText("sin datos");
                            setImagenLabel(jblImagenAlbumC, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                        }
                    
                    }
            }
            
                catch(Exception e){
                    btnAvanzarAlbum.setEnabled(false);
                    System.out.println("albumB " + e.getMessage());
                   // indiceAlbumB = indiceAlbumB - 3;
                    jblNombreAlbumB.setText("sin datos");
                    setImagenLabel(jblImagenAlbumB, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    
                    System.out.println(indiceAlbumA + "," + indiceAlbumB + "," + indiceAlbumC);
                    
                    jblNombreAlbumC.setText("sin datos");
                    setImagenLabel(jblImagenAlbumC, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            }
            
            
            }

        }
        
        catch(Exception e){
            btnAvanzarAlbum.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas albumes", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceAlbumA = indiceAlbumA - 3;
            jblNombreAlbumA.setText(albumes.get(indiceAlbumA).getNombre());
            setImagenLabel(jblImagenAlbumA, albumes.get(indiceAlbumA).getImagen());

        }
        
    }//GEN-LAST:event_btnAvanzarAlbumActionPerformed

    private void btnRetrocederCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederCancionActionPerformed
        // TODO add your handling code here:
        
        IArtistaNegocio negocio = new ArtistaNegocio();

        
        try{
            
             btnAvanzarCancion.setEnabled(true);
            indiceCancionA = indiceCancionA - 3;
            if(canciones.get(indiceCancionA) != null){ 

                jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
            
                try{
                    System.out.println("indice cacnion a" + indiceCancionA);
                    indiceCancionB = indiceCancionB - 3;
                    if(canciones.get(indiceCancionB) != null){ 

                        jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                        setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                        
                        try{
                            indiceCancionC = indiceCancionC - 3;
                            if(canciones.get(indiceCancionC) != null){ 

                                jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                                setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                            }
                        }
                        
                        catch(Exception e){
                            btnRetrocederCancion.setEnabled(false);
                            System.out.println(e.getMessage());
                            JOptionPane.showMessageDialog(this, "No hay mas canciones", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
                            indiceCancionC = indiceCancionC + 3;
                            jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                            setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                        }
                    
                    }
            }
            
                catch(Exception e){
                    btnRetrocederCancion.setEnabled(false);
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "No hay mas Canciones", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
                    indiceCancionB = indiceCancionB + 3;
                    jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                    setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
            }
            
            
            }

        }
        
        catch(Exception e){
            btnRetrocederCancion.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas canciones", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
            indiceCancionA = indiceCancionA + 3;
            jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
            setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));

        }
    }//GEN-LAST:event_btnRetrocederCancionActionPerformed

    private void btnAvanzarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarCancionActionPerformed
        // TODO add your handling code here:
        IArtistaNegocio negocio = new ArtistaNegocio();
        
        try{
            
            btnRetrocederCancion.setEnabled(true);
            indiceCancionA = indiceCancionA + 3;
            if(canciones.get(indiceCancionA) != null){ 

                jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
            
                try{
                    System.out.println("indice cacnion a" + indiceCancionA);
                    indiceCancionB = indiceCancionB + 3;
                    if(canciones.get(indiceCancionB) != null){ 

                        jblNombreCancionB.setText(canciones.get(indiceCancionB).getNombreCancion());
                        setImagenLabel(jblImagenCancionB, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                        
                        try{
                            indiceCancionC = indiceCancionC + 3;
                            if(canciones.get(indiceCancionC) != null){ 

                                jblNombreCancionC.setText(canciones.get(indiceCancionC).getNombreCancion());
                                setImagenLabel(jblImagenCancionC, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                            }
                        }
                        
                        catch(Exception e){
                            btnAvanzarCancion.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceCancionC = indiceCancionC - 3;
                            jblNombreCancionC.setText("sin datos");
                            setImagenLabel(jblImagenCancionC, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                        }
                    
                    }
            }
            
                catch(Exception e){
                    btnAvanzarCancion.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceCancionB = indiceCancionB - 3;
                    jblNombreCancionC.setText("sin datos");
                    setImagenLabel(jblImagenCancionB, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            }
            
            
            }

        }
        
        catch(Exception e){
            btnAvanzarCancion.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas canciones", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceCancionA = indiceCancionA - 3;
            jblNombreCancionA.setText(canciones.get(indiceCancionA).getNombreCancion());
            setImagenLabel(jblImagenCancionA, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));

        }
    }//GEN-LAST:event_btnAvanzarCancionActionPerformed


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarAlbum;
    private javax.swing.JButton btnAvanzarCancion;
    private javax.swing.JButton btnMostrarTodosIntegrantes;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetrocederAlbum;
    private javax.swing.JButton btnRetrocederCancion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jblAlbumes;
    private javax.swing.JLabel jblCanciones;
    private javax.swing.JLabel jblGenero;
    private javax.swing.JLabel jblImagenAlbumA;
    private javax.swing.JLabel jblImagenAlbumB;
    private javax.swing.JLabel jblImagenAlbumC;
    private javax.swing.JLabel jblImagenArtista;
    private javax.swing.JLabel jblImagenCancionA;
    private javax.swing.JLabel jblImagenCancionB;
    private javax.swing.JLabel jblImagenCancionC;
    private javax.swing.JLabel jblNombreAlbumA;
    private javax.swing.JLabel jblNombreAlbumB;
    private javax.swing.JLabel jblNombreAlbumC;
    private javax.swing.JLabel jblNombreArtista;
    private javax.swing.JLabel jblNombreCancionA;
    private javax.swing.JLabel jblNombreCancionB;
    private javax.swing.JLabel jblNombreCancionC;
    private javax.swing.JLabel jblNombresIntegrantes;
    // End of variables declaration//GEN-END:variables
}
