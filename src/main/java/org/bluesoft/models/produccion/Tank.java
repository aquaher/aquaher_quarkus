package org.bluesoft.models.produccion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="p_tank")
public class Tank extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String water;

}
