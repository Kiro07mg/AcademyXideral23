package Clases;

import Interfaz.Jugable;

public class Jugador {
	
	private String nombre;
	private Jugable dispositivoJugable;
	
	//constructor
	public Jugador(String nombre, Jugable animaljugable) {
		this.nombre = nombre;
		this.dispositivoJugable = animaljugable;
	}

	public void jugar() {
		dispositivoJugable.jugar();
	}

}
