package Main;

import Clases.JugableFactory;
import Clases.Jugador;
import Interfaz.Jugable;

public class main {

	public static void main(String[] args) {

		/*
		 * creamos los objetos y mandamos a llamar al metodo
		 * */
		Jugable dispositivo = JugableFactory.create(JugableFactory.tipoDeJugable.PC);
		Jugador ani = new Jugador("gato", dispositivo);
		ani.jugar();
		
		Jugable dispositivo2 = JugableFactory.create(JugableFactory.tipoDeJugable.CONSOLA);
		Jugador ani2 = new Jugador("gato", dispositivo2);
		ani2.jugar();
	}

}
