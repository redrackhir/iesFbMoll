
package factorymethodlavadora;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestLavadora {

	@Test
	public void test_carga_frontal() {
		
		Lavadora lavadora = new LavadoraCargaFrontal();
		lavadora.ponerMandos();
		lavadora.ponerTambor();
		
		assertEquals("frontal", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}

	@Test
	public void test_carga_superior() {
		
		Lavadora lavadora = new LavadoraCargaSuperior();
		
		assertEquals("superior", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}

}
