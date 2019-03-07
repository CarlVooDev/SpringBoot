/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.vista.resource;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.service.ClienteService;
import com.platzi.ereservation.vista.resource.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.xml.ws.http.HTTPBinding;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carl
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente creado corrrectamente")
        ,
        @ApiResponse(code = 400, message = "Consulta no valida")})
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO) {
        Cliente cliente = new Cliente();
        cliente.setNameCliente(clienteVO.getNameCliente());
        cliente.setApellidoCliente(clienteVO.getApellidoCliente());
        cliente.setDireccionCliente(clienteVO.getNameCliente());
        cliente.setEmailCliente(clienteVO.getEmailCliente());
        cliente.setIdCliente(clienteVO.getIdCliente());
        cliente.setIdentifacionCliente(clienteVO.getIdentifacionCliente());
        cliente.setReservas(clienteVO.getReservas());
        cliente.setTelefonoCliente(clienteVO.getTelefonoCliente());
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un nuevo cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente actualizado corrrectamente")
        ,
        @ApiResponse(code = 404, message = "Cliente no encontrado")})
    public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion, ClienteVO clienteVO) {
        Cliente cliente = this.clienteService.findByIdentifacionCliente(identificacion);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        } else {
            cliente.setNameCliente(clienteVO.getNameCliente());
            cliente.setApellidoCliente(clienteVO.getApellidoCliente());
            cliente.setDireccionCliente(clienteVO.getNameCliente());
            cliente.setEmailCliente(clienteVO.getEmailCliente());
            cliente.setIdCliente(clienteVO.getIdCliente());
            cliente.setIdentifacionCliente(clienteVO.getIdentifacionCliente());
            cliente.setReservas(clienteVO.getReservas());
            cliente.setTelefonoCliente(clienteVO.getTelefonoCliente());
        }
        return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un nuevo cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente eliminado corrrectamente")
        ,
        @ApiResponse(code = 404, message = "Cliente no encontrado")})
    public void removeCliente(@PathVariable("identificacion") String identificacion) {
        Cliente cliente = this.clienteService.findByIdentifacionCliente(identificacion);
        if (cliente != null) {
            this.clienteService.delete(cliente);
        }
    }

    @GetMapping
    @ApiOperation(value = "Listar cliente", notes = "Servicio para listar un todos los cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cliente eliminado corrrectamente")
        ,
        @ApiResponse(code = 404, message = "Cliente no encontrado")})
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}
