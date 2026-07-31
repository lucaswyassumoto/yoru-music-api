package com.yoru.wavy.repository;

import com.yoru.wavy.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    List<Playlist> findByNome(String nome);

}
