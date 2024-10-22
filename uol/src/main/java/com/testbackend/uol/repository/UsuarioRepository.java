package com.testbackend.uol.repository;

import com.testbackend.uol.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u.codinome FROM Usuario u")
    List<String> getUsuarioByCodinome();
}
