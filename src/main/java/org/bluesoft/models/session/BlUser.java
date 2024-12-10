package org.bluesoft.models.session;

import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="bl_user")
public class BlUser extends PanacheEntityBase {
    @Id
    public String id;
    public String periodo;
    @Column(unique = true)
    public String username;
    public String firstname;
    public String lastname;
    public String type;
    public String email;
    private String password;
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    public Set<BlAccess> accesses;

    public BlUser() {
        this.id = UUID.randomUUID().toString();
    }

    public BlUser( String periodo, String username, String firstname, String lastname, String email, String password) {
        this();
        this.periodo = periodo;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getId() {
        return id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<BlAccess> getAccesses() {
        return accesses;
    }

    public BlUser(String id) {
        this.id = id;
    }

    public String toString() {
        return "BlUser [id=" + id + ", periodo=" + periodo + ", username=" + username + ", firstname=" + firstname
                + ", lastname=" + lastname + ", type=" + type + ", email=" + email + ", password=" + password;
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