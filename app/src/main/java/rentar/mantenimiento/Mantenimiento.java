package rentar.mantenimiento;
import java.time.LocalDate;


public class Mantenimiento {    
        private LocalDate fecha;
        private String detalles_mantenimiento;
        
        
        public Mantenimiento(LocalDate fecha, String detalles_mantenimiento) {
            this.fecha = fecha;
            this.detalles_mantenimiento = detalles_mantenimiento;
        }


        public LocalDate getFecha() {
            return fecha;
        }


        public String getDetalles_mantenimiento() {
            return detalles_mantenimiento;
        }

        
        
        
        
        

        

    }
