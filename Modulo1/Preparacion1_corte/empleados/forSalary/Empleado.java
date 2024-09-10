
public class Empleado {
    private int id;
    private String nombre;
    private float salario_Base;

    public Empleado(int id, String nombre, float salario_Base) {
        this.id = id;
        this.nombre = nombre;
        this.salario_Base = salario_Base;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSalario_Base() {
        return salario_Base;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario_Base(float salario_Base) {
        this.salario_Base = salario_Base;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre: %s, Salario base: %.6f", id, nombre, salario_Base);
    }
}
