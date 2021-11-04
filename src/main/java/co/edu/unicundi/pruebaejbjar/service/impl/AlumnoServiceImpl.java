package co.edu.unicundi.pruebaejbjar.service.impl;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import co.edu.unicundi.pruebaejbjar.exception.BussinessException;
import co.edu.unicundi.pruebaejbjar.exception.ResourceNotFoundException;
import co.edu.unicundi.pruebaejbjar.repository.IAlumnoRepo;
import javax.ejb.*;
import co.edu.unicundi.pruebaejbjar.service.IAlumnoService;
import java.util.List;

/**
 * Nunca se pasa la clase bean al cliente, se pasa la interface nada más
 * @Stateful 
 * El sistema crea propios objetos del cliente y ningun otro cliente puede acceder
 * los objetos se pueden recuperar cuando desee siempre y cuando no se destruya la conexión
 * Ej: Sessión
 * @Stateless 
 * El sistema crea el objeto del cliente
 * mientras haga la petición nadie más puede acceder a ese objeto
 * despues de realizada la petición y retornar inmediatamente la conexión se destruye pero guarda el objeto en el pool para poder ser usado por otro cliente
 * PROBLEMAS: Guarda sesión de un cliente y otro puede acceder
 * SOLUCIÓN: 
 * 1. No colocar variables globales, si local
 * 2. Las variables locales se destruyen al momento de terminar el metodo 
 * Ej: Request
 * @Singleton
 * El sistema crea el objeto del cliente una sola vez
 * cuando termina la conexión se destruye la misma y el objeto se guarda en el pool
 * todos pueden acceder al mismo objeto por lo que se comparte información
 * el objeto dura lo que dura la aplcación 
 * Ej: Saber cuantos clientes estan conectados, información global
 * @author James Alzate Jr
 * //Logica fuerte de la aplicación (Conexión BBDD, Metodos)
 */
@Stateless //Inversión de control
public class AlumnoServiceImpl implements IAlumnoService {

    @EJB
    public IAlumnoRepo repo;

    @Override
    public List<Alumno> listar() {
        return repo.listarTodos();
    }

    @Override
    public Alumno listarPorId(Integer id) throws ResourceNotFoundException {
        Alumno alumno = repo.listarPorId(id);
        if (alumno != null)
            return alumno;
        else
            throw new ResourceNotFoundException("Alumno no encontrado");
    }

    @Override
    public void guardar(Alumno obj) {
        //Validaciones, recorridos, for
        this.repo.guardar(obj);
    }

    @Override
    public void editar(Alumno obj) throws BussinessException, ResourceNotFoundException {
        if (obj.getId() != null){
            Alumno alumno = this.listarPorId(obj.getId());
            this.repo.editar(obj);
            
            //Logica si la cedula no se puede modificar
            /*if (!obj.getCedula().equals((alumno.getCedula())))
                throw new BussinessException(("Cedula no se puede modificar"));
            
            if (!obj.getCedula().equals((alumno.getCedula())))
                 obj.setCedula(alumno.getCedula());*/
            
            //Logica cedula si modificar (Validar que la cedula no la tenga otra persona y ser diferente a mi propia cedula)
        } else
            throw new BussinessException("El id es obligatorio");
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        Alumno alumno = this.listarPorId(id);
        this.repo.eliminar(alumno);
    }    
}