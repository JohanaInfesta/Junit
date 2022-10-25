package restaurant;
import java.util.Date;
import java.util.Objects;

public class Usuario {
	static int nextID;
	int id;
	String nombreYApellido;
	int tipoUsuario;
	float saldoCuenta;
	Date ultimaRecarga;
	String email;
	public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.tipoUsuario = tipoUsuario;
		this.saldoCuenta = saldoCuenta;
		this.email=email;
	}

	public void cargarCredito(float cuanto) {
		saldoCuenta+=cuanto;

	}
	public float descontarSaldo(float cuanto) throws SinSaldoException {
		if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
		else
			saldoCuenta-= cuanto;
		return saldoCuenta;

	}
	public float getSaldo() {
		return saldoCuenta;
	}

	

	public int getId() {
		return id;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombreYApellido, other.nombreYApellido);
	}

}
