
package rentar.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClienteTest {
 
    @Test
    public void testCreacionCliente() {
        Cliente cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");
        
        assertEquals("12345678", cliente1.getDni());
        assertEquals("Juan Perez", cliente1.getNombre());
        assertNotNull(cliente1);
    }

    
    @Test
    public void testEquals() {
        Cliente cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");
        Cliente cliente2 = new Cliente("87654321", "Maria Lopez", "LP54321", "maria.lopez@email.com", "3834112233");
        Cliente cliente3 = new Cliente("12345678", "Juan A. Perez", "LP99999", "juan.p@email.com", "3831112233");
        
        assertTrue("Los clientes con el mismo DNI deben ser iguales", cliente1.equals(cliente3));
        assertFalse("Los clientes con diferente DNI no deben ser iguales", cliente1.equals(cliente2));
    }
}