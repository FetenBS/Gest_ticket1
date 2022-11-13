package org.sid.entities;



import java.util.List;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class TableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private int nbCouvert;
@Enumerated(EnumType.STRING)

private TableType type;

private double supplement;

@OneToMany(mappedBy="table")
private List<TicketEntity>tickets;
}
