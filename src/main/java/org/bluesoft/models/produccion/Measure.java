package org.bluesoft.models.produccion;


import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.bluesoft.models.produccion.operador.Turn;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "p_measure")
public class Measure extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalTime measurement_time;
    public Double measurement_channel;
    public Double reading_kwh_1;
    public Double reading_kvarh_8;
    public Double reading_kwh_13;
    public Double reading_kvarh_14;

    @OneToOne
    public Turn turn;
}
