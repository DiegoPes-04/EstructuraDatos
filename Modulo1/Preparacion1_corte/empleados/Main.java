import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner (System.in);

        ArrayList<Empleado> empleados = new ArrayList<>();
        
        //Se define cuantas persona va a ingresar el usuario

        System.out.println("¿Cuantas personas ingresara?");
        int numPersonas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPersonas ; i++)
        {
            System.out.println("Ingresando datos de la persona #" + (i+1));

            System.out.println("Id de la persona");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nombre de la persona");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el salario base");
            float salarioBase = scanner.nextFloat();

            Empleado nuevoEmpleado = new Empleado(id, nombre, salarioBase);
            empleados.add(nuevoEmpleado);
            

        }

        // Ordenar empleados por ID usando quicksort
        quicksort(empleados, 0, empleados.size() - 1);

        System.out.println("Persona ingresadas: ");
        for (Empleado e : empleados) 
        {
            System.out.println(e);    
        }

         // Búsqueda binaria
        System.out.println("Ingrese el Id del empleado que desea buscar:");
        int idBuscado = scanner.nextInt();

        int resultado = busquedaBinaria(empleados, idBuscado);
        if (resultado == -1)
        {
            System.out.println("Empleado con Id " + idBuscado + " no encontrado.");
        } else
        {
            System.out.println("Empleado encontrado: " + empleados.get(resultado));
        }

        scanner.close();
    }

      // Método quicksort
    public static void quicksort(ArrayList<Empleado> empleados, int low, int high) {
        if (low < high) {
            int pi = partition(empleados, low, high);
            quicksort(empleados, low, pi - 1);  // Recursivamente ordenar antes de la partición
            quicksort(empleados, pi + 1, high); // Recursivamente ordenar después de la partición
        }
    }

    // Método de partición para quicksort
    public static int partition(ArrayList<Empleado> empleados, int low, int high) {
        int pivot = empleados.get(high).getId(); // Elegimos el último elemento como pivote
        int i = (low - 1); // Índice de los elementos más pequeños que el pivote

        for (int j = low; j < high; j++) {
            if (empleados.get(j).getId() < pivot) {
                i++;
                // Intercambiamos empleados.get(i) y empleados.get(j)
                Empleado temp = empleados.get(i);
                empleados.set(i, empleados.get(j));
                empleados.set(j, temp);
            }
        }

        // Intercambiar el pivote con el elemento en i+1
        Empleado temp = empleados.get(i + 1);
        empleados.set(i + 1, empleados.get(high));
        empleados.set(high, temp);

        return i + 1; // Retornar el índice de la partición
    }

    // Método de búsqueda binaria
    public static int busquedaBinaria(ArrayList<Empleado> empleados, int idBuscado) {
        int low = 0;
        int high = empleados.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Empleado empleado = empleados.get(mid);
            int idActual = empleado.getId();

            if (idActual == idBuscado) {
                return mid;
            } else if (idActual < idBuscado) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Si no se encuentra el empleado
    }
    
}
