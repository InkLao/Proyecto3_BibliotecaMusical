package dtos;

/**
 *
 * @author eduar
 */
public class CancionDTO {

    private String idCancion;
    private String nombreCancion;
    private String duracion;

    public CancionDTO() {
    }

    public CancionDTO(String idCancion, String nombreCancion, String duracion) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(String idCancion) {
        this.idCancion = idCancion;
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
        return "CancionDTO{" + "idCancion=" + idCancion + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + '}';
    }
}
