package org.sid.dao;


import org.sid.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientEntityRepository extends JpaRepository<ClientEntity,Integer>{

}
