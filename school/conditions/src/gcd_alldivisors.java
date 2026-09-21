import java.util.Scanner;

public class a {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("give me a number");
    int num = sc.nextInt();
    System.out.println("Divisors are :");
    for (int i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        System.out.print(i + " ");
        System.out.println(num / i + " ");
      }
    }
    System.out.println("give me 2 numbers");
    num = sc.nextInt();
    int num2 = sc.nextInt();
    while (num != num2) {
      if (num > num2) {
        num -= num2;
      } else {
        num2 -= num;
      }
    }
    System.out.println("gcd is " + num);

    sc.close();
  }
}
