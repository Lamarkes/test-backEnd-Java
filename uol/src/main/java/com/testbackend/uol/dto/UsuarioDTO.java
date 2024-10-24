package com.testbackend.uol.dto;

import com.testbackend.uol.enums.HeroGrupo;
import com.testbackend.uol.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {

    @NotNull
    private String nome;
    @NotNull
    private String email;

    private String telefone;

    @NotNull
    private HeroGrupo grupo;


    public UsuarioDTO(Usuario usuario){

        BeanUtils.copyProperties(usuario,this);
    }
}
