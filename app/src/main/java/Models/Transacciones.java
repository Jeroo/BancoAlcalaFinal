package Models;

public class Transacciones {

    private int transaccionTipoId;
    private int cuentaorigen;
    private  int cuentadestino;
    private double montotransaccion;

    public Transacciones(int transaccionTipoId, int cuentaorigen, int cuentadestino, double montotransaccion) {
        this.transaccionTipoId = transaccionTipoId;
        this.cuentaorigen = cuentaorigen;
        this.cuentadestino = cuentadestino;
        this.montotransaccion = montotransaccion;
    }

    public int getTransaccionTipoId() {
        return transaccionTipoId;
    }

    public void setTransaccionTipoId(int transaccionTipoId) {
        this.transaccionTipoId = transaccionTipoId;
    }

    public int getCuentaorigen() {
        return cuentaorigen;
    }

    public void setCuentaorigen(int cuentaorigen) {
        this.cuentaorigen = cuentaorigen;
    }

    public int getCuentadestino() {
        return cuentadestino;
    }

    public void setCuentadestino(int cuentadestino) {
        this.cuentadestino = cuentadestino;
    }

    public double getMontotransaccion() {
        return montotransaccion;
    }

    public void setMontotransaccion(double montotransaccion) {
        this.montotransaccion = montotransaccion;
    }
}
