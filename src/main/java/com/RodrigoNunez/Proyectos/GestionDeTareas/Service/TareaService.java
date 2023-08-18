package com.RodrigoNunez.Proyectos.GestionDeTareas.Service;

import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.EstadoTarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Prioridad;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Tarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    private TareaRepository tareaRepository;
@Autowired
    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository=tareaRepository;
    }
    public Tarea guardarTarea(Tarea tarea){
    return tareaRepository.save(tarea);
    }
    public List<Tarea> octenerTodasLasTareas(){
    return tareaRepository.findAll();
    }
    public Optional<Tarea> octenerTareaPorId(Integer id){
    return tareaRepository.findById(id);
    }
    public List<Tarea> octenerTareaPorPrioridad(Prioridad prioridad){
    return tareaRepository.findByPrioridad(prioridad);
    }
    public List<Tarea> octenerTareaPorEstado (EstadoTarea estado){
    return tareaRepository.findByEstado(estado);
    }



}
