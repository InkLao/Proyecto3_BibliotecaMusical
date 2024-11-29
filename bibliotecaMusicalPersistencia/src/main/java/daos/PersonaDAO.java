/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author eduar
 */
public class PersonaDAO implements IPersonaDAO {

    MongoDatabase baseDeDatos;
    MongoCollection<Persona> collectionPersona;

    public PersonaDAO() {
        this.baseDeDatos = new ConexionBD().conexion();
        this.collectionPersona = baseDeDatos.getCollection("persona", Persona.class);
    }

    @Override
    public List<Persona> obtenerTodas() {
        return collectionPersona.find().into(new ArrayList<>());
    }

    @Override
    public Persona buscarPersonaPorId(ObjectId id) {
        Document query = new Document("_id", id);
        return collectionPersona.find(query).first();
    }

    @Override
    public Persona agregarPersona(Persona persona) {
        collectionPersona.insertOne(persona);
        return persona;
    }

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
