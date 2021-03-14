package com.alinghinea.Server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alinghinea.Server.entities.Sensors;

public interface SensorsRepository extends JpaRepository<Sensors, Long>{
	
	@Query(value = "SELECT * FROM 16Ec3VcgYd.sensors WHERE user_id = :id", 
			nativeQuery = true)
	List<Sensors> getByUser(long id);

}
