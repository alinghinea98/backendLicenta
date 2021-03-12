package com.alinghinea.Server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alinghinea.Server.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	@Query(value = "SELECT EXISTS(SELECT * FROM application_db.utilizatori WHERE application_db.utilizatori.username = :username)", 
			nativeQuery = true)
	boolean existsByUsernameNotId(@Param("username") String username);

	User getById(Long id);
	
	@Query(value = "SELECT * FROM application_db.utilizatori WHERE username = :username AND password = :password", 
			nativeQuery = true)
	User getByUsernameAndPassword(@Param("username")String username, @Param("password") String password);
	
	long deleteByUsername(String username); // for admin type only
	
	@Modifying
	@Query(value="UPDATE  application_db.utilizatori SET is_deleted = 1 where username = :username AND role = :role", nativeQuery = true)
	void deleteUserByRole(@Param("username") String username, @Param("role") String role); // for caregiver and enduser
	
}
