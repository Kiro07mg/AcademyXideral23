package clases;
/*
 * 
 * */
public class Automobil extends AbsInfoVehiculo{
		
	/*
	 * Se crea el constructor del objeto
	 * */
		public Automobil(String marca,String modelo,String color,String tipo_motor,
				String gas_Km, int distancia, int tiempo, double lvlTank, double tankMax) {
			this.marca = marca;
			this.modelo = modelo;
			this.color = color;
			this.tipo_motor = tipo_motor;
			this.gas_Km = gas_Km;
			this.distancia = distancia;
			this.tiempo = tiempo;
			this.lvlTank = lvlTank;
			this.tankMax = tankMax;
		}
		
		/*
		 * Creamos un metodo para sacar km/h
		 * */
		public int velocidad() {
			return distancia / tiempo;
		}
		
		public double tanqueLLeno() {
			return (lvlTank*100) / tankMax;
		}
}
