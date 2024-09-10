import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Lista de empleados creada directamente en el código
        ArrayList<Empleadito> empleados = new ArrayList<>();
        
        // Se crean empleados con datos predefinidos
        empleados.add(new Empleadito(102, "Juan", 3000));
        empleados.add(new Empleadito(305, "María", 4500));
        empleados.add(new Empleadito(150, "Pedro", 3800));
        empleados.add(new Empleadito(200, "Ana", 5000));
        empleados.add(new Empleadito(99, "Luis", 2900));
        
        // Ordenar empleados por ID usando quicksort
        quicksort(empleados, 0, empleados.size() - 1);

        // Imprimir empleados ordenados
        System.out.println("Personas ingresadas (ordenadas por Id):");
        for (Empleadito e : empleados) {
            System.out.println(e);
        }

        // Realizar búsqueda binaria
        int idBuscado = 150;  // Cambia este valor para buscar otros empleados

        int resultado = busquedaBinaria(empleados, idBuscado);
        if (resultado == -1) {
            System.out.println("Empleado con Id " + idBuscado + " no encontrado.");
        } else {
            System.out.println("Empleado encontrado: " + empleados.get(resultado));
            System.out.println("Posición del empleado en la lista: " + resultado);
        }
    }

    // Método quicksort
    public static void quicksort(ArrayList<Empleadito> empleados, int low, int high) {
        if (low < high) {
            int pi = partition(empleados, low, high);
            quicksort(empleados, low, pi - 1);
            quicksort(empleados, pi + 1, high);
        }
    }

    // Método de partición para quicksort
    public static int partition(ArrayList<Empleadito> empleados, int low, int high) {
        int pivot = empleados.get(high).getId();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (empleados.get(j).getId() < pivot) {
                i++;
                Empleadito temp = empleados.get(i);
                empleados.set(i, empleados.get(j));
                empleados.set(j, temp);
            }
        }

        Empleadito temp = empleados.get(i + 1);
        empleados.set(i + 1, empleados.get(high));
        empleados.set(high, temp);

        return i + 1;
    }

    // Método de búsqueda binaria
    public static int busquedaBinaria(ArrayList<Empleadito> empleados, int idBuscado) {
        int low = 0;
        int high = empleados.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Empleadito empleado = empleados.get(mid);
            int idActual = empleado.getId();

            if (idActual == idBuscado) {
                return mid;  // Retorna el índice donde se encontró el empleado
            } else if (idActual < idBuscado) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Si no se encuentra el empleado
    }
}
