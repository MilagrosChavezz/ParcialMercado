package ar.edu.unlam.pb2;

import java.util.Objects;

public class Transferible {
	
	private String titular;
	private String entidad;
	
	
	public Transferible( String entidad, String titular)  {
		super();
	
		this.titular = titular;
		this.entidad = entidad;
	}

	

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}



	@Override
	public int hashCode() {
		return Objects.hash(entidad);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Transferible other = (Transferible) obj;
		return Objects.equals(entidad, other.entidad);
	}
	
	

}
