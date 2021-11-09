package co.edu.unicundi.pruebaejbjar.repository;

import co.edu.unicundi.pruebaejbjar.entity.Libro;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface ILibroRepo extends ICrud<Libro, Integer>{
        
}