package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Billetera {

	private static final Compra Compra = null;
	private String nombre;
	private Set<Comercio> comercios;
	private Set<Consumidor> consumidores;
	private Map<Long, Consumidor> tarjetas;
	private Set<Pagadora> tarjetasPagadoras;
	private Set<Transferible> cuentas;

	public Billetera(String nombre) {
		super();
		this.nombre = nombre;
		this.comercios = new HashSet<>();
		this.consumidores = new HashSet<>();
		this.tarjetas = new HashMap<>();
		this.tarjetasPagadoras = new HashSet<>();
		this.cuentas=new HashSet<>();
	}

	public void agregarComercio(Comercio comercio) {
		// TODO Auto-generated method stub
		comercios.add(comercio);
	}

	public Integer getCantidadDeComercios() {
		return comercios.size();
	}

	public void agregarConsumidor(Consumidor consumidor) {
		// TODO Auto-generated method stub
		consumidores.add(consumidor);
	}

	public Object getCantidadDeConsumidores() {
		// TODO Auto-generated method stub
		return consumidores.size();
	}

	public Consumidor consumidorBuscado(Integer dni) throws ConsumidorInexistente {
		for (Consumidor consumidor : consumidores) {
			if (consumidor.getDni().equals(dni)) {
				return consumidor;
			}
		}
		throw new ConsumidorInexistente();
	}

	public Boolean coincideConTitular(Integer dni, Pagadora t)
			throws ConsumidorInexistente, NoCoincideTitularException {
		if (consumidorBuscado(dni).getNombre().equals(t.getTitular())) {
			return true;
		}
		throw new NoCoincideTitularException();
	}

	public Boolean coincideConTitular(Integer dni, Transferible t)
			throws ConsumidorInexistente, NoCoincideTitularException {
		if (consumidorBuscado(dni).getNombre().equals(t.getTitular())) {
			return true;
		}
		throw new NoCoincideTitularException();
	}

	public void agregarMedioDePago(Integer dni, Pagadora t) throws ConsumidorInexistente, NoCoincideTitularException {
		// TODO Auto-generated method stub
		if (coincideConTitular(dni, t)) {
			tarjetas.put(t.getNumero(), consumidorBuscado(dni));
			tarjetasPagadoras.add(t);
		}

	}

	public void agregarMedioDePago(Integer dni, Transferible t)
			throws ConsumidorInexistente, NoCoincideTitularException {
		if (coincideConTitular(dni, t)) {
			long identificador = Long.parseLong(((IMedioDePago) t).getIdentificador());
			tarjetas.put(identificador, consumidorBuscado(dni));
			cuentas.add(t);
		}
	}

	public Integer getCantidadDeMediosDePago(int i) throws ConsumidorInexistente {
		// TODO Auto-generated method stub
		Integer cantidadMediosPago = 0;
		for (Map.Entry<Long, Consumidor> tarjetas : tarjetas.entrySet()) {
			Long key = tarjetas.getKey();
			Consumidor val = tarjetas.getValue();
			if (consumidorBuscado(i).getNombre().equals(val.getNombre())) {
				cantidadMediosPago++;
			}
		}
		return cantidadMediosPago;
	}

	public Comercio buscarComercio(Long dni) throws ComercioInexcistente {
		for (Comercio comercio : comercios) {
			if (comercio.getCuit().equals(dni)) {
				return comercio;
			}
		}

		throw new ComercioInexcistente();

	}

	public Compra generarCodigoQR(Long l, Double valorCompra) throws ComercioInexcistente {
		// TODO Auto-generated method stub
		return new Compra(buscarComercio(l), valorCompra);

	}

	public Boolean pagar(Compra codigoQR, Consumidor consumidor, Pagadora medioPagador)
			throws ExcedeLimiteDeCompraException {
		// TODO Auto-generated method stub
		if (medioPagador instanceof ICredito
				&& ((ICredito) medioPagador).getLimiteDeCompraEnDolares() >= codigoQR.getGasto()
				|| ((ICredito) medioPagador).getLimiteDeComprasEnPesos() >= codigoQR.getGasto()) {
			return true;
		} else {
			throw new ExcedeLimiteDeCompraException();
		}
	}

	public Pagadora getMedioPagador(long l) throws NumeroDeTarjetaInvalidoException {
		// TODO Auto-generated method stub
		for (Pagadora pagador : tarjetasPagadoras) {
			if (pagador.getNumero().equals(l)) {
				return pagador;
			}
		}
		throw new NumeroDeTarjetaInvalidoException();
	}

	public Boolean transferir(Transferible cuentaOrigen, Transferible cuentaDestino) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		if(cuentaBuscada(cuentaOrigen) !=null &&
		cuentaBuscada(cuentaDestino)!=null) {
		return true;}
		return false;
	
	}

	public Transferible cuentaBuscada(Transferible cuentaOrigen) throws NoCoincideTitularException {
		for (Transferible c : cuentas) {
			if(cuentaOrigen.getTitular().equals(c.getTitular())) {
				return c;
			}
		}
		throw new NoCoincideTitularException();
	}
}
