//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.geeksforgeeks.org/quick-sort/ //
 
class QuickSort {
     
// A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high) {
        
        // pivot
        int pivot = arr[high];
        
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++) {
            
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
                
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high)
        {
            
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
    
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // Function to print an array
    static void printArray(int[] arr, int size) {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
            
        System.out.println();
    }
    
    // Driver Code
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int k;
        int dataAngka[] = new int[50000]; //besar dari array int dapat dirubah sesuai dengan jumlah bilangan yang akan diurutkan//
        k=0;

            try {
                    File myObj = new File("random-angka-50000.txt"); //nama file dapat disesuaikan dengan file yang ingin diurutkan//
                    Scanner myReader = new Scanner(myObj);

                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        dataAngka[k] = Integer.parseInt(data);
                        k++;
                    }

                    myReader.close();
                  } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }

        int n = dataAngka.length;
        
        quickSort(dataAngka, 0, n - 1);

        try {
            FileWriter myWriter =new FileWriter("hasil-pengurutan-50000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
            for(int i=0; i<dataAngka.length; i++){  
                    myWriter.write(String.valueOf(dataAngka[i]));
                    myWriter.write("\r\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote the result of quick sort "+k);

            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;

            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
            System.out.println(elapsedTimeInSecond + " seconds");
        
    }
}
    
    // This code is contributed by Ayush Choudhary