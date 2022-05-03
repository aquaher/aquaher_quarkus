package org.bluesoft.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "bl_menu")
public class BlMenu extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String module;
    public String icon;
    public Long orden;

    @OneToMany(
        mappedBy = "menu",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<BlAccess> accesses;

}
