package com.yoru.wavy.dto;

public class UsuarioPublicDTO {

    private Long id;

    private String nome;

    private String email;

    private String pfpUrl;

    public UsuarioPublicDTO(){}

    public UsuarioPublicDTO(Long id, String nome, String email, String pfpUrl){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pfpUrl = pfpUrl;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPfpUrl() {
        return pfpUrl;
    }


    public void setPfpUrl(String pfpUrl) {
        this.pfpUrl = pfpUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
