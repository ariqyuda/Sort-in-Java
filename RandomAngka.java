import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class RandomAngka {
  public static void main(String[] args) {

    long startTime = System.nanoTime();

    int angka;
    int max, min, range, i;
    max = 100;
    min = 0;
    range = max - min + 1;

    try {
      FileWriter myWriter = new FileWriter("random-angka-100.txt");
      for (i=1; i<=1000000; i++){
        angka = (int)(Math.random() * range) + min;
            myWriter.write(angka+"\n");
      }
      
      myWriter.close();
      System.out.println("Successfully wrote number to "+i);

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