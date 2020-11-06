package org.epodia.dao;

import org.epodia.entities.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository extends JpaRepository<Expert, Long> {

}
