package ar.edu.unlam.pb2;

public  class TarjetaDeCredito extends Pagadora implements ICredito{

	private Double limiteDeCompraEnDolares;
	private Double limiteDeCompraEnPesos;
	
	public TarjetaDeCredito(Long numero, String titular,String fechaDeVencimiento, Integer codigoDeSeguridad, Double LIMITE_COMPRA_EN_PESOS, Double LIMITE_DE_COMPRA_EN_DOLARES)
			throws NumeroDeTarjetaInvalidoException {
		super(numero, titular, codigoDeSeguridad, fechaDeVencimiento);
		// TODO Auto-generated constructor stub
		this.limiteDeCompraEnDolares=LIMITE_DE_COMPRA_EN_DOLARES;
		this.limiteDeCompraEnPesos=LIMITE_COMPRA_EN_PESOS;
	}

	@Override
	public Double getLimiteDeCompraEnDolares() {
		// TODO Auto-generated method stub
		return limiteDeCompraEnDolares;
	}

	@Override
	public Double getLimiteDeComprasEnPesos() {
		// TODO Auto-generated method stub
		return limiteDeCompraEnPesos;
	}

}
