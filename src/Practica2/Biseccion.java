package Practica2;

import java.util.*;
import java.math.*;

public class Biseccion extends FuncionBiseccion {

	private int func;

	public Biseccion(double li, double ls, double prec, int func) {
		super(li, ls, prec);
		this.func = func;

	}
	//metodo que realiza el procedimiento de la biseccion
	private double metodoBi(double li, double ls, double prec) {

		double media = (ls + li) / 2;
		double raiz = 0;

		// comprobamos
		if (funcion(this.func, media) < prec && funcion(this.func, media) > prec * (-1)) {

			raiz = media;

		} else { // evaluamos la función por ambos lados y determinamos el intervalo

			if (funcion(this.func, media) * funcion(this.func, li) < 0) {
				raiz = metodoBi(li, media, prec);
				this.setls(media);
			}

			if (funcion(this.func, media) * funcion(this.func, li) > 0) {
				raiz = metodoBi(media, ls, prec);
				this.setli(media);
			}
		}

		return raiz;
	}

	public void evaluarBolzano() {
		// Evaluamos primero la condicion de bolzano para pasar al metodo de biseccion
		if (funcion(this.func, this.getli()) * funcion(this.func, this.getls()) < 0) {
			double r = metodoBi(this.getli(), this.getls(), this.getPrec());
			System.out.println("La raíz en el intervalo [" + this.getLiInicial() + "," + this.getLsInicial() + "] es "
					+ r + " y ha sido encontrada en el intervalo [" + this.getli() + "," + this.getls() + "]\n");
		} else {
			System.out.println(
					"No es posible aplicar el método de la bisección a la función , ya que se cumple que --> f(a)*f(b)>=0 \n");
		}

	}

	// Metodo con las 3 funciones a elegir
	public double funcion(int nFuncion, double x) {

		double f = 0;

		if (nFuncion == 1) {
			f = (Math.pow(x, 2) - 2 * x - 3);
		} else if (nFuncion == 2) {
			f = (Math.pow(2, x) - Math.pow(x, 2) - 10);
		} else if (nFuncion == 3) {
			f = (Math.sin(x) - (1 / x));
		}
		return f;
	}

}
