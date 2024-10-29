package com.testbackend.uol.controller;

import com.testbackend.uol.dto.UsuarioDTO;
import com.testbackend.uol.model.Usuario;
import com.testbackend.uol.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UsuarioService usuarioService;

    public HomeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/users")
    public String getPlayers(Model model){
        List<Usuario> users = usuarioService.getAll();
        model.addAttribute("users", users);
        return "clients/index";
    }


    @GetMapping("/users/create")
    public String showCreatePage(Model model){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "clients/create";
    }

    @PostMapping("/users/create")
    public String createClient(@Valid @ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, BindingResult result){

        if (usuarioService.getByEmail(usuarioDTO.getEmail()) != null){
            result.addError(
                    new FieldError("usuarioDTO", "email", usuarioDTO.getEmail(), false, null,null,"Email ja cadastrado")
            );
        }


        if (result.hasErrors()){
            return "clients/create";
        }

        usuarioService.saveUsuario(usuarioDTO);

        return "redirect:/users/create";
    }
}
