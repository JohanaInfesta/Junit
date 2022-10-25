package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import restaurant.Almacen;
import restaurant.Ingrediente;
import restaurant.ItemReceta;
import restaurant.Receta;
import restaurant.SinSuficientesIngredientesException;

public class CocinaTest {

//	static List<Ingrediente>consumibles;
	static Almacen almacen;
	static Receta defaultReceta;
	
	@SuppressWarnings("static-access")
	@BeforeAll
	public static void initClass() {
		Ingrediente papa = new Ingrediente("Papa","gramos",20, 50);
		Ingrediente sal = new Ingrediente("Sal","gramos",10, 50);
//		consumibles.add(papa);
//		consumibles.add(sal);
		almacen = new Almacen();
		almacen.IngresarConsumibles(sal, 7);
		almacen.IngresarConsumibles(papa, 8);
		
		defaultReceta = new Receta("papas fritas",7, 50);
		defaultReceta.addIngrediente(papa, 5);
		defaultReceta.addIngrediente(sal, 5);
	}
	
	//f
	@SuppressWarnings("static-access")
	@Test
	public void cocinar () throws SinSuficientesIngredientesException {
		if(almacen.esPosibleCocinar(defaultReceta)) {
			for (ItemReceta item : defaultReceta.getIngredientes()){
				almacen.ExtraerConsumibles(item.getIngrediente(), item.getCantidad());
			}
		}else 
			throw new SinSuficientesIngredientesException();
	}
}
