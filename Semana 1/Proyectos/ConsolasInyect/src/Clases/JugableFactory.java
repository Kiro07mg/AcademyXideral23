package Clases;

import Interfaz.Jugable;
/*
 * Vendria a ser nuertro inyector de dependencias
 * es la unica que conocera como se instancia cada uno de los objetos
 * */
public class JugableFactory {
	/*
	 * limitamos la creacion de objetos
	 * */
	public enum tipoDeJugable{PC,CONSOLA}
	
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
