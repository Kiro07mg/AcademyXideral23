package com.danCode.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.danCode.spring.batch.entity.Cliente;

public class ProcesadorCliente implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        if(cliente.getCiudad().equals("China")) {
            return cliente;
        }
        return null;
    }
}
