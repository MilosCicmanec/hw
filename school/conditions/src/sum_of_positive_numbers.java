import java.util.Scanner;

public class sum_of_positive_numbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    int res = 0;
    int m = 0;
    while (true) {
      n = sc.nextInt();

      if (n < 0)
        break;
      m++;
      res += n;
    }
    System.out.println("The sum is: " + res);
    double sum = (double) res;
    double x = (double) m;

    System.out.println("The average number is " + (sum / x));
    sc.close();
  }
}
