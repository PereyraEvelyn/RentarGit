package rentar.cliente;

import rentar.reservas.RegistroReservas;

public class Cliente{
    private String dni;
    private String nombre;
    private String email;
    private String telefono;
    private String licenciaConducir;
    private RegistroReservas reservas;


    
    public Cliente(String dni, String nombre, String licenciaConducir, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.licenciaConducir = licenciaConducir;
        this.email= email;
        this.telefono = telefono;
        this.reservas = new RegistroReservas();
        }
        

    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        } 
        Cliente cliente1 = (Cliente) obj; 
        return dni.equals(cliente1.dni); //Compara por el dni
    }


    public String getDni() {
        return dni;
    }


    public String getNombre() {
        return nombre;
    }


    public String getEmail() {
        return email;
    }


    public String getTelefono() {
        return telefono;
    }


    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public RegistroReservas getReservas() {
        return reservas;
    }

}


