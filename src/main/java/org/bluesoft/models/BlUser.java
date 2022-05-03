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
@Table(name="bl_user")
public class BlUser extends PanacheEntityBase {
    @Id
    public String id;
    public String periodo;
    public String username;
    public String type;
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<BlAccess> accesses;

    public BlUser() {
    }

    public BlUser(String id, String periodo, String username) {
        this.id = id;
        this.periodo = periodo;
        this.username = username;
    }
    
    public BlUser(String id) {
        this.id = id;
    }    
}

/*
 @ManyToOne(fetch = FetchType.LAZY)
    public Department department;

    public static List<Employee> findEmployeesByDepartmentId(Long departmentId) {
        return find("department.id", departmentId).list();
    }

    public static List<Employee> searchEmpsByName(String name) {

       // return find("from Employee e WHERE (0 < LOCATE(?1,e.first_name)) ", name).list();
        return find("first_name like CONCAT('%',?1, '%') ", name).list();
    }


*/