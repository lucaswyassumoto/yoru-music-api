package com.yoru.wavy.service;

import com.yoru.wavy.entity.Artista;
import com.yoru.wavy.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository){
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> listarArtista(String nome){

        if(nome == null || nome.isBlank()){
            return List.of();
        }

        nome.trim();

        return artistaRepository.findByNome(nome);

    }

    public Artista criarArtista(Artista artista){

        if(artista.getNome() == null || artista.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa informar o nome do artista");
        }

        artista.setNome(artista.getNome().trim());

        return artistaRepository.save(artista);

    }

    public Artista editarArtista(Artista artista){

        Optional<Artista> artistaEncontrado = artistaRepository.findById(artista.getId());

        if (artistaEncontrado.isEmpty()){
            throw new IllegalArgumentException("Artista não encontrado");
        }

        Artista artistaBanco = artistaEncontrado.get();

        if (artista.getNome() == null || artista.getNome().isBlank()){
            throw new IllegalArgumentException("Você precisa digitar um nome válido");
        }

        artistaBanco.setNome(
                artista.getNome().trim()
        );

        return artistaRepository.save(artistaBanco);

    }



}
