package com.danCode.spring.batch.repository;

import com.danCode.spring.batch.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente  extends JpaRepository<Cliente,Integer> {
}
