public class fib {
  public static void main() {
    long x, y, z;
    x = 0;
    y = 1;
    z = 0;
    System.out.print(x + " ");
    System.out.print(y + " ");
    for (int i = 0; i < 15; i++) {
      z = x + y;
      x = y;
      y = z;
      System.out.print(z + " ");
    }
    System.out.println();
  }
}
