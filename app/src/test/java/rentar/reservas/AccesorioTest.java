package rentar.reservas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class AccesorioTest {
    

    @Test
    public void testCreacionAccesorio() {
        Accesorio accesorio = new Accesorio("silla de bebe", "para llevar bebes", new BigDecimal(4000));
        assertEquals("silla de bebe", accesorio.getNombre_accesorio());
    }

    @Test
    public void testEquals() {
        Accesorio accesorio = new Accesorio("silla de bebe grande", "para llevar bebes", new BigDecimal(6000));
        Accesorio accesorio2 = new Accesorio("silla de bebe mediana", "para llevar bebes", new BigDecimal(4000));

        assertFalse("Un accesorio es igual al otro si su nombre, descripcion y costo son iguales", accesorio.equals(accesorio2));
    }
}
