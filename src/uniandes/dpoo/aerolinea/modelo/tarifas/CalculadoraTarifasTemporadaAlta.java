package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	protected int COSTO_POR_KM = 1000;
	
	
	public CalculadoraTarifasTemporadaAlta() {
		
	}

	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoPorKm = COSTO_POR_KM;
        	
		int costoBase = distancia * costoPorKm;
        return (int) (costoBase * (1 - descuento));
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		//En temporada alta no hay descuentos
		return 0;
	}

}
