package org.bluesoft.models.produccion.calidad;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="p_quality")
public class Quality extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public String lote;

    
}
