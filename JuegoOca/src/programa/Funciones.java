package programa;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

public class Funciones {
	static final int TAMCIRCUITO = 11;
	static int fichaJ1, fichaJ2;
	static int minDado, maxDado;

	static int tiraDados() {
		int resultado;
		resultado = (int) Math.random() * (maxDado - minDado) + minDado;
		return resultado;
	}

	static void pintaPista() {
		for (int i = 1; i <= TAMCIRCUITO; i++) {
			System.out.print("\t" + i);
		}

		System.out.println();

		for (int pos = 0; pos <= fichaJ1; pos++) {
			if (pos == fichaJ1) {
				System.out.print("J1");
			} else {
				System.out.print(" ");
			}
			System.out.print("\t");
		}

		System.out.println();

		for (int pos = 0; pos <= fichaJ2; pos++) {
			if (pos == fichaJ2) {
				System.out.print("J2");
			} else {
				System.out.print(" ");
			}
			System.out.print("\t");
		}
		
		System.out.println();
	}

	static boolean sumaDeNumerosEsPrimo(int tirada1, int tirada2) {
		int resultado = tirada1 + tirada2;
		boolean estado = true;
		for (int i = 2; i < resultado; i++) {
			if (resultado % i == 0||resultado<=1) {
				estado = false;
			}

		}

		return estado;
	}

	void imprimeComoVaLaCarrera(String nomJ1, String nomJ2) {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		}

		else if (fichaJ2 > fichaJ1) {
			System.out.println("Va ganando " + nomJ2);
		}

		else {
			System.out.println("Van empatados");
		}
	}

	String esGanador(String nomJ1, String nomJ2) {
		String resultado = "";
		if (fichaJ1 >= TAMCIRCUITO) {
			resultado = nomJ1;
		}

		else if (fichaJ2 >= TAMCIRCUITO) {
			resultado = nomJ2;
		}

		return resultado;
	}

}
