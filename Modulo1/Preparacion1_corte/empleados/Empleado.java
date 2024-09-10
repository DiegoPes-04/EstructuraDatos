public class Empleado 
{
    private int id;
    private String nombre;
    private float  salarioBase;

    public Empleado (int id, String nombre , float salarioBase)
    {
        this.id = id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public int getId ()
    {
        return id;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public float  getSalarioBase()
    {
        return salarioBase;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public void setSalarioBase (float  salarioBase)
    {
        this.salarioBase = salarioBase;
    }
    
    @Override
    public String toString ()
    {
        return String.format("Id: %d, Nombre: %s, Salario base: %.2f" , id , nombre , salarioBase);
    }
}
