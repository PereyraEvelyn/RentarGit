package rentar.mantenimiento;
import java.util.ArrayList;
import java.time.LocalDate;

public class GestorMantenimiento {
    private ArrayList<Mantenimiento> mantenimientos;

    public GestorMantenimiento() {
        setMantenimientos(new ArrayList<Mantenimiento>());
    }

    public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public void agregarMantenimiento(Mantenimiento mantenimiento){
        this.mantenimientos.add(mantenimiento);
    }

    public void eliminarMantenimiento(LocalDate fecha){
        Mantenimiento mantenimientoEncontrado = getMantenimiento(fecha);
        this.mantenimientos.remove(mantenimientoEncontrado);
    }

    public void modificarMantenimiento(Mantenimiento nuevoMantenimiento){
        Mantenimiento mantenimientoEncontrado;
        mantenimientoEncontrado = getMantenimiento(nuevoMantenimiento.getFecha());
        mantenimientos.remove(mantenimientoEncontrado); 
        mantenimientos.add(nuevoMantenimiento);             
	}


    public Mantenimiento getMantenimiento(LocalDate fecha){
        Mantenimiento mantenimientoEncontrado = null;
        for (Mantenimiento var : mantenimientos) {
            if (var.getFecha().equals(fecha)) {
                mantenimientoEncontrado = var;
                break;
            }
        }
        return mantenimientoEncontrado;
    }
    //faltan datos jaja
    public void mostrarMantenimientos(){
        for(Mantenimiento var : mantenimientos){
            System.out.println(var.getDetalles_mantenimiento());
        }
    }

}
