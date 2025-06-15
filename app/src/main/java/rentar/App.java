package rentar;
import rentar.vehiculo.*;
import rentar.vehiculo.Vehiculo.Estado;
import rentar.cliente.Cliente;
import java.math.BigDecimal;
import rentar.mantenimiento.*;
import java.time.LocalDate;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

    }
}
