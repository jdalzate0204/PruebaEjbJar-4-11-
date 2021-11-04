/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.pruebaejbjar.repository;

import co.edu.unicundi.pruebaejbjar.entity.Alumno;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface ILibroRepo extends ICrud<Alumno, Integer>{
        
}