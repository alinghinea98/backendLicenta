package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorsRepository extends JpaRepository<Sensors, Long>{
	
	@Query(value = "SELECT * FROM 16Ec3VcgYd.sensors WHERE user_id = :id", 
			nativeQuery = true)
	List<Sensors> getByUser(long id);

}
