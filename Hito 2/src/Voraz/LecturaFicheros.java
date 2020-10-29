/*
 * Nombre clase: LecturaDeFichero
 * Paquetes usados: java.io.* y java.util.*
 * Métodos contenidos: datosBecas
 * Realizado por: Luis Patiño Camacho y Laura Muñoz Jávega
 * Fecha: Abril 2020
 * Escuela Superior de Informática UCLM
 */

package Voraz;

import java.io.*;
import java.util.*;

public class LecturaFicheros {

	// Método que se encarga de realizar la lectura del documento txt introducido.
	public static Beca[] datosBecas(String datos) throws IOException {

		ArrayList<Beca> becas = new ArrayList<Beca>();
		File fichero = new File(datos);

		try {
			Scanner LECTURA = new Scanner(fichero);
			while (LECTURA.hasNext()) {
				int id = LECTURA.nextInt();
				int finicio = LECTURA.nextInt();
				int ffin = LECTURA.nextInt();
				int sueldo = LECTURA.nextInt();

				becas.add(new Beca(id, finicio, ffin, sueldo));

			}
			LECTURA.close();

		} catch (FileNotFoundException e) { // excepcion si no encuentra el fichero en la ruta introducida.
			System.out.println("No se ha podido abrir el fichero");
		}
		return becas.toArray(new Beca[becas.size()]);

	}
}
