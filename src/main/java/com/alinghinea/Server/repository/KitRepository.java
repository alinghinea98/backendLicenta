package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.Kit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KitRepository extends JpaRepository<Kit, Long> {


    @Query(value = "SELECT * FROM 16Ec3VcgYd.kit WHERE id = :id",
            nativeQuery = true)
    Kit getKitById(@Param("id") Long id);
}
