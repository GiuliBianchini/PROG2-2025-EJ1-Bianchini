package Service;

import DTO.CajaDeAhorro;
import DTO.CuentaCorriente;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        LogicaCuenta logica = LogicaCuenta.getInstancia();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            if (random.nextBoolean()) {
                logica.agregarCuenta(new CajaDeAhorro(100));
            } else {
                logica.agregarCuenta(new CuentaCorriente(100, 50));
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10_000; i++) {
            executor.execute(() -> {
                int cuentaId;
                double monto;
                boolean agregar;

                synchronized (random) {
                    cuentaId = random.nextInt(10); // Entre 0 y 9
                    monto = random.nextDouble() * 100; // Entre 0.0 y 100.0
                    agregar = random.nextBoolean(); // true = agregar, false = quitar
                }

                if (agregar) {
                    logica.agregarSaldo(cuentaId, monto);
                } else {
                    logica.quitarSaldo(cuentaId, monto);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Resultados");
        for (int i = 0; i < 10; i++) {
            double saldo = logica.consultarSaldo(i);
            int operaciones = logica.consultarOperaciones(i);
            System.out.printf("Cuenta #%d -> Saldo: %.2f | Operaciones: %d\n", i, saldo, operaciones);
        }
    }
}
