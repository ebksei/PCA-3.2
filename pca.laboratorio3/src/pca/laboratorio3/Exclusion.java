package pca.laboratorio3;

import pca.laboratorio3.util.*;

public class Exclusion {

	private int numProcesos;
	private VolatileInteger[] num;
	private VolatileBoolean[] eligiendo;

	// TODO 2.1: Declarar atributos
	public Exclusion(int numProcesos) {
		this.numProcesos = numProcesos;
		// TODO 2.2: Inicializar atributos
		num = new VolatileInteger[numProcesos];
		eligiendo = new VolatileBoolean[numProcesos];

		for (int i = 0; i < numProcesos; i++) {
			num[i] = new VolatileInteger(0);
			eligiendo[i] = new VolatileBoolean(false);
		}
	}

	private int maximo() {
		int max = num[0].get();

		for (int i = 1; i < num.length; i++) {
			if (num[i].get() > max) {
				max = num[i].get();
			}
		}
		return max;
	}

	public void obtener(int idProceso) {
		// TODO 2.3: Codificar preprotocolo

		/* Calcula el número de turno */
		eligiendo[idProceso].set(true);
		num[idProceso].set(1 + maximo());
		eligiendo[idProceso].set(false);

		/* Compara con todos los hilos */
		for (int j = 0; j < numProcesos; j++) {
			/* Si el hilo j está calculando su número, espera a que termine */
			while (eligiendo[idProceso].get()) {
			}

			/* Si el hilo j tiene más prioridad, espera a que ponga su número a cero */
			/* j tiene más prioridad si su número de turno es más bajo que el de idProceso,  */
			/*  o bien si es el mismo número y además j es menor que idProceso               */
            while ( (num[j].get()!= 0) &&
					((num[j].get() < num[idProceso].get()) || (num[j].get() == num[idProceso].get() && j<idProceso)) ) { }  
		}
	}

	public void liberar(int idProceso) {
		// TODO 2.4: Codificar postprotocolo
		num[idProceso].set(0);
	}
}
