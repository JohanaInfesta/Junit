package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import restaurant.Usuario;
import restaurant.UsuarioRepetidoException;

public class usuarioTest {

	static List<Usuario>usuariosTest;
	Usuario defaultUsuarios;

	@BeforeAll
	public static void initClass() {
		usuariosTest = new ArrayList<Usuario>();
		usuariosTest.add(new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com"));
		usuariosTest.add(new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com"));
		usuariosTest.add(new Usuario("Homero", 0, 350, "homerojsimpson@springfield.com"));
	}

	@Test
	public void verificarRepetidos() throws UsuarioRepetidoException {
		List<Usuario>usuariosTemp = new ArrayList<>();
		for (Usuario u : usuariosTest) {
			if(!usuariosTemp.contains(u))
				usuariosTemp.add(u);
			else 
				fail("Fallo por usuario repetido");
		}
	}
	
	@Test
	public void verificarMail() throws Exception{
		for (Usuario usuario : usuariosTest) {
			String usuarioMail = usuario.getEmail();
			String mail = "@";
			assertTrue(usuarioMail.contains(mail));
		}
		
	}
}