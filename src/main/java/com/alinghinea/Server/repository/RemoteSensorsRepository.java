package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.RemoteSensors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteSensorsRepository extends JpaRepository<RemoteSensors, Long> {
}
