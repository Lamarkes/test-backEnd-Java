package com.testbackend.uol.model;

import com.testbackend.uol.dto.UsuarioDTO;
import com.testbackend.uol.enums.HeroGrupo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Table(name = "tb_usuario")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(length = 20)
    private String telefone;
    @Column(nullable = false)
    private String codinome;
    @Enumerated(value = EnumType.STRING)
    private HeroGrupo grupo;


    public Usuario(UsuarioDTO dto){

        BeanUtils.copyProperties(dto,this);
    }

}
