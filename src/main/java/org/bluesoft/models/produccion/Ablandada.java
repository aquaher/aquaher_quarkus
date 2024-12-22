package org.bluesoft.models.produccion;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.bluesoft.models.session.BlUser;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "p_ablandada")
public class Ablandada extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public LocalDateTime dateTime;

    public Double bomba1;
    public Double bomba2;

    public Double caudalA1;
    public Double caudalA2;
    public Double caudalA3;
    public Double caudalA4;

    public Double presionA1;
    public Double presionA2;
    public Double presionA3;
    public Double presionA4;

    public Double durezaA1;
    public Double durezaA1Gotas;
    public Double durezaA2;
    public Double durezaA2Gotas;
    public Double durezaA3;
    public Double durezaA3Gotas;
    public Double durezaA4;
    public Double durezaA4Gotas;

    public Double volumenTK3;
    public Double volumenTK4;

    @ManyToOne
    public BlUser userOp;

    @ManyToOne
    public BlUser userAyu;


}
