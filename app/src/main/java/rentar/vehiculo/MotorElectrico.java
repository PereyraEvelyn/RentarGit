package rentar.vehiculo;

import java.math.BigDecimal;

public interface MotorElectrico {

    default BigDecimal aplicarDescuentoPromocional(BigDecimal costoBase) {
        BigDecimal factorDescuento = new BigDecimal("0.10"); // 10%
        BigDecimal descuento = costoBase.multiply(factorDescuento);
        return costoBase.subtract(descuento);
    }
    
}
