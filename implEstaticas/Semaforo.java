package implEstaticas;

import especificaciones.SemaforoTDA;

public class Semaforo implements SemaforoTDA {

	private String color;
    
    @Override
    public void inicializarSemaforo(String color) {
        switch (color) {
            case "Rojo", "Verde", "Amarillo" -> this.color = color;
        }
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
