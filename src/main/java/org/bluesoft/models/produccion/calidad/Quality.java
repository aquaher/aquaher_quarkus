package org.bluesoft.models.produccion.calidad;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bluesoft.models.produccion.Tank;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="p_quality")
public class Quality extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public Boolean active;

    @OneToMany(
        mappedBy = "quality",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<Parameter> parameter;

    @ManyToOne(optional=false)
    public Tank tank;
}
