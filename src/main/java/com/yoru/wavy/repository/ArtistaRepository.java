package com.yoru.wavy.repository;

import com.yoru.wavy.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    List<Artista> findByNome(String nome);

}
