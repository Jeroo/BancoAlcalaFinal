package Models;

public class Usuarios {
    private int pin;
    private String nombre;
    private  String Apellidos;


    public Usuarios(int pin, String nombre, String apellidos) {
        this.pin = pin;
        this.nombre = nombre;
        Apellidos = apellidos;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
}
