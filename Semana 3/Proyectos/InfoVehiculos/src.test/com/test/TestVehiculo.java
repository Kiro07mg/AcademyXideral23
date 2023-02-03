package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import clases.Automobil;
import clases.Camiones;
import clases.Motocicletas;

class TestVehiculo {

	@Test
	public void Automobil() {
		Automobil auto = new Automobil("Chevrolet","4x4","Negra","Gasolina","30",50,3,50.0,100.0);
		String res = auto.toString();
		int vel = auto.velocidad();
		double tan = auto.tanqueLLeno();
		assertEquals("Automobil[marca=Chevrolet, modelo=4x4, color=Negra, tipo_motor=Gasolina, gas_Km=30, distancia=50, tiempo=3, lvlTank=50.0, tankMax=100.0]", res);
		assertEquals(16, vel);
		assertTrue(tan>25.0 && tan<100.0);
	}
	
	@Test
	public void Motocicletas() {
		Motocicletas moto = new Motocicletas("Zuzuki","R6","Azul","Gasolina","35",50,2,50.0,100.0);
		String res = moto.toString();
		int vel = moto.velocidad();
		double tan = moto.tanqueLLeno();
		assertEquals("Motocicletas[marca=Zuzuki, modelo=R6, color=Azul, tipo_motor=Gasolina, gas_Km=35, distancia=50, tiempo=2, lvlTank=50.0, tankMax=100.0]", res);
		assertEquals(25, vel);
		assertTrue(tan>25.0 && tan<100.0);
	}
	
	@Test
	public void Camiones() {
		Camiones camion = new Camiones("Kenworth","Kenworth T660","Rojo","Gaolina","26",60,5,50.0,100.0);
		String res = camion.toString();
		int vel = camion.velocidad();
		double tan = camion.tanqueLLeno();
		assertEquals("Camiones[marca=Kenworth, modelo=Kenworth T660, color=Rojo, tipo_motor=Gaolina, gas_Km=26, distancia=60, tiempo=5, lvlTank=50.0, tankMax=100.0]", res);
		assertEquals(12, vel);
		assertTrue(tan>25.0 && tan<100.0);
	}
}
