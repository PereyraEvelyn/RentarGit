package rentar.reservas;
import java.math.BigDecimal;
import java.time.LocalDate;

import rentar.cliente.Cliente;
import rentar.vehiculo.Vehiculo;



public class Seguro implements Extra{
    private String numero_poliza;
    private BigDecimal costo;
    private Cliente ttular;
    private Vehiculo vehiculo;
    private LocalDate fecha_inicio_seg;
    private LocalDate fecha_fin_seg;
    private TipoCobertura cobertura;
    private BigDecimal monto_asegurado;
    


    public enum TipoCobertura {
    TERCEROS_BASICO,        //Cubre daños a terceros.
    TERCEROS_COMPLETO,        // Cubre daños a terceros + robo, incendio parcial, etc.
    TODO_RIESGO_CON_FRANQUICIA, // Cubre todo, pero con un monto que el asegurado paga.
    TODO_RIESGO_SIN_FRANQUICIA, // Cubre todo sin pagar diferencia.
    ROBO_E_INCENDIO,          // Solo cubre si te lo roban o se prende fuego.
    PREMIUM                   // Cubre todo + extras (grúa, cristales, etc.)
    }

    


    public Seguro(String numero_poliza, BigDecimal costo, Cliente ttular, Vehiculo vehiculo, LocalDate fecha_inicio_seg,
            LocalDate fecha_fin_seg, TipoCobertura cobertura, BigDecimal monto_asegurado) {
        this.numero_poliza = numero_poliza;
        this.costo = costo;
        this.ttular = ttular;
        this.vehiculo = vehiculo;
        this.fecha_inicio_seg = fecha_inicio_seg;
        this.fecha_fin_seg = fecha_fin_seg;
        this.cobertura = cobertura;
        this.monto_asegurado = monto_asegurado;
    }



    public String getNumero_poliza() {
        return numero_poliza;
    }



    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }



    public BigDecimal getCosto() {
        return costo;
    }



    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }



    public Cliente getTtular() {
        return ttular;
    }



    public void setTtular(Cliente ttular) {
        this.ttular = ttular;
    }



    public Vehiculo getVehiculo() {
        return vehiculo;
    }



    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }



    public LocalDate getFecha_inicio_seg() {
        return fecha_inicio_seg;
    }



    public void setFecha_inicio_seg(LocalDate fecha_inicio_seg) {
        this.fecha_inicio_seg = fecha_inicio_seg;
    }



    public LocalDate getFecha_fin_seg() {
        return fecha_fin_seg;
    }



    public void setFecha_fin_seg(LocalDate fecha_fin_seg) {
        this.fecha_fin_seg = fecha_fin_seg;
    }



    public TipoCobertura getCobertura() {
        return cobertura;
    }



    public void setCobertura(TipoCobertura cobertura) {
        this.cobertura = cobertura;
    }



    public BigDecimal getMonto_asegurado() {
        return monto_asegurado;
    }



    public void setMonto_asegurado(BigDecimal monto_asegurado) {
        this.monto_asegurado = monto_asegurado;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        } 
        Seguro seg = (Seguro) obj; 
        return numero_poliza.equals(seg.numero_poliza);
    }

}
