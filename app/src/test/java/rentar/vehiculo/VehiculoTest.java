package rentar.vehiculo;
import rentar.vehiculo.*;
import rentar.vehiculo.Vehiculo.Estado;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VehiculoTest {
    ModeloVehiculo m;
    AutoCombustion b;
    AutoCombustion a;


    @Before
    public void setUp() {
        m = new ModeloVehiculo("peugeot", "peugeot", 2010, new BigDecimal("100000"));
        b = new AutoCombustion("3333", 3000, Estado.Disponible, m, 30, 10);
        a = new AutoCombustion("3333", 3000, Estado.Disponible, m, 30, 10);

    }

    @Test
    public void testCreacionVehiculo() {
        assertEquals("3333", b.getPatente());
    }

    
    @Test
    public void testEquals() {
        
        assertTrue("Los vehiculos se diferencian por la patente, si la patente es igual es el mismo vehiculo", a.equals(b));
    }
}
