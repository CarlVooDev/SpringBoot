/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.negocio.repository;

import com.platzi.ereservation.modelo.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Carl
 */
public interface ReservaRepository extends JpaRepository<Reserva, String> {

    @Query("Select r from Reserva r where r.fechaIngreso=:fechaIngreso2 and r.fechaSalida=:fechaSalida2")
    public List<Reserva> find(@Param("fechaIngreso2") Date fechaIngreso2, @Param("fechaSalida2") Date fechaSalida2);
}
