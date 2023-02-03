package com.danCode.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@Column(name="CLIENTES_INFO")
	private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "NUM_CONTACTO")
    private String noContacto;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaN;
}
