package com.yoru.wavy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    private Integer duracao;

    @Column(name = "mp3_url")
    private String mp3Url;

    @Column(name = "capa_url")
    private String capaUrl;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    public Musica(){}

    public Musica(String titulo, Usuario usuario, Artista artista, Genero genero, Integer duracao, String mp3Url, String capaUrl){
        this.titulo = titulo;
        this.usuario = usuario;
        this.artista = artista;
        this.genero = genero;
        this.duracao = duracao;
        this.mp3Url = mp3Url;
        this.capaUrl = capaUrl;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Artista getArtista() {
        return artista;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public String getCapaUrl() {
        return capaUrl;
    }
}
