package empresax.models;

public class Empleado {
    private String documento;
    private String nombreEmpleado;
    private int horasTrabajadas;
    private double valorHora;
    private double sueldo;
    
    public Empleado(){
        this.documento = "";
        this.nombreEmpleado = "No definido";
        this.horasTrabajadas = 0;
        this.valorHora = 0.0;
        this.sueldo = 0.0;
    }

    public Empleado(String documento, String nombreEmpleado, int horasTrabajadas, 
            double valorHora, double sueldo) {
        this.documento = documento;
        this.nombreEmpleado = nombreEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.sueldo = sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getDocumento() {
        return documento;
    }   
    
}
