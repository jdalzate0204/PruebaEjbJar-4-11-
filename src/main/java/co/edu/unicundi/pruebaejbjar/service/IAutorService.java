package co.edu.unicundi.pruebaejbjar.service;

import co.edu.unicundi.pruebaejbjar.dto.AutorDto;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IAutorService {
    public void guardar(Autor obj)throws CloneNotSupportedException;
    public List<Autor> listar();
    public Autor listarPorId(Integer id) throws ResourceNotFoundException;
    public void editar(Autor obj) throws CloneNotSupportedException;
    public void eliminar(Integer id) throws ResourceNotFoundException;
    public List<VistaAutorLibro> obtener();
    public List<AutorDto> listarModelMaper();
    public List<Autor> listarId(Integer id) throws ResourceNotFoundException;
}
