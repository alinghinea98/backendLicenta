package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {


    @Query(value = "SELECT * FROM 16Ec3VcgYd.alert WHERE user_id = :id",
            nativeQuery = true)
    List<Alert> getByUser(long id);

}
