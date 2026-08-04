package com.yoru.wavy.controller;

import com.yoru.wavy.dto.MusicaPesquisaDTO;
import com.yoru.wavy.service.MusicaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
