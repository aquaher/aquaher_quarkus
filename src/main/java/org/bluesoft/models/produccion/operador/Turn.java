package org.bluesoft.models.produccion.operador;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bluesoft.models.session.BlUser;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "p_turn")
public class Turn extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer turn;
    
    @ManyToOne
    public BlUser user;

    public LocalDateTime start_date;
    public LocalDateTime end_date;
    public Boolean active;
}
