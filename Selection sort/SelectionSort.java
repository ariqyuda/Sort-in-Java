//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.javatpoint.com/selection-sort-in-java //

public class SelectionSort {  
    public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
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
          
        selectionSort(dataAngka);//sorting array using selection sort  
         
            try {
                FileWriter myWriter = new FileWriter("hasil-pengurutan-5000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
                for(int i=0; i<dataAngka.length; i++){  
                    myWriter.write(String.valueOf(dataAngka[i]));
                    myWriter.write("\r\n");
                }
        
                myWriter.close();
                System.out.println("Successfully wrote the result of selection sort "+k);
  
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