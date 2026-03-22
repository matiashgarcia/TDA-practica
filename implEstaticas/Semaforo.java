package implEstaticas;

import especificaciones.SemaforoTDA;

public class Semaforo implements SemaforoTDA {

	private String color;

	@Override
	public void inicializarSemaforo(String color) {
		if (color.equals("Rojo") || color.equals("Verde") || color.equals("Amarillo"))
			this.color = color;
		else
			this.color = "Rojo";
	}

	@Override
	public void cambiarARojo() {
		this.color = "Rojo";
	}

	@Override
	public void cambiarAAmarilo() {
		this.color = "Amarillo";
	}

	@Override
	public void cambiarAVerde() {
		this.color = "Verde";
	}

	@Override
	public String colorActual() {
		return this.color;
	}
}
