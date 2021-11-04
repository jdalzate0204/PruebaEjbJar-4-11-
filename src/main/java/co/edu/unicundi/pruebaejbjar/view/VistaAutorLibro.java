package co.edu.unicundi.pruebaejbjar.view;

import java.io.Serializable;
import javax.persistence.*;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author acer
 */
@Entity
@Immutable
@Table(name = "vista_autor_libro")

@NamedQueries({
    @NamedQuery(name = "VistaAutor.Listar", query = "SELECT v FROM VistaAutorLibro v")
})

public class VistaAutorLibro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", insertable = false, updatable = false, length = 30)
    private String nombre;
    
    @Column(name = "edad", insertable = false, updatable = false)
    private Integer edad;
    
    @Column(name = "identificacion", insertable = false, updatable = false, length = 10, unique = true)
    private String identificacion;
    
    @Column(name = "cantidad_libros", insertable = false, updatable = false)
    private Integer cantidadLibros;
    
    @Column(name = "libro_mas_paginas", insertable = false, updatable = false)
    private Integer libroMasPaginas;
    
    @Column(name = "nombre_libro_mas_paginas", insertable = false, updatable = false, length = 30)
    private String nombreLibroMasPaginas;

    public VistaAutorLibro() {
    }

    public VistaAutorLibro(String nombre, Integer edad, String identificacion, Integer cantidadLibros, Integer libroMasPaginas, String nombreLibroMasPaginas) {
        this.nombre = nombre;
        this.edad = edad;
        this.identificacion = identificacion;
        this.cantidadLibros = cantidadLibros;
        this.libroMasPaginas = libroMasPaginas;
        this.nombreLibroMasPaginas = nombreLibroMasPaginas;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(Integer cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public Integer getLibroMasPaginas() {
        return libroMasPaginas;
    }

    public void setLibroMasPaginas(Integer libroMasPaginas) {
        this.libroMasPaginas = libroMasPaginas;
    }

    public String getNombreLibroMasPaginas() {
        return nombreLibroMasPaginas;
    }

    public void setNombreLibroMasPaginas(String nombreLibroMasPaginas) {
        this.nombreLibroMasPaginas = nombreLibroMasPaginas;
    }
}
