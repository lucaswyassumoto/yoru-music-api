package com.yoru.wavy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Column(name = "senha")
    private String senhaHash;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    @Column(name = "pfp_url")
    private String pfpUrl;


    public Usuario(){}

    public Usuario(String nome, String email, String senhaHash, String pfpUrl){
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.pfpUrl = pfpUrl;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public void setPfpUrl(String pfpUrl) {
        this.pfpUrl = pfpUrl;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public String getPfpUrl() {
        return pfpUrl;
    }
}
