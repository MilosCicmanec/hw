import java.util.Scanner;

public class s {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int res = 0;
    while (num > 0) {
      num = (int) num / 10;
      res++;
    }
    System.out.println("number of digits is " + res);
    sc.close();
  }
}
