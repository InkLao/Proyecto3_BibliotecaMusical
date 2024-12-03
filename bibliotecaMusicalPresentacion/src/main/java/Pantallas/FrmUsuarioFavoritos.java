/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import dtos.AlbumDTO;
import dtos.ArtistaDTO;
import dtos.CancionDTO;
import dtos.FavoritoDTO;
import dtos.FavoritosDTO;
import dtos.UsuarioDTO;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import negocio.ArtistaNegocio;
import negocio.FavoritosNegocio;
import negocio.GeneroNoDeseadoNegocio;
import negocio.IArtistaNegocio;
import negocio.IFavoritosNegocio;
import negocio.IGeneroNoDeseadoNegocio;

/**
 *
 * @author Arturo ITSON
 */
public class FrmUsuarioFavoritos extends javax.swing.JFrame {

    FrmUsuarioPerfil perfil;

    UsuarioDTO usuarioDTO;
    static List<ArtistaDTO> artistas;
    static List<AlbumDTO> albumes;
    static List<CancionDTO> canciones;
    static List<FavoritoDTO> favoritos;
    static List<String> generoNoDeseado;

    static int indiceArtistaA = 0;
    static int indiceArtistaB = 1;
    static int indiceArtistaC = 2;

    static int indiceAlbumA = 0;
    static int indiceAlbumB = 1;
    static int indiceAlbumC = 2;

    static int indiceCancionA = 0;
    static int indiceCancionB = 1;
    static int indiceCancionC = 2;

    IArtistaNegocio negocio = new ArtistaNegocio();
    IFavoritosNegocio favoritosNegocio = new FavoritosNegocio();
    IGeneroNoDeseadoNegocio generoNoDeseadoNegocio = new GeneroNoDeseadoNegocio();
    DlgFiltrosUsuarioFavoritos filtrosBuscador = new DlgFiltrosUsuarioFavoritos(this, true, this);

    /**
     * Creates new form FrmBuscador
     */
    public FrmUsuarioFavoritos(FrmUsuarioPerfil perfil, UsuarioDTO usuarioDTO) {
        this.perfil = perfil;
        this.usuarioDTO = usuarioDTO;

        initComponents();

        btnRetrocederAlbum.setEnabled(false);
        btnRetrocederArtista.setEnabled(false);
        btnRetrocederCancion.setEnabled(false);

        obtenerDatos();
        cargarDatos();
    }

    public void obtenerDatos() {
        favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(String.valueOf(usuarioDTO.getId()));
        System.out.println("Favoritos obtenidos: " + favoritos);

        List<ArtistaDTO> todosArtistas = negocio.obtenerTodos();
        System.out.println("Artistas obtenidos: " + todosArtistas);

        List<AlbumDTO> todosAlbumes = negocio.obtenerTodosAlbumesEnArtista();
        System.out.println("Álbumes obtenidos: " + todosAlbumes);

        List<CancionDTO> todasCanciones = negocio.obtenerTodasCancionesEnArtista();
        System.out.println("Canciones obtenidas: " + todasCanciones);

        System.out.println("Favoritos obtenidos de la base de datos: " + favoritos);
        System.out.println("Cantidad de favoritos obtenidos: " + favoritos.size());
        favoritos.forEach(favorito -> System.out.println(favorito.toString()));

        // Filtrar favoritos
        artistas = filtrarFavoritosArtistas(todosArtistas, favoritos);
        albumes = filtrarFavoritosAlbumes(todosAlbumes, favoritos);
        canciones = filtrarFavoritosCanciones(todasCanciones, favoritos);

        System.out.println("Artistas favoritos: " + artistas);
        System.out.println("Álbumes favoritos: " + albumes);
        System.out.println("Canciones favoritas: " + canciones);
    }

// Métodos de filtrado
    private List<ArtistaDTO> filtrarFavoritosArtistas(List<ArtistaDTO> todosArtistas, List<FavoritoDTO> favoritos) {
        List<ArtistaDTO> artistasFavoritos = new ArrayList<>();
        for (ArtistaDTO artista : todosArtistas) {
            if (buscarFavorito(favoritos, artista.getIdDos())) {
                artistasFavoritos.add(artista);
            }
        }
        return artistasFavoritos;
    }

    private List<AlbumDTO> filtrarFavoritosAlbumes(List<AlbumDTO> todosAlbumes, List<FavoritoDTO> favoritos) {
        List<AlbumDTO> albumesFavoritos = new ArrayList<>();
        for (AlbumDTO album : todosAlbumes) {
            if (buscarFavorito(favoritos, album.getIdAlbum())) {
                albumesFavoritos.add(album);
            }
        }
        return albumesFavoritos;
    }

    private List<CancionDTO> filtrarFavoritosCanciones(List<CancionDTO> todasCanciones, List<FavoritoDTO> favoritos) {
        List<CancionDTO> cancionesFavoritas = new ArrayList<>();
        for (CancionDTO cancion : todasCanciones) {
            if (buscarFavorito(favoritos, cancion.getIdCancion())) {
                cancionesFavoritas.add(cancion);
            }
        }
        return cancionesFavoritas;
    }

    public void cargarDatos() {

        if (artistas.isEmpty() || albumes.isEmpty() || canciones.isEmpty()) {
            System.out.println("Una de las listas está vacía.");
            return;
        }

        jblCantidadArtistas.setText("Artistas: " + artistas.size());
        jblCantidadAlbumes.setText("Albumes: " + albumes.size());
        jblCantidadCanciones.setText("Canciones: " + canciones.size());

        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            if (artistas.get(indiceArtistaA) != null) {

                jblNombreArtista1.setText(artistas.get(indiceArtistaA).getNombreArtista());
                setImagenLabel(jblArtista1, artistas.get(indiceArtistaA).getImagen());
                if (buscarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos())) {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {

                    if (artistas.get(indiceArtistaB) != null) {

                        jblNombreArtista2.setText(artistas.get(indiceArtistaB).getNombreArtista());
                        setImagenLabel(jblArtista2, artistas.get(indiceArtistaB).getImagen());
                        if (buscarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos())) {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {

                            if (artistas.get(indiceArtistaC) != null) {

                                jblNombreArtista3.setText(artistas.get(indiceArtistaC).getNombreArtista());
                                setImagenLabel(jblArtista3, artistas.get(indiceArtistaC).getImagen());
                                if (buscarFavorito(favoritos, artistas.get(indiceArtistaC).getIdDos())) {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {

                            System.out.println(e.getMessage());
                            jblNombreArtista3.setText("sin datos");
                            setImagenLabel(jblArtista3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                            jblNombreAlbum3.setText("sin datos");
                            setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                            jblNombreCancion3.setText("sin datos");
                            setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    jblNombreArtista2.setText("sin datos");
                    setImagenLabel(jblArtista2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreArtista3.setText("sin datos");
                    setImagenLabel(jblArtista3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreAlbum1.setText("sin datos");
                    setImagenLabel(jblAlbum1, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreAlbum2.setText("sin datos");
                    setImagenLabel(jblAlbum2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreAlbum3.setText("sin datos");
                    setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreCancion1.setText("sin datos");
                    setImagenLabel(jblCancion1, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreCancion2.setText("sin datos");
                    setImagenLabel(jblCancion2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreCancion3.setText("sin datos");
                    setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            jblNombreArtista1.setText("sin datos");
            setImagenLabel(jblArtista1, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreArtista2.setText("sin datos");
            setImagenLabel(jblArtista2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreArtista3.setText("sin datos");
            setImagenLabel(jblArtista3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreAlbum2.setText("sin datos");
            setImagenLabel(jblAlbum2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreAlbum3.setText("sin datos");
            setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreCancion2.setText("sin datos");
            setImagenLabel(jblCancion2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreCancion3.setText("sin datos");
            setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }

        // cargar albumes
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            if (albumes.get(indiceAlbumA) != null) {

                jblNombreAlbum1.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblAlbum1, albumes.get(indiceAlbumA).getImagen());
                if (buscarFavorito(favoritos, albumes.get(indiceAlbumA).getIdAlbum())) {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {

                    if (albumes.get(indiceAlbumB) != null) {

                        jblNombreAlbum2.setText(albumes.get(indiceAlbumB).getNombre());
                        setImagenLabel(jblAlbum2, albumes.get(indiceAlbumB).getImagen());
                        if (buscarFavorito(favoritos, albumes.get(indiceAlbumB).getIdAlbum())) {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {

                            if (albumes.get(indiceAlbumC) != null) {

                                jblNombreAlbum3.setText(albumes.get(indiceAlbumC).getNombre());
                                setImagenLabel(jblAlbum3, albumes.get(indiceAlbumC).getImagen());
                                if (buscarFavorito(favoritos, albumes.get(indiceAlbumC).getIdAlbum())) {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("albumC " + e.getMessage());
                            jblNombreAlbum3.setText("sin datos");
                            setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    System.out.println("albumB " + e.getMessage());
                    jblNombreAlbum2.setText("sin datos");
                    setImagenLabel(jblAlbum2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreAlbum3.setText("sin datos");
                    setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            jblNombreAlbum1.setText("sin datos");
            setImagenLabel(jblAlbum1, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreAlbum2.setText("sin datos");
            setImagenLabel(jblAlbum2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreAlbum3.setText("sin datos");
            setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }

        //cargar canciones
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            if (canciones.get(indiceCancionA) != null) {

                jblNombreCancion1.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblCancion1, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
                if (buscarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion())) {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {

                    if (canciones.get(indiceCancionB) != null) {

                        jblNombreCancion2.setText(canciones.get(indiceCancionB).getNombreCancion());
                        setImagenLabel(jblCancion2, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                        if (buscarFavorito(favoritos, canciones.get(indiceCancionB).getIdCancion())) {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            if (canciones.get(indiceCancionC) != null) {

                                jblNombreCancion3.setText(canciones.get(indiceCancionC).getNombreCancion());
                                setImagenLabel(jblCancion3, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                                if (buscarFavorito(favoritos, canciones.get(indiceCancionC).getIdCancion())) {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            jblNombreCancion3.setText("sin datos");
                            setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    jblNombreCancion2.setText("sin datos");
                    setImagenLabel(jblCancion2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreCancion3.setText("sin datos");
                    setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            jblNombreCancion1.setText("sin datos");
            setImagenLabel(jblCancion1, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreCancion2.setText("sin datos");
            setImagenLabel(jblCancion2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            jblNombreCancion3.setText("sin datos");
            setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
            setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }

    }

    private boolean buscarFavorito(List<FavoritoDTO> favoritos, String id) {
        for (FavoritoDTO favorito : favoritos) {
            if (favorito.getIdFavorito().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminarFavorito(List<FavoritoDTO> favorito, String id) {
        Iterator<FavoritoDTO> iterator = favoritos.iterator();

        while (iterator.hasNext()) {
            FavoritoDTO favoritoss = iterator.next();
            if (favoritoss.getIdFavorito().equalsIgnoreCase(id)) { // Ignora mayúsculas y minúsculas
                iterator.remove();
                return true; // Indica que si se encontro el favorito el
            }
        }

        return false;
    }

    public boolean eliminarAlbum(List<AlbumDTO> album) {
        Iterator<AlbumDTO> iterator = albumes.iterator();

        while (iterator.hasNext()) {
            AlbumDTO albu = iterator.next();
            if (generoNoDeseado.contains(albu.getGenero())) {
                iterator.remove();
                return true; // Indica que si se encontro el favorito el
            }
        }

        return false;
    }

    public boolean eliminarArtista(List<ArtistaDTO> artista) {
        Iterator<ArtistaDTO> iterator = artistas.iterator();

        while (iterator.hasNext()) {
            ArtistaDTO arti = iterator.next();
            if (generoNoDeseado.contains(arti.getGenero())) {
                iterator.remove();
                return true; // 
            }
        }

        return false;
    }

    public boolean eliminarCancionPorBusqueda(String texto) {
        Iterator<CancionDTO> iterator = canciones.iterator();

        while (iterator.hasNext()) {
            CancionDTO canci = iterator.next();
            if (!canci.getNombreCancion().equalsIgnoreCase(texto)) {
                iterator.remove();
                return true; // 
            }
        }

        return false;
    }

    public boolean eliminarAlbumPorBusqueda(String texto) {
        Iterator<AlbumDTO> iterator = albumes.iterator();

        while (iterator.hasNext()) {
            AlbumDTO albu = iterator.next();
            if (!albu.getNombre().equalsIgnoreCase(texto)) {
                iterator.remove();
                return true; // Indica que si se encontro el favorito el
            }
        }

        return false;
    }

    public boolean eliminarArtistaPorBusqueda(String texto) {
        Iterator<ArtistaDTO> iterator = artistas.iterator();

        while (iterator.hasNext()) {
            ArtistaDTO arti = iterator.next();
            if (!arti.getNombreArtista().equalsIgnoreCase(texto)) {
                iterator.remove();
                return true; // 
            }
        }

        return false;
    }

    public boolean existeCancion(String texto) {
        Iterator<CancionDTO> iterator = canciones.iterator();

        while (iterator.hasNext()) {
            CancionDTO canci = iterator.next();
            if (canci.getNombreCancion().equalsIgnoreCase(texto)) {
                return true; // 
            }
        }

        return false;
    }

    public boolean existeAlbum(String texto) {
        Iterator<AlbumDTO> iterator = albumes.iterator();

        while (iterator.hasNext()) {
            AlbumDTO albu = iterator.next();
            if (!albu.getNombre().equalsIgnoreCase(texto)) {
                return true; //
            }
        }

        return false;
    }

    public boolean existeArtista(String texto) {
        Iterator<ArtistaDTO> iterator = artistas.iterator();

        while (iterator.hasNext()) {
            ArtistaDTO arti = iterator.next();
            if (!arti.getNombreArtista().equalsIgnoreCase(texto)) {
                return true; // 
            }
        }

        return false;
    }

    public boolean existeGeneroAlbum(String texto) {
        Iterator<AlbumDTO> iterator = albumes.iterator();

        while (iterator.hasNext()) {
            AlbumDTO albu = iterator.next();
            if (!albu.getGenero().equalsIgnoreCase(texto)) {
                return true; //
            }
        }

        return false;
    }

    public boolean existeGeneroArtista(String texto) {
        Iterator<ArtistaDTO> iterator = artistas.iterator();

        while (iterator.hasNext()) {
            ArtistaDTO arti = iterator.next();
            if (!arti.getGenero().equalsIgnoreCase(texto)) {
                return true; // 
            }
        }

        return false;
    }

    /**
     * Metodo que coloca una imagen un jbl
     *
     * @param nombreJlb el jlabel que sera reemplazado por una imagen
     * @param ruta la direccion donde se encuentra la imagen
     */
    private void setImagenLabel(JLabel nombreJlb, String ruta) {

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

        jSpinner1 = new javax.swing.JSpinner();
        jblNombreArtista5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscador = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jblBuscar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnFiltros = new javax.swing.JButton();
        jblFormatoFecha = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jblArtistas = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnRetrocederArtista = new javax.swing.JButton();
        btnAvanzarArtista = new javax.swing.JButton();
        jblArtista1 = new javax.swing.JLabel();
        jblArtista2 = new javax.swing.JLabel();
        jblArtista3 = new javax.swing.JLabel();
        jblNombreArtista1 = new javax.swing.JLabel();
        jblNombreArtista2 = new javax.swing.JLabel();
        jblNombreArtista3 = new javax.swing.JLabel();
        jblArtistaFavorito1 = new javax.swing.JLabel();
        jblArtistaFavorito2 = new javax.swing.JLabel();
        jblArtistaFavorito3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnRetrocederAlbum = new javax.swing.JButton();
        btnAvanzarAlbum = new javax.swing.JButton();
        jblAlbum1 = new javax.swing.JLabel();
        jblAlbum2 = new javax.swing.JLabel();
        jblAlbum3 = new javax.swing.JLabel();
        jblNombreAlbum1 = new javax.swing.JLabel();
        jblNombreAlbum2 = new javax.swing.JLabel();
        jblNombreAlbum3 = new javax.swing.JLabel();
        jblAlbumFavorito1 = new javax.swing.JLabel();
        jblAlbumFavorito2 = new javax.swing.JLabel();
        jblAlbumFavorito3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnRetrocederCancion = new javax.swing.JButton();
        btnAvanzarCancion = new javax.swing.JButton();
        jblCancion1 = new javax.swing.JLabel();
        jblCancion2 = new javax.swing.JLabel();
        jblCancion3 = new javax.swing.JLabel();
        jblNombreCancion1 = new javax.swing.JLabel();
        jblNombreCancion2 = new javax.swing.JLabel();
        jblNombreCancion3 = new javax.swing.JLabel();
        jblCancionFavorito1 = new javax.swing.JLabel();
        jblCancionFavorito2 = new javax.swing.JLabel();
        jblCancionFavorito3 = new javax.swing.JLabel();
        jblAlbumes = new javax.swing.JLabel();
        jblCanciones = new javax.swing.JLabel();
        jblCantidadArtistas = new javax.swing.JLabel();
        jblCantidadAlbumes = new javax.swing.JLabel();
        jblCantidadCanciones = new javax.swing.JLabel();

        jblNombreArtista5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscador");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setPreferredSize(new java.awt.Dimension(475, 76));

        btnBuscador.setBackground(new java.awt.Color(8, 148, 249));
        btnBuscador.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBuscador.setText("Buscador");
        btnBuscador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscadorActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(217, 217, 217));
        btnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPerfil.setText("Perfil");
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 235, Short.MAX_VALUE)
                .addComponent(btnBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 243, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblBuscar.setText("Buscar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnFiltros.setText("Filtros");
        btnFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrosActionPerformed(evt);
            }
        });

        jblFormatoFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jblBuscar)
                        .addGap(42, 42, 42)
                        .addComponent(jblFormatoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltros))
                    .addComponent(txtBuscar))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblBuscar)
                    .addComponent(btnFiltros)
                    .addComponent(jblFormatoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(14, 14, 14))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jblArtistas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblArtistas.setText("Artistas");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnRetrocederArtista.setBackground(new java.awt.Color(8, 148, 249));
        btnRetrocederArtista.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnRetrocederArtista.setText("<");
        btnRetrocederArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederArtistaActionPerformed(evt);
            }
        });

        btnAvanzarArtista.setBackground(new java.awt.Color(8, 148, 249));
        btnAvanzarArtista.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAvanzarArtista.setText(">");
        btnAvanzarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarArtistaActionPerformed(evt);
            }
        });

        jblArtista1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblArtista1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtista1MouseClicked(evt);
            }
        });

        jblArtista2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblArtista2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtista2MouseClicked(evt);
            }
        });

        jblArtista3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblArtista3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtista3MouseClicked(evt);
            }
        });

        jblNombreArtista1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreArtista1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreArtista2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreArtista2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreArtista3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreArtista3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblArtistaFavorito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtistaFavorito1MouseClicked(evt);
            }
        });

        jblArtistaFavorito2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtistaFavorito2MouseClicked(evt);
            }
        });

        jblArtistaFavorito3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblArtistaFavorito3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnRetrocederArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblNombreArtista1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jblArtista1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jblArtistaFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblArtista2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreArtista2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblArtistaFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jblNombreArtista3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAvanzarArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jblArtista3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblArtistaFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jblArtistaFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblArtista3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jblArtistaFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jblArtista1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jblArtistaFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jblArtista2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblNombreArtista1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAvanzarArtista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jblNombreArtista2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreArtista3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRetrocederArtista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnRetrocederAlbum.setBackground(new java.awt.Color(8, 148, 249));
        btnRetrocederAlbum.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnRetrocederAlbum.setText("<");
        btnRetrocederAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederAlbumActionPerformed(evt);
            }
        });

        btnAvanzarAlbum.setBackground(new java.awt.Color(8, 148, 249));
        btnAvanzarAlbum.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAvanzarAlbum.setText(">");
        btnAvanzarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarAlbumActionPerformed(evt);
            }
        });

        jblAlbum1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblAlbum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbum1MouseClicked(evt);
            }
        });

        jblAlbum2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblAlbum2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbum2MouseClicked(evt);
            }
        });

        jblAlbum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblAlbum3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblAlbum3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbum3MouseClicked(evt);
            }
        });

        jblNombreAlbum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreAlbum1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreAlbum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreAlbum2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreAlbum3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblAlbumFavorito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbumFavorito1MouseClicked(evt);
            }
        });

        jblAlbumFavorito2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbumFavorito2MouseClicked(evt);
            }
        });

        jblAlbumFavorito3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAlbumFavorito3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRetrocederAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jblAlbum1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jblAlbumFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jblNombreAlbum1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblAlbum2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblNombreAlbum2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblAlbumFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jblNombreAlbum3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnAvanzarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jblAlbum3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblAlbumFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblAlbum3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblAlbum1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jblAlbum2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jblAlbumFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jblAlbumFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jblNombreAlbum1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAvanzarAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRetrocederAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jblNombreAlbum2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblNombreAlbum3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jblAlbumFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnRetrocederCancion.setBackground(new java.awt.Color(8, 148, 249));
        btnRetrocederCancion.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnRetrocederCancion.setText("<");
        btnRetrocederCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederCancionActionPerformed(evt);
            }
        });

        btnAvanzarCancion.setBackground(new java.awt.Color(8, 148, 249));
        btnAvanzarCancion.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAvanzarCancion.setText(">");
        btnAvanzarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarCancionActionPerformed(evt);
            }
        });

        jblCancion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblCancion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancion1MouseClicked(evt);
            }
        });

        jblCancion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblCancion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancion2MouseClicked(evt);
            }
        });

        jblCancion3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jblCancion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancion3MouseClicked(evt);
            }
        });

        jblNombreCancion1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jblNombreCancion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreCancion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreCancion2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jblNombreCancion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreCancion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblNombreCancion3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jblNombreCancion3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreCancion3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jblCancionFavorito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancionFavorito1MouseClicked(evt);
            }
        });

        jblCancionFavorito2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancionFavorito2MouseClicked(evt);
            }
        });

        jblCancionFavorito3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblCancionFavorito3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRetrocederCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblNombreCancion1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblCancion1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblCancionFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jblCancion2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblCancionFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jblNombreCancion2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jblNombreCancion3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnAvanzarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jblCancion3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblCancionFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblCancionFavorito3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblCancion2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblCancion1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblCancion3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblCancionFavorito2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblNombreCancion3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jblNombreCancion1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblNombreCancion2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRetrocederCancion)
                                        .addComponent(btnAvanzarCancion))))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jblCancionFavorito1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jblAlbumes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblAlbumes.setText("Albumes");

        jblCanciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblCanciones.setText("Canciones");

        jblCantidadArtistas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblCantidadArtistas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jblCantidadArtistas.setText("jLabel1");

        jblCantidadAlbumes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblCantidadAlbumes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jblCantidadAlbumes.setText("jLabel1");

        jblCantidadCanciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblCantidadCanciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jblCantidadCanciones.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jblCanciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblCantidadCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jblAlbumes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblCantidadAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jblArtistas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblCantidadArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblArtistas)
                    .addComponent(jblCantidadArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jblAlbumes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblCantidadAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblCanciones)
                    .addComponent(jblCantidadCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(123, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(634, Short.MAX_VALUE)))
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

    private void btnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscadorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnBuscadorActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:

        perfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void jblArtista1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtista1MouseClicked
        // TODO add your handling code here:
        if (jblNombreArtista1.getText().equalsIgnoreCase("sin datos")) {

        } else {
            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtista(artistas.get(indiceArtistaA).getId());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, null, usuarioDTO);
            perfilArtista.setVisible(true);
        }
    }//GEN-LAST:event_jblArtista1MouseClicked

    private void btnAvanzarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarArtistaActionPerformed
        // TODO add your handling code here:
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnRetrocederArtista.setEnabled(true);
            indiceArtistaA = indiceArtistaA + 3;
            if (artistas.get(indiceArtistaA) != null) {

                jblNombreArtista1.setText(artistas.get(indiceArtistaA).getNombreArtista());
                setImagenLabel(jblArtista1, artistas.get(indiceArtistaA).getImagen());
                if (buscarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos())) {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    indiceArtistaB = indiceArtistaB + 3;
                    if (artistas.get(indiceArtistaB) != null) {

                        jblNombreArtista2.setText(artistas.get(indiceArtistaB).getNombreArtista());
                        setImagenLabel(jblArtista2, artistas.get(indiceArtistaB).getImagen());
                        if (buscarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos())) {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceArtistaC = indiceArtistaC + 3;
                            if (artistas.get(indiceArtistaC) != null) {

                                jblNombreArtista3.setText(artistas.get(indiceArtistaC).getNombreArtista());
                                setImagenLabel(jblArtista3, artistas.get(indiceArtistaC).getImagen());
                                if (buscarFavorito(favoritos, artistas.get(indiceArtistaC).getIdDos())) {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {
                            btnRetrocederArtista.setEnabled(true);
                            btnAvanzarArtista.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceArtistaC = indiceArtistaC - 3;
                            jblNombreArtista3.setText("sin datos");
                            setImagenLabel(jblArtista3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    btnRetrocederArtista.setEnabled(true);
                    btnAvanzarArtista.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceArtistaB = indiceArtistaB - 3;
                    jblNombreArtista2.setText("sin datos");
                    setImagenLabel(jblArtista2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    jblNombreArtista3.setText("sin datos");
                    setImagenLabel(jblArtista3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            btnRetrocederArtista.setEnabled(true);
            btnAvanzarArtista.setEnabled(false);
            JOptionPane.showMessageDialog(this, "No hay mas artistas", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceArtistaA = indiceArtistaA - 3;
            jblNombreArtista1.setText(artistas.get(indiceArtistaA).getNombreArtista());
            setImagenLabel(jblArtista1, artistas.get(indiceArtistaA).getImagen());
            setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }


    }//GEN-LAST:event_btnAvanzarArtistaActionPerformed

    private void btnAvanzarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarCancionActionPerformed
        // TODO add your handling code here:

        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnRetrocederCancion.setEnabled(true);
            indiceCancionA = indiceCancionA + 3;
            if (canciones.get(indiceCancionA) != null) {

                jblNombreCancion1.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblCancion1, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
                if (buscarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion())) {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    System.out.println("indice cacnion a" + indiceCancionA);
                    indiceCancionB = indiceCancionB + 3;
                    if (canciones.get(indiceCancionB) != null) {

                        jblNombreCancion2.setText(canciones.get(indiceCancionB).getNombreCancion());
                        setImagenLabel(jblCancion2, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                        if (buscarFavorito(favoritos, canciones.get(indiceCancionB).getIdCancion())) {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceCancionC = indiceCancionC + 3;
                            if (canciones.get(indiceCancionC) != null) {

                                jblNombreCancion3.setText(canciones.get(indiceCancionC).getNombreCancion());
                                setImagenLabel(jblCancion3, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                                if (buscarFavorito(favoritos, canciones.get(indiceCancionC).getIdCancion())) {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }

                            }
                        } catch (Exception e) {
                            btnAvanzarCancion.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceCancionC = indiceCancionC - 3;
                            jblNombreCancion3.setText("sin datos");
                            setImagenLabel(jblCancion3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    btnAvanzarCancion.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceCancionB = indiceCancionB - 3;
                    jblNombreCancion2.setText("sin datos");
                    setImagenLabel(jblCancion2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            btnAvanzarCancion.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas canciones", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceCancionA = indiceCancionA - 3;
            jblNombreCancion1.setText(canciones.get(indiceCancionA).getNombreCancion());
            setImagenLabel(jblCancion1, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
            setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }
    }//GEN-LAST:event_btnAvanzarCancionActionPerformed

    private void btnAvanzarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarAlbumActionPerformed
        // TODO add your handling code here:
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnRetrocederAlbum.setEnabled(true);
            indiceAlbumA = indiceAlbumA + 3;
            if (albumes.get(indiceAlbumA) != null) {

                jblNombreAlbum1.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblAlbum1, albumes.get(indiceAlbumA).getImagen());
                if (buscarFavorito(favoritos, albumes.get(indiceAlbumA).getIdAlbum())) {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    System.out.println("indice album a" + indiceAlbumA);
                    indiceAlbumB = indiceAlbumB + 3;
                    if (albumes.get(indiceAlbumB) != null) {

                        jblNombreAlbum2.setText(albumes.get(indiceAlbumB).getNombre());
                        setImagenLabel(jblAlbum2, albumes.get(indiceAlbumB).getImagen());
                        if (buscarFavorito(favoritos, albumes.get(indiceAlbumB).getIdAlbum())) {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceAlbumC = indiceAlbumC + 3;
                            if (albumes.get(indiceAlbumC) != null) {

                                jblNombreAlbum3.setText(albumes.get(indiceAlbumC).getNombre());
                                setImagenLabel(jblAlbum3, albumes.get(indiceAlbumC).getImagen());
                                if (buscarFavorito(favoritos, albumes.get(indiceAlbumC).getIdAlbum())) {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {
                            btnAvanzarAlbum.setEnabled(false);
                            System.out.println("albumC " + e.getMessage());
                            indiceAlbumC = indiceAlbumC - 3;
                            jblNombreAlbum3.setText("sin datos");
                            setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    btnAvanzarAlbum.setEnabled(false);
                    System.out.println("albumB " + e.getMessage());
                    // indiceAlbumB = indiceAlbumB - 3;
                    jblNombreAlbum2.setText("sin datos");
                    setImagenLabel(jblAlbum2, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");

                    System.out.println(indiceAlbumA + "," + indiceAlbumB + "," + indiceAlbumC);

                    jblNombreAlbum3.setText("sin datos");
                    setImagenLabel(jblAlbum3, "src/main/java/ImagenesProyecto/NoImagen.jpg");
                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            btnAvanzarAlbum.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas albumes", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceAlbumA = indiceAlbumA - 3;
            jblNombreAlbum1.setText(albumes.get(indiceAlbumA).getNombre());
            setImagenLabel(jblAlbum1, albumes.get(indiceAlbumA).getImagen());
            setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }


    }//GEN-LAST:event_btnAvanzarAlbumActionPerformed

    private void btnRetrocederCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederCancionActionPerformed
        // TODO add your handling code here:
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnAvanzarCancion.setEnabled(true);
            indiceCancionA = indiceCancionA - 3;
            if (canciones.get(indiceCancionA) != null) {

                jblNombreCancion1.setText(canciones.get(indiceCancionA).getNombreCancion());
                setImagenLabel(jblCancion1, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
                if (buscarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion())) {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    System.out.println("indice cacnion a" + indiceCancionA);
                    indiceCancionB = indiceCancionB - 3;
                    if (canciones.get(indiceCancionB) != null) {

                        jblNombreCancion2.setText(canciones.get(indiceCancionB).getNombreCancion());
                        setImagenLabel(jblCancion2, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                        if (buscarFavorito(favoritos, canciones.get(indiceCancionB).getIdCancion())) {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceCancionC = indiceCancionC - 3;
                            if (canciones.get(indiceCancionC) != null) {

                                jblNombreCancion3.setText(canciones.get(indiceCancionC).getNombreCancion());
                                setImagenLabel(jblCancion3, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                                if (buscarFavorito(favoritos, canciones.get(indiceCancionC).getIdCancion())) {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }

                            }
                        } catch (Exception e) {
                            btnRetrocederCancion.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceCancionC = 2;
                            jblNombreCancion3.setText(canciones.get(indiceCancionC).getNombreCancion());
                            setImagenLabel(jblCancion3, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionC).getIdCancion()));
                        }

                    }
                } catch (Exception e) {
                    btnRetrocederCancion.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceCancionB = 1;
                    jblNombreCancion2.setText(canciones.get(indiceCancionB).getNombreCancion());
                    setImagenLabel(jblCancion2, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionB).getIdCancion()));
                    setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            btnRetrocederCancion.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas canciones", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
            indiceCancionA = 0;
            jblNombreCancion1.setText(canciones.get(indiceCancionA).getNombreCancion());
            setImagenLabel(jblCancion1, negocio.obtenerImagenPorIdCancion(canciones.get(indiceCancionA).getIdCancion()));
            if (buscarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion())) {
                setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
            } else {
                setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            }

        }


    }//GEN-LAST:event_btnRetrocederCancionActionPerformed

    private void btnRetrocederAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederAlbumActionPerformed
        // TODO add your handling code here:
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnAvanzarAlbum.setEnabled(true);
            indiceAlbumA = indiceAlbumA - 3;
            if (albumes.get(indiceAlbumA) != null) {

                jblNombreAlbum1.setText(albumes.get(indiceAlbumA).getNombre());
                setImagenLabel(jblAlbum1, albumes.get(indiceAlbumA).getImagen());
                if (buscarFavorito(favoritos, albumes.get(indiceAlbumA).getIdAlbum())) {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    System.out.println("indice album a" + indiceCancionA);
                    indiceAlbumB = indiceAlbumB - 3;
                    if (albumes.get(indiceAlbumB) != null) {

                        jblNombreAlbum2.setText(albumes.get(indiceAlbumB).getNombre());
                        setImagenLabel(jblAlbum2, albumes.get(indiceAlbumB).getImagen());
                        if (buscarFavorito(favoritos, albumes.get(indiceAlbumB).getIdAlbum())) {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceAlbumC = indiceAlbumC - 3;
                            if (albumes.get(indiceAlbumC) != null) {

                                jblNombreAlbum3.setText(albumes.get(indiceAlbumC).getNombre());
                                setImagenLabel(jblAlbum3, albumes.get(indiceAlbumC).getImagen());
                                if (buscarFavorito(favoritos, albumes.get(indiceAlbumC).getIdAlbum())) {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {
                            btnRetrocederAlbum.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceAlbumC = 2;
                            jblNombreAlbum3.setText(albumes.get(indiceAlbumC).getNombre());
                            setImagenLabel(jblAlbum3, albumes.get(indiceAlbumC).getImagen());
                            setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Album b");
                    btnRetrocederAlbum.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceAlbumB = 1;
                    jblNombreAlbum2.setText(albumes.get(indiceAlbumB).getNombre());
                    setImagenLabel(jblAlbum2, albumes.get(indiceAlbumB).getImagen());
                    setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

            }

        } catch (Exception e) {
            System.out.println("Album A");
            btnRetrocederAlbum.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas albumes", "Inicio de la lista", JOptionPane.ERROR_MESSAGE);
            indiceAlbumA = 0;
            jblNombreAlbum1.setText(albumes.get(indiceAlbumA).getNombre());
            setImagenLabel(jblAlbum1, albumes.get(indiceAlbumA).getImagen());
            setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");

        }

    }//GEN-LAST:event_btnRetrocederAlbumActionPerformed

    private void btnRetrocederArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederArtistaActionPerformed
        // TODO add your handling code here:
        try {

            favoritos = favoritosNegocio.obtenerFavoritosPorUsuario(usuarioDTO.getId().toString());

            btnAvanzarArtista.setEnabled(true);
            indiceArtistaA = indiceArtistaA - 3;
            if (artistas.get(indiceArtistaA) != null) {

                jblNombreArtista1.setText(artistas.get(indiceArtistaA).getNombreArtista());
                setImagenLabel(jblArtista1, artistas.get(indiceArtistaA).getImagen());
                if (buscarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos())) {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                } else {
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                }

                try {
                    indiceArtistaB = indiceArtistaB - 3;
                    if (artistas.get(indiceArtistaB) != null) {

                        jblNombreArtista2.setText(artistas.get(indiceArtistaB).getNombreArtista());
                        setImagenLabel(jblArtista2, artistas.get(indiceArtistaB).getImagen());
                        if (buscarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos())) {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                        } else {
                            setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                        try {
                            indiceArtistaC = indiceArtistaC - 3;
                            if (artistas.get(indiceArtistaC) != null) {

                                jblNombreArtista3.setText(artistas.get(indiceArtistaC).getNombreArtista());
                                setImagenLabel(jblArtista3, artistas.get(indiceArtistaC).getImagen());
                                if (buscarFavorito(favoritos, artistas.get(indiceArtistaC).getIdDos())) {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                                } else {
                                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                                }
                            }
                        } catch (Exception e) {
                            btnRetrocederArtista.setEnabled(false);
                            System.out.println(e.getMessage());
                            indiceArtistaC = 2;
                            jblNombreArtista3.setText(artistas.get(indiceArtistaC).getNombreArtista());
                            setImagenLabel(jblArtista3, artistas.get(indiceArtistaC).getImagen());
                            setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                        }

                    }
                } catch (Exception e) {
                    btnRetrocederArtista.setEnabled(false);
                    System.out.println(e.getMessage());
                    indiceArtistaB = 1;
                    jblNombreArtista2.setText(artistas.get(indiceArtistaB).getNombreArtista());
                    setImagenLabel(jblArtista2, artistas.get(indiceArtistaB).getImagen());
                    if (buscarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos())) {
                        setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                    } else {
                        setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    }
                }

            }

        } catch (Exception e) {
            btnRetrocederArtista.setEnabled(false);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "No hay mas artistas", "Fin de la lista", JOptionPane.ERROR_MESSAGE);
            indiceArtistaA = 0;
            jblNombreArtista1.setText(artistas.get(indiceArtistaA).getNombreArtista());
            setImagenLabel(jblArtista1, artistas.get(indiceArtistaA).getImagen());
            if (buscarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos())) {
                setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
            } else {
                setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
            }

        }
    }//GEN-LAST:event_btnRetrocederArtistaActionPerformed

    private void jblArtista2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtista2MouseClicked
        // TODO add your handling code here:

        if (jblArtista2.getText().equalsIgnoreCase("sin datos")) {

        } else {
            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtista(artistas.get(indiceArtistaB).getId());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, null, usuarioDTO);
            perfilArtista.setVisible(true);
        }
    }//GEN-LAST:event_jblArtista2MouseClicked

    private void jblArtista3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtista3MouseClicked
        // TODO add your handling code here:

        if (jblArtista3.getText().equalsIgnoreCase("sin datos")) {

        } else {
            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtista(artistas.get(indiceArtistaC).getId());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, null, usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblArtista3MouseClicked

    private void jblAlbum1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbum1MouseClicked
        // TODO add your handling code here:

        if (jblNombreAlbum1.getText().equalsIgnoreCase("sin datos")) {

        } else {
            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdAlbum(albumes.get(indiceAlbumA).getIdAlbum());

            AlbumDTO album = negocio.buscarAlbumPorId(albumes.get(indiceAlbumA).getIdAlbum());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, album.getIdAlbum(), null, usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblAlbum1MouseClicked

    private void jblAlbum2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbum2MouseClicked
        // TODO add your handling code here:

        if (jblNombreAlbum2.getText().equalsIgnoreCase("sin datos")) {

        } else {
            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdAlbum(albumes.get(indiceAlbumB).getIdAlbum());

            AlbumDTO album = negocio.buscarAlbumPorId(albumes.get(indiceAlbumB).getIdAlbum());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, album.getIdAlbum(), null, usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblAlbum2MouseClicked

    private void jblAlbum3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbum3MouseClicked
        // TODO add your handling code here:

        if (jblNombreAlbum3.getText().equalsIgnoreCase("sin datos")) {

        } else {

            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdAlbum(albumes.get(indiceAlbumC).getIdAlbum());

            AlbumDTO album = negocio.buscarAlbumPorId(albumes.get(indiceAlbumC).getIdAlbum());
            System.out.println("ss" + album.toString());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, album.getIdAlbum(), null, usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblAlbum3MouseClicked

    private void jblCancion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancion1MouseClicked
        // TODO add your handling code here:

        if (jblNombreCancion1.getText().equalsIgnoreCase("sin datos")) {

        } else {

            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdCancion(canciones.get(indiceCancionA).getIdCancion());

            CancionDTO cancion = negocio.buscarCancionPorId(canciones.get(indiceCancionA).getIdCancion());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, cancion.getIdCancion(), usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblCancion1MouseClicked

    private void jblCancion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancion2MouseClicked
        // TODO add your handling code here:

        if (jblNombreCancion2.getText().equalsIgnoreCase("sin datos")) {

        } else {

            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdCancion(canciones.get(indiceCancionB).getIdCancion());

            CancionDTO cancion = negocio.buscarCancionPorId(canciones.get(indiceCancionB).getIdCancion());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, cancion.getIdCancion(), usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblCancion2MouseClicked

    private void jblCancion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancion3MouseClicked
        // TODO add your handling code here:

        if (jblNombreCancion3.getText().equalsIgnoreCase("sin datos")) {

        } else {

            ArtistaDTO artista = new ArtistaDTO();
            artista = negocio.buscarArtistaPorIdCancion(canciones.get(indiceCancionC).getIdCancion());

            CancionDTO cancion = negocio.buscarCancionPorId(canciones.get(indiceCancionC).getIdCancion());

            FrmPerfilArtista perfilArtista = new FrmPerfilArtista(artista, null, cancion.getIdCancion(), usuarioDTO);
            perfilArtista.setVisible(true);
        }

    }//GEN-LAST:event_jblCancion3MouseClicked

    private void jblArtistaFavorito1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtistaFavorito1MouseClicked
        // TODO add your handling code here:

        try {
            if (buscarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + artistas.get(indiceArtistaA).getNombreArtista() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), artistas.get(indiceArtistaA).getIdDos());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, artistas.get(indiceArtistaA).getIdDos());
                    setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(artistas.get(indiceArtistaA).getIdDos());
                System.out.println(favo.getIdFavorito());
                System.out.println(usuarioDTO.getId());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblArtistaFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblArtistaFavorito1MouseClicked

    private void jblArtistaFavorito2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtistaFavorito2MouseClicked
        // TODO add your handling code here:

        try {
            if (buscarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + artistas.get(indiceArtistaB).getNombreArtista() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), artistas.get(indiceArtistaB).getIdDos());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, artistas.get(indiceArtistaB).getIdDos());
                    setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(artistas.get(indiceArtistaB).getIdDos());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblArtistaFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jblArtistaFavorito2MouseClicked

    private void jblArtistaFavorito3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblArtistaFavorito3MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, artistas.get(indiceArtistaC).getIdDos())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + artistas.get(indiceArtistaC).getNombreArtista() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), artistas.get(indiceArtistaC).getIdDos());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, artistas.get(indiceArtistaC).getIdDos());
                    setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(artistas.get(indiceArtistaC).getIdDos());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblArtistaFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jblArtistaFavorito3MouseClicked

    private void jblAlbumFavorito1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbumFavorito1MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, albumes.get(indiceAlbumA).getIdAlbum())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + albumes.get(indiceAlbumA).getNombre() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), albumes.get(indiceAlbumA).getIdAlbum());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, albumes.get(indiceAlbumA).getIdAlbum());
                    setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(albumes.get(indiceAlbumA).getIdAlbum());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblAlbumFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblAlbumFavorito1MouseClicked

    private void jblAlbumFavorito2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbumFavorito2MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, albumes.get(indiceAlbumB).getIdAlbum())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + albumes.get(indiceAlbumB).getNombre() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), albumes.get(indiceAlbumB).getIdAlbum());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, albumes.get(indiceAlbumB).getIdAlbum());
                    setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(albumes.get(indiceAlbumB).getIdAlbum());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblAlbumFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblAlbumFavorito2MouseClicked

    private void jblAlbumFavorito3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAlbumFavorito3MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, albumes.get(indiceAlbumC).getIdAlbum())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + albumes.get(indiceAlbumC).getNombre() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), albumes.get(indiceAlbumC).getIdAlbum());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, albumes.get(indiceAlbumC).getIdAlbum());
                    setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(albumes.get(indiceAlbumC).getIdAlbum());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblAlbumFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblAlbumFavorito3MouseClicked

    private void jblCancionFavorito1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancionFavorito1MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + canciones.get(indiceCancionA).getNombreCancion() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), canciones.get(indiceCancionA).getIdCancion());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, canciones.get(indiceCancionA).getIdCancion());
                    setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(canciones.get(indiceCancionA).getIdCancion());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblCancionFavorito1, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblCancionFavorito1MouseClicked

    private void jblCancionFavorito2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancionFavorito2MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, canciones.get(indiceCancionB).getIdCancion())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + canciones.get(indiceCancionB).getNombreCancion() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), canciones.get(indiceCancionB).getIdCancion());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, canciones.get(indiceCancionB).getIdCancion());
                    setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(canciones.get(indiceCancionB).getIdCancion());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblCancionFavorito2, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblCancionFavorito2MouseClicked

    private void jblCancionFavorito3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblCancionFavorito3MouseClicked
        // TODO add your handling code here:
        try {
            if (buscarFavorito(favoritos, canciones.get(indiceCancionC).getIdCancion())) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de quitar de favoritos a: " + canciones.get(indiceCancionC).getNombreCancion() + "?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    favoritosNegocio.eliminarFavorito(usuarioDTO.getId().toString(), canciones.get(indiceCancionC).getIdCancion());
                    JOptionPane.showMessageDialog(this, "Favorito eliminado");
                    eliminarFavorito(favoritos, canciones.get(indiceCancionC).getIdCancion());
                    setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoNo.png");
                    System.out.println("favorito eliminado");
                }
            } else {

                FavoritosDTO favoritoDTO = new FavoritosDTO();

                FavoritoDTO favo = new FavoritoDTO();

                favo.setFechaAgregacion(new Date());
                favo.setIdFavorito(canciones.get(indiceCancionC).getIdCancion());

                List<FavoritoDTO> lista = new ArrayList<>();
                lista.add(favo);

                favoritoDTO.setIdUsuario(usuarioDTO.getId().toString());
                favoritoDTO.setFavorito(lista);

                favoritosNegocio.actualizarFavoritos(favoritoDTO);
                setImagenLabel(jblCancionFavorito3, "src/main/java/ImagenesProyecto/FavoritoSi.png");
                System.out.println("Favorito agregado");
                favoritos.add(favo);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jblCancionFavorito3MouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        indiceAlbumA = 0;
        indiceAlbumB = 1;
        indiceAlbumC = 2;
        indiceArtistaA = 0;
        indiceArtistaB = 1;
        indiceArtistaC = 2;
        indiceCancionA = 0;
        indiceCancionB = 1;
        indiceCancionC = 2;

        obtenerDatos();

        String texto = txtBuscar.getText();

        if (texto.equalsIgnoreCase("")) {
            obtenerDatos();
            cargarDatos();

        } else {
            if (!filtrosBuscador.cbFecha.isSelected() && !filtrosBuscador.cbGeneroAlbum.isSelected() && !filtrosBuscador.cbNombreAlbum.isSelected()) {
                if (existeArtista(texto) || existeAlbum(texto) || existeCancion(texto) || existeGeneroArtista(texto) || existeGeneroAlbum(texto)) {
                    artistas.removeIf(ArtistaDTO -> !ArtistaDTO.getNombreArtista().equalsIgnoreCase(texto) && !ArtistaDTO.getGenero().equalsIgnoreCase(texto));
                    albumes.removeIf(AlbumesDTO -> !AlbumesDTO.getNombre().equalsIgnoreCase(texto) && !AlbumesDTO.getGenero().equalsIgnoreCase(texto));
                    canciones.removeIf(CancionDTO -> !CancionDTO.getNombreCancion().equalsIgnoreCase(texto));

                    cargarDatos();

                }
            }

            if (filtrosBuscador.cbNombreAlbum.isSelected()) {
                albumes.removeIf(AlbumesDTO -> !AlbumesDTO.getNombre().equalsIgnoreCase(texto));
                canciones.clear();
                artistas.clear();

                cargarDatos();
            }

            if (filtrosBuscador.cbGeneroAlbum.isSelected()) {
                albumes.removeIf(AlbumesDTO -> !AlbumesDTO.getGenero().equalsIgnoreCase(texto));
                canciones.clear();
                artistas.clear();

                cargarDatos();
            }

        }

        if (filtrosBuscador.cbFecha.isSelected()) {

            if (validarFormatoFecha(texto)) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                // Fecha proporcionada como String 2000-07-10
                String fechaString = "31/12/1999";

                try {
                    // Convertir String a Date (sin hora)

                    Date fechaComparacion = sdf.parse(fechaString);

                    System.out.println(fechaString);
                    System.out.println(sdf.format(albumes.get(0).getFechaLanzamiento()).toString());
                    System.out.println(fechaString.equalsIgnoreCase(sdf.format(albumes.get(0).getFechaLanzamiento()).toString()));
                    albumes.removeIf(AlbumDTO -> !texto.equalsIgnoreCase(sdf.format(AlbumDTO.getFechaLanzamiento()).toString()));
                    canciones.clear();
                    artistas.clear();

                } catch (ParseException ex) {
                    Logger.getLogger(FrmUsuarioFavoritos.class.getName()).log(Level.SEVERE, null, ex);
                }

                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Formato de fecha invalido", "Fecha Invalida", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrosActionPerformed
        // TODO add your handling code here:
        filtrosBuscador.setVisible(true);

    }//GEN-LAST:event_btnFiltrosActionPerformed

    public boolean validarFormatoFecha(String fecha) {

        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        return Pattern.matches(regex, fecha);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarAlbum;
    private javax.swing.JButton btnAvanzarArtista;
    private javax.swing.JButton btnAvanzarCancion;
    private javax.swing.JButton btnBuscador;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltros;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnRetrocederAlbum;
    private javax.swing.JButton btnRetrocederArtista;
    private javax.swing.JButton btnRetrocederCancion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel jblAlbum1;
    private javax.swing.JLabel jblAlbum2;
    private javax.swing.JLabel jblAlbum3;
    private javax.swing.JLabel jblAlbumFavorito1;
    private javax.swing.JLabel jblAlbumFavorito2;
    private javax.swing.JLabel jblAlbumFavorito3;
    private javax.swing.JLabel jblAlbumes;
    private javax.swing.JLabel jblArtista1;
    private javax.swing.JLabel jblArtista2;
    private javax.swing.JLabel jblArtista3;
    private javax.swing.JLabel jblArtistaFavorito1;
    private javax.swing.JLabel jblArtistaFavorito2;
    private javax.swing.JLabel jblArtistaFavorito3;
    private javax.swing.JLabel jblArtistas;
    private javax.swing.JLabel jblBuscar;
    private javax.swing.JLabel jblCancion1;
    private javax.swing.JLabel jblCancion2;
    private javax.swing.JLabel jblCancion3;
    private javax.swing.JLabel jblCancionFavorito1;
    private javax.swing.JLabel jblCancionFavorito2;
    private javax.swing.JLabel jblCancionFavorito3;
    private javax.swing.JLabel jblCanciones;
    private javax.swing.JLabel jblCantidadAlbumes;
    private javax.swing.JLabel jblCantidadArtistas;
    private javax.swing.JLabel jblCantidadCanciones;
    public javax.swing.JLabel jblFormatoFecha;
    private javax.swing.JLabel jblNombreAlbum1;
    private javax.swing.JLabel jblNombreAlbum2;
    private javax.swing.JLabel jblNombreAlbum3;
    private javax.swing.JLabel jblNombreArtista1;
    private javax.swing.JLabel jblNombreArtista2;
    private javax.swing.JLabel jblNombreArtista3;
    private javax.swing.JLabel jblNombreArtista5;
    private javax.swing.JLabel jblNombreCancion1;
    private javax.swing.JLabel jblNombreCancion2;
    private javax.swing.JLabel jblNombreCancion3;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
