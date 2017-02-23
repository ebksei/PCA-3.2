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

	public void obtener(int idProceso) {
		// TODO 2.3: Codificar preprotocolo
	}

	public void liberar(int idProceso) {
		// TODO 2.4: Codificar postprotocolo
	}
}
