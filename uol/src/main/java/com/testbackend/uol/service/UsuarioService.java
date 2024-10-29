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


    public List<Usuario> getAll(){

        return usuarioRepository.findAll();

    }

    public UsuarioDTO getByEmail(String email){
        return usuarioRepository.getUsuarioByEmail(email);
    }

    public Usuario getUsuarioById(Long id){

        return usuarioRepository.getUsuarioById(id);
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuario) {
        var entity = new Usuario(usuario);
        String codinome = "";
        List<String> listUsuariosGrupo;

        if (entity.getGrupo().getValue().equals(HeroGrupo.VINGADORES.getValue())) {
            listUsuariosGrupo = usuarioRepository.getCodinomeByGrupo(entity.getGrupo());

            codinome = vingadoresChoiceStrategy.choiceHeroClass(listUsuariosGrupo);
        }
        if(entity.getGrupo().getValue().equals(HeroGrupo.LIGADAJUSTICA.getValue())){
            listUsuariosGrupo = usuarioRepository.getCodinomeByGrupo(entity.getGrupo());

            codinome = ligaChoiceStrategy.choiceHeroClass(listUsuariosGrupo);
        }

        entity.setCodinome(codinome);

        return new UsuarioDTO(usuarioRepository.save(entity));
        }


        public void updateUsuario(Long id, Usuario usuario){
            Usuario usuarioAtualizado = usuarioRepository.getUsuarioById(id);

            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setEmail(usuario.getEmail());
            usuarioAtualizado.setTelefone(usuario.getTelefone());

            usuarioRepository.save(usuarioAtualizado);

        }

        public void deleteUsuario(Long id){
            var user = usuarioRepository.getUsuarioById(id);

            usuarioRepository.delete(user);
        }

}
