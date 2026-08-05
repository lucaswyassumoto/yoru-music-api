package com.yoru.wavy.service;

import com.yoru.wavy.entity.Playlist;
import com.yoru.wavy.entity.Usuario;
import com.yoru.wavy.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> listarPlaylists(String nome){

        if(nome == null || nome.isBlank()){
            return List.of();
        }

        return playlistRepository.findByNome(nome);
    }

    public Playlist criarPlaylist(Playlist playlist){

        if (playlist.getNome().isBlank() || playlist.getNome() == null){
            throw new IllegalArgumentException("Você precisa digitar um nome válido");
        }

        playlist.setNome(
                playlist.getNome().trim()
        );

        if (playlist.getCapaUrl() == null || playlist.getCapaUrl().isBlank()){
            playlist.setCapaUrl("/");
        }

        return playlistRepository.save(playlist);

    }

    public Playlist editarPlaylist(Playlist playlist){

        Optional<Playlist> playlistEncontrada = playlistRepository.findById(playlist.getId());

        if (playlistEncontrada.isEmpty()){
            throw new IllegalArgumentException("Playlist não encontrada");
        }

        Playlist playlistBanco = playlistEncontrada.get();

        if (playlist.getNome() == null || playlist.getNome().isBlank()){
            throw new IllegalArgumentException("Digite um nome para a playlist");
        }

        playlistBanco.setNome(
                playlist.getNome().trim()
        );

        if (playlist.getCapaUrl() != null){
            playlistBanco.setCapaUrl(playlist.getCapaUrl().trim());
        }

        return playlistRepository.save(playlistBanco);

    }

}
