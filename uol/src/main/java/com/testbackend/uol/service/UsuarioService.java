package com.testbackend.uol.service;


import com.testbackend.uol.dto.UsuarioDTO;
import com.testbackend.uol.enums.HeroGrupo;
import com.testbackend.uol.model.Usuario;
import com.testbackend.uol.repository.UsuarioRepository;
import com.testbackend.uol.util.LigaChoice;
import com.testbackend.uol.util.VingadoresChoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final VingadoresChoice vingadoresChoiceStrategy;
    private final LigaChoice ligaChoiceStrategy;


    public List<UsuarioDTO> getAll(){

        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();

    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuario) {
        var entity = new Usuario(usuario);
        String codinome;
        List<String> list;

        if (entity.getGrupo().getValue().equals(HeroGrupo.VINGADORES.getValue())) {
            list = usuarioRepository.getCodinomeByGrupo(entity.getGrupo());

            codinome = vingadoresChoiceStrategy.choiceHeroClass(list);
        }else{
            list = usuarioRepository.getCodinomeByGrupo(entity.getGrupo());

            codinome = ligaChoiceStrategy.choiceHeroClass(list);
        }

        entity.setCodinome(codinome);

        return new UsuarioDTO(usuarioRepository.save(entity));
        }
}
