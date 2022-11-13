package org.sid.dao;


import org.sid.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketEntityRepository extends JpaRepository<TicketEntity,Integer>{

}
