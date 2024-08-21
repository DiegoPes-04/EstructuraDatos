import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SortingAlgorithms 
{
    
    public static void main(String[] args) 
    {
        //Llamado a ordenamiento counting sort
        System.out.println("\nOrdenamiento CountingSort\n"
        +"\nArray sin ordenar");
        System.out.print("[");
        int[] nums = { 4, 2, 1, 4, 1, 4, 2, 1, 10 };
        for (int value: nums) 
        {
            System.out.print(value +  " ");
        }
        System.out.print("]\n");
        System.out.println("Array Ordenado");
        countSort(nums);
        System.out.println(Arrays.toString(nums));

        //Llamado a ordenamiento por bubble sort

        System.out.println("\nOrdenamiento BubbleSort");
        BubbleSort ();

        //Llamado a ordenamiento por merge sort
        System.out.println("\n\nOrdenamiento MergeSort");
        Sorge Sorge = new Sorge();
        int arr [] = {5,26,12,6,1,4,7,-29};
        int n = arr.length;

        System.out.print("Array original:"+
        "\n[");

        for (int value : arr) 
        {
            System.out.print(value + " ");
        }
        System.out.print("]");

        System.out.println();

        System.out.println("Array ordenado:");
        Sorge.sort(arr,0,n-1);

        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " "); 
        }
        System.out.print("]\n");

        //Llamado a ordenamiento por quicksort
        System.out.println("\nOrdenamiento QuickSort\n");
        System.out.println("Vector sin ordenar");
        int numeros [] = {10,9,8,7,28,-2,6,5,4,3,2,1};
        System.out.print("[");
        for (int i = 0; i < numeros.length; i++)
        {
            System.out.print(numeros[i] + "  ");   
        }
        System.out.println("]");

        System.out.println("Vector Ordenado");
        Quicksort(numeros, 0, numeros.length -1);
        ImprimirVector(numeros);
    }
    public static  void BubbleSort ()
    {

        int vec[]={6,4,7,8,3,5,2,1,0,9};
            System.out.print("\nArray sin ordenar: \n");
            System.out.print("[");
            for (int i = 0; i< vec.length; i++) 
            {
                
                System.out.print( +vec[i] +" " ); 
                
            }
            System.out.println("]");

            //ordenamiento
            for (int i = 0; i < vec.length-1; i++) 
            {
                for (int j= 0; j < vec.length-1-i; j++) 
                {
                    if(vec[j] > vec[j+1])
                    {
                        int aux = vec[j];
                        vec[j] = vec [j+1];
                        vec [j+1] = aux;
                    }
                }
            }

            
            System.out.print("Array ordenado: ");
            System.out.print("\n[");
            for (int i = 0; i < vec.length; i++) 
            {
                System.out.print(vec[i] + " ");    
            }
            System.out.print("]");

    }

    //METODOS DE ORDENAMIENTO

    //Ordenamiento Mergesort
    public void sort(int arr[], int left, int right) 
    {
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;
            
            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle+1, right);

            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) 
    {
        //Encuentra el tamaño de los sub-vectores para unirlos.
    int n1 = middle - left + 1;
    int n2 = right - middle;

    //Vectores temporales.
    int leftArray[] = new int [n1];
    int rightArray[] = new int [n2];

    //Copia los datos a los arrays temporales.
    for (int i=0; i < n1; i++) {
        leftArray[i] = arr[left+i];
    }
    for (int j=0; j < n2; j++) {
        rightArray[j] = arr[middle + j + 1];
    }
    /* Une los vectorestemporales. */

    //Índices inicial del primer y segundo sub-vector.
    int i = 0, j = 0;

    //Índice inicial del sub-vector arr[].
    int k = left;

    //Ordenamiento.
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
        } else {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }//Fin del while.

    /* Si quedan elementos por ordenar */
    //Copiar los elementos restantes de leftArray[].
    while (i < n1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }
    //Copiar los elementos restantes de rightArray[].
    while (j < n2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }

    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    //Ordenamiento quicksort
    public static void Quicksort(int numeros[], int izq, int der)
    {
        /*Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor
        Y el ultimo*/
        
        //Se toma como pivote el primer valor
        int pivote = numeros[izq];
            
        //Se definen los dos lados y un auxiliar
        int i = izq; 
        int j = der; 
        int aux;
        
        while(i<j)
        {
            while (numeros[i] <= pivote && i < j) 
            i++;

            while (numeros[j] > pivote) 
            j--;   

            if (i<j) 
            {                                     
                aux = numeros[i];                  
                numeros[i]= numeros[j];
                numeros[j]=aux;
            }
        }

            numeros[izq] = numeros[j]; 
            numeros[j] = pivote;

            if (izq < j-1)
            {
            Quicksort(numeros,izq,j-1);
            }

            if (j+1 < der)
            {
            Quicksort(numeros,j+1,der);
            }

    }
    
    public static void ImprimirVector(int arreglo[])
    {
        System.out.print("[");
        for(int i = 0; i < arreglo.length; i++)
        {
            System.out.print(arreglo[i] + "  ");
        }
        System.out.print("]");
    }

    //Ordenamiento CountingSort
    public static void countSort(int[] nums)
    {
        // crea un `TreeMap` para almacenar la frecuencia de los elementos del array
        Map<Integer, Integer> freq = new TreeMap<>();

        // almacenar valores distintos en la array de entrada como clave y
        // sus respectivos conteos como valores en el `TreeMap`
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // atravesar el mapa (según el orden ordenado de las claves) y
        // sobrescribe la array de entrada con elementos ordenados
        int i = 0;
        for (var entry: freq.entrySet())
        {
            int value = entry.getValue();
            while (value-- > 0) {
                nums[i++] = entry.getKey();
            }
        }
    }
    
}