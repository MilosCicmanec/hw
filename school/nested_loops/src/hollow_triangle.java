import java.util.Scanner;

public class hollow_triangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter triangle size (int) : ");
    int num = sc.nextInt();

    if (num >= 1) {
      System.out.println("*");
    }

    int x = 0;
    for (int i = 0; i < num - 2; i++) {
      System.out.print("*");
      for (int j = 0; j < x; j++) {
        System.out.print(" ");
      }
      System.out.print("*");
      System.out.println();
      x++;
    }

    if (num > 1) {
      for (int i = 0; i < num; i++) {
        System.out.print("*");
      }
      System.out.println();
    }
    sc.close();
  }
}
