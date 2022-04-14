package org.bluesoft.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlUser {
    @Id
    private String id;
    private String periodo;
    
    public BlUser(String id, String periodo) {
        this.id = id;
        this.periodo = periodo;
    }
    public BlUser() {
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "BlUser [id=" + id + ", periodo=" + periodo + "]";
    }
}
/**
 * @SequenceGenerator(
            name = "personSequence",
            sequenceName = "person_id_seq",
            allocationSize = 1,
            initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
 */