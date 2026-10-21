package unsch;

public class CuentaBancaria {
    private double saldo;
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    public void depositar(double monto) {
        saldo += monto;
    }
    // --- AGREGA ESTO ---
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        }
    }
    public double obtenerSaldo() {
        return saldo;
    }

    // --- NUEVA FUNCIONALIDAD: PAGO DE SERVICIO ---
    public boolean pagarServicio(String nombreServicio, double monto) {
        // Validamos que el monto sea mayor a 0 y que haya saldo suficiente
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Pago exitoso de " + nombreServicio + " por un monto de: " + monto);
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o monto inválido para pagar " + nombreServicio);
            return false;
        }
    }
}


