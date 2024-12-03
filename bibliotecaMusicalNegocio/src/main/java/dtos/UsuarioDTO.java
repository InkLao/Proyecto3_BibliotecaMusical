package dtos;

import org.bson.types.ObjectId;

/**
 * Representa un usuario en el sistema.
 * Contiene información personal como nombre, correo electrónico, contraseña e imagen de perfil.
 */
public class UsuarioDTO {

    private ObjectId id; // Identificador único del usuario
    private String nombres; // Nombres del usuario
    private String apellidoP; // Apellido paterno del usuario
    private String apellidoM; // Apellido materno del usuario
    private String correo; // Correo electrónico del usuario
    private String contrasena; // Contraseña encriptada del usuario
    private String imagen; // Ruta o URL de la imagen de perfil del usuario

    /**
     * Constructor por defecto.
     */
    public UsuarioDTO() {}

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param id Identificador único del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidoP Apellido paterno del usuario.
     * @param apellidoM Apellido materno del usuario.
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @param imagen Imagen de perfil del usuario.
     */
    public UsuarioDTO(ObjectId id, String nombres, String apellidoP, String apellidoM, String correo, String contrasena, String imagen) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagen = imagen;
    }

    /**
     * Constructor sin identificador único.
     *
     * @param nombres Nombres del usuario.
     * @param apellidoP Apellido paterno del usuario.
     * @param apellidoM Apellido materno del usuario.
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @param imagen Imagen de perfil del usuario.
     */
    public UsuarioDTO(String nombres, String apellidoP, String apellidoM, String correo, String contrasena, String imagen) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagen = imagen;
    }

    // Métodos Getter y Setter con documentación.

    /**
     * Obtiene el identificador único del usuario.
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     * @param id Nuevo identificador del usuario.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del usuario.
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     * @param nombres Nuevos nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     * @return apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Establece el apellido paterno del usuario.
     * @param apellidoP Nuevo apellido paterno del usuario.
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Obtiene el apellido materno del usuario.
     * @return apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Establece el apellido materno del usuario.
     * @param apellidoM Nuevo apellido materno del usuario.
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo Nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena Nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la imagen de perfil del usuario.
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen de perfil del usuario.
     * @param imagen Nueva imagen de perfil del usuario.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Representación en cadena del objeto.
     * @return Información del usuario en formato de texto.
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" +
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
