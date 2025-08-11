public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
    }

    public void depositar(double disponible) {
        if (disponible > 0) {
            saldo += disponible;
            System.out.println("Depósito realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    public void retirar(double disponible) {
        if (disponible > 0 && disponible <= saldo) {
            saldo -= disponible;
            System.out.println("Retiro realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("Monto inválido o saldo insuficiente.");
        }
    }

    public void transferir(CuentaBancaria destino, double disponible) {
        if (disponible > 0 && disponible <= saldo) {
            this.saldo -= disponible;
            destino.saldo += disponible;
            System.out.println("Transferencia realizada a " + destino.titular + ". Saldo actual: $" + saldo);
        } else {
            System.out.println("Monto inválido o saldo insuficiente para transferencia.");
        }
    }


    public static void main(String[] args) {

        CuentaBancaria cuenta1 = new CuentaBancaria("Maiki", "24525", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Lisandro", "252351", 500);


        cuenta1.mostrarDatos();
        System.out.println();
        cuenta2.mostrarDatos();

        System.out.println("\n[Movimientos]");
        cuenta1.depositar(1000000000);
        cuenta1.retirar(150);
        cuenta1.transferir(cuenta2, 1000);

        System.out.println("\n[Estado final]");
        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();
    }
}