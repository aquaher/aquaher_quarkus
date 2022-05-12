package org.bluesoft.models.produccion.operador;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.bluesoft.models.session.BlUser;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@NamedStoredProcedureQuery(
    name = "stp_register_turn",
    procedureName = "stp_register_turn",
    resultClasses = Turn.class,
    parameters = {
        @StoredProcedureParameter(name="_turn_id", type=Long.class, mode=ParameterMode.IN),
        @StoredProcedureParameter(name="_user_id", type=String.class, mode=ParameterMode.IN)
    }
)
@NamedStoredProcedureQuery(
    name = "stp_turn_finalize_and_create",
    procedureName = "stp_turn_finalize_and_create",
    resultClasses = Turn.class,
    parameters = {
        @StoredProcedureParameter(name="_turn_id", type=Long.class, mode=ParameterMode.IN),
        @StoredProcedureParameter(name="_user_id", type=String.class, mode=ParameterMode.IN)
    }
)
@Entity
@Table(name = "p_turn")
public class Turn extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer turn;
    
    @ManyToOne
    public BlUser user;

    public LocalDateTime start_date;
    public LocalDateTime end_date;
    public Boolean active;
}
