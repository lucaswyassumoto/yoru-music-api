package com.yoru.wavy.controller;

import com.yoru.wavy.dto.MusicaPesquisaDTO;
import com.yoru.wavy.entity.Musica;
import com.yoru.wavy.service.MusicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController (MusicaService musicaService){
        this.musicaService = musicaService;
    }

    @GetMapping("/pesquisar")
    public List<MusicaPesquisaDTO> pesquisar(@RequestParam String titulo){
        return musicaService.pesquisar(titulo);
    }

    @PostMapping("/criar-musica")
    public Musica criarMusica(@RequestBody Musica musica){
        return musicaService.criarMusica(musica);
    }

}
