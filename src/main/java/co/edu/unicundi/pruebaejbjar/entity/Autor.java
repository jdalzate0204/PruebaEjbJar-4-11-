package co.edu.unicundi.pruebaejbjar.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
@Entity //Indica que es un objeto persistente a la bbdd
@Table (name = "autor")

@NamedQueries({
    @NamedQuery(name = "Autor.ListarTodos", query = "SELECT a FROM Autor a"),    
    @NamedQuery(name = "Autor.ListarTodosSinLibro", query = "SELECT NEW co.edu.unicundi.pruebaejbjar.dto.AutorDto"
            + "(a.id, a.identificacion, a.nombre, a.apellido, a.edad) FROM Autor a"),
    @NamedQuery(name = "Autor.BuscarId", query = "SELECT count (a.identificacion) FROM Autor a WHERE a.identificacion = :identificacion"),
    @NamedQuery(name = "Autor.ListarPorId", query = "SELECT NEW co.edu.unicundi.pruebaejbjar.dto.AutorDto"
            + "(a.id, a.identificacion, a.nombre, a.apellido, a.edad) FROM Autor a WHERE a.id = :id"),
    @NamedQuery(name = "Autor.ContarId", query = "SELECT COUNT(a.id) FROM Autor a WHERE a.id = :id"),
    @NamedQuery(name = "Autor.Editar", query = "UPDATE Autor "
            + "SET identificacion = :identificacion, nombre = :nombre, apellido = :apellido, edad = :edad WHERE id = :id")
})

public class Autor implements Serializable{
    @Id //LLave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "identificacion es obligatorio")
    @Size(min = 7, max = 10, message = "identificacion debe estar entre 7 y 10 caracteres")
    @Pattern(regexp = "^\\d+$", message = "¡Solo se admiten numeros!")
    @Column(name = "identificacion", nullable = false, length = 15, unique = true) //Columna de la tabla
    private String identificacion;
    
    @NotNull(message = "nombre es obligatorio")
    @Size(min = 3, max = 30, message = "nombre debe estar entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "nombre", nullable = false, length = 30) //Columna de la tabla
    private String nombre;
    
    @NotNull(message = "apellido es obligatorio")
    @Size(min = 3, max = 30, message = "apellido debe estar entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "apellido", nullable = false, length = 30) //Columna de la tabla
    private String apellido;
    
    @NotNull(message = "edad es obligatorio")
    @Min(value = 18, message = "Debe ser mayor de edad")
    @Column(name = "edad", nullable = false) //Columna de la tabla
    private Integer edad;
    
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Libro> libro; //Permite objetos repetidos
    
    //private Set<Libro> libro2; //No permite objetos repetidos

    public Autor() {
    }

    public Autor(Integer id, String identificacion, String nombre, String apellido, Integer edad, List<Libro> libro) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.libro = libro;
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

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
    
    public Set<ConstraintViolation<Autor>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
