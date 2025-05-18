package rentar.mantenimiento;
import java.time.LocalDate;
import rentar.vehiculo.*;

public class Mantenimiento {    
        private LocalDate fecha;
        private String detalles_mantenimiento;
        private Vehiculo vehiculo;
        
        
        public Mantenimiento(LocalDate fecha, String detalles_mantenimiento, Vehiculo vehiculo) {
            this.fecha = fecha;
            this.detalles_mantenimiento = detalles_mantenimiento;
            this.vehiculo = vehiculo;
        }


        public LocalDate getFecha() {
            return fecha;
        }


        public String getDetalles_mantenimiento() {
            return detalles_mantenimiento;
        }

        
        
        
        
        

        

    }
