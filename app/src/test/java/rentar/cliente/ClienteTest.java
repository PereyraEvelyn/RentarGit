package rentar.cliente;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente cliente1;
    private Cliente cliente2_igual_a_1;
    private Cliente cliente3_diferente;

    @Before
    public void setUp() {
        // Datos de entrada para las pruebas
        cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");
        cliente2_igual_a_1 = new Cliente("12345678", "Juan Alberto Perez", "LP99999", "juan.p@email.com", "3831112233");
        cliente3_diferente = new Cliente("87654321", "Maria Lopez", "LP54321", "maria.lopez@email.com", "3834112233");
    }
 
    @Test
    public void testCreacionCliente() {
        assertEquals("12345678", cliente1.getDni());
    }

    @Test
    public void testEqualsClientesIguales() {
        assertTrue("Los clientes con el mismo DNI deben ser considerados iguales", cliente1.equals(cliente2_igual_a_1));
    }

    @Test
    public void testEqualsClientesDiferentes() {
        assertFalse("Los clientes con diferente DNI no deben ser considerados iguales", cliente1.equals(cliente3_diferente));
    }
}











