package com.RodrigoNunez.Proyectos.GestionDeTareas.Controller;

import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Tarea;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Usuario;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    @PostMapping("/GuardarUsuario")
    public Usuario GuardarUsuario ( Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
    @GetMapping("/octenerTodosLosUsuario")
    public List<Usuario>octenerTodosLosUsuario(){
        return usuarioService.octenerListaDeUsuarios();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> OctenerUsuarioPorId(@PathVariable Integer id){
        Optional<Usuario> usuario = usuarioService.octenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/email{email}")
    public Optional<Usuario> OctenerUsuarioPorEmail(@PathVariable String email){
        return usuarioService.octenerUsuarioPorEmail(email);
    }

    @DeleteMapping("/EliminarUsuarioPorId{id}")
    public void EliminarUsuarioPorId(@PathVariable Integer id){
        usuarioService.eliminarUsuarioPorId(id);
    }

}
