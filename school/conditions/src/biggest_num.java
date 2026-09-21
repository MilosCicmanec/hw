import java.util.Scanner;

public class biggest_num {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    int m = Integer.MIN_VALUE;
    while (true) {
      n = sc.nextInt();
      if (n < 0)
        break;
      if (n > m)
        m = n;

    }
    System.out.println("Max number: " + m);
    sc.close();
  }
}
