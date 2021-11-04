package co.edu.unicundi.pruebaejbjar.repository.impl;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import co.edu.unicundi.pruebaejbjar.repository.IAlumnoRepo;

/**
 *
 * @author acer
 */
@Stateless
public class AlumnoRepoImpl implements IAlumnoRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em; //Se encarga de hacer operaciones sobre la bbdd
    
    @Override
    public List<Alumno> listarTodos() {
        TypedQuery<Alumno> query = em.createNamedQuery("Alumno.ListarTodos", Alumno.class);
        return query.getResultList();
    }

    @Override
    public Alumno listarPorId(Integer id) {
        return em.find(Alumno.class, id);
    }

    @Override
    public void guardar(Alumno obj) {
        this.em.persist(obj);
    }

    @Override
    public void editar(Alumno obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Alumno obj) {
        this.em.remove(obj);
    }
}
