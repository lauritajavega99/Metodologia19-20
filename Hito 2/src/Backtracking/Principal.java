/*
 * Nombre clase: Beca
 * Paquetes usados: java.io.IOException, java.util.Arrays, java.util.InputMismatchException, java.util.List, java.util.Scanner
 * Métodos contenidos: main, Menu, ImprimirBecasFichero, becasTotales
 * Realizado por: Luis Patiño Camacho y Laura Muñoz Jávega
 * Fecha: Abril 2020
 * Escuela Superior de Informática UCLM
 */

package Backtracking;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
	// Método main
	public static void main(String[] args) throws IOException {

		List<Beca> becas = Becastotales();
		Menu(becas);

	}

	// Método que muestra un menú para interactuar con el usuario.
	public static void Menu(List<Beca> listaBecas) throws IOException {
		int eleccion;
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		do {
			try {

				System.out.println("\nPRÁCTICA 4: El cazador de becas");
				System.out.println("*******************************");
				System.out.println("Introduzca el valor:" + "\n 1. Resolución por backtracking." + "\n 0. Salir.");

				eleccion = teclado.nextInt();

				// switch case que contiene cada una de las opciones del menú
				switch (eleccion) {

				// Opción para salir del programa
				case 0:
					salir = true;
					System.out.println("Saliendo...");
					break;

				// Mostrar las becas elegidas
				case 1:
					ImprimirBecasFichero(listaBecas);
					Backtracking b = new Backtracking(listaBecas);
					break;

				// Opción por si el usuario introduce algún valor no válido.
				default:
					System.out.println("La opción introducida no es válida, vuelva a intentarlo.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("La opción debe de tener un valor numérico" + ",introduzca la opción de nuevo.\n");
				teclado.next();
			}

		} while (salir == false); 
	}

	// Método que imprime el documento de texto completo.
	
	public static void ImprimirBecasFichero(List<Beca> l) throws IOException { 
		Beca[] lb = new Beca[l.size()];
		lb = l.toArray(lb);
		System.out.println("\nEl conjunto de becas a contemplar son:");
		System.out.println("**************************************\n");
		for (int i = 0; i < lb.length; i++) {
			System.out.println(lb[i]);
		}

	}

	// Leemos las becas del fichero y las pasamos a una lista.
	public static List<Beca> Becastotales() throws IOException {
		List<Beca> listaBecas = LecturaDeFicheros.datosBecas("src\\DatosBecas8.txt"); // "src\\DatosBecas8.txt" o "src\\DatosBecas6.txt"

		return listaBecas;
	}
}
