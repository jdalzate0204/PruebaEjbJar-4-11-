package co.edu.unicundi.pruebaejbjar.dto;

/**
 *
 * @author acer
 */
public class LibroDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer noPaginas;
    private Integer idAutor;

    public LibroDto() {
    }    

    public LibroDto(Integer id, String nombre, String descripcion, Integer noPaginas, Integer idAutor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.noPaginas = noPaginas;
        this.idAutor = idAutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(Integer noPaginas) {
        this.noPaginas = noPaginas;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }
}
