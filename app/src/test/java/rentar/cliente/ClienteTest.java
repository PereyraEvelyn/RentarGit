/* package rentar.cliente;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class ClienteTest {
    
    @Test void testCreacionCliente() {
        Cliente cliente1 = new Cliente("1234567", "samuel", "216738", "samu@gmail.com", "213213213");
        assertEquals("1234567", cliente1.getDni());
    }   


}
*/
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
    }

    
    @Test
    public void testEquals() {
        Cliente cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");

        Cliente cliente2 = new Cliente("12345678", "Juan A. Perez", "LP99999", "juan.p@email.com", "3831112233");
        
        assertTrue("Los clientes con el mismo DNI deben ser iguales", cliente1.equals(cliente2));
    }
}