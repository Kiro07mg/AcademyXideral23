package clases;

/*
 * Indicamos que esta clase sera hija y la clase AbsInfo será la clase padre
 * */
public class Camiones extends AbsInfoVehiculo{
	
	/*
	 * Se crea el constructor del objeto
	 * */
	public Camiones(String marca,String modelo,String color, int distancia, int tiempo) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}

	/*
	 * Creamos un metodo para sacar km/h
	 * */
	public int velocidad() {
		return distancia / tiempo;
	}
}
