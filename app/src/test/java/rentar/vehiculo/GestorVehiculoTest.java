package rentar.vehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import rentar.vehiculo.Vehiculo.Estado;

public class GestorVehiculoTest {

    ModeloVehiculo modelo;
    AutoCombustion auto;
    AutoElectrico auto1;
    GestorVehiculo gestor;
    
    @Before
    public void setUp() {
        modelo = new ModeloVehiculo("peugeot", "peugeot", 2010, new BigDecimal("100000"));
        auto1 = new AutoElectrico("3333", 3000, Estado.Disponible, modelo, 30, 10);
        auto = new AutoCombustion("3333", 3000, Estado.Disponible, modelo, 30, 10);
        gestor = new GestorVehiculo();
    }

    @Test
    public void vehiculosListosParaMantenimientoTest(){
        auto.setKilometraje(auto.getKilometros_para_mantenimiento());
        gestor.agregarVehiculo(auto);
        assertNotNull(gestor.vehiculosListosParaMantenimiento());
    }

    @Test
    public void vehiculosEnMantenimientoTest(){
        auto1.setEstado(Estado.EnMantenimiento);
        gestor.agregarVehiculo(auto1);
        assertNotNull(gestor.vehiculosEnMantenimiento());
    }

    @Test
    public void ingresar_a_mantenimiento_vehiculosTest(){
        auto1.setEstado(Estado.Disponible);
        gestor.agregarVehiculo(auto1);
        gestor.ingresar_a_mantenimiento_vehiculos(auto1, "mantenimiento", LocalDate.of(2025, 7, 29));
        assertTrue(auto1.getEstado() == Estado.EnMantenimiento);
    }

    /*@Test
    public void egresar_mantenimientoTest(){
        auto1.setEstado(Estado.Disponible);
        gestor.agregarVehiculo(auto1);
        gestor.ingresar_a_mantenimiento_vehiculos(auto,"mantenimiento" , LocalDate.of(2025, 7, 29));
        gestor.egresar_mantenimiento(auto1, LocalDate.of(2025, 7, 29));
        assertTrue(auto1.getEstado() == Estado.Disponible);

    }*/

}
