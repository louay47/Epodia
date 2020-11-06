package org.epodia.dao;

import java.util.Collection;


import org.epodia.entities.Conversation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>  {

	@Query(value="SELECT * FROM `Conversation` WHERE code_use_1 IN (code_user_1 , code_user_2) AND code_use_2 IN (code_user_1 , code_user_2)", nativeQuery = true)
	public Collection<Conversation> findExistingChannel(@Param("userOneId") long userOneId, @Param("userTwoId") long userTwoId);
		
	
	@Query(value="SELECT id_conv FROM `Conversation` WHERE code_use_1 IN (code_user_1 , code_user_2) AND code_use_2 IN (code_user_1 , code_user_2)", nativeQuery = true)
	public Long getChannelUuid(@Param("userIdOne") long userIdOne, @Param("userIdTwo") long userIdTwo);
		      
}
