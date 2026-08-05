package com.yoru.wavy.controller;

import com.yoru.wavy.entity.Usuario;
import com.yoru.wavy.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

    @GetMapping("/buscar-usuario")
    public List<Usuario> listarPorNome(@RequestParam String nome){
        return usuarioService.listarPorNome(nome);
    }

}
