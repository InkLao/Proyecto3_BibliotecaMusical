/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import colecciones.Album;
import colecciones.Albumes;
import colecciones.Artista;
import colecciones.Cancion;
import colecciones.Canciones;
import colecciones.Integrantes;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexionBD.ConexionBD;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Arturo ITSON
 */
public class ArtistaDAO implements IArtistaDAO {

    MongoDatabase baseDeDatos;
    MongoCollection<Artista> collectionArtista;

    public ArtistaDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionArtista = baseDeDatos.getCollection("artistas", Artista.class);
    }

    @Override
    public List<Artista> obtenerTodos() {

        List<Artista> artistas;

        artistas = collectionArtista.find().into(new ArrayList<>());

        return artistas;
    }

    @Override
    public Artista buscarArtista(Object id) {

        Document query = new Document("_id", id);

        Artista artista = collectionArtista.find(query).first();

        return artista;

    }
    
    @Override
    public List<Artista> obtenerTodosArtistaSinGeneroNoDeseado(List<String> excluir){
    
        List<Artista> artistas = new ArrayList<>();
        
        Document query = new Document("genero", new Document("$nin", excluir));
        
        // Ejecutar la consulta y agregar los resultados a la lista
            try (MongoCursor<Artista> cursor = collectionArtista.find(query).iterator()) {
                while (cursor.hasNext()) {
                    artistas.add(cursor.next());
                }
            }
            
            return artistas;
        
    }
    
    
    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtistaFiltroGeneroNoDeseado(List<String> excluir) {

        // Obtener todos los artistas de la colección
        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Lista donde se almacenarán los álbumes filtrados
        List<Albumes> listaAlbumes = new ArrayList<>();

        // Procesamos cada artista
        for (Artista artista : listaArtistas) {
            // Extraemos los álbumes del artista
            List<Albumes> albumes = artista.getAlbumes();

            // Filtramos los álbumes por género
            for (Albumes album : albumes) {
                String generoAlbum = album.getGenero();

                // Si el género no está en la lista de exclusión, lo añadimos a la lista final
                if (!excluir.contains(generoAlbum)) {
                    listaAlbumes.add(album);
                }
            }
        }

        return listaAlbumes;
    }    
    

    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtista() {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Lista donde se almacenarán todos los álbumes
        List<Albumes> listaAlbumes = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Crear un nuevo objeto Album con todos los datos (incluyendo el id)
                Albumes nuevoAlbum = new Albumes();
                nuevoAlbum.setIdAlbum(album.getIdAlbum());
                nuevoAlbum.setNombre(album.getNombre());
                nuevoAlbum.setImagen(album.getImagen());
                nuevoAlbum.setGenero(album.getGenero());
                nuevoAlbum.setFechaLanzamiento(album.getFechaLanzamiento());
                nuevoAlbum.setCanciones(album.getCanciones());

                // Agregar el álbum a la lista
                listaAlbumes.add(nuevoAlbum);
            }
        }

        return listaAlbumes;
    }

    @Override
    public List<Canciones> obtenerTodasCancionesEnArtista() {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Lista donde se almacenarán todas las canciones
        List<Canciones> listaCanciones = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Recorrer las canciones de cada álbum
                if (album.getCanciones() != null) {
                    for (Canciones cancion : album.getCanciones()) {
                        // Crear una nueva Canción con todos los datos (incluyendo el id)
                        Canciones nuevaCancion = new Canciones();
                        nuevaCancion.setIdCancion(cancion.getIdCancion());
                        nuevaCancion.setNombreCancion(cancion.getNombreCancion());
                        nuevaCancion.setDuracion(cancion.getDuracion());

                        // Agregar la canción a la lista
                        listaCanciones.add(nuevaCancion);
                    }
                }
            }
        }

        return listaCanciones;

    }

    @Override
    public String obtenerImagenPorIdCancion(String id) {

        List<Artista> listaArtistas = collectionArtista.find().into(new ArrayList<>());

        // Variable para almacenar la imagen del álbum
        String imagenAlbum = null;

        // Iterar sobre los artistas y buscar la canción
        for (Artista artista : listaArtistas) {
            List<Albumes> albumes = artista.getAlbumes();
            if (albumes != null) {
                for (Albumes album : albumes) {
                    List<Canciones> canciones = album.getCanciones();
                    if (canciones != null) {
                        for (Canciones cancion : canciones) {
                            if (cancion.getIdCancion().equals(id)) {
                                // Encontramos la canción, obtenemos la imagen del álbum
                                imagenAlbum = album.getImagen();

                                return imagenAlbum;

                            }
                        }
                    }
                    if (imagenAlbum != null) {
                        break; // Salir del bucle si ya encontramos la canción
                    }
                }
            }
            if (imagenAlbum != null) {
                break; // Salir del bucle si ya encontramos la canción
            }
        }

        // Mostrar el resultado
        if (imagenAlbum != null) {
            System.out.println("Imagen del álbum: " + imagenAlbum);
        } else {
            System.out.println("No se encontró la canción con el ID proporcionado.");
        }

        return null;
    }

    @Override
    public Artista agregarArtista(Artista artista) {
        try {
            // Insertar el artista en la colección
            collectionArtista.insertOne(artista);
            System.out.println("Artista agregado con éxito: " + artista.getNombreArtista());
            return artista;
        } catch (Exception e) {
            System.err.println("Error al agregar el artista: " + e.getMessage());
            return null;
        }
    }

    
    
    @Override
    public List<Canciones> obtenerTodasCancionesEnArtistaEspecifico(ObjectId id) {

        Document query = new Document("_id", id);
        
        List<Artista> listaArtistas = collectionArtista.find(query).into(new ArrayList<>());

        // Lista donde se almacenarán todas las canciones
        List<Canciones> listaCanciones = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Recorrer las canciones de cada álbum
                if (album.getCanciones() != null) {
                    for (Canciones cancion : album.getCanciones()) {
                        // Crear una nueva Canción con todos los datos (incluyendo el id)
                        Canciones nuevaCancion = new Canciones();
                        nuevaCancion.setIdCancion(cancion.getIdCancion());
                        nuevaCancion.setNombreCancion(cancion.getNombreCancion());
                        nuevaCancion.setDuracion(cancion.getDuracion());

                        // Agregar la canción a la lista
                        listaCanciones.add(nuevaCancion);
                    }
                }
            }
        }

        return listaCanciones;

    }
    
    
    @Override
    public List<Albumes> obtenerTodosAlbumesEnArtistaEspecifico(ObjectId id) {

        Document query = new Document("_id", id);
        
        List<Artista> listaArtistas = collectionArtista.find(query).into(new ArrayList<>());

        // Lista donde se almacenarán todos los álbumes
        List<Albumes> listaAlbumes = new ArrayList<>();

        // Recorrer el AggregateIterable
        for (Artista artista : listaArtistas) {
            // Recorrer los álbumes del artista
            for (Albumes album : artista.getAlbumes()) {
                // Crear un nuevo objeto Album con todos los datos (incluyendo el id)
                Albumes nuevoAlbum = new Albumes();
                nuevoAlbum.setIdAlbum(album.getIdAlbum());
                nuevoAlbum.setNombre(album.getNombre());
                nuevoAlbum.setImagen(album.getImagen());
                nuevoAlbum.setFechaLanzamiento(album.getFechaLanzamiento());
                nuevoAlbum.setCanciones(album.getCanciones());

                // Agregar el álbum a la lista
                listaAlbumes.add(nuevoAlbum);
            }
        }

        return listaAlbumes;
    }
    
    
    @Override
    public Albumes buscarAlbumPorId(String id) {

 // Consulta para encontrar el artista que contiene el álbum con ese ID
        Bson filter = Filters.elemMatch("albumes", Filters.eq("idAlbum", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            System.out.println("Artista encontrado: " + artista.getNombreArtista());

            // Buscar el álbum dentro de los álbumes del artista
            Optional<Albumes> albumEncontrado = artista.getAlbumes().stream()
                    .filter(album -> album.getIdAlbum().equals(id))
                    .findFirst();

            if (albumEncontrado.isPresent()) {
                Albumes album = albumEncontrado.get();
                System.out.println("Álbum encontrado: " + album.getNombre());
                System.out.println("Canciones:");
                album.getCanciones().forEach(cancion ->
                        System.out.println("- " + cancion.getNombreCancion() + " (" + cancion.getDuracion() + ")")
                );
                
                return album;
                
            } else {
                System.out.println("El álbum no se encontró en los datos del artista.");
            }
        } else {
            System.out.println("No se encontró ningún artista con un álbum de id " + id);
        }
        
        return null;
    }
    
    
    @Override
    public Canciones buscarCancionPorId(String id){
        
         // Consulta para encontrar el artista que contiene la canción con ese ID
        Bson filter = Filters.elemMatch("albumes.canciones", Filters.eq("idCancion", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            System.out.println("Artista encontrado: " + artista.getNombreArtista());

            // Buscar la canción dentro de los álbumes del artista
            Optional<Canciones> cancionEncontrada = artista.getAlbumes().stream()
                    .flatMap(album -> album.getCanciones().stream())
                    .filter(cancion -> cancion.getIdCancion().equals(id))
                    .findFirst();

            if (cancionEncontrada.isPresent()) {
                Canciones cancion = cancionEncontrada.get();
                System.out.println("Canción encontrada: " + cancion.getNombreCancion());
                System.out.println("Duración: " + cancion.getDuracion());
                
                return cancion;
            } else {
                System.out.println("La canción no se encontró en los datos del artista.");
            }
        } else {
            System.out.println("No se encontró ningún artista con una canción de id " + id);
        }
        
        return null;
    }
    
    
    @Override
    public Artista buscarArtistaPorIdAlbum(String id){
    
    
         // Filtro para buscar el artista que tiene un álbum con este idAlbum
        Bson filter = Filters.elemMatch("albumes", Filters.eq("idAlbum", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            System.out.println("Artista encontrado: " + artista.getNombreArtista());
            System.out.println("Género: " + artista.getGenero());
        } else {
            System.out.println("No se encontró ningún artista con el álbum de id " + id);
        }
        
        return artista;
    }
    
    @Override
    public Artista buscarArtistaPorIdCancion(String id){
        
    // Filtro para buscar el artista que tiene una canción con este idCancion
        Bson filter = Filters.elemMatch("albumes.canciones", Filters.eq("idCancion", id));
        Artista artista = collectionArtista.find(filter).first();

        if (artista != null) {
            System.out.println("Artista encontrado: " + artista.getNombreArtista());
            System.out.println("Género: " + artista.getGenero());
        } else {
            System.out.println("No se encontró ningún artista con la canción de id " + id);
        }
    
        return artista;
    }
    
    
    @Override
    public boolean InsercionArtistasArturo(){
                
        try{
        Artista artistaUno = new Artista();
        
        artistaUno.setIdDos("1");
        artistaUno.setNombreArtista("Linkin Park");
        artistaUno.setImagen("src/main/java/ImagenesProyecto/ArtistaLinkinPark.jpg");
        artistaUno.setGenero("Rock");
        
            List<Integrantes> listaIntegrantesLinkinPark = new ArrayList<>();
            
            Integrantes integranteLP1 = new Integrantes();
                integranteLP1.setIdPersona("persona1");
                integranteLP1.setRolBanda("Vocalista");
                    LocalDate localDate = LocalDate.of(1999, Month.JANUARY, 01);
                    Date fechaInicioChester = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteLP1.setFechaIngreso(fechaInicioChester);
                    LocalDate localDate2 = LocalDate.of(2017, Month.JULY, 20);
                    Date fechaSalidaChester = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant()); 
                integranteLP1.setFechaSalida(fechaSalidaChester);
                
            Integrantes integranteLP2 = new Integrantes();
                integranteLP2.setIdPersona("persona2");
                integranteLP2.setRolBanda("Vocalista, guitarra");
                    LocalDate localDate3 = LocalDate.of(1996, Month.JANUARY, 01);
                    Date fechaInicioMike = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteLP2.setFechaIngreso(fechaInicioMike);
                integranteLP2.setFechaSalida(null);        
       
            Integrantes integranteLP3 = new Integrantes();
                integranteLP3.setIdPersona("persona3");
                integranteLP3.setRolBanda("Vocalista");
                    LocalDate localDate4 = LocalDate.of(2024, Month.SEPTEMBER, 24);
                    Date fechaInicioEmily = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteLP3.setFechaIngreso(fechaInicioEmily);
                integranteLP3.setFechaSalida(null);     
            
            listaIntegrantesLinkinPark.add(integranteLP1);
            listaIntegrantesLinkinPark.add(integranteLP2);
            listaIntegrantesLinkinPark.add(integranteLP3);
        
        artistaUno.setIntegrantes(listaIntegrantesLinkinPark);
        
            List<Albumes> albumesArtista1 = new ArrayList<>();
            
                Albumes album1LP = new Albumes();
                album1LP.setIdAlbum("album1");
                album1LP.setNombre("Hybrid Theory");
                album1LP.setGenero("Nu Metal");
                album1LP.setImagen("src/main/java/ImagenesProyecto/AlbumHybridTheory.jpg");
                    LocalDate localDate5 = LocalDate.of(2000, Month.OCTOBER, 24);
                    Date fechaLanzamientoAlbum1 = Date.from(localDate5.atStartOfDay(ZoneId.systemDefault()).toInstant());
                album1LP.setFechaLanzamiento(fechaLanzamientoAlbum1);
                
                    List<Canciones> cancionesAlbum1 = new ArrayList<>();
                        
                        Canciones cancion1Album1 = new Canciones();
                        cancion1Album1.setDuracion("2:35");
                        cancion1Album1.setIdCancion("cancion1Album1");
                        cancion1Album1.setNombreCancion("One Step Closer");
                        
                        Canciones cancion2Album1 = new Canciones();
                        cancion2Album1.setDuracion("3:04");
                        cancion2Album1.setIdCancion("cancion2Album1");
                        cancion2Album1.setNombreCancion("A Place For My Head");
                        
                        Canciones cancion3Album1 = new Canciones();
                        cancion3Album1.setDuracion("3:36");
                        cancion3Album1.setIdCancion("cancion3Album1");
                        cancion3Album1.setNombreCancion("In The End");
                        
                    cancionesAlbum1.add(cancion1Album1);
                    cancionesAlbum1.add(cancion2Album1);
                    cancionesAlbum1.add(cancion3Album1);
                
                album1LP.setCanciones(cancionesAlbum1);
                            
            
                Albumes album2LP = new Albumes();
                album2LP.setIdAlbum("album2");
                album2LP.setNombre("From Zero");
                album2LP.setGenero("Rock");
                album2LP.setImagen("src/main/java/ImagenesProyecto/AlbumHybridTheory.jpg");
                    LocalDate localDate6 = LocalDate.of(2024, Month.NOVEMBER, 15);
                    Date fechaLanzamientoAlbum2 = Date.from(localDate6.atStartOfDay(ZoneId.systemDefault()).toInstant());
                album2LP.setFechaLanzamiento(fechaLanzamientoAlbum2);
                
                    List<Canciones> cancionesAlbum2 = new ArrayList<>();
                        
                        Canciones cancion1Album2 = new Canciones();
                        cancion1Album1.setDuracion("3:20");
                        cancion1Album1.setIdCancion("cancion1Album2");
                        cancion1Album1.setNombreCancion("The Emptiness Machine");
                        
                        Canciones cancion2Album2 = new Canciones();
                        cancion2Album1.setDuracion("3:49");
                        cancion2Album1.setIdCancion("cancion2Album2");
                        cancion2Album1.setNombreCancion("Cut The Brigde");
                        
                        Canciones cancion3Album2 = new Canciones();
                        cancion3Album1.setDuracion("3:07");
                        cancion3Album1.setIdCancion("cancion3Album2");
                        cancion3Album1.setNombreCancion("Two Faced");
                        
                    cancionesAlbum2.add(cancion1Album2);
                    cancionesAlbum2.add(cancion2Album2);
                    cancionesAlbum2.add(cancion3Album2);
                
                album2LP.setCanciones(cancionesAlbum2);
  
                
        albumesArtista1.add(album2LP);
        albumesArtista1.add(album1LP);
                    
        artistaUno.setAlbumes(albumesArtista1); 
        
        
        
        Artista artistaDos = new Artista();
        
        artistaDos.setIdDos("2");
        artistaDos.setNombreArtista("Bring Me The Horizon");
        artistaDos.setImagen("src/main/java/ImagenesProyecto/ArtistaBMTH.jpg");
        artistaDos.setGenero("Metal");
        
            List<Integrantes> listaIntegrantesBMTH = new ArrayList<>();
            
            Integrantes integranteBMTH1 = new Integrantes();
                integranteBMTH1.setIdPersona("persona3");
                integranteBMTH1.setRolBanda("Vocalista");
                    LocalDate localDate7 = LocalDate.of(2003, Month.JANUARY, 01);
                    Date fechaInicioOliver = Date.from(localDate7.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteBMTH1.setFechaIngreso(fechaInicioOliver);
                integranteBMTH1.setFechaSalida(null);
                
            Integrantes integranteBMTH2 = new Integrantes();
                integranteBMTH2.setIdPersona("persona4");
                integranteBMTH2.setRolBanda("Teclado");
                    LocalDate localDate8 = LocalDate.of(2013, Month.JANUARY, 01);
                    Date fechaInicioJordan = Date.from(localDate8.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteBMTH2.setFechaIngreso(fechaInicioJordan);
                LocalDate localDate9 = LocalDate.of(2023, Month.DECEMBER, 22);
                    Date fechaSalidaJordan = Date.from(localDate9.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteBMTH2.setFechaSalida(fechaSalidaJordan);        
       
            Integrantes integranteBMTH3 = new Integrantes();
                integranteBMTH3.setIdPersona("persona5");
                integranteBMTH3.setRolBanda("Baterista");
                    LocalDate localDate10 = LocalDate.of(2003, Month.JANUARY, 01);
                    Date fechaInicioMatt = Date.from(localDate10.atStartOfDay(ZoneId.systemDefault()).toInstant());
                integranteBMTH3.setFechaIngreso(fechaInicioMatt);
                integranteBMTH3.setFechaSalida(null);     
            
            listaIntegrantesBMTH.add(integranteBMTH1);
            listaIntegrantesBMTH.add(integranteBMTH2);
            listaIntegrantesBMTH.add(integranteBMTH3);
        
        artistaDos.setIntegrantes(listaIntegrantesBMTH);
        
            List<Albumes> albumesArtista2 = new ArrayList<>();
            
                Albumes album1BMTH = new Albumes();
                album1BMTH.setIdAlbum("album3");
                album1BMTH.setNombre("That's The Spirit");
                album1BMTH.setGenero("Post Hardcore");
                album1BMTH.setImagen("src/main/java/ImagenesProyecto/AlbumHybridTheory.jpg");
                    LocalDate localDate11 = LocalDate.of(2015, Month.SEPTEMBER, 11);
                    Date fechaLanzamientoAlbum3 = Date.from(localDate11.atStartOfDay(ZoneId.systemDefault()).toInstant());
                album1BMTH.setFechaLanzamiento(fechaLanzamientoAlbum3);
                
                    List<Canciones> cancionesAlbum3 = new ArrayList<>();
                        
                        Canciones cancion1Album3 = new Canciones();
                        cancion1Album3.setDuracion("3:51");
                        cancion1Album3.setIdCancion("cancion1Album3");
                        cancion1Album3.setNombreCancion("Follow You");
                        
                        Canciones cancion2Album3 = new Canciones();
                        cancion2Album3.setDuracion("3:52");
                        cancion2Album3.setIdCancion("cancion2Album3");
                        cancion2Album3.setNombreCancion("True Friends");
                        
                        Canciones cancion3Album3 = new Canciones();
                        cancion3Album3.setDuracion("4:12");
                        cancion3Album3.setIdCancion("cancion3Album3");
                        cancion3Album3.setNombreCancion("What You Need");
                        
                    cancionesAlbum3.add(cancion1Album3);
                    cancionesAlbum3.add(cancion2Album3);
                    cancionesAlbum3.add(cancion3Album3);
                
                album1BMTH.setCanciones(cancionesAlbum3);
  
            
                Albumes album2BMTH = new Albumes();
                album2BMTH.setIdAlbum("album4");
                album2BMTH.setNombre("Sempiternal");
                album2BMTH.setGenero("Metal");
                album2BMTH.setImagen("src/main/java/ImagenesProyecto/AlbumSempiternal.jpg");
                    LocalDate localDate12 = LocalDate.of(2013, Month.APRIL, 11);
                    Date fechaLanzamientoAlbum4 = Date.from(localDate12.atStartOfDay(ZoneId.systemDefault()).toInstant());
                album2BMTH.setFechaLanzamiento(fechaLanzamientoAlbum4);
                
                    List<Canciones> cancionesAlbum4 = new ArrayList<>();
                        
                        Canciones cancion1Album4 = new Canciones();
                        cancion1Album1.setDuracion("3:48");
                        cancion1Album1.setIdCancion("cancion1Album4");
                        cancion1Album1.setNombreCancion("Can You Feel My Hearth");
                        
                        Canciones cancion2Album4 = new Canciones();
                        cancion2Album1.setDuracion("3:25");
                        cancion2Album1.setIdCancion("cancion2Album4");
                        cancion2Album1.setNombreCancion("The House Of Wolves");
                        
                        Canciones cancion3Album4 = new Canciones();
                        cancion3Album1.setDuracion("4:03");
                        cancion3Album1.setIdCancion("cancion3Album4");
                        cancion3Album1.setNombreCancion("Shadow Moses");
                        
                    cancionesAlbum4.add(cancion1Album4);
                    cancionesAlbum4.add(cancion2Album4);
                    cancionesAlbum4.add(cancion3Album4);
                
                album2BMTH.setCanciones(cancionesAlbum4);
  
            
             albumesArtista2.add(album1BMTH);
             albumesArtista2.add(album2BMTH);
                
        artistaDos.setAlbumes(albumesArtista2);
        

        
        
         // Artista 3: Imagine Dragons
        Artista artista3 = new Artista();
        artista3.setIdDos("3");
        artista3.setNombreArtista("Imagine Dragons");
        artista3.setImagen("src/main/java/ImagenesProyecto/ArtistaImagineDragons.jpg");
        artista3.setGenero("Pop Rock");

        // Integrantes Imagine Dragons
        List<Integrantes> listaIntegrantesID = new ArrayList<>();
        Integrantes integranteID1 = new Integrantes();
        integranteID1.setIdPersona("persona6");
        integranteID1.setRolBanda("Vocalista");
        integranteID1.setFechaIngreso(convertToDate(2008, Month.JANUARY, 1));
        integranteID1.setFechaSalida(null);

        Integrantes integranteID2 = new Integrantes();
        integranteID2.setIdPersona("persona7");
        integranteID2.setRolBanda("Guitarra");
        integranteID2.setFechaIngreso(convertToDate(2008, Month.JANUARY, 1));
        integranteID2.setFechaSalida(null);

        listaIntegrantesID.add(integranteID1);
        listaIntegrantesID.add(integranteID2);
        artista3.setIntegrantes(listaIntegrantesID);

        // Álbumes Imagine Dragons
        List<Albumes> albumesArtista3 = new ArrayList<>();
        Albumes album1ID = new Albumes();
        album1ID.setIdAlbum("album5");
        album1ID.setNombre("Night Visions");
        album1ID.setGenero("Pop Rock");
        album1ID.setImagen("src/main/java/ImagenesProyecto/AlbumNightVisions.jpg");
        album1ID.setFechaLanzamiento(convertToDate(2012, Month.SEPTEMBER, 4));

        List<Canciones> cancionesAlbum1ID = new ArrayList<>();
        Canciones cancion1ID = new Canciones();
        cancion1ID.setDuracion("3:37");
        cancion1ID.setIdCancion("cancion1Album5");
        cancion1ID.setNombreCancion("Radioactive");

        Canciones cancion2ID = new Canciones();
        cancion2ID.setDuracion("3:52");
        cancion2ID.setIdCancion("cancion2Album5");
        cancion2ID.setNombreCancion("Demons");

        cancionesAlbum1ID.add(cancion1ID);
        cancionesAlbum1ID.add(cancion2ID);
        album1ID.setCanciones(cancionesAlbum1ID);

        albumesArtista3.add(album1ID);
        artista3.setAlbumes(albumesArtista3);

        // Artista 2: Arctic Monkeys
        Artista artista4 = new Artista();
        artista4.setIdDos("4");
        artista4.setNombreArtista("Arctic Monkeys");
        artista4.setImagen("src/main/java/ImagenesProyecto/ArtistaArcticMonkeys.jpg");
        artista4.setGenero("Indie Rock");

        // Integrantes Arctic Monkeys
        List<Integrantes> listaIntegrantesAM = new ArrayList<>();
        Integrantes integranteAM1 = new Integrantes();
        integranteAM1.setIdPersona("persona8");
        integranteAM1.setRolBanda("Vocalista, Guitarra");
        integranteAM1.setFechaIngreso(convertToDate(2002, Month.JANUARY, 1));
        integranteAM1.setFechaSalida(null);

        listaIntegrantesAM.add(integranteAM1);
        artista4.setIntegrantes(listaIntegrantesAM);

        // Álbumes Arctic Monkeys
        List<Albumes> albumesArtista4 = new ArrayList<>();
        Albumes album1AM = new Albumes();
        album1AM.setIdAlbum("album6");
        album1AM.setNombre("AM");
        album1AM.setGenero("Indie Rock");
        album1AM.setImagen("src/main/java/ImagenesProyecto/AlbumAM.jpg");
        album1AM.setFechaLanzamiento(convertToDate(2013, Month.SEPTEMBER, 9));

        List<Canciones> cancionesAlbum1AM = new ArrayList<>();
        Canciones cancion1AM = new Canciones();
        cancion1AM.setDuracion("3:23");
        cancion1AM.setIdCancion("cancion1Album6");
        cancion1AM.setNombreCancion("Do I Wanna Know?");

        Canciones cancion2AM = new Canciones();
        cancion2AM.setDuracion("4:05");
        cancion2AM.setIdCancion("cancion2Album6");
        cancion2AM.setNombreCancion("R U Mine?");

        cancionesAlbum1AM.add(cancion1AM);
        cancionesAlbum1AM.add(cancion2AM);
        album1AM.setCanciones(cancionesAlbum1AM);

        albumesArtista4.add(album1AM);
        artistaDos.setAlbumes(albumesArtista4);

        // Artista 3: Coldplay
        Artista artista5 = new Artista();
        artista5.setIdDos("5");
        artista5.setNombreArtista("Coldplay");
        artista5.setImagen("src/main/java/ImagenesProyecto/ArtistaColdplay.jpg");
        artista5.setGenero("Alternative Rock");

        // Integrantes Coldplay
        List<Integrantes> listaIntegrantesColdplay = new ArrayList<>();
        Integrantes integranteCP1 = new Integrantes();
        integranteCP1.setIdPersona("persona9");
        integranteCP1.setRolBanda("Vocalista");
        integranteCP1.setFechaIngreso(convertToDate(1996, Month.JANUARY, 1));
        integranteCP1.setFechaSalida(null);

        listaIntegrantesColdplay.add(integranteCP1);
        artista5.setIntegrantes(listaIntegrantesColdplay);

        // Álbumes Coldplay
        List<Albumes> albumesArtista5 = new ArrayList<>();
        Albumes album1CP = new Albumes();
        album1CP.setIdAlbum("album7");
        album1CP.setNombre("A Rush of Blood to the Head");
        album1CP.setGenero("Alternative Rock");
        album1CP.setImagen("src/main/java/ImagenesProyecto/AlbumRushOfBlood.jpg");
        album1CP.setFechaLanzamiento(convertToDate(2002, Month.AUGUST, 26));

        List<Canciones> cancionesAlbum1CP = new ArrayList<>();
        Canciones cancion1CP = new Canciones();
        cancion1CP.setDuracion("4:57");
        cancion1CP.setIdCancion("cancion1Album7");
        cancion1CP.setNombreCancion("Clocks");

        Canciones cancion2CP = new Canciones();
        cancion2CP.setDuracion("5:03");
        cancion2CP.setIdCancion("cancion2Album7");
        cancion2CP.setNombreCancion("The Scientist");

        cancionesAlbum1CP.add(cancion1CP);
        cancionesAlbum1CP.add(cancion2CP);
        album1CP.setCanciones(cancionesAlbum1CP);

        albumesArtista3.add(album1CP);
        artista5.setAlbumes(albumesArtista3);
     
                
        List<Artista> artistas = new ArrayList<>();
        //artistas.add(artistaUno);
       // artistas.add(artistaDos);
       // artistas.add(artista3);
       // artistas.add(artista4);
        artistas.add(artista5);
        
        
        collectionArtista.insertMany(artistas);
        
        return true;
        
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    
    // Método auxiliar para convertir LocalDate a Date
    private static Date convertToDate(int year, Month month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    
    
}
    
    
    

