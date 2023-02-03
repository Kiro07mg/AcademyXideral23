package clases;

import interfaces.VehiculoService;
//Tenemos la clase abstracta que implementa la interfaz
public abstract class AbsInfoVehiculo implements VehiculoService {

	/*
	 * Indicamos los atributos del objeto
	 * */
	String marca;
	String modelo;
	String color;
	int distancia;
	int tiempo;
	/*
	 * Indicamos el comportamiento
	 * */
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+
				"[marca=" + marca + ", Modelo=" + modelo + ", color=" + color + ", km=" + distancia
				+ ", tiempo=" + tiempo + "]";
	}
}
