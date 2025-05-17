package rentar.cliente;
import java.util.ArrayList;
import java.util.List;


public class Cliente{
    private String dni;
    private String nombre;
    private String email;
    private String telefono;
    private String licenciaConducir;


    
    public Cliente(String dni, String nombre, String licenciaConducir, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.licenciaConducir = licenciaConducir;
        this.email= email;
        this.telefono = telefono;
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
    








}


