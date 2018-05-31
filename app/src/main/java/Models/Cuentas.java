package Models;

public class Cuentas {

    double monto;
    int numeroCuenta;
    int pin;


    public Cuentas() {
    }

    public Cuentas(int pin, int numeroCuenta, double monto) {
        this.pin = pin;
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
    }

    public Cuentas(int numeroCuenta, double monto) {
        this.pin = pin;
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
    }


    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
