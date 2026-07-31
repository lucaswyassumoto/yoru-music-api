package com.yoru.wavy.service;

import com.yoru.wavy.entity.Artista;
import com.yoru.wavy.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository){
        this.artistaRepository = artistaRepository;
    }

    List<Artista> listarArtista(String nome){

        if(nome == null || nome.isBlank()){
            return List.of();
        }

        nome.trim();

        return artistaRepository.findByNome(nome);

    }

    Artista criarArtista(Artista artista){

        if(artista.getNome() == null || artista.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa informar o nome do artista");
        }

        artista.setNome(artista.getNome().trim());

        return artistaRepository.save(artista);

    }

}
