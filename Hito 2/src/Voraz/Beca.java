/*
 * Nombre clase: Beca
 * Métodos contenidos: Beca(constructor), respectivos getters y setters y toString.
 * Realizado por: Luis Patiño Camacho y Laura Muñoz Jávega
 * Fecha: Abril 2020
 * Escuela Superior de Informática UCLM
 */

package Voraz;

public class Beca implements Comparable<Beca> {
	
	//Parámetros beca
	private int id;
	private int finicio;
	private int ffin;
	private int sueldo;

	//Constructor
	public Beca(int id, int finicio, int ffin, int sueldo) {
		this.id = id;
		this.finicio = finicio;
		this.ffin = ffin;
		this.sueldo = sueldo;
	}

	//Getters y setters
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

	//Muestra cada beca con su atributo.
	@Override
	public String toString() {
		return "Beca -> id = " + id + ", Fecha inicio = " + finicio + ", Fecha fin = " + ffin + ", sueldo = " + sueldo + " euros.\n";
	}

	
	@Override
	public int compareTo(Beca b) {
		int resultado = 0;

		if (b.ffin > this.finicio) {
			resultado = -1;
		}

		if (this.ffin > b.ffin) {
			resultado = 1;
		}
		return resultado;
	}

}
