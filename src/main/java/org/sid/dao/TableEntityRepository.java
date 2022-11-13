package org.sid.dao;


import org.sid.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableEntityRepository extends JpaRepository<TableEntity,Integer>{

}
