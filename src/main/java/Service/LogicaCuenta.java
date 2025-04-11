package Service;
import DTO.IGestionSaldo;

import java.util.*;

public class LogicaCuenta {
    private static LogicaCuenta instancia;
    private List<IGestionSaldo> cuentas;

    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }

    public static synchronized LogicaCuenta getInstancia() {
        if (instancia == null) {
            instancia = new LogicaCuenta();
        }
        return instancia;
    }

    public int agregarCuenta(IGestionSaldo cuenta) {
        cuentas.add(cuenta);
        return cuentas.size() - 1;
    }

    public boolean agregarSaldo(int cuentaIndex, double monto) {
        if (cuentaIndex >= 0 && cuentaIndex < cuentas.size()) {
            return cuentas.get(cuentaIndex).agregarSaldo(monto);
        }
        return false;
    }

    public boolean quitarSaldo(int cuentaIndex, double monto) {
        if (cuentaIndex >= 0 && cuentaIndex < cuentas.size()) {
            return cuentas.get(cuentaIndex).quitarSaldo(monto);
        }
        return false;
    }

    public double consultarSaldo(int cuentaIndex) {
        if (cuentaIndex >= 0 && cuentaIndex < cuentas.size()) {
            return cuentas.get(cuentaIndex).getSaldo();
        }
        return -1;
    }
    public int consultarOperaciones(int cuentaIndex) {
        if (cuentaIndex >= 0 && cuentaIndex < cuentas.size()) {
            return cuentas.get(cuentaIndex).getOperaciones();
        }
        return -1;
    }
}
