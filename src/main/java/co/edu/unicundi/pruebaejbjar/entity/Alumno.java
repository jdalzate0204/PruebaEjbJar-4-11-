package co.edu.unicundi.pruebaejbjar.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
@Entity //Indica que es un objeto persistente a la bbdd
@Table (name = "alumno") //Indicar que es una tabla (name opcional, schema por defecto publico)

//Consultas JPQL (No se hace la consulta sobre la base de datos, sino en codigo java)
@NamedQueries({
    @NamedQuery(name = "Alumno.ListarTodos", query = "SELECT a FROM Alumno a")    
})

public class Alumno implements Serializable{
    
    @Id //LLave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "nombre es obligatorio")
    @Size(min = 3, max = 30, message = "Nombre debe estar entre 3 y 30 caracteres")
    @Column(name = "nombre", nullable = false, length = 30) //Columna de la tabla
    private String nombre;
    
    @NotNull(message = "edad es obligatorio")
    @Min(value = 18, message = "Debe ser mayor de edad")
    @Column(name = "edad", nullable = false)
    private Integer edad;
    
    @NotNull(message = "cedula es obligatorio")
    @Size(min = 7, max = 12, message = "Cedula debe estar entre 7 y 12 caracteres")
    @Column(name = "cedula", nullable = false, length = 12, unique = true) 
    private String cedula;
    
    public Alumno() {
    }

    public Alumno(Integer id, String nombre, Integer edad, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
