/*
 * Nombre clase: Backtracking
 * Paquetes usados: java.util.List
 * Métodos contenidos: Backtracking(constructor), backtrackingOpt, esMejor, esPosible, esSolapable, calcularBeneficio, imprimirSolucion
 * Realizado por: Luis Patiño Camacho y Laura Muñoz Jávega
 * Fecha: Abril 2020
 * Escuela Superior de Informática UCLM
 */

package Backtracking;

import java.util.List;

public class Backtracking {

	private List<Beca> listaBecas; // Lista de becas del txt.

	// Constructor
	public Backtracking(List<Beca> listaBecas) {

		this.listaBecas = listaBecas;
		int actual[] = new int[listaBecas.size()];
		int solucionOpt[] = new int[listaBecas.size()];

		// Llamadas a los métodos de Backtracking.
		backtrackingOpt(0, actual, solucionOpt);
		imprimirSolucion(solucionOpt);
		calcularBeneficio(solucionOpt);
	}

	/// MÉTODOS PRÁCTICA BACKTRACKING///

	// Método recursivo que resuelve el algoritmo Backtracking
	public void backtrackingOpt(int etapa, int actual[], int solucionOpt[]) {
		int i;
		if (etapa == actual.length) {  //Caso base
			if (esMejor(actual, solucionOpt)) 
				System.arraycopy(actual, 0, solucionOpt, 0, actual.length); //Copia el array actual desde la pos. 0
																			// al array solucionOpt desde la pos. 0.

		} else {// Caso general
			for (i = 0; i <= 1; i++) {//Se recorren las aristas del árbol binario.
				if (esPosible(etapa, i, actual)) {
					actual[etapa] = i;//Añadimos la beca al array actual si cumple con los requisitos.
					backtrackingOpt(etapa + 1, actual, solucionOpt);

				}
			}
		}
	}

	// Método que comprueba los dos arrays para ver cual de ellos tiene más
	// beneficio.
	public boolean esMejor(int actual[], int solucionOpt[]) { 
		boolean mejor = false;
		int totalActual = 0;
		int totalOpt = 0;
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] == 1) {// 1+2 //Se calcula el beneficio total del array actual.
				totalActual += listaBecas.get(i).tSueldo();
			}
			if (solucionOpt[i] == 1) { //Se calcula el beneficio total del array soluciónOpt.
				totalOpt += listaBecas.get(i).tSueldo();
			}
		}
		if (totalActual > totalOpt) { //Se comparan ambos presupuestos y se devuelve el que más beneficio
										// proporcione.
			mejor = true;
		}
		return mejor;
	}

	// Método que recorre el array con becas concedidas anteriormente para comprobar
	// si es posible meter la candidata.
	public boolean esPosible(int etapa, int i, int actual[]) { 
		boolean vale = true; 
		if (i == 1) { 
			for (int k = 0; k < etapa && vale; k++) { 
				if (actual[k] == 1) { 
					if (esSolapable(listaBecas.get(etapa), listaBecas.get(k))) { 
						vale = false; 
					}
				}
			}
		}

		return vale; 
	}

	// Método que evalúa la Beca posible anterior con la candidata para que no se
	// solapen en el tiempo.
	public boolean esSolapable(Beca b1, Beca b2) {
		boolean solapable = false; 
		if (b1.getFinicio() <= b2.getFfin() && b1.getFfin() >= b2.getFinicio()) {
			solapable = true;
		}
		return solapable;
	}

	// Método que calcula el presupuesto total recibido con las becas que se le han
	// concedido, recorriendo las posiciones que contengan 1.
	
	
	public void calcularBeneficio(int solucionOpt[]) { 
		int s = 0; 
		for (int i = 0; i < solucionOpt.length; i++) { 
			if (solucionOpt[i] == 1) { 
				s = s + listaBecas.get(i).tSueldo(); 
			}
		}

		System.out.println("El beneficio total obtenido es de --> " + s + " euros.\n"); 
	}

	// Método que imprime la solución, recorriendo solo las posiciones del vector
	// que contengan un 1.
	public void imprimirSolucion(int solucionOpt[]) { 
		System.out.println("La solución con la estrategia Backtracking es:"); 
		System.out.println("*****************************************\n"); 
		for (int i = 0; i < solucionOpt.length; i++) { 
			if (solucionOpt[i] == 1) { 
				System.out.println(listaBecas.get(i).toString());

			}

		}

	}
}
