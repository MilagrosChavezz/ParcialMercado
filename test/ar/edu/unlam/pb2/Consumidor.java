package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Consumidor {

	private String nombre;
	private Integer dni;
	private Set<Pagadora>tarjetas;

	public Consumidor(Integer dni, String nombre) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	    this.tarjetas=new HashSet<>();	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		return Objects.equals(dni, other.dni);
	}

	public void agregarTarjetas(Pagadora t) {
		tarjetas.add(t);
	}
	
	public Pagadora getMedioPagador(long l) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		for (Pagadora pagadora : tarjetas) {
		  if(pagadora.getNumero().equals(l));
		  return pagadora;
		}
		throw new NoCoincideTitularException();
	}

}
