package co.edu.unicundi.pruebaejbjar.repository.impl;

import co.edu.unicundi.pruebaejbjar.dto.AutorDto;
import co.edu.unicundi.pruebaejbjar.entity.Autor;
import co.edu.unicundi.pruebaejbjar.repository.IAutorRepo;
import co.edu.unicundi.pruebaejbjar.view.VistaAutorLibro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Stateless
public class AutorRepoImpl implements IAutorRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em; //Se encarga de hacer operaciones sobre la bbdd
    
    @Override
    public void guardar(Autor obj) {
        this.em.persist(obj);
    }

    @Override
    public List<Autor> listarTodos() {
        //TypedQuery<Autor> query = em.createNamedQuery("Autor.ListarTodos", Autor.class);
        TypedQuery<Autor> query = em.createNamedQuery("Autor.ListarTodosSinLibro", Autor.class);
        return query.getResultList();
    }
    
    @Override
    public List<AutorDto> listarTodosModelMaper() {
        TypedQuery<AutorDto> query = em.createNamedQuery("Autor.ListarTodos", AutorDto.class);
        return query.getResultList();
    }

    @Override
    public Autor listarPorId(Integer id) {
        Query query = em.createNamedQuery("Autor.ListarPorId");
        query.setParameter("id", id);
        Autor autor = (Autor) query.getSingleResult();
        return autor;
    }

    @Override
    public void editar(Autor obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Autor obj) {
        this.em.remove(obj);
    }

    @Override
    public List<VistaAutorLibro> obtener() {
        TypedQuery<VistaAutorLibro> query = em.createNamedQuery("VistaAutor.Listar", VistaAutorLibro.class);
        return query.getResultList();
    }  

    @Override
    public int validarExistencia(String identificacion) {
        Query query = em.createNamedQuery("Autor.BuscarId");
        query.setParameter("identificacion", identificacion);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }

    @Override
    public int validarExistenciaPorId(Integer id) {
        Query query = em.createNamedQuery("Autor.ContarId");
        query.setParameter("id", id);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }
}
