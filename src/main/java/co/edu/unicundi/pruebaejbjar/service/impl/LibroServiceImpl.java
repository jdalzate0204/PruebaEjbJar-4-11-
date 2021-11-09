package co.edu.unicundi.pruebaejbjar.service.impl;

import co.edu.unicundi.pruebaejbjar.dto.LibroDto;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.entity.Libro;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.repository.ILibroRepo;
import co.edu.unicundi.pruebaejbjar.service.ILibroService;
import java.util.List;
import javax.ejb.*;

/**
 *
 * @author acer
 */
@Stateless
public class LibroServiceImpl implements ILibroService {

    @EJB
    public ILibroRepo repo;
    
    //Forma1
    /*@Override
    public void guardar(Libro obj) throws CloneNotSupportedException {
        Autor autor = new Autor();
        autor.setId(obj.getIdAutor());
        obj.setAutor(autor);
        
        this.repo.guardar(obj);
    }*/
    
    @Override
    public void guardar(LibroDto obj) throws CloneNotSupportedException {
        Autor autor = new Autor();
        autor.setId(obj.getIdAutor());
        
        Libro libro = new Libro();
        libro.setDescripcion(obj.getDescripcion());
        libro.setNoPaginas(obj.getNoPaginas());
        libro.setNombre(obj.getNombre());
        libro.setAutor(autor);
        
        this.repo.guardar(libro);
    }

    @Override
    public List<Libro> listar() {
        return this.repo.listarTodos();
    }

    @Override
    public Libro listarPorId(Integer id) throws ResourceNotFoundException {
        Libro libro = repo.listarPorId(id);
        
        if (libro != null)
            return libro;
        else
            throw new ResourceNotFoundException("Libro no encontrado");
    }

    @Override
    public void editar(Libro obj) throws CloneNotSupportedException {
        Libro libro = repo.listarPorId(obj.getId());
        libro.setDescripcion(obj.getDescripcion());
        libro.setNombre(obj.getNombre());
        libro.setNoPaginas(obj.getNoPaginas());
        this.repo.editar(libro);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        Libro libro = repo.listarPorId(id);
        this.repo.eliminar(libro);
    }
    
}
