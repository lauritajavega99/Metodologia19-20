package Practica2;

public abstract class FuncionBiseccion {
	protected double li;
	protected double ls;
	protected double liInicial;
	protected double lsInicial;
	protected double prec;

	public FuncionBiseccion(double li, double ls, double prec) {
		this.li = li;
		this.ls = ls;
		this.prec = (double) (1 / Math.pow(10, prec));
		liInicial = li;
		lsInicial = ls;
	}

	public double getli() {
		return li;
	}

	public void setli(double li) {
		this.li = li;
	}

	public double getls() {
		return ls;
	}

	public void setls(double ls) {
		this.ls = ls;
	}

	public double getPrec() {
		return prec;
	}

	public void setPrec(double prec) {
		this.prec = prec;
	}

	public double getLiInicial() {
		return liInicial;
	}

	public double getLsInicial() {
		return lsInicial;
	}

}
