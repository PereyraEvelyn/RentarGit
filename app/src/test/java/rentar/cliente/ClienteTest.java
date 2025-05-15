package rentar.cliente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClienteTest {

    @Test public void testCreacionCliente() {
        Cliente cliente = new Cliente("1234567", "samuel", "216738", "samu_crack@gmail.com", "213213213");
        assertEquals("1234567", cliente.getDni());
        assertEquals("samuel", cliente.getNombre());
    }
    
}
