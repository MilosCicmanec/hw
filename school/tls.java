import java.util.ArrayList;

public class tls {
  public static void main() {
    // first assignment
    for (int i = 0; i < 21; i++) {
      System.out.print(i + " ");
      System.out.println((double) (i * 9.0 / 5.0) + 32);
    }
    // second assignment
    ArrayList<Integer> grades = new ArrayList<Integer>();
    grades.add(85);
    grades.add(92);
    grades.add(78);
    grades.add(95);
    grades.add(88);
    double res = 0;
    for (int i = 0; i < 5; i++) res+= grades.get(i);
    System.out.println("The average grade is " + (int)(res/5)); 
    for (int i = 0; i < 10; i++) {
      for (int j = 65; j < 65 + i + 1; j++) {
        System.out.print((char)(j) +" ");
      }
      System.out.println();
    }



  }
}
