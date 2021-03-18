package com.alinghinea.Server.repository;

import com.alinghinea.Server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	@Query(value = "SELECT EXISTS(SELECT * FROM 16Ec3VcgYd.utilizatori WHERE 16Ec3VcgYd.utilizatori.username = :username)", 
			nativeQuery = true)
	boolean existsByUsernameNotId(@Param("username") String username);

	User getById(Long id);
	
	@Query(value = "SELECT * FROM 16Ec3VcgYd.utilizatori WHERE username = :username AND password = :password", 
			nativeQuery = true)
	User getByUsernameAndPassword(@Param("username")String username, @Param("password") String password);
	
	long deleteByUsername(String username); // for admin type only
	
	@Modifying
	@Query(value="UPDATE  16Ec3VcgYd.utilizatori SET is_deleted = 1 where username = :username AND role = :role", nativeQuery = true)
	void deleteUserByRole(@Param("username") String username, @Param("role") String role);

	@Query(value = "SELECT * FROM 16Ec3VcgYd.utilizatori WHERE ENDUSER_PIN = :enduserPin",
			nativeQuery = true)
	User getUserByPin(@Param("enduserPin")double enduserPin);
}
