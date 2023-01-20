package clases;

public class Camiones extends AbsInfoVehiculo{
	
	//costructor
	public Camiones(String marca,String modelo,String color, int distancia, int tiempo) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}

	public int velocidad() {
		return distancia / tiempo;
	}
}
