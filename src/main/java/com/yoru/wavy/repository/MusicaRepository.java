package com.yoru.wavy.repository;

import com.yoru.wavy.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByUsuarioNome(String nome);
    List<Musica> findByTitulo(String titulo);

}
