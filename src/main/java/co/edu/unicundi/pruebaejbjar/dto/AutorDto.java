package co.edu.unicundi.pruebaejbjar.dto;

/**
 *
 * @author acer
 */
public class AutorDto {

    private Integer id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private Integer edad;

    public AutorDto() {
    }

    public AutorDto(Integer id, String identificacion, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
