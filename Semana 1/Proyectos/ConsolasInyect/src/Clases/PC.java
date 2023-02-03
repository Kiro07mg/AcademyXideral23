package Clases;

import Interfaz.Jugable;

public class PC implements Jugable{
	
private String modelo;
	
	public PC(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void jugar() {
		System.out.println(modelo);
	}
}
