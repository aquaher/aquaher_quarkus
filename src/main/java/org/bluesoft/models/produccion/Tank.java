package org.bluesoft.models.produccion;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bluesoft.models.produccion.calidad.Quality;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="p_tank")
public class Tank extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String water;

    @OneToMany(
        mappedBy = "tank",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<Quality> quality;

    @OneToMany(
        mappedBy = "tank",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<Water> purified;
}
