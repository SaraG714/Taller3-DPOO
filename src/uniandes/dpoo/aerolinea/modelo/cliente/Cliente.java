package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	List<Tiquete> tiquetesSinUsar;
	List<Tiquete> tiquetesUsados;

	public Cliente() {	
		tiquetesSinUsar = new ArrayList<Tiquete>(); 
		tiquetesUsados = new ArrayList<Tiquete>(); 
		}
		
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete (Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}

	public int calcularValorTotalTiquetes() {
		int total = 0;

		for (Tiquete tiq: tiquetesUsados) {
			total += tiq.getTarifa();
		}

		for (Tiquete tiq: tiquetesSinUsar) {
			total += tiq.getTarifa();
		}
		return total;

	}
	
	public void usarTiquetes (Vuelo vuelo) {
		
		for (Tiquete tiq: tiquetesSinUsar) {
			if (tiq.getVuelo() == vuelo){
				
				tiquetesUsados.add(tiq);
				tiquetesSinUsar.remove(tiq);
			}
		}
	}


	}

	

