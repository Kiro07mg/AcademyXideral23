package principal;

import java.util.ArrayList;

import clases.Automobil;
import clases.Camiones;
import clases.Motocicletas;
import interfaces.VehiculoService;

public class principal {

	public static void main(String[] args) {

		ArrayList<VehiculoService> lista = new ArrayList<>();
		
		lista.add(new Automobil("Chevrolet","4x4","Negra",50,3));
		lista.add(new Motocicletas("Zuzuki","R6","Azul",50,2));
		lista.add(new Camiones("Kenworth","Kenworth T660","Rojo",60,5));
		show(lista);
	}
	
	static void show(ArrayList<VehiculoService> lista) {
		
		for (VehiculoService t: lista) {
			System.out.println(t);
			System.out.println(t.velocidad()+" km/h");
			}
		}

}
