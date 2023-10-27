package ar.edu.unlam.pb2;

public class Compra {

	private Comercio comercio;
	
	private Double gasto;

	public Compra(Comercio comercio, Double gasto) {
		super();
		this.comercio =comercio;
		this.gasto = gasto;
	}

	

	public Comercio getComercio() {
		return comercio;
	}



	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}



	public Double getGasto() {
		return gasto;
	}

	public void setGasto(Double gasto) {
		this.gasto = gasto;
	}

}
