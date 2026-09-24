import java.util.Scanner;

public class jfp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 1. Temperature Conversion
    System.out.print("Enter temperature in Celsius: ");
    double temp = sc.nextDouble();
    System.out.println("Fahrenheit: " + convert_temperapeture(temp));

    // 2. Integers for single and multi-variable operations
    System.out.print("Enter integer n: ");
    int n = sc.nextInt();

    System.out.print("Enter integer x: ");
    int x = sc.nextInt();

    System.out.print("Enter integer y: ");
    int y = sc.nextInt();

    // 3. Testing all integer-based functions
    System.out.println("Count of multiples of " + x + " up to " + n + ": " + count_multiples(n, x));
    System.out.println("Factorial of " + n + ": " + factorial(n));
    System.out.println("Number of divisors of " + n + ": " + number_of_divisors(n));
    System.out.println("Number with the most divisors up to " + n + ": " + number_with_the_most_divisors(n));
    System.out.println("Alternating sum up to " + n + ": " + alternating_sum(n));
    System.out
        .println("Greatest difference between " + n + ", " + x + ", and " + y + ": " + greates_difference(n, x, y));

    sc.close();
  }

  public static double convert_temperapeture(double degrees) {
    return degrees * 9.0 / 5.0 + 32;
  }

  public static int count_multiples(int n, int x) {
    int res = 0;
    for (int i = 1; i < n + 1; i++) {
      if (i % x == 0) {
        res++;
      }
    }
    return res;
  }

  public static int factorial(int n) {
    int num = Math.abs(n);
    int res = 1;
    for (int i = 1; i < num + 1; i++) {
      res = res * i;
    }
    return res;
  }

  public static int number_of_divisors(int n) {
    int res = 0;
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0 && i * i != n) {
        res++;
        res++;
      } else if (i * i == n) {
        res++;
      }
    }

    return res;
  }

  public static int number_with_the_most_divisors(int n) {
    int bn = 0;
    int nd = 0;
    for (int i = 1; i < n + 1; i++) {
      if (number_of_divisors(i) > nd) {
        nd = number_of_divisors(i);
        bn = i;
      }
    }
    return bn;
  }

  public static int greates_difference(int a, int b, int c) {
    int biggest = Integer.MIN_VALUE;
    if (biggest < a)
      biggest = a;
    if (biggest < b)
      biggest = b;
    if (biggest < c)
      biggest = c;
    int smallest = Integer.MAX_VALUE;
    if (smallest > a)
      smallest = a;
    if (smallest > b)
      smallest = b;
    if (smallest > c)
      smallest = c;
    return biggest - smallest;
  }

  public static int alternating_sum(int n) {
    int res = 0;
    for (int i = 1; i < n + 1; i++) {
      if (i % 2 == 0) {
        res = res - i;
      } else {
        res = res + i;
      }
    }
    return res;
  }
}
