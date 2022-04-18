package org.bluesoft.models.produccion;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.bluesoft.models.produccion.operador.Turn;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "p_bitacora")
public class Bitacora extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalTime start_time;
    public LocalTime end_time;
    public String section;
    
    @OneToOne
    public Turn turn;

    @OneToOne
    public Event event;

    @Column(length = 500)
    public String description;
}
