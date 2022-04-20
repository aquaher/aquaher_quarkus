package org.bluesoft.models.produccion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bluesoft.models.produccion.operador.Turn;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "p_w_purified")
public class Purified extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double start_vol;
    public Double end_vol;
    public Double dispatch;
    public Double total_produced;
    public Double total_volume;

    @ManyToOne
    public Tank tank;

    @ManyToOne
    public Turn turn;

}
