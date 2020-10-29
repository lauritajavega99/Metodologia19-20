
/*
 * Nombre clase: Beca
 * M�todos contenidos: constructor de la clase beca, respectivos getters y setters y toString.
 * Realizado por: Luis Pati�o Camacho y Laura Mu�oz J�vega
 * Fecha: Abril 2020
 * Escuela Superior de Inform�tica UCLM
 */

package Backtracking;

public class Beca {

	// Par�metros de la clase Beca.
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

	// getters y setters de todos los par�metros de la clase .
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

	// M�todo toString que devuelve el valor de todos los par�metros de la clase.
	@Override
	public String toString() {
		return "Beca -> id = " + id + ", Fecha inicio = " + finicio + ", Fecha fin = " + ffin + ", sueldo = " + sueldo
				+ " euros.\n";
	}

}
