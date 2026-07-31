package com.yoru.wavy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "capa_url")
    private String capaUrl;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    public Playlist(){}

    public Playlist(String nome, Usuario usuario, String capaUrl){
        this.nome = nome;
        this.usuario = usuario;
        this.capaUrl = capaUrl;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public String getCapaUrl() {
        return capaUrl;
    }
}
