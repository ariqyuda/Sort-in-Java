//Nama : Ariq Yuda Pratama //
//NIM  : 1908107010029 //

import java.io.*;
import java.util.*;

//Source code: https://www.geeksforgeeks.org/shellsort/ //

class ShellSort {
	/* An utility function to print array of size n*/
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* function to sort arr using shellSort */
	int sort(int arr[]) {
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	// Driver method
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

		ShellSort ob = new ShellSort();
		ob.sort(dataAngka);
        
        try {
            FileWriter myWriter =new FileWriter("hasil-pengurutan-50000-angka.txt"); //nama file disamping dapat disesuaikan dengan nam file tempat hasil pengurutan//
            for(int i=0; i<dataAngka.length; i++){  
                    myWriter.write(String.valueOf(dataAngka[i]));
                    myWriter.write("\r\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote the result of shell sort "+k);

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
/*This code is contributed by Rajat Mishra */
