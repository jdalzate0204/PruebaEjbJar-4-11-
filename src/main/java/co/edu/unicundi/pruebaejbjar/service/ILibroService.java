package co.edu.unicundi.pruebaejbjar.service;

import co.edu.unicundi.pruebaejbjar.dto.LibroDto;
import co.edu.unicundi.pruebaejbjar.entity.Libro;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ILibroService {
    public void guardar(LibroDto obj)throws CloneNotSupportedException;
    public List<Libro> listar();
    public Libro listarPorId(Integer id) throws ResourceNotFoundException;
    public void editar(Libro obj) throws CloneNotSupportedException;
    public void eliminar(Integer id) throws ResourceNotFoundException;
}
