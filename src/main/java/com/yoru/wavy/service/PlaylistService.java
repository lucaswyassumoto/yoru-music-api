package com.yoru.wavy.service;

import com.yoru.wavy.entity.Playlist;
import com.yoru.wavy.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    List<Playlist> listarPlaylists(String nome){

        if(nome == null || nome.isBlank()){
            return List.of();
        }

        return playlistRepository.findByNome(nome);
    }

    Playlist criarPlaylist(Playlist playlist){



        return playlistRepository.save(playlist);

    }

}
