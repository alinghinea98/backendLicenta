package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.Kit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitRepository extends JpaRepository<Kit, Long> {


    Kit getKitById(Long id);
}
