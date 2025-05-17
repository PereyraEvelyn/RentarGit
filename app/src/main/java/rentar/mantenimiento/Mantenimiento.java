package rentar.mantenimiento;
import java.time.LocalDate;

public class Mantenimiento {    
        private LocalDate fecha;
        private String detalles_mantenimiento;
        
        
        public Mantenimiento(LocalDate fecha, String detalles_mantenimiento) {
            this.fecha = fecha;
            this.detalles_mantenimiento = detalles_mantenimiento;
        }

        

    }
