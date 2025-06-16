package rentar.mantenimiento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import rentar.vehiculo.AutoCombustion;
import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.Vehiculo.Estado;

public class GestorMantenimientoTest {

    private GestorMantenimiento gestor;
    private ModeloVehiculo m;
    private AutoCombustion b;
    private Mantenimiento mante;
    private Mantenimiento mante2;
    @Before
    public void setUp() {
        gestor = new GestorMantenimiento();
        m = new ModeloVehiculo("peugeot", "peugeot", 2010, new BigDecimal("100000"));
        b = new AutoCombustion("3333", 3000, Estado.Disponible, m, 30, 10);
        mante = new Mantenimiento(LocalDate.of(1999,5,30), "coso");
        mante2= new Mantenimiento(LocalDate.of(1999,6,24), "coso");
    }

    @Test
    public void agregarMantenimientoTest() {
        gestor.agregarMantenimiento(mante);
        // verificar que la lista no está vacía.
        assertTrue("El registro no debería estar vacío después de agregar un mantenimiento.", !gestor.getMantenimientos().isEmpty());
    }

    @Test
    public void getMantenimientoTest() {
        gestor.agregarMantenimiento(mante);       
        Mantenimiento mantenimientoEncontrado = gestor.getMantenimiento(mante.getFecha_fin_mantenimiento());
        assertTrue(mantenimientoEncontrado.getFecha_fin_mantenimiento() == mante.getFecha_fin_mantenimiento());
    }

    @Test
    public void eliminarMantenimientoTest() {
        gestor.agregarMantenimiento(mante);
        gestor.eliminarMantenimiento(mante.getFecha_fin_mantenimiento());
        assertNull("El valor eliminado no deberia estar en la lista de mantenimientos.", gestor.getMantenimiento(mante.getFecha_fin_mantenimiento()));
    }

    @Test
    public void modificarMantenimientoTest() {
        gestor.agregarMantenimiento(mante);
        Mantenimiento mantenimientoModificado = mante2;
        gestor.modificarMantenimiento(mantenimientoModificado);
        assertFalse("El manteniumiento no puede ser el mismo que el valor modificado.", gestor.getMantenimiento(mantenimientoModificado.getFecha_fin_mantenimiento()).equals(mante));
    }
    
}
