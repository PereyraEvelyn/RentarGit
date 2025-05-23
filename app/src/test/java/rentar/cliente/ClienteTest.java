package rentar.cliente;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class ClienteTest {

    @Test public void comprobarNuevaPersona() {
        Cliente cliente = new Cliente("123456", "Juan Perez", "A123", "Juan@gmail.comprobarNuevaPersona", "3834500020");
        
        assertEquals("123456", cliente.getDni());
    }

}
