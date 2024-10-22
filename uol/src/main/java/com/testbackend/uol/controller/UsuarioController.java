package com.testbackend.uol.controller;


import com.testbackend.uol.dto.UsuarioDTO;
import com.testbackend.uol.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/new")
    public ResponseEntity<UsuarioDTO> saveUsuario(@Valid @RequestBody UsuarioDTO dto){

        var usuarioCriado = usuarioService.saveUsuario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }
}
