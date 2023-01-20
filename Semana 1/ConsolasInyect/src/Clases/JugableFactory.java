package Clases;

import Interfaz.Jugable;

public class JugableFactory {
	public enum tipoDeJugable{PC,Consola}
	
	/*
	 * creamos la abstraccion de los objetos
	 * */
	public static Jugable create(tipoDeJugable tipo) {
		Jugable jugable;
		switch(tipo) {
			case PC:
				jugable = new PC("Windows");
				break;
			default:
				jugable = new Consola("PS4");
				break;
		}
		return jugable;
	}
}
