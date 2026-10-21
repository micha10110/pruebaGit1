package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    // 1. Prueba que ya tenías (Depósito)
    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.depositar(50);
        assertEquals(150, cuenta.obtenerSaldo());
    }

    // 2. Prueba para la funcionalidad de Retiro (si la mantienes)
    @Test
    void retiroExitosoDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }

    // 3. Prueba de Retiro con saldo insuficiente
    @Test
    void retiroConSaldoInsuficienteNoDebeCambiarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(30);
        cuenta.retirar(50);
        assertEquals(30, cuenta.obtenerSaldo()); // El saldo no debe bajar de 30
    }

    // ==========================================
    // NUEVAS PRUEBAS: PAGO DE SERVICIO
    // ==========================================

    // 4. Pago exitoso
    @Test
    void pagoServicioExitosoDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(200);
        boolean resultado = cuenta.pagarServicio("Luz", 50);

        assertTrue(resultado); // Verifica que devuelva true
        assertEquals(150, cuenta.obtenerSaldo()); // Verifica el saldo restante
    }

    // 5. Pago fallido por saldo insuficiente
    @Test
    void pagoServicioConSaldoInsuficienteDebeFallar() {
        CuentaBancaria cuenta = new CuentaBancaria(40);
        boolean resultado = cuenta.pagarServicio("Agua", 50);

        assertFalse(resultado); // Verifica que devuelva false
        assertEquals(40, cuenta.obtenerSaldo()); // El saldo no debe cambiar
    }

    // 6. Pago fallido por monto inválido (negativo)
    @Test
    void pagoServicioConMontoNegativoDebeFallar() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        boolean resultado = cuenta.pagarServicio("Internet", -20);

        assertFalse(resultado);
        assertEquals(100, cuenta.obtenerSaldo());
    }
}