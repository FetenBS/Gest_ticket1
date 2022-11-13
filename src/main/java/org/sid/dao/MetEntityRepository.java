package org.sid.dao;

import java.time.LocalDate;

import org.sid.entities.MetEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MetEntityRepository extends JpaRepository<MetEntity,Integer>{

	@Query(nativeQuery=true, value="select id From met_entity where id=("
			+ "select mets_id as id from compose where mets_id in("
			+ "select id from met_entity where dtype='Plat' and id in("
			+ "select mets_id from compose where tickets_numero from tickets_entity"
			+ "where"
			+"date_time< :fin"  
			+"and date_time> :deb)))"
			+"group by mets_id"
			+"order by count(*) desc"
			+"limit 1)")
	MetEntity plasPlusAcheter(@Param("deb") LocalDate deb,@Param("fin") LocalDate fin);
			
			
}
