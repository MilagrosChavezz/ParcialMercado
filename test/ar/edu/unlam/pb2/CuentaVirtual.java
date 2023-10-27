package ar.edu.unlam.pb2;

public class CuentaVirtual extends Transferible implements IMedioDePago{

String cvu;
	
	public CuentaVirtual( String cvu,String entidad, String titular) throws CVUInvalidoException {
		super( entidad, titular);
		// TODO Auto-generated constructor stub
		if(cvu.length()==23) {
			this.cvu = cvu;}
			else {
				throw new CVUInvalidoException();
			}
	}

	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return cvu;
	}

	
}
