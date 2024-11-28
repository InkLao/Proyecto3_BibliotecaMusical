package dtos;

/**
 *
 * @author eduar
 */
public class CancionDTO {

    private String id;
    private String nombreCancion;
    private String duracion;

    public CancionDTO() {
    }

    public CancionDTO(String id, String nombreCancion, String duracion) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "CancionDTO{" + "id=" + id + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + '}';
    }
}
