package com.RodrigoNunez.Proyectos.GestionDeTareas.Repository;

import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.EstadoTarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Prioridad;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Tarea;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TareaRepository extends JpaRepository<Tarea,Integer> {

//Guardar tarea en la base de datos
     Tarea save (Tarea tarea);

//Octener todas las tareas de la base de datos

     List<Tarea> findAll();

//Octener tarea por Id
     Optional<Tarea> findById(Integer id);

//Octener todas las tareas por Prioridad

    List<Tarea> findByPrioridad (Prioridad prioridad);

//Octener tareas por su estado

    List<Tarea> findByEstado (EstadoTarea estado);

}
