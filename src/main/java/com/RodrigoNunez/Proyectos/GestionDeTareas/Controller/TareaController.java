package com.RodrigoNunez.Proyectos.GestionDeTareas.Controller;

import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.EstadoTarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Prioridad;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Tarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    private TareaService tareaService;
@Autowired
    public TareaController(TareaService tareaService){
        this.tareaService=tareaService;
    }
    @PostMapping("/GuardarTarea")
    public Tarea GuardarTarea(@RequestBody Tarea tarea){return tareaService.guardarTarea(tarea);
    }

    @GetMapping("/OctenerTodasLasTareas")
    public List<Tarea> OctenerTodasLasTareas(){
    return tareaService.octenerTodasLasTareas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> OctenerTareaPorId(@PathVariable Integer id){
    Optional<Tarea>tarea=tareaService.octenerTareaPorId(id);
    return tarea.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{prioridad}")

    public List<Tarea>OctenerTareaPorPrioridad(@PathVariable Prioridad prioridad){
    return tareaService.octenerTareaPorPrioridad(prioridad);
    }
    @GetMapping("/{estado}")
    public List<Tarea>OctenerTareaPorEstado(@PathVariable EstadoTarea estado){
    return tareaService.octenerTareaPorEstado(estado);
    }


}
