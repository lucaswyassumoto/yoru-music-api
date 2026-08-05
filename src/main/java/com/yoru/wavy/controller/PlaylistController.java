package com.yoru.wavy.controller;

import com.yoru.wavy.entity.Playlist;
import com.yoru.wavy.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController (PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> listarPlaylists(@RequestParam String nome){
        return playlistService.listarPlaylists(nome);
    }

    @PostMapping
    public Playlist criarPlaylist(@RequestBody Playlist playlist){
        return playlistService.criarPlaylist(playlist);
    }

}
