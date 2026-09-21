import java.util.Scanner;

public class square {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the square:");
    int size = sc.nextInt();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == 0 || i == size - 1 || j == 0 || j == size - 1 || i == j || j == size - 1 - i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

      }
      System.out.println();
    }
    sc.close();
  }
}
