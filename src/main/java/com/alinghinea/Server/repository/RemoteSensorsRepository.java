package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.RemoteSensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RemoteSensorsRepository extends JpaRepository<RemoteSensors, Long> {

    @Query(value = "SELECT * FROM 16Ec3VcgYd.remote WHERE user_id = :id",
            nativeQuery = true)
    RemoteSensors getByUser(long id);
}
