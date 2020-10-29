
/*
 * Nombre clase: Beca
 * Métodos contenidos: constructor de la clase beca, respectivos getters y setters y toString.
 * Realizado por: Luis Patiño Camacho y Laura Muñoz Jávega
 * Fecha: Abril 2020
 * Escuela Superior de Informática UCLM
 */

package Backtracking;

public class Beca {

	// Parámetros de la clase Beca.
	private int id;
	private int finicio;
	private int ffin;
	private int sueldo;

	// Constructor de la clase beca.
	public Beca(int id, int finicio, int ffin, int sueldo) {
		this.id = id;
		this.finicio = finicio;
		this.ffin = ffin;
		this.sueldo = sueldo;
	}

	// getters y setters de todos los parámetros de la clase .
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFinicio() {
		return finicio;
	}

	public void setFinicio(int finicio) {
		this.finicio = finicio;
	}

	public int getFfin() {
		return ffin;
	}

	public void setFfin(int ffin) {
		this.ffin = ffin;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int tSueldo() {
		int sueld = ((ffin - finicio + 1) * sueldo);
		return sueld;
	}

	public int tTiempo() {
		int tiempo = (ffin - finicio) + 1;
		return tiempo;
	}

	// Método toString que devuelve el valor de todos los parámetros de la clase.
	@Override
	public String toString() {
		return "Beca -> id = " + id + ", Fecha inicio = " + finicio + ", Fecha fin = " + ffin + ", sueldo = " + sueldo
				+ " euros.\n";
	}

}
