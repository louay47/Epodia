package org.epodia.dao;

import java.util.Collection;


import org.epodia.entities.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	
	@Query(value="SELECT * FROM `message` WHERE recipientUserId IN (:userIdOne , :userIdTwo ) AND authorUserId IN (:userIdOne , :userIdTwo )", nativeQuery = true)
	 public Collection<Message> getExistingChatMessages(@Param("userIdOne") long userIdOne, @Param("userIdTwo") long userIdTwo);
		        

}
