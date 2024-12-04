package daos;

import colecciones.Persona;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexionBD.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos para gestionar entidades de tipo Persona en la base de datos.
 * 
 * @author eduar
 */
public class PersonaDAO implements IPersonaDAO {

    /** Instancia de la base de datos MongoDB. */
    MongoDatabase baseDeDatos;

    /** Colección de documentos para la entidad Persona. */
    MongoCollection<Persona> collectionPersona;

    /**
     * Constructor que inicializa la conexión a la base de datos y la colección Persona.
     */
    public PersonaDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionPersona = baseDeDatos.getCollection("persona", Persona.class);
    }

    /**
     * Obtiene todas las personas almacenadas en la colección.
     * 
     * @return Lista de objetos Persona.
     */
    @Override
    public List<Persona> obtenerTodas() {
        return collectionPersona.find().into(new ArrayList<>());
    }

    /**
     * Busca una persona en la colección por su identificador único.
     * 
     * @param id Identificador único de la persona.
     * @return Objeto Persona encontrado o null si no existe.
     */
    @Override
    public Persona buscarPersonaPorId(ObjectId id) {
        Document query = new Document("_id", id);
        return collectionPersona.find(query).first();
    }

    /**
     * Busca una persona en la colección por su identificador único en cadena.
     * 
     * @param id Identificador único de la persona en formato String.
     * @return Objeto Persona encontrado o null si no existe.
     */
    @Override
    public Persona buscarPersonaPorId(String id) {
        Document query = new Document("idPersona", id);
        return collectionPersona.find(query).first();
    }

    /**
     * Agrega una nueva persona a la colección.
     * 
     * @param persona Objeto Persona a agregar.
     * @return Objeto Persona que fue agregado.
     */
    @Override
    public Persona agregarPersona(Persona persona) {
        collectionPersona.insertOne(persona);
        return persona;
    }

    /**
     * Agrega una persona como integrante en la colección Persona.
     * 
     * @param persona Objeto Persona a agregar.
     */
    public void agregarPersonaComoIntegrante(Persona persona) {
        PersonaDAO personaDAO = new PersonaDAO();
        Persona personaInsertada = personaDAO.agregarPersona(persona);
        if (personaInsertada != null) {
            System.out.println("Persona agregada como integrante: " + personaInsertada.getNombreCompleto());
        } else {
            System.err.println("Error al agregar la persona como integrante.");
        }
    }
}
