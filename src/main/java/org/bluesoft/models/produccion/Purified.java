package org.bluesoft.models.produccion;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "p_w_purified")
public class Purified extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer turn;
    public LocalDate date;
    public String operator;
    public Double start_vol;
    public Double end_vol;
    public Double dispatch;
    public Double total_produced;
    public Double total_volume;

    @ManyToOne
    public Tank tank;

}