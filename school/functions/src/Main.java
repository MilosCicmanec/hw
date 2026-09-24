import java.util.Scanner;

public class Main {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter n ");
    int num = sc.nextInt();
    if (a4(num))
      System.out.println("its a palindrom");
    sc.close();
  }

  // palindrome problem
  public static boolean a4(int num) {
    String n = Integer.toString(num);
    int size = n.length();
    for (int i = 0; i * 2 < size; i++) {
      char p1 = n.charAt(i);
      char p2 = n.charAt(size - i - 1);
      if (p1 != p2) {
        return false;
      }
    }
    return true;
  }

  // printing primes from 2 to n
  public static void a8(int n) {
    if (n < 2) {
      return;
    }
    for (int i = 2; i < n + 1; i++) {
      if (a7(i))
        System.out.print(i + " ");
    }
  }

  // euklidian algorithm
  public static int a3(int a, int b) {
    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }
    return a;
  }

  // raising to a power problem
  public static double a2(int num, int power) {
    double n = (double) num;
    double res = n;
    for (int i = 0; i < power; i++) {
      res = res * n;
    }
    return res;
  }

  // printing the biggest of the 3 numbers
  public static int a1(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > c && b > a) {
      return b;
    } else {
      return c;
    }
  }

  // calculating the side of a right angled triangle
  public static double a5(double a, double b) {
    return (a + b) / 2.0;
  }

  public static boolean a7(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
