package com.RodrigoNunez.Proyectos.GestionDeTareas.Repository;
import com.RodrigoNunez.Proyectos.GestionDeTareas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{

    /*//Guardar usuario en la base de datos
    Usuario save (Usuario usuario);

    //Octener los usuarios de la base de datos

    List<Usuario> findAll();

    //Octener Usuario por Id
    Optional<Usuario> findById(Integer Id);*/

    //Octener Usuario por Email
    Optional<Usuario> findByEmail(String email);

    //Eliminar Usuario por Id
    //void deleteById(Integer id);


}
