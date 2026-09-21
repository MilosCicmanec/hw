import java.util.Scanner;

public class reversed_right_triangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter triangle size (int) : ");
    int num = sc.nextInt();
    System.out.println();
    int x = 0;
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < x; j++) {
        System.out.print(" ");
      }
      if (i % 2 == 0) {
        for (int j = 0; j < num - x; j++) {
          System.out.print("+");
        }
      } else {
        for (int j = 0; j < num - x; j++) {
          System.out.print("-");
        }
      }
      x++;
      System.out.println();
    }

    sc.close();
  }
}
