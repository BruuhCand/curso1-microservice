package com.BrunaFirstProject.entities;

public class MathOperation {

	public Double soma(Double x, Double y) {
		return x + y;
	}
	
	public Double subtracao(Double x, Double y) {
		return x - y;
	}
	
	public Double divisao(Double x, Double y) {
		return x / y;
	}
	
	public Double multi(Double x, Double y) {
		return x * y;
	}
	
	public Double media(Double x, Double y) {
		return (x + y) / 2;
	}
	
	public Double raiz(Double x) {
		return Math.sqrt(x);
	}
}
