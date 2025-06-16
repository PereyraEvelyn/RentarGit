package rentar.vehiculo;

import java.math.BigDecimal;

public interface MotorACombustion {
 default BigDecimal aplicarDescuentoPromocional(BigDecimal costoBase) {
        return costoBase;
    }
}

