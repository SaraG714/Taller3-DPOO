package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo{
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;
	
	//Constructor
	public Vuelo(String fecha, Ruta ruta, Avion avion) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
    // Getters
    public Ruta getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
    	int precio = calculadora.calcularTarifa(this, cliente);
    	if (cantidad > avion.getCapacidad()) {
    		throw new VueloSobrevendidoException(this);
    	}
    	return precio;
    		
    }
    
    public boolean equals (Object obj) {
    	if (obj == this) {
    		return true;
    	}
    	return false;
    }
    
}
