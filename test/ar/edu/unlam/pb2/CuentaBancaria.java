package ar.edu.unlam.pb2;

public class CuentaBancaria extends Transferible implements IMedioDePago{

	private String cbu;
	
	public CuentaBancaria(String cbu, String entidad, String titular) throws CBUInvalidoException {
		super( entidad, titular);
		// TODO Auto-generated constructor stub
		if(cbu.length()==20) {
			this.cbu = cbu;}
			else {
				throw new CBUInvalidoException();
			}
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return cbu;
	}
	
	

}
