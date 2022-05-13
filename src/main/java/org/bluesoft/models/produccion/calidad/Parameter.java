package org.bluesoft.models.produccion.calidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.bluesoft.models.produccion.Tank;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@NamedStoredProcedureQuery(
    name = "stp_create_parameter",
    procedureName = "stp_create_parameter",
    resultClasses = Parameter.class,
    parameters = {
        @StoredProcedureParameter(name="_tank_id", type=Long.class, mode=ParameterMode.IN),
        @StoredProcedureParameter(name="_lote", type=String.class, mode=ParameterMode.IN)
    }
)
@Entity
@Table(name = "p_parameter")
public class Parameter extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String result;

    @ManyToOne
    public Quality quality;

    @OneToOne
    public Method method;
    
    @ManyToOne
    public Tank tank;
  
}
