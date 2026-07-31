package com.yoru.wavy.service;

import com.yoru.wavy.dto.ArtistaResumoDTO;
import com.yoru.wavy.dto.MusicaPesquisaDTO;
import com.yoru.wavy.entity.Artista;
import com.yoru.wavy.entity.Musica;
import com.yoru.wavy.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public MusicaService (MusicaRepository musicaRepository){
        this.musicaRepository = musicaRepository;
    }

    public List<MusicaPesquisaDTO> pesquisar(String titulo){

        List<Musica> musicas = musicaRepository.findByTitulo(titulo);

        List<MusicaPesquisaDTO> resultado = new ArrayList<>();

        for(Musica musica : musicas){

            ArtistaResumoDTO artistaDTO = new ArtistaResumoDTO(
                    musica.getArtista().getId(),
                    musica.getArtista().getNome()
            );

            MusicaPesquisaDTO musicaDTO = new MusicaPesquisaDTO(
                    musica.getId(),
                    musica.getTitulo(),
                    artistaDTO,
                    musica.getCapaUrl()
            );

            resultado.add(musicaDTO);

        }

        return resultado;

    }

    public Musica criarMusica(Musica musica){

        if(musica.getTitulo() == null || musica.getTitulo().isBlank()){
            throw new IllegalArgumentException("Você precisa informar o nome da música");
        }

        musica.setTitulo(
                musica.getTitulo().trim()
        );

        return musicaRepository.save(musica);

    }

}
