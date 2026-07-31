package com.yoru.wavy.service;

import com.yoru.wavy.entity.Usuario;
import com.yoru.wavy.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarPorNome(String nome){

        if(nome == null || nome.isBlank()){
            return List.of();
        }

        return usuarioRepository.findByNome(nome);
    }

    public Usuario cadastrar(Usuario usuario){

        if(usuario.getEmail() == null || usuario.getEmail().isBlank()){
            throw new IllegalArgumentException("Você precisa informar um e-mail");
        }

        usuario.setEmail(
                usuario.getEmail().trim().toLowerCase()
        );

        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Esse email já possui um cadastro");
        }

        if(usuario.getNome() == null || usuario.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa informar um nome");
        }

        usuario.setNome(
                usuario.getNome().trim()
        );

        if(usuario.getSenhaHash() == null || usuario.getSenhaHash().isBlank()){
            throw new IllegalArgumentException("Você precisa informar uma senha");
        }

        if(usuario.getSenhaHash().length() < 8){
            throw new IllegalArgumentException("A senha deve conter no mínimo 8 caracteres");
        }

        if(usuario.getPfpUrl() == null || usuario.getPfpUrl().isBlank()){
            usuario.setPfpUrl("/");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenhaHash(
                encoder.encode(usuario.getSenhaHash())
        );

        return usuarioRepository.save(usuario);

    }

}
