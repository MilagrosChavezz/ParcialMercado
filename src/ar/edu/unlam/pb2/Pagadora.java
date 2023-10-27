package ar.edu.unlam.pb2;

public abstract class Pagadora {

	private Long numero;
	private String titular;
	private Integer codigoDeSeguridad;
	private String FechaDeVencimiento;
	
	public Pagadora(Long numero, String titular, Integer codigoDeSeguridad, String fechaDeVencimiento) throws NumeroDeTarjetaInvalidoException {
		super();
		if(numero.longValue()>=16) {
		this.numero = numero;}else {
			throw new NumeroDeTarjetaInvalidoException();
		}
		this.titular = titular;
		this.codigoDeSeguridad = codigoDeSeguridad;
		FechaDeVencimiento = fechaDeVencimiento;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}

	public void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}

	public String getFechaDeVencimiento() {
		return FechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		FechaDeVencimiento = fechaDeVencimiento;
	}


	

}