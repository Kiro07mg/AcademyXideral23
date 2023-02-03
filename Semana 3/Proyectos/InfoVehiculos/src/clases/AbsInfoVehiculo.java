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
	String tipo_motor;
	String gas_Km;
	int distancia;
	int tiempo;
	double lvlTank;
	double tankMax;
	/*
	 * Indicamos el comportamiento
	 * */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo_motor="
				+ tipo_motor + ", gas_Km=" + gas_Km + ", distancia=" + distancia + ", tiempo=" + tiempo + ", lvlTank="
				+ lvlTank + ", tankMax=" + tankMax + "]";
	}
}
