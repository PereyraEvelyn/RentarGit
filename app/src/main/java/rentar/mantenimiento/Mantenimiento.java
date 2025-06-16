package rentar.mantenimiento;
import java.time.LocalDate;

import rentar.cliente.Cliente;
import rentar.vehiculo.*;
import rentar.vehiculo.Vehiculo.Estado;


public class Mantenimiento {
        private LocalDate fecha_fin_mantenimiento;
        private String detalles_mantenimiento;
        
        
        public Mantenimiento(LocalDate fecha_fin, String detalles_mantenimiento) {
            fecha_fin_mantenimiento = fecha_fin;
            this.detalles_mantenimiento = detalles_mantenimiento;
        }


        

        


        public String getDetalles_mantenimiento() {
            return detalles_mantenimiento;
        }

        public void setFecha_inicio_mantenimiento(LocalDate fecha_fin_mantenimiento) {
            this.fecha_fin_mantenimiento = fecha_fin_mantenimiento;
        }


        public LocalDate getFecha_fin_mantenimiento() {
            return fecha_fin_mantenimiento;
        }


        public void setFecha_fin_mantenimiento(LocalDate fecha_fin_mantenimiento) {
            this.fecha_fin_mantenimiento = fecha_fin_mantenimiento;
        }


        @Override
        public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        } 
        Mantenimiento mantenimiento = (Mantenimiento) obj; 
        return fecha_fin_mantenimiento.equals(mantenimiento.fecha_fin_mantenimiento);
        }
        
        
        
        

        

    }
