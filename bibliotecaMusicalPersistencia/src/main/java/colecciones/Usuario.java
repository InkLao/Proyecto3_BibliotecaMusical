package colecciones;

import org.bson.types.ObjectId;

/**
 * Representa un usuario en el sistema.
 * Contiene la información personal y de autenticación del usuario.
 * 
 * @author Arturo
 */
public class Usuario {

    /** Identificador único en la base de datos. */
    private ObjectId id;

    /** Nombres del usuario. */
    private String nombres;

    /** Apellido paterno del usuario. */
    private String apellidoP;

    /** Apellido materno del usuario. */
    private String apellidoM;

    /** Correo electrónico del usuario. */
    private String correo;

    /** Contraseña encriptada del usuario. */
    private String contrasena;

    /** Ruta de la imagen del perfil del usuario. */
    private String imagen;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor para inicializar todos los campos.
     *
     * @param id Identificador único.
     * @param nombres Nombres del usuario.
     * @param apellidoP Apellido paterno.
     * @param apellidoM Apellido materno.
     * @param correo Correo electrónico.
     * @param contrasena Contraseña encriptada.
     * @param imagen Ruta de la imagen del perfil.
     */
    public Usuario(ObjectId id, String nombres, String apellidoP, String apellidoM, String correo, String contrasena, String imagen) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagen = imagen;
    }

    /** @return El identificador único. */
    public ObjectId getId() {
        return id;
    }

    /** @param id El identificador único a asignar. */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /** @return Los nombres del usuario. */
    public String getNombres() {
        return nombres;
    }

    /** @param nombres Los nombres del usuario a asignar. */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /** @return El apellido paterno del usuario. */
    public String getApellidoP() {
        return apellidoP;
    }

    /** @param apellidoP El apellido paterno del usuario a asignar. */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /** @return El apellido materno del usuario. */
    public String getApellidoM() {
        return apellidoM;
    }

    /** @param apellidoM El apellido materno del usuario a asignar. */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /** @return El correo electrónico del usuario. */
    public String getCorreo() {
        return correo;
    }

    /** @param correo El correo electrónico del usuario a asignar. */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** @return La contraseña encriptada del usuario. */
    public String getContrasena() {
        return contrasena;
    }

    /** @param contrasena La contraseña encriptada del usuario a asignar. */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /** @return La ruta de la imagen del perfil del usuario. */
    public String getImagen() {
        return imagen;
    }

    /** @param imagen La ruta de la imagen del perfil a asignar. */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve una representación en forma de texto del usuario.
     * 
     * @return Información del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
