package Practica1;

/*
 * Código realizado por Luis Patiño Camacho y Laura Muñoz Jávega
 * Laboratorio de metodología
 * Sesión 1
 */

import java.lang.*;
import java.util.Scanner;

public class Pract1 {
	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		int unidad;

		boolean salir = false;
		do {

			// menu con distintas opciones para ejecutar

			Scanner teclado = new Scanner(System.in);
			System.out.println("Elija una opción:" + "\n 1. Tabla de resultados con el tiempo medido en nanosegundos."
					+ "\n 2. Tabla de resultados con el tiempo medido en milisegundos."
					+ "\n 3. Ingresar un número por teclado y obtener el tiempo (tanto en ns como en ms)."
					+ "\n 0. Salir del programa.");

			unidad = teclado.nextInt();

			int valores[] = { 1, 15, 20, 50, 100, 200, 500, 1000, 3000, 10000 };
			long tiempoin, tiempofn, tiempoi, tiempon, tiempof, tiempo2n, tiempo3n, resultado1, resultado2, resultado3,
					tiempo, tiempo2, tiempo3;

			switch (unidad) {


			case 0:

				salir = true;
				System.out.println("SALIENDO...");

				break;

			case 1:

				tiempo(valores, 1);

				break;

			case 2:

				tiempo(valores, 2);

				break;

			case 3:

				System.out.println("Introduzca un número:");
				int n = teclado.nextInt();

				System.out.printf(
						" | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |  %-15s | %-15s | %-15s | \n",
						"Valor n", "Resultado 1", "Resultado 2", "Resultado 3", "Tiempo 1(ms)", "Tiempo 2(ms)",
						"Tiempo 3(ms)", "Tiempo 1(ns)", "Tiempo 2(ns)", "Tiempo 3(ns)");

				// Formula
				tiempoi = (long) getTiempo(2);
				resultado1 = formula(n);
				tiempof = (long) getTiempo(2);
				tiempo = tiempof - tiempoi;

				tiempoin = (long) getTiempo(1);
				resultado1 = formula(n);
				tiempofn = (long) getTiempo(1);
				tiempon = tiempofn - tiempoin;

				// Iterativo
				tiempoi = (long) getTiempo(2);
				resultado2 = iterativo(n);
				tiempof = (long) getTiempo(2);
				tiempo2 = tiempof - tiempoi;

				tiempoin = (long) getTiempo(1);
				resultado2 = iterativo(n);
				tiempofn = (long) getTiempo(1);
				tiempo2n = tiempofn - tiempoin;

				// Recursivo
				tiempoi = (long) getTiempo(2);
				resultado3 = recursivo(n - 1);
				tiempof = (long) getTiempo(2);
				tiempo3 = tiempof - tiempoi;

				tiempoin = (long) getTiempo(1);
				resultado3 = recursivo(n - 1);
				tiempofn = (long) getTiempo(1);
				tiempo3n = tiempofn - tiempoin;

				System.out.printf(
						" | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |  %-15s | %-15s | %-15s | \n", n,
						resultado1, resultado2, resultado3, tiempo, tiempo2, tiempo3, tiempon, tiempo2n, tiempo3n);

				break;

			default:

				System.out.println("El número introducido no es válido, vuelva a intentarlo.");

				break;

			}
		} while (salir == false);

	}

	// metodo que devuelve el resultado mediante la formula
	public static long formula(long n) {

		long resultado = 2 * n * n - n;

		return resultado;

	}

	// metodo que calcula el resultado de forma iterativa
	public static long iterativo(long n) {

		long resultado = 0;

		for (long i = 0; i < n; i++) {
			resultado = resultado + 4 * i + 1;
		}

		return resultado;

	}

	// método que calcula el resultado de forma recursiva
	public static long recursivo(long i) {
		long res = 0;
		if (i >= 0) {
			res = ((4 * i) + 1) + recursivo(i - 1);
		}
		return res;
	}

	//metodo que devuelve el tiempo en nanosegundo o milisegundos dependiendo de la opcion
	public static long getTiempo(int num) {
		long tiempodevolver;
		if (num == 1) {
			tiempodevolver = System.nanoTime();
		} else {
			tiempodevolver = System.currentTimeMillis();
		}
		return tiempodevolver;
	}

	//método que muestra los diferentes tiempo de ejecución
	public static void tiempo(int valores[], int n) {
		System.out.printf(" | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", "Valor n", "Resultado 1",
				"Resultado 2", "Resultado 3", "Tiempo 1", "Tiempo 2", "Tiempo 3");
		long tiempoi, tiempof, resultado1, resultado2, resultado3, tiempo, tiempo2, tiempo3;
		int i;
		for (i = 0; i < valores.length; i++) {
			// Formula

			tiempoi = (long) getTiempo(n);
			resultado1 = formula(valores[i]);
			tiempof = (long) getTiempo(n);
			tiempo = tiempof - tiempoi;

			// Iterativo

			tiempoi = (long) getTiempo(n);
			resultado2 = iterativo(valores[i]);
			tiempof = (long) getTiempo(n);
			tiempo2 = tiempof - tiempoi;

			// Recursivo

			tiempoi = (long) getTiempo(n);
			resultado3 = recursivo(valores[i] - 1);
			tiempof = (long) getTiempo(n);
			tiempo3 = tiempof - tiempoi;

			System.out.printf(" | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", valores[i], resultado1,
					resultado2, resultado3, tiempo, tiempo2, tiempo3);
		}
	}
}