package Main;

import java.util.Scanner;

import Clases.Registro;

public class main {

	/*
	 * Esta linea de codigo nos permite obtener info ingresado desde consola
	 * */
    private static Scanner S = new Scanner(System.in);
    
	public static void main(String[] args) {
		
		int opc;
        do{
        	//invocamos el metodo menu
            opc = menu();
            switch(opc) {
                case 1:
                    System.out.print("Ingrese nombre del producto: ");
                    String producto = S.nextLine();
                    System.out.print("Ingrese cantidad vendida: ");
                    int cant = Integer.parseInt(S.nextLine());
                    /*
                     * pedimos los parametros necesarios para ejecutar el metodo
                     * de aggregar metodo
                     * */
                    Registro.getInstancia().agregarVenta(producto, cant);
                    break;
                case 2:
                    System.out.println( Registro.getInstancia());
                    break;
                case 3:
                    System.out.println("Cerrando programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while(opc!=3);
	}

	/*
	 * Creamos un pequeño menu para imprimirlo en consola
	 * */
    private static int menu() {
        System.out.print(
                "\nMENU DE OPCIONES"
               +"\n1. Registrar nueva venta."
               +"\n2. Consultar historial de ventas."
               +"\n3. Salir del programa."
               +"\nSeleccione opcion: "        
        );
        /*
         * Regresamos lo que ingresamos en la consola
         * */
        return Integer.parseInt( S.nextLine() );
    }
}
