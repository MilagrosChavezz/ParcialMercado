package ar.edu.unlam.pb2;

import java.util.Objects;
import java.util.Set;

public class Comercio {

	private Long cuit;
	private String nombre;
	

	public Comercio(Long cuit, String nombre) throws CuitInvalidoException {
		super();
		if(cuitValido(cuit)) {
		this.cuit = cuit;}
		else {throw new CuitInvalidoException();}
		this.nombre = nombre;
	}
	
	public Boolean cuitValido(Long cuit)  {
		
		String c= String.valueOf(cuit);
		
		if(c.charAt(0)=='3' && c.charAt(1)=='0' && c.length()<=11) {
			return true;
		}
		
		return false;
	  
	}
	
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Comercio other = (Comercio) obj;
		return Objects.equals(cuit, other.cuit) && Objects.equals(nombre, other.nombre);
	}
	
	

}
