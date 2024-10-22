package com.testbackend.uol.service;


import com.testbackend.uol.dto.UsuarioDTO;
import com.testbackend.uol.enums.HeroGrupo;
import com.testbackend.uol.model.Usuario;
import com.testbackend.uol.repository.UsuarioRepository;
import com.testbackend.uol.util.HeroClassConfiguration;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {


    private final HeroClassConfiguration configuration;
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(HeroClassConfiguration configuration, UsuarioRepository usuarioRepository) {
        this.configuration = configuration;
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioDTO saveUsuario(UsuarioDTO usuario){
        var entity = new Usuario(usuario);
        String codinome = "";
        if (usuario.getGrupo().getValue().equals(HeroGrupo.VINGADORES.getValue())){
            var list = usuarioRepository.getUsuarioByCodinome();

            do {
                codinome = configuration.getVingador();
            } while (list.contains(codinome));

        }else if (usuario.getGrupo().getValue().equals(HeroGrupo.LIGADAJUSTICA.getValue())){

            var list = usuarioRepository.getUsuarioByCodinome();

            do {
                codinome = configuration.getLigaDaJustica();
            } while (list.contains(codinome));
        }

        entity.setCodinome(codinome);

        return new UsuarioDTO(usuarioRepository.save(entity));
    }
}
