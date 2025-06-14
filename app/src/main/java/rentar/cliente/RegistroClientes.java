package rentar.cliente;

import java.util.ArrayList;

public class RegistroClientes {
    private ArrayList<Cliente> clientes;

     public RegistroClientes(){
        this.clientes = new ArrayList<Cliente>();
     }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

     public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void eliminarCliente(String dni){
        Cliente clienteEncontrado = getCliente(dni);
        clientes.remove(clienteEncontrado);
    }

    public Cliente getCliente(String dni){
        Cliente clienteEncontrado = null;
        for (Cliente aux : clientes) {
            if (aux.getDni().equals(dni)) {
                clienteEncontrado = aux;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("No se encontro el cliente");;
        }    
        return clienteEncontrado;
    }


     public void modificarDatosCliente(Cliente nuevoCliente) {
        Cliente clienteEncontrado;
        clienteEncontrado = getCliente(nuevoCliente.getDni());
        clientes.remove(clienteEncontrado); 
        clientes.add(nuevoCliente);               
	}
    

}

   

    

   
    

