package com.RodrigoNunez.Proyectos.GestionDeTareas.Service;

import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Usuario;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public List<Usuario>octenerListaDeUsuarios(){
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> octenerUsuarioPorId(Integer id){
        return usuarioRepository.findById(id);
    }
    public Optional<Usuario>octenerUsuarioPorEmail(String email){
        Optional<Usuario> byEmail = usuarioRepository.findByEmail(email);
        return byEmail;
    }
    public void eliminarUsuarioPorId(Integer id){
        usuarioRepository.deleteById(id);
    }


}
