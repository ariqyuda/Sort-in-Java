//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.javatpoint.com/bubble-sort-in-java //

public class BubbleSort {  
    public static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
                for (int i=0; i < n; i++){  
                        for (int j=1; j < (n-i); j++){  
                                if (arr[j-1] > arr[j]){  
                                        //swap elements  
                                        temp = arr[j-1];  
                                        arr[j-1] = arr[j];  
                                        arr[j] = temp;  
                        }  
                          
                }  
        }  
  
    }

    public static void main(String[] args) {

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
          
        bubbleSort(dataAngka);//sorting array using selection sort  
         
            try {
                FileWriter myWriter = new FileWriter("hasil-pengurutan-5000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
                for(int i=0; i<dataAngka.length; i++){  
                    myWriter.write(String.valueOf(dataAngka[i]));
                    myWriter.write("\r\n");
                }
        
                myWriter.close();
                System.out.println("Successfully wrote the result of bubble sort "+k);
  
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