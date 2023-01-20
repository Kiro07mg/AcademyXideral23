package clases;

import interfaces.VehiculoService;

public abstract class AbsInfoVehiculo implements VehiculoService {

	String marca;
	String modelo;
	String color;
	int distancia;
	int tiempo;
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+
				"[marca=" + marca + ", Modelo=" + modelo + ", color=" + color + ", km=" + distancia
				+ ", tiempo=" + tiempo + "]";
	}
}
