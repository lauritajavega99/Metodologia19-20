
/*
 * Nombre clase: Principal
 * Paquetes usados: java.io.IOException, java.util.Arrays, java.util.InputMismatchException, java.util.List, java.util.Scanner, java.util.Comparator,java.util.Collections,java.util.ArrayList;
 * M�todos contenidos: main, Menu, VorazBecaCorta, VorazBecaMasPagada, becasSeleccionadas, Correcta, Becastotales, calcularBeneficio, ImprimirBecasSelec, ImprimirBecasFichero
 * Realizado por: Luis Pati�o Camacho y Laura Mu�oz J�vega
 * Fecha: Abril 2020
 * Escuela Superior de Inform�tica UCLM
 */

package Voraz;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class Principal {

	// m�todo main
	public static void main(String[] args) throws IOException {

		Beca[] becas = Becastotales();
		Menu(becas);

	}

	// Este m�todo crea con un switch case un m�todo men�, para que podamos
	// interaccionar con el usuario y elija la opci�n que desee.
	public static void Menu(Beca[] becas) throws IOException {
		int eleccion;
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		do {
			try {
				// Visualizaci�n de las opciones para el usuario.
				System.out.println("\nPR�CTICA 3: El cazador de becas");
				System.out.println("*******************************");
				System.out.println("Introduzca el valor correspondiente a la heur�stica voraz que desea probar:"
						+ "\n 1. Mayor sueldo con las becas m�s cortas."
						+ "\n 2. Mayor sueldo con las becas que paguen m�s al mes." + "\n 0. Salir.");

				eleccion = teclado.nextInt();

				// switch case con las distintas opciones de nuestro menu.
				switch (eleccion) {

				// Opci�n para salir del bucle del menu.
				case 0:
					salir = true;
					System.out.println("Saliendo...");
					break;

				// Opcion que llamara a distintos m�todos para mostrar el mayor sueldo en
				// funci�n de las becas m�s cortas.
				case 1:
					ImprimirBecasFichero(becas);
					Beca[] sol1 = VorazBecaCorta(becas);
					ImprimirBecasSelec(sol1);
					calcularBeneficio(sol1);

					break;
				// Opci�n que llamara a distintos m�todos para mostrar el mayor sueldo en
				// funci�n de las becas que paguen m�s al mes.
				case 2:
					ImprimirBecasFichero(becas);
					Beca[] sol2 = VorazBecaMasPagada(becas);
					ImprimirBecasSelec(sol2);
					calcularBeneficio(sol2);

					break;

				// Opci�n por si el usuario introduce alg�n tipo de valor no v�lido.
				default:
					System.out.println("La opci�n introducida no es v�lida, vuelva a intentarlo.");
					break;
				}
			} catch (InputMismatchException e) { // Excepci�n que controla el uso de caracteres no num�ricos
				System.out.println("La opci�n debe de tener un valor num�rico" + ",introduzca la opci�n de nuevo.\n");
				teclado.next();
			}

		} while (salir == false);
	}

	/// M�TODOS PR�CTICA VORAZ////

	// M�todo que realiza la heur�stica en funci�n de las becas m�s cortas.
	public static Beca[] VorazBecaCorta(Beca[] b) {
		List<Beca> listaBecas = Arrays.asList(b); // Creamos lista de becas.

		// Para ordenarlas por tiempo m�s corto.
		Collections.sort(listaBecas, new Comparator<Beca>() {
			public int compare(Beca b1, Beca b2) {
				return new Integer(b1.tTiempo()).compareTo(new Integer(b2.tTiempo()));
			}
		});

		// Convertimos el la lista a un Array.
		Beca[] resultado = new Beca[listaBecas.size()];
		listaBecas.toArray(resultado);

		//Imprimimos el nuevo orden de las Becas
				System.out.println("\nEl conjunto de becas ordenas de menor a mayor tiempo:");
				System.out.println("*****************************************************\n");
				ImprimirBecasOrdenadas(resultado);
				
		// Pasamos el array para que sean seleccionadas las becas correspondientes a la
		// heur�stica.
		Beca[] seleccionadas = becasSeleccionadas(resultado);

		return seleccionadas;
	}

	// M�todo que realiza la heur�stica en funci�n de las becas m�s pagadas al mes.
	public static Beca[] VorazBecaMasPagada(Beca[] bec) {
		List<Beca> listaBecas = Arrays.asList(bec); // Creamos arraylist de becas.

		// Para ordenarlas por m�s sueldo al mes.
		Collections.sort(listaBecas, new Comparator<Beca>() {
			public int compare(Beca b1, Beca b2) {
				return new Integer(b2.getSueldo()).compareTo(new Integer(b1.getSueldo()));
			}
		});

		// Convertimos la lista en array.
		Beca[] resultado = new Beca[listaBecas.size()];
		listaBecas.toArray(resultado);
		
		//Imprimimos el nuevo orden de las Becas
		System.out.println("\nEl conjunto de becas ordenas de mayor a menor pagada al mes es:");
		System.out.println("***************************************************************\n");
		ImprimirBecasOrdenadas(resultado);

		// Pasamos el array para que sean seleccionadas las becas correspondientes a la
		// heur�stica.
		Beca[] seleccionadas = becasSeleccionadas(resultado);

		return seleccionadas;

	}

	// Selecci�n de becas para la soluci�n.
	public static Beca[] becasSeleccionadas(Beca[] lisBecas) {
		List<Beca> list = new ArrayList<Beca>();
		int posSol = 0;
		list.add(0, lisBecas[0]);

		// Recorre el array de todas las becas
		for (int i = 1; i < lisBecas.length; i++) {
			if (Correcta(list, lisBecas[i])) {// Comprobar que no solapen la una con la otra y si no solapan a�adirla a
												// la lista nueva.
				posSol++;
				list.add(posSol, lisBecas[i]);
			}
		}

		// Convertimos la lista en array.
		Beca[] becasSeleccionadas = new Beca[list.size()];
		list.toArray(becasSeleccionadas);

		return becasSeleccionadas;
	}

	// Comprobaci�n para que no solapen fechas una vez ordenadas.
	public static boolean Correcta(List<Beca> l, Beca be) {
		boolean siCorrecta = false;
		boolean aux = true;
		// Recorremos la lista con los elementos que han sido seleccionados
		// Comparando las fechas de sus elementos con la fecha de la beca candidata al
		// conjunto.
		for (int i = 0; i < l.size() && aux == true; i++) {
			// Comparaci�n de los distintos extremos y posibilidades de solapaci�n de
			// fechas.
			if ((be.getFinicio() < l.get(i).getFinicio() && be.getFfin() < l.get(i).getFinicio())) {
				siCorrecta = true;

			} else if (be.getFinicio() > l.get(i).getFfin() && siCorrecta == false) {
				siCorrecta = true;

			} else if (be.getFinicio() > l.get(i).getFfin() && siCorrecta == true) {
				siCorrecta = true;

			} else {
				siCorrecta = false;
				aux = false;
			}
		}
		return siCorrecta;
	}

	// Pasamos las becas del fichero a un array
	public static Beca[] Becastotales() throws IOException {
		Beca[] listaBecas = LecturaFicheros.datosBecas("src\\DatosBecas6.txt"); // "src\\DatosBecas8.txt" o
																				// "src\\DatosBecas6.txt"

		return listaBecas;
	}

	// Calcular el sueldo total de las becas que han sido seleccionadas como
	// soluci�n
	public static void calcularBeneficio(Beca[] becas) {
		int s = 0;
		for (int i = 0; i < becas.length; i++) {
			s = s + becas[i].tSueldo(); // Recorre el array de las becas seleccionadas y suma el beneficio total de cada
										// una de ellas.
		}

		System.out.println("El beneficio total obtenido es de --> " + s + " euros.\n");
	}

	// Imprime la soluci�n de becas con la heur�stica seleccionada.
	public static void ImprimirBecasSelec(Beca[] listaBecas) {
		System.out.println("La soluci�n con la heur�stica elegida es:");
		System.out.println("*****************************************\n");
		for (int i = 0; i < listaBecas.length; i++) {
			System.out.println(listaBecas[i]);
		}

	}

	// Imprime las becas contenidas en el fichero txt.
	public static void ImprimirBecasFichero(Beca[] lb) throws IOException {
		System.out.println("\nEl conjunto de becas a contemplar son:");
		System.out.println("**************************************\n");
		for (int i = 0; i < lb.length; i++) {
			System.out.println(lb[i]);
		}

	}

	//Imprime las becas ordenadas
	public static void ImprimirBecasOrdenadas(Beca[] ord) {
		for (int i = 0; i < ord.length; i++) {
			System.out.println(ord[i]);
		}
	}
}
