package com.testbackend.uol.dto;

import com.testbackend.uol.enums.HeroGrupo;
import com.testbackend.uol.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    @NotEmpty(message = "O nome deve ser informado!")
    private String nome;
    @NotEmpty(message = "O email deve ser informado!")
    @Email(message = "infome um email valido")
    private String email;
    private String telefone;
    private HeroGrupo grupo;


    public UsuarioDTO(Usuario usuario){

        BeanUtils.copyProperties(usuario,this);
    }
}
