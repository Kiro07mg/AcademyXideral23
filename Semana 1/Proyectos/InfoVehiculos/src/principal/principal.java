package principal;

import java.util.ArrayList;

import clases.Automobil;
import clases.Camiones;
import clases.Motocicletas;
import interfaces.VehiculoService;

public class principal {

	public static void main(String[] args) {

		/*
		 * Creamos un arreglo para poder guardar los valores
		 * */
		ArrayList<VehiculoService> lista = new ArrayList<>();
		/*
		 * Se añaden los valores
		 * */
		lista.add(new Automobil("Chevrolet","4x4","Negra",50,3));
		lista.add(new Motocicletas("Zuzuki","R6","Azul",50,2));
		lista.add(new Camiones("Kenworth","Kenworth T660","Rojo",60,5));
		/*
		 * invocamos el metodo show
		 * */
		show(lista);
	}
	
	static void show(ArrayList<VehiculoService> lista) {
		/*
		 * Utilizamos un For para recorrer el Arreglo para imprimir uno a uno.
		 * En esta parte es donde podemos ver el tema de polimorfismo
		 * de la instancia de t puede tener varios comportamientos
		 * */
		for (VehiculoService t: lista) {
			System.out.println(t);
			System.out.println(t.velocidad()+" km/h");
			}
		}

}
