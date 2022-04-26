package org.bluesoft.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "bl_menu")
public class BlMenu extends PanacheEntityBase {
    @Id
    public String menu;
    public String title;
    public String module;
    public Long orden;

    @OneToMany(
        mappedBy = "menu",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<BlAccess> accesses;

}
