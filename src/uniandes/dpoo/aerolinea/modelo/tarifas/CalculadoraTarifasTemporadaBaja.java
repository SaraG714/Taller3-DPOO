package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
    protected int COSTO_POR_KM_NATURAL = 600;
    protected int COSTO_POR_KM_CORPORATIVO = 900;
    protected double DESCUENTO_PEQ = 0.02;
    protected double DESCUENTO_MEDIANAS = 0.1;
    protected double DESCUENTO_GRANDES = 0.2;
    

	public CalculadoraTarifasTemporadaBaja() {
	}
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        double descuento = calcularPorcentajeDescuento(cliente);
        String tipoCliente = cliente.getTipoCliente();
        int costoPorKm = 0;
        if (tipoCliente == "Natural") {
        	costoPorKm = COSTO_POR_KM_NATURAL;
        }else if (tipoCliente == "Corporativo") {
        	costoPorKm = COSTO_POR_KM_CORPORATIVO;
        }
        	
		int costoBase = distancia * costoPorKm;
        return (int) (costoBase * (1 - descuento));

	}
	@Override
	public double calcularPorcentajeDescuento(Cliente cliente) {
	    double dcto = 0;
		if (cliente instanceof ClienteCorporativo) {
	        ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
	        int tamano = clienteCorporativo.getTamanoEmpresa();
	        if (tamano == 1) {
	        	dcto = DESCUENTO_GRANDES;
	        }else if (tamano == 2) {
	        	dcto = DESCUENTO_MEDIANAS;
	        }else if (tamano == 3) {
	        	dcto = DESCUENTO_PEQ;
	        }
		}
	    
	    
		return dcto;
		}


    
}
