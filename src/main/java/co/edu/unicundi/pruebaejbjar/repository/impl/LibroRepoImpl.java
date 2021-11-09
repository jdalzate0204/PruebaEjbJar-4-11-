package co.edu.unicundi.pruebaejbjar.repository.impl;

import co.edu.unicundi.pruebaejbjar.entity.Libro;
import co.edu.unicundi.pruebaejbjar.repository.ILibroRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
/**
 *
 * @author acer
 */
@Stateless
public class LibroRepoImpl implements ILibroRepo {
    
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager em; //Se encarga de hacer operaciones sobre la bbdd

    @Override
    public void guardar(Libro obj) {
        this.em.persist(obj);
    }

    @Override
    public List<Libro> listarTodos() {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.ListarTodos", Libro.class);
        return query.getResultList();
    }

    @Override
    public Libro listarPorId(Integer id) {
        return em.find(Libro.class, id);
    }

    @Override
    public void editar(Libro obj) {
        this.em.merge(obj);
    }

    @Override
    public void eliminar(Libro obj) {
        this.em.remove(obj);
    }
    
}
