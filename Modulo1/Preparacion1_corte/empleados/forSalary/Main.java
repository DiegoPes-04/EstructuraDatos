import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Lista de empleados creada directamente en el código
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        // Se crean empleados con datos predefinidos
        empleados.add(new Empleado(102, "Juan", 3000));
        empleados.add(new Empleado(305, "María", 4500));
        empleados.add(new Empleado(150, "Pedro", 3800));
        empleados.add(new Empleado(200, "Ana", 5000));
        empleados.add(new Empleado(99, "Luis", 2900));
        
        // Ordenar empleados por salario usando quicksort
        quicksort(empleados, 0, empleados.size() - 1);

        // Imprimir empleados ordenados por salario
        System.out.println("Personas ingresadas (ordenadas por salario):");
        for (Empleado e : empleados) {
            System.out.println(e);
        }

        // Realizar búsqueda binaria por salario
        float salarioBuscado = 3800;  // Cambia este valor para buscar por otros salarios

        int resultado = busquedaBinaria(empleados, salarioBuscado);
        if (resultado == -1) {
            System.out.println("Empleado con salario " + salarioBuscado + " no encontrado.");
        } else {
            System.out.println("Empleado encontrado: " + empleados.get(resultado));
            System.out.println("Posición del empleado en la lista: " + resultado);
        }
    }

    // Método quicksort que ahora ordena por salario
    public static void quicksort(ArrayList<Empleado> empleados, int low, int high) {
        if (low < high) {
            int pi = partition(empleados, low, high);
            quicksort(empleados, low, pi - 1);
            quicksort(empleados, pi + 1, high);
        }
    }

    // Método de partición para quicksort basado en salario
    public static int partition(ArrayList<Empleado> empleados, int low, int high) {
        float pivot = empleados.get(high).getSalario_Base();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (empleados.get(j).getSalario_Base() < pivot) {
                i++;
                Empleado temp = empleados.get(i);
                empleados.set(i, empleados.get(j));
                empleados.set(j, temp);
            }
        }

        Empleado temp = empleados.get(i + 1);
        empleados.set(i + 1, empleados.get(high));
        empleados.set(high, temp);

        return i + 1;
    }

    // Método de búsqueda binaria por salario
    public static int busquedaBinaria(ArrayList<Empleado> empleados, float salarioBuscado) {
        int low = 0;
        int high = empleados.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Empleado empleado = empleados.get(mid);
            float salarioActual = empleado.getSalario_Base();

            if (salarioActual == salarioBuscado) {
                return mid;  // Retorna el índice donde se encontró el empleado
            } else if (salarioActual < salarioBuscado) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Si no se encuentra el empleado
    }
}

