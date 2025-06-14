package rentar.vehiculo;
import java.math.BigDecimal;


public class ModeloVehiculo {
    private String modelo;
    private String marca;
    private Integer anio;
    private BigDecimal costo_renta;
    
    public ModeloVehiculo(String modelo, String marca, Integer anio, BigDecimal costo_renta) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.costo_renta = costo_renta;

    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        }
        ModeloVehiculo modelo1 = (ModeloVehiculo) obj;
        return anio.equals(modelo1.anio) && modelo.equals(modelo1.modelo) && marca.equals(modelo1.marca);
        }

    public BigDecimal getCosto_renta() {
        return costo_renta;
    }
    
        

}
