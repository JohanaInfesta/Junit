package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import restaurant.ItemPedido;
import restaurant.Pedido;
import restaurant.ProductoBasico;
import restaurant.Usuario;

public class PedidoTest {
	
	static Pedido pedidoDefault;
	static Usuario usuarioDefault;
	static List<ItemPedido> items;
	
	@BeforeAll
	public static void initClass() {
		items = new ArrayList<>();
		items.add(new ItemPedido(3, new ProductoBasico("kiwi", 10, 50)));
		items.add(new ItemPedido(5, new ProductoBasico("banana", 10, 20)));
		usuarioDefault = new Usuario("bolita hernandez", 0, 300, "mail");
		pedidoDefault = new Pedido(items, usuarioDefault);
	}
	//d
	@Test
	public void verificarReduccionSaldo() throws Exception {
		float total=pedidoDefault.totalPedido();
		float saldoOriginal = usuarioDefault.getSaldo();
		pedidoDefault.getUsuario().descontarSaldo(total);
		assertEquals(saldoOriginal-total, usuarioDefault.getSaldo());
	}
	//e
	@Test
	public void verificarGanancia() {
		float precioCompra = 0.0f;
		for (ItemPedido itemPedido : items) {
			precioCompra += (itemPedido.getCantidad())*itemPedido.getItem().getPrecioUnitarioCompra();
		}
		float precioVenta = pedidoDefault.totalPedido();
		if((20.0 * precioCompra/100 + precioCompra)>precioVenta)
			fail();
		else
			assert(1+1==2);
	}
	
}
