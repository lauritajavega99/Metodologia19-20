package Practica2;

/*
 * Código realizado por Luis Patiño Camacho y Laura Muñoz Jávega
 * Laboratorio de metodología
 * Sesión 2
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		System.out.println("PRÁCTICA 2: Divide y Vencerás ---> Método de la Bisección.");
		menu();
	}

	public static void menu() {
		int optn;
		double precision;
		boolean salir = false;
		do {

			// menu
			System.out.println("Elija una opción:" + "\n 1. f(x)=x^2-2x-3" + "\n 2. f(x)=2^x-x^2-10"
					+ "\n 3. f(x)=sen(x)-(1/x)" + "\n 0. Salir del programa.");

			optn = introducirOpcion();

			switch (optn) {

			case 0:

				salir = true;
				System.out.println("SALIENDO...");

				break;

			// f(x)=x^2-2x-3
			case 1:
				System.out.println("Introduzca la precisión con la que desea calcular la raíz en el intervalo [0,4]");
				precision = introducirPrecision();
				Biseccion bi = new Biseccion(0.0, 4.0, precision, 1);
				bi.evaluarBolzano();

				System.out
						.println("Introduzca la precisión con la que desea calcular la raíz en el intervalo [2,2.5].");
				precision = introducirPrecision();
				Biseccion bi1 = new Biseccion(2.0, 2.5, precision, 1);
				bi1.evaluarBolzano();

				break;

			// f(x)=2^x-x^2-10
			case 2:
				System.out.println("Introduzca la precisión con la que desea calcular la raíz en el intervalo [0,6].");
				precision = introducirPrecision();
				Biseccion bi2 = new Biseccion(0.0, 6.0, precision, 2);
				bi2.evaluarBolzano();

				break;

			// f(x)=sen(x)-(1/x)
			case 3:
				System.out.println(
						"Introduzca la precisión con la que desea calcular la raíz en el intervalo [2pi,5pi/2].");
				precision = introducirPrecision();
				Biseccion bi3 = new Biseccion(2 * Math.PI, (5 * Math.PI) / 2, precision, 3);
				bi3.evaluarBolzano();
				break;

			default:

				System.out.println("El número introducido no es válido, vuelva a intentarlo.");

				break;

			}
		} while (salir == false);
	}

	public static int introducirOpcion() { // evitar que se introduzcan strings
		Scanner teclado = new Scanner(System.in);
		int num = 0;
		do {
			try {
				num = teclado.nextInt();
			} catch (InputMismatchException e) {
				teclado.next();
				System.out.println("Introduzca un valor válido.");
				num = -1;
			}
		} while (num < 0);
		return num;

	}

	public static double introducirPrecision() { 
		double precision = 0;
		Scanner teclado = new Scanner(System.in);
		do {
			precision = teclado.nextDouble();
			if (precision < 0) {
				System.out.println("Introduzca una precisión positiva.");
			}
		} while (precision < 0);

		return precision;
	}
}
