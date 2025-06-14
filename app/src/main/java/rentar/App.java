package rentar;

import rentar.cliente.Cliente;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Cliente cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");;
        
        System.out.println(cliente1.getDni());

    }
}
