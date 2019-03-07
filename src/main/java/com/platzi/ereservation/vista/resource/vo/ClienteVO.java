/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.vista.resource.vo;

import com.platzi.ereservation.modelo.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Carl
 */
@Data
public class ClienteVO {

    private String idCliente;
    private String nameCliente;
    private String apellidoCliente;
    private String identifacionCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    private Set<Reserva> reservas;
}
