package co.edu.unicundi.pruebaejbjar.service.impl;

import co.edu.unicundi.pruebaejbjar.dto.AutorDto;
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
        int respuesta = this.repo.validarExistencia(obj.getIdentificacion());
        
        if(respuesta == 0){
            if (obj.getLibro() != null && !obj.getLibro().isEmpty()){
                for (Libro l: obj.getLibro())
                    l.setAutor(obj); 
            }
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
    public List<AutorDto> listarModelMaper() {
        return this.repo.listarTodosModelMaper();
    }

    @Override
    public Autor listarPorId(Integer id) throws ResourceNotFoundException{
        int conteo = repo.validarExistenciaPorId(id);
        
        if (conteo == 1)
            return repo.listarPorId(id);
        else
            throw new ResourceNotFoundException("Autor no encontrado");
    }
    
    @Override
    public List<Autor> listarId(Integer id) throws ResourceNotFoundException {
        int conteo = repo.validarExistenciaPorId(id);
        
        if (conteo == 1)
            return repo.listarId(id);
        else
            throw new ResourceNotFoundException("Autor no encontrado");
    }

    @Override
    public void editar(Autor obj) throws CloneNotSupportedException{
        //obj.setLibro(null); //Elimina los libros del autor
        //Solución, hacer querys de edicion o quitar la cascada
        int respuesta = this.repo.validarExistencia(obj.getIdentificacion());
        Autor autor = this.repo.listarPorId(obj.getId());
        
        if ((respuesta == 0) || ((autor.getId() == obj.getId()) && (autor.getIdentificacion().equals(obj.getIdentificacion())))) {
            obj.setLibro(obj.getLibro()); 
            this.repo.editar(obj);
        } else 
            throw new CloneNotSupportedException("La identificacion ingresada ya esta registrada con otro usuario");
        
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
