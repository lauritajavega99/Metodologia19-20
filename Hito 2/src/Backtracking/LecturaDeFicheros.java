/*
 * Nombre clase: LecturaDeFichero
 * Paquetes usados: java.io.* y java.util.*
 * M�todos contenidos: datosBecas
 * Realizado por: Luis Pati�o Camacho y Laura Mu�oz J�vega
 * Fecha: Abril 2020
 * Escuela Superior de Inform�tica UCLM
 */

package Backtracking;

import java.io.*;
import java.util.*;

public class LecturaDeFicheros {

	// M�todo que se encarga de realizar la lectura de un documento txt encontrado
	// en la ruta proporcionada.
	public static List<Beca> datosBecas(String datos) throws IOException { 

		ArrayList<Beca> becas = new ArrayList<Beca>(); 
		File fichero = new File(datos); 

		try {
			Scanner LECTURA = new Scanner(fichero); 

			// Mediante este bucle iremos rellenando el arraylist con los distintos
			// parametros que contiene la clase beca.
			while (LECTURA.hasNext()) { 
				int id = LECTURA.nextInt(); 
				int finicio = LECTURA.nextInt(); 
				int ffin = LECTURA.nextInt(); 
				int sueldo = LECTURA.nextInt(); 

				// A�adimos una nueva beca al list becas
				becas.add(new Beca(id, finicio, ffin, sueldo)); 

			}
			LECTURA.close();

		} catch (FileNotFoundException e) {

			// Mostraremos este mensaje en el caso que no podamos leer correctamente el
			// fichero.
			System.out.println("No se ha podido abrir el fichero.");
		}
		// Finalmente devolvemos la lista becas completa.
		return becas;

	}
}
