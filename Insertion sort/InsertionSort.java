//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.javatpoint.com/insertion-sort-in-java //

public class InsertionSort {  
    public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }  
       
    public static void main(String a[]){    
        
        long startTime = System.nanoTime();

        int k;
        int dataAngka[] = new int[5000]; //besar dari array int dapat dirubah sesuai dengan jumlah bilangan yang akan diurutkan//
        k=0;

            try {
                    File myObj = new File("random-angka-5000.txt"); //nama file dapat disesuaikan dengan file yang ingin diurutkan//
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
            
        insertionSort(dataAngka);//sorting array using insertion sort    
           
            try {
                FileWriter myWriter =new FileWriter("hasil-pengurutan-5000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
                for(int i=0; i<dataAngka.length; i++){  
                        myWriter.write(String.valueOf(dataAngka[i]));
                        myWriter.write("\r\n");
                }
    
                myWriter.close();
                System.out.println("Successfully wrote the result of insertion sort "+k);

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