package co.edu.unicundi.pruebaejbjar.service.impl;

import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.entity.Libro;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.repository.IAutorRepo;
import co.edu.unicundi.pruebaejbjar.service.IAutorService;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author acer
 */
@Stateless
public class AutorServiceImpl implements IAutorService{

    @EJB
    public IAutorRepo repo;
    
    @Override
    public void guardar(Autor obj) throws CloneNotSupportedException {
        int respuesta=this.repo.validarExistencia(obj.getIdentificacion());
        System.out.println(respuesta);
        if(respuesta==1){
         this.repo.guardar(obj);
        }else{
            throw new CloneNotSupportedException("La identificacion ingresada ya esta registrada con otro usuario");  
        }
    }

    @Override
    public List<Autor> listar() {
        List<Autor> listaAutor = repo.listarTodos();
        
        //No se debe haccer
        /*for (Autor a: listaAutor){
            a.getLibro().clear();
            Libro libro = new Libro();
            libro.setAutor(a);
            libro.setDescripcion("des");
            libro.setNoPaginas(20);
            libro.setNombre("nom lib");
            a.getLibro().add(libro);
        }*/
        
        return listaAutor;
    }

    @Override
    public Autor listarPorId(Integer id) throws ResourceNotFoundException{
        Autor autor = repo.listarPorId(id);
        if (autor != null)
            return autor;
        else
            throw new ResourceNotFoundException("Autor no encontrado");
    }

    @Override
    public void editar(Autor obj) {
        //obj.setLibro(null); //Elimina los libros del autor
        //Solución, hacer querys de edicion o quitar la cascada
        this.repo.editar(obj);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException{
        Autor autor = listarPorId(id);
        this.repo.eliminar(autor); 
    }

    @Override
    public List<VistaAutorLibro> obtener() {
        return this.repo.obtener();
    }
    
}
