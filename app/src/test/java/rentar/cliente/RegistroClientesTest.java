package rentar.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue; 

import org.junit.Before;
import org.junit.Test;

public class RegistroClientesTest {

    private RegistroClientes registro;
    private Cliente cliente1;
    private Cliente cliente2;

    @Before
    public void setUp() {
        registro = new RegistroClientes();
        cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");
        cliente2 = new Cliente("87654321", "Maria Lopez", "LP54321", "maria.lopez@email.com", "3834112233");
    }

    //Pruebas para agregarCliente

    @Test
    public void agregarCliente() {
        registro.agregarCliente(cliente1);
        // verificar que la lista no está vacía.
        assertTrue("El registro no debería estar vacío después de agregar un cliente.", !registro.getClientes().isEmpty());
    }

    @Test
    public void agregarDosClientes() {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente2);
        assertEquals("El tamaño del registro debería ser 2.", 2, registro.getClientes().size());
    }

    //Pruebas para getCliente

    @Test
    public void buscarUnClienteExistente() {
        registro.agregarCliente(cliente1);
        Cliente clienteEncontrado = registro.getCliente("12345678");
        assertNotNull("Se debería encontrar un cliente con un DNI existente.", clienteEncontrado);
    }
    
    @Test
    public void devolverElClienteCorrecto() {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente2);
        Cliente clienteEncontrado = registro.getCliente("12345678");
        assertEquals("El cliente encontrado debería ser el que corresponde al DNI buscado.", cliente1, clienteEncontrado);
    }


    @Test
    public void buscarUnClienteInexistente() {
        registro.agregarCliente(cliente1);
        Cliente clienteEncontrado = registro.getCliente("99999999");
        assertNull("No se debería encontrar un cliente con un DNI inexistente.", clienteEncontrado);
    }

    //Pruebas para eliminarCliente
    @Test
    public void eliminarUnCliente() {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente2);
        registro.eliminarCliente("12345678");
        assertEquals("El registro debería tener 1 cliente después de eliminar.", 1, registro.getClientes().size());
    }

    @Test
    public void alEliminarUnCliente_EseClienteYaNoDeberiaEstarEnElRegistro() {
        registro.agregarCliente(cliente1);
        registro.eliminarCliente("12345678");
        assertNull("El cliente eliminado ya no debería poder ser encontrado.", registro.getCliente("12345678"));
    }

    // --- Pruebas para modificarDatosCliente ---

    @Test
    public void modificarDatos() {
        registro.agregarCliente(cliente1);
        Cliente clienteModificado = new Cliente("12345678", "Juan Carlos Perez", "LP12345", "juan.p@email.com", "3834998877");
        registro.modificarDatosCliente(clienteModificado);
        Cliente clienteEncontrado = registro.getCliente("12345678");
        assertEquals("El nombre del cliente debería haber sido actualizado.", "Juan Carlos Perez", clienteEncontrado.getNombre());
    }

}


