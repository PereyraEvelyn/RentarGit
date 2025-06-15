package rentar.mantenimiento;
import java.time.LocalDate;

import rentar.cliente.Cliente;
import rentar.vehiculo.*;
import rentar.vehiculo.Vehiculo.Estado;


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

        public Vehiculo getVehiculo(){
            return vehiculo;
        }


        public String getDetalles_mantenimiento() {
            return detalles_mantenimiento;
        }

        public void mantenimientoAuto() {
            vehiculo.setEstado(Estado.EnMantenimiento);
        }

        public void finMantenimiento(){
            vehiculo.setEstado(Estado.Disponible);
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
        return fecha.equals(mantenimiento.fecha) && vehiculo.equals(mantenimiento.vehiculo);
        }
        
        
        
        

        

    }
