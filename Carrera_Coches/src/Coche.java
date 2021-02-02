import java.util.Random;

public class Coche {
	
	private String nombre_piloto;
	private int dorsal;
	private int distancia_carrera;
	private String estado_coche;
	private final int POTENCIA = 50;
	private int velocidad;
	private int km_recorridos;
	
	public Coche(String nombre_piloto, int dorsal) {
		this.nombre_piloto = nombre_piloto;
		this.dorsal = dorsal;
		this.distancia_carrera = distancia_carrera;
		this.estado_coche = "parado";
		this.velocidad = 0;
		this.km_recorridos = 0;
	}
	
	public void arrancar() {
	
		if (estado_coche.equalsIgnoreCase("parado")) {
			estado_coche = "arrancado";
			velocidad = 0;
			System.out.println("coche arrancado");
		}
		
	}
	
	public void arrancar_accidente() {
		
		if (estado_coche.equalsIgnoreCase("accidentado")) {
			estado_coche = "arrancado";
			velocidad = 0;
			System.out.println("coche arrancado");
		}
		
	}
	
	public void acelerar() {
		int aceleracion = 0;
		Random azar_aceleracion = new Random();
		if (estado_coche.equalsIgnoreCase("arrancado")) {
			aceleracion += azar_aceleracion.nextInt(POTENCIA);
			this.velocidad += aceleracion;
			System.out.println("vas a " + this.velocidad + " km/h");
			if (velocidad > 200) {
				velocidad = 0;
				estado_coche = "accidentado";
				km_recorridos += aceleracion/3;
			} else {
				km_recorridos += aceleracion + (0.5*velocidad);
			}
		} else {
			System.out.println("el coche esta parado, tienes que arrancarlo");
		}
	}
	
	public void frenar() {
		int aceleracion = 0;
		Random azar_aceleracion = new Random();
		if (estado_coche.equalsIgnoreCase("arrancado")) {
			aceleracion -= azar_aceleracion.nextInt(POTENCIA);
			this.velocidad += aceleracion;
			System.out.println("vas a " + this.velocidad + " km/h");
			if (velocidad < 0) {
				velocidad = 0;
				estado_coche = "accidentado";
			} else {
				km_recorridos += (aceleracion + (0.3*velocidad));
			}
		} else {
			System.out.println("el coche esta parado, tienes que arrancarlo");
		}
	}

	public String getNombre_piloto() {
		return nombre_piloto;
	}

	public void setNombre_piloto(String nombre_piloto) {
		this.nombre_piloto = nombre_piloto;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getDistancia_carrera() {
		return distancia_carrera;
	}

	public void setDistancia_carrera(int distancia_carrera) {
		this.distancia_carrera = distancia_carrera;
	}

	public String getEstado_coche() {
		return estado_coche;
	}

	public void setEstado_coche(String estado_coche) {
		this.estado_coche = estado_coche;
	}

	public int getPotencia() {
		return POTENCIA;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public double getKm_recorridos() {
		return km_recorridos;
	}

	public void setKm_recorridos(int km_recorridos) {
		this.km_recorridos = km_recorridos;
	}

	@Override
	public String toString() {
		return "Coche [nombre_piloto=" + nombre_piloto + ", dorsal=" + dorsal + ", distancia_carrera="
				+ distancia_carrera + ", estado_coche=" + estado_coche + ", potencia=" + POTENCIA + ", velocidad="
				+ velocidad + ", km_recorridos=" + km_recorridos + "]";
	}
	
	
	
}
