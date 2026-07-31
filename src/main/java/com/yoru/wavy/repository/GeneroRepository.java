package com.yoru.wavy.repository;

import com.yoru.wavy.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

    List<Genero> findByNome(String nome);

}
