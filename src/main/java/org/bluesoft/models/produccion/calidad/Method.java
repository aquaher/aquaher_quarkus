package org.bluesoft.models.produccion.calidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bluesoft.models.Unit;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="p_method")
public class Method extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String symbol;

    @ManyToOne
    public Unit unit;
}
