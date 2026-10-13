import java.util.Scanner;

public class Main {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int res = 0;
    boolean b = false;
    while (num > 0) {
      if (b) {
        res += num % 10;
        b = false;
      } else {
        b = true;
      }
      num = (int) (num / 10);
    }
    System.out.println(res);
    sc.close();

  }
}
