package test;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import restaurant.Ingrediente;
import restaurant.Receta;

public class recetaTest {

	static List<Receta>recetasTest;
	Receta defaultReceta;
	@BeforeAll
	public static void initClass() {
		//ingredientes
		Ingrediente papa = new Ingrediente("Papa","gramos",20000, 50);
		Ingrediente sal = new Ingrediente("Sal","gramos",1000, 50);
		
		recetasTest = new ArrayList<Receta>();
		Receta receta1 = new Receta("papas fritas",7, 50);
		receta1.addIngrediente(papa, 6);
		receta1.addIngrediente(sal, 6);
		recetasTest.add(receta1);
		
	}
	
	@Test
	public void verifyRecetaCantIngredientes() throws Exception {
		for (Receta r : recetasTest) {
			assert(r.getIngredientes().size() > 0);
		}
	}
	
	
	
}
