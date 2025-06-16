package rentar.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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

    @Test
    public void agregarUnCliente() throws ClienteExistenteException {
        registro.agregarCliente(cliente1);
        assertEquals(1, registro.consultarTodosLosClientes().size());
    }

    @Test(expected = ClienteExistenteException.class)
    public void agregarUnClienteDuplicado() throws ClienteExistenteException {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente1);
    }

    
    @Test
    public void buscarClienteExistente() throws ClienteInexistenteException, ClienteExistenteException {
        registro.agregarCliente(cliente1);
        Cliente clienteEncontrado = registro.getCliente("12345678");
        assertEquals(cliente1, clienteEncontrado);
    }

    
    @Test(expected = ClienteInexistenteException.class)
    public void buscarClienteInexistente() throws ClienteInexistenteException {
        // Intentar buscar un cliente que no existe
        registro.getCliente("99999999");
    }

    

    @Test
    public void eliminarUnClienteExistente() throws ClienteExistenteException, ClienteInexistenteException {
        registro.agregarCliente(cliente1);
        registro.eliminarCliente(cliente1);
        assertEquals(0, registro.consultarTodosLosClientes().size());
    }

    @Test(expected = ClienteInexistenteException.class)
    public void eliminarUnClienteInexistente() throws ClienteInexistenteException {

        Cliente clienteNoRegistrado = new Cliente("1111", "Maria Eugenia", "F1", "f@mail.com", "111");

        registro.eliminarCliente(clienteNoRegistrado); 

    }


    @Test
    public void modificarUnCliente() throws ClienteExistenteException, ClienteInexistenteException {
        registro.agregarCliente(cliente1);

        Cliente clienteConDatosNuevos = new Cliente("12345678", "Juan Carlos Perez", "LP12345", "jc.perez@email.com", "3834998877");

        registro.modificarDatosCliente(clienteConDatosNuevos);

        assertEquals("Juan Carlos Perez", registro.getCliente("12345678").getNombre());
    }

    @Test(expected = ClienteInexistenteException.class)
    public void modificarUnClienteInexistente() throws ClienteInexistenteException {
        
        Cliente clienteNoExistente = new Cliente("2222", "Ramiro", "N2", "n@mail.com", "222");
        
        registro.modificarDatosCliente(clienteNoExistente); 
    }   

    @Test
    public void consultarTodosLosClientes() throws ClienteExistenteException {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente2);
        List<Cliente> clientes = registro.consultarTodosLosClientes();
        assertEquals(2, clientes.size());
    }

     @Test(expected = UnsupportedOperationException.class)
    public void intentarModificarLaListadeConsultarTodosLosClientes() throws ClienteExistenteException {
        registro.agregarCliente(cliente1);
        registro.agregarCliente(cliente2);
        List<Cliente> clientes = registro.consultarTodosLosClientes();

        // Intentar modificar la lista de los Clientes debe lanzar UnsupportedOperationException 
        clientes.add(cliente2); 
    }
}