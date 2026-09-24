import java.util.Scanner;

public class gcd_alldivisors {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int res = 0;
    int num = sc.nextInt();
    while (num > 0) {
      res = res + (num % 10);
      num = (int) (num / 10);
    }
    System.out.println(res);
    sc.close();
  }
}
