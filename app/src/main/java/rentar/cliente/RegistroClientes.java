package rentar.cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroClientes {
    private final List<Cliente> clientes;

     public RegistroClientes(){
        this.clientes = new ArrayList<>();
     }


   public List<Cliente> consultarTodosLosClientes() {
        return Collections.unmodifiableList(clientes);
    }

  
     public void agregarCliente(Cliente cliente) throws ClienteExistenteException {
       if (this.clientes.contains(cliente)) {
            throw new ClienteExistenteException("ERROR: El cliente con DNI " + cliente.getDni() + " ya está registrado.");
        }
        this.clientes.add(cliente);
    }

   
    public void eliminarCliente(Cliente cliente) throws ClienteInexistenteException {
        boolean fueEliminado = clientes.remove(cliente);
        if (!fueEliminado) {
            throw new ClienteInexistenteException("ERROR: No se puede eliminar. El cliente con DNI " + cliente.getDni() + " no existe.");
        }
    }

    public Cliente getCliente(String dni) throws ClienteInexistenteException {
        for (Cliente aux : clientes) {
            if (aux.getDni().equals(dni)) {
                return aux;
            }
        }
        throw new ClienteInexistenteException("ERROR: No se encontró un cliente con el DNI " + dni);
    }


      public void modificarDatosCliente(Cliente clienteActualizado) throws ClienteInexistenteException {
        Cliente clienteExistente = getCliente(clienteActualizado.getDni());
        this.clientes.remove(clienteExistente);
        this.clientes.add(clienteActualizado);
    }

   
}

    

   
    

