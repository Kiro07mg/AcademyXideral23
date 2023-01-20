package Main;

import Clases.JugableFactory;
import Clases.Jugador;
import Interfaz.Jugable;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jugable dispositivo = JugableFactory.create(JugableFactory.tipoDeJugable.PC);
		Jugador ani = new Jugador("gato", dispositivo);
		ani.jugar();
		
		Jugable dispositivo2 = JugableFactory.create(JugableFactory.tipoDeJugable.Consola);
		Jugador ani2 = new Jugador("gato", dispositivo2);
		ani2.jugar();
	}

}
