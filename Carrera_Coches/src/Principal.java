import java.util.Scanner;

public class Principal {
		
	public static void main(String[] args) {
		int jugadores = 0;
		int distancia = 0;
		Scanner leer = new Scanner(System.in);
		System.out.println("¿cuantos jugadores vais a ser?");
		jugadores = leer.nextInt();
		Coche vCoche[] = new Coche[jugadores];
		int turnos[] = new int[jugadores];
		for (int i = 0; i < vCoche.length; i++) {
			int z = 0;
			String nombre[] = new String[jugadores];
			int dorsal[] = new int[jugadores];
			dorsal[0] = 0;
			nombre[0] = "";
			System.out.println("dime el nombre del jugador " + (i+1));
			Scanner leer_nombre = new Scanner(System.in);
			nombre[i] = leer_nombre.next();
			System.out.println("dime el dorsal del jugador " + (i+1));
			Scanner leer_dorsal = new Scanner(System.in);
				if (i == 0) {
					dorsal[i] = leer_dorsal.nextInt();
					z++;
				} else {
					dorsal[i] = leer_dorsal.nextInt();
					if (dorsal[i] == dorsal[i-z]) {
						System.out.println("dorsal no valido, dime un nuevo dorsal");
						dorsal[i] = leer_dorsal.nextInt();
					}
				}
			vCoche[i] = new Coche(nombre[i], dorsal[i]);
		}
		System.out.println("Cuantos km tiene la pista (recomendacion +750km)");
		Scanner leer_distancia = new Scanner(System.in);
		distancia = leer_distancia.nextInt();
		for (int j = 0; j < vCoche.length; j++) {
			vCoche[j].setDistancia_carrera(distancia);	
		}
		int opcion = 0;
		try {
			for (int x = 0; (vCoche[x].getKm_recorridos()<vCoche[x].getDistancia_carrera() && x<vCoche.length); x++) {
				do {
					Scanner leer_opcion = new Scanner(System.in);
					switch (opcion) {
					case 0:
						System.out.println("pulse 1 para arrancar y empezar la carrera");
						System.out.println("pulse 2 para acelerar");
						System.out.println("pulse 3 para frenar");
						System.out.println("pulse 4 para volver a arrancar tras accidente");
						System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
						System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
						opcion = leer_opcion.nextInt();
						break;
					case 1:	
						vCoche[x].arrancar();
						System.out.println("acelerar : 2");
						System.out.println("frenar : 3");
						System.out.println("volver a arrancar tras accidente : 4"); 
						System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
						System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
						if (vCoche[x].getKm_recorridos() < vCoche[x].getDistancia_carrera()) {
							opcion = leer_opcion.nextInt();
							turnos[x]++;
						}
						break;	
					case 2:
						vCoche[x].acelerar();
						System.out.println("acelerar : 2");
						System.out.println("frenar : 3");
						System.out.println("volver a arrancar tras accidente : 4"); 
						System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
						System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
						if (vCoche[x].getKm_recorridos() < vCoche[x].getDistancia_carrera()) {
							opcion = leer_opcion.nextInt();
							turnos[x]++;
						}
						break;	
					case 3:
						vCoche[x].frenar();
						System.out.println("acelerar : 2");
						System.out.println("frenar : 3");
						System.out.println("volver a arrancar tras accidente : 4"); 
						System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
						System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
						if (vCoche[x].getKm_recorridos() < vCoche[x].getDistancia_carrera()) {
							opcion = leer_opcion.nextInt();
							turnos[x]++;
						}
						break;
					case 4:
						if (vCoche[x].getEstado_coche().equalsIgnoreCase("accidentado")) {
							vCoche[x].arrancar_accidente();
							System.out.println("acelerar : 2");
							System.out.println("frenar : 3");
							System.out.println("volver a arrancar tras accidente : 4"); 
							System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
							System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
							if (vCoche[x].getKm_recorridos() < vCoche[x].getDistancia_carrera()) {
								opcion = leer_opcion.nextInt();
								turnos[x]++;
							}
						}
					break;
					default:
						if (vCoche[x].getEstado_coche().equalsIgnoreCase("accidentado")) {
							vCoche[x].arrancar();
							System.out.println("acelerar : 2");
							System.out.println("frenar : 3");
							System.out.println("volver a arrancar tras accidente : 4"); 
							System.out.println("no supere los 200 km/h o pulse una tecla distinta a las propuestas o acabara accidentado");
							System.out.println("estado del coche : " + vCoche[x].getEstado_coche() + ", velocidad actual : " + vCoche[x].getVelocidad() + ", km recorridos : " + vCoche[x].getKm_recorridos() + ", km restantes : " + (vCoche[x].getDistancia_carrera() - vCoche[x].getKm_recorridos()));
							if (vCoche[x].getKm_recorridos() < vCoche[x].getDistancia_carrera()) {
								opcion = leer_opcion.nextInt();
								turnos[x]++;
							}
						}
						break;
					}
				} while ((vCoche[x].getKm_recorridos()<vCoche[x].getDistancia_carrera()));
					
				System.out.println("FELICIDADES " + vCoche[x].getNombre_piloto() + " HAS TERMINADO LA CARRERA EN " + turnos[x] + " TURNOS");
				if (x+1 < jugadores) {
					if (turnos[0] >= turnos[x] || turnos[x] <= turnos[x-1]) {
						System.out.println("EL GANADOR ESTA SIENDO " + vCoche[x].getNombre_piloto() + " CON " + turnos[x] + " TURNOS");
						opcion = 0;
						System.out.println("TURNO DE " + vCoche[x+1].getNombre_piloto());
					} else {
						System.out.println("EL GANADOR ESTA SIENDO " + vCoche[x-1].getNombre_piloto() + " CON " + turnos[x-1] + " TURNOS");
						opcion = 0;
						System.out.println("TURNO DE " + vCoche[x+1].getNombre_piloto());
					}
				} else {
					if (turnos[0] >= turnos[x] || turnos[x] <= turnos[x-1]) {
						System.out.println("EL GANADOR HA SIDO " + vCoche[x].getNombre_piloto() + " CON " + turnos[x] + " TURNOS");
					} else {
						System.out.println("EL GANADOR HA SIDO " + vCoche[x-1].getNombre_piloto() + " CON " + turnos[x-1] + " TURNOS");
					}
				}
			}
		} catch (Exception e) {

		}
 
	}

}

