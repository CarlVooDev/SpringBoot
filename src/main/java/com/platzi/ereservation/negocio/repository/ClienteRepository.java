/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.negocio.repository;

import com.platzi.ereservation.modelo.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carl
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    /*Busca clientes por apellido *finBy**/
    public List<Cliente> findByApellidoCliente(String apellidoCliente);

    public Cliente findByIdentifacionCliente(String identifacionCliente);
}
