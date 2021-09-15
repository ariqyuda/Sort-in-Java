//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.geeksforgeeks.org/merge-sort/ //

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver code
    public static void main(String args[]) {

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
 
        MergeSort ob = new MergeSort();
        ob.sort(dataAngka, 0, dataAngka.length - 1);

        try {
            FileWriter myWriter =new FileWriter("hasil-pengurutan-50000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
            for(int i=0; i<dataAngka.length; i++){  
                    myWriter.write(String.valueOf(dataAngka[i]));
                    myWriter.write("\r\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote the result of merge sort "+k);

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
/* This code is contributed by Rajat Mishra */