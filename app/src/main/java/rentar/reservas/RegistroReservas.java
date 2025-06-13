package rentar.reservas; 

import java.util.ArrayList;

public class RegistroReservas {
     private ArrayList<Reserva> reservas;

     public RegistroReservas(){
        this.reservas = new ArrayList<>();
     }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

     public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void eliminarReserva(String codigoReserva){
        Reserva reservaEncontrada = getReserva(codigoReserva);
        reservas.remove(reservaEncontrada);
    }

    public Reserva getReserva(String codigoReserva){
        Reserva reservaEncontrada = null;
        for (Reserva aux : reservas) {
            if (aux.getCodigoReserva().equals(codigoReserva)) {
                reservaEncontrada = aux;
                break;
            }
        }
        if (reservaEncontrada == null) {
            System.out.println("No se encontro la reserva");;
        }    
        return reservaEncontrada;
    }


     public void modificarReserva(Reserva nuevaReserva) {
        Reserva reservaEncontrada;
        reservaEncontrada = getReserva(nuevaReserva.getCodigoReserva());
        reservas.remove(reservaEncontrada); 
        reservas.add(nuevaReserva);               
	}
    
}
   

    

   
    
