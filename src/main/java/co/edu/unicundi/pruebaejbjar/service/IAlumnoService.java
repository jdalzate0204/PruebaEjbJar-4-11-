package co.edu.unicundi.pruebaejbjar.service;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ejb.*;

/**
 *
 * @author James Alzate
 */
//Si no se coloca ninguna anotación, default @Local
//@Remote
@Local
public interface IAlumnoService {
    public void guardar(Alumno obj);
    public List<Alumno> listar();
    public Alumno listarPorId(Integer id) throws ResourceNotFoundException;
    public void editar(Alumno obj) throws BussinessException, ResourceNotFoundException;
    public void eliminar(Integer id) throws ResourceNotFoundException;
}
