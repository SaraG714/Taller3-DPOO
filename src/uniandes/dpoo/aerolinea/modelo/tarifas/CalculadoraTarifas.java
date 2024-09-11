package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	public static final double IMPUESTO = 0.28;
	
	
	public CalculadoraTarifas() {
	}

	public int calcularTarifa(Vuelo vuelo, Cliente cliente){
		int base = calcularCostoBase(vuelo, cliente);
		int impuesto = calcularValorImpuestos(base);
		int costo = base + impuesto;
		return costo;
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo (Ruta ruta) {
		Aeropuerto destino = ruta.getDestino();
		Aeropuerto origen = ruta.getOrigen();
		return Aeropuerto.calcularDistancia(destino, origen);
	}
	
	protected int calcularValorImpuestos (int costoBase) {
		return (int) (costoBase * IMPUESTO);
	}
	
}
