package programa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Funciones metodo = new Funciones ();
		
		int tirada1, tirada2;
		String nomJ1, nomJ2;
		Scanner read = new Scanner (System.in);
		
		System.out.println("Introduce el número mínimo del dado: ");
		Funciones.minDado=read.nextInt();
		System.out.println("Introduce el número máximo del dado: ");
		Funciones.maxDado=read.nextInt();
			
		
		do {
			System.out.println("Introduce el nombre del primer jugador: ");
			nomJ1=read.next();
			System.out.println("Introduce el nombre del segundo jugador: ");
			nomJ2=read.next();
		} while (nomJ1.equals(nomJ2));
		
		do {
			System.out.println("Pulsa culauier tecla:");
			read.next();
			
			tirada1=Funciones.tiraDados();
			System.out.println("Primera tirada jugador 1: " + Funciones.tiraDados());
			
			tirada2=Funciones.tiraDados();
			System.out.println("Segundo tirada jugador 1: " + Funciones.tiraDados());
			
			
			if (Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)) {
				Funciones.fichaJ1+=tirada1+tirada2;
				System.out.println("La jugada es válida");
			}
			
			else {
				System.out.println("La tirada no es válida");
			}
			
			Funciones.pintaPista();
			
			if (Funciones.fichaJ1>=Funciones.TAMCIRCUITO) {
				break;
			}
		
			metodo.imprimeComoVaLaCarrera(nomJ1, nomJ2);			
			
			System.out.println("Pulsa culauier tecla:");
			read.next();
			
			tirada1=Funciones.tiraDados();
			System.out.println("Primera tirada jugador 2: " + Funciones.tiraDados());
			
			tirada2=Funciones.tiraDados();
			System.out.println("Segundo tirada jugador 2: " + Funciones.tiraDados());
			
			
			if (Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)) {
				Funciones.fichaJ2+=tirada1+tirada2;
				System.out.println("La jugada es válida");
			}
			
			else {
				System.out.println("La tirada no es válida");
			}
			
			Funciones.pintaPista();
			
			if (Funciones.fichaJ1>=Funciones.TAMCIRCUITO) {
				break;
			}
			
			metodo.imprimeComoVaLaCarrera(nomJ1, nomJ2);
			
			
		}while (metodo.esGanador(nomJ1, nomJ2).equals(""));
		
		System.out.println("Ha ganado " + metodo.esGanador(nomJ1, nomJ2));
	}

}
