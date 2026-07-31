package com.yoru.wavy.dto;

public class MusicaPesquisaDTO {

    private Long id;

    private String titulo;

    private ArtistaResumoDTO artista;

    private String capaUrl;

    public MusicaPesquisaDTO(){}

    public MusicaPesquisaDTO(Long id, String titulo, ArtistaResumoDTO artista, String capaUrl){
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.capaUrl = capaUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArtistaResumoDTO getArtista() {
        return artista;
    }

    public String getCapaUrl() {
        return capaUrl;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(ArtistaResumoDTO artista) {
        this.artista = artista;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }
}
