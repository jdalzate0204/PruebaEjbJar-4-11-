package co.edu.unicundi.pruebaejbjar.repository;

import co.edu.unicundi.pruebaejbjar.dto.AutorDto;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IAutorRepo extends ICrud<Autor, Integer>{
    public List<VistaAutorLibro> obtener();
    public int validarExistenciaPorId(Integer id);
    public List<AutorDto> listarTodosModelMaper();
    public int validarExistencia(String identificacion);
    public List<Autor> listarId(Integer id);
}
