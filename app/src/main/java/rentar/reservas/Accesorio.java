package rentar.reservas;
import java.math.BigDecimal;


public class Accesorio implements ConceptoExtra{
    private String nombre_accesorio;
    private String descripcion_accessorio;
    private BigDecimal costo_accesorio;

    public Accesorio(String nombre, String descripcion, BigDecimal costo){
        nombre_accesorio = nombre;
        descripcion_accessorio = descripcion;
        costo_accesorio = costo;
    }

    public void setNombre_accesorio(String nombre_accesorio) {
        this.nombre_accesorio = nombre_accesorio;
    }

    public void setDescripcion_accessorio(String descripcion_accessorio) {
        this.descripcion_accessorio = descripcion_accessorio;
    }

    public void setCosto_accesorio(BigDecimal costo_accesorio) {
        this.costo_accesorio = costo_accesorio;
    }

    public String getNombre_accesorio() {
        return nombre_accesorio;
    }

    public String getDescripcion_accessorio() {
        return descripcion_accessorio;
    }

     @Override
    public BigDecimal getCosto() {
        return this.costo_accesorio;
    }

    @Override
        public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        } 
        Accesorio accesorio = (Accesorio) obj; 
        return nombre_accesorio.equals(accesorio.nombre_accesorio) && descripcion_accessorio.equals(accesorio.descripcion_accessorio) && costo_accesorio.equals(accesorio.costo_accesorio);
        }
}
