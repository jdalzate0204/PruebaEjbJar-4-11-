package co.edu.unicundi.pruebaejbjar.repository;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IAlumnoRepo extends ICrud<Alumno, Integer>{
    
}
