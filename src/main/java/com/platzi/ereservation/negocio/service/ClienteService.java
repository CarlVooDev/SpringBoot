/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.negocio.service;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Carl
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Metodo para realizar la operacion de guardar un cliente
    @Transactional
    public Cliente create(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    //Metodo para actualizar un cliente
    @Transactional
    public Cliente update(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    //Metodo para eliminar un cliente
    @Transactional
    public void delete(Cliente cliente) {
        this.clienteRepository.delete(cliente);
    }

    //Metodo para consultar un cliente por su identificacion
    public Cliente findByIdentifacionCliente(String identificacion) {
        return this.clienteRepository.findByIdentifacionCliente(identificacion);
    }

    //Metodo para traer varios clientes
    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }
}
