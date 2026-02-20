package com.fisio.manager.fisio_manager.repository;

import com.fisio.manager.fisio_manager.entity.HorarioBloqueado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioBloqueadoRepository extends JpaRepository<HorarioBloqueado, Long> {
    List<HorarioBloqueado> findByDate(String date);
}
