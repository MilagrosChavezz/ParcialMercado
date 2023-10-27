package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Pagadora implements IDebito{

	private Double saldo;
	
	public TarjetaDeDebito(Long numero, String titular , String fechaDeVencimiento,Integer codigoDeSeguridad) throws NumeroDeTarjetaInvalidoException {
		super(numero, titular, codigoDeSeguridad, fechaDeVencimiento);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void setSaldo(Double saldo) {
		// TODO Auto-generated method stub
		this.saldo=saldo;
	}

	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	

	

}
