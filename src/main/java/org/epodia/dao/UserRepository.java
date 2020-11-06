package org.epodia.dao;

import java.util.Collection;


import org.epodia.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	@Query(value = "SELECT * FROM `user` WHERE username =:username", nativeQuery = true)
	public User getUserByUsername(@Param("username") String username);
	
	@Query("SELECT user FROM User user WHERE  user.id IN ( SELECT relation.patient.id FROM Relation relation WHERE relation.expert.id = :id )")
	public Collection<User> getPatientList(@Param("id") Long id);
	
	@Query("SELECT user FROM User user WHERE  user.id IN ( SELECT relation.expert.id  FROM Relation relation WHERE relation.patient.id = :id )")
	public Collection<User> getExpertList(@Param(value = "id") Long id);
	
	@Query(value = "SELECT * FROM `user` WHERE email =:email", nativeQuery = true)
	public User findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM `user` WHERE confirmation_token LIKE :confirmationToken", nativeQuery = true)
    public User findByConfirmationToken(@Param("confirmationToken") String confirmationToken);
	
	

}
