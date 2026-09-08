public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello World");
    // System.out.println("Something else...");
    // type language
    int a = 5;
    double b = 2.5;
    long aa = 3333333;
    short aaa = 33;
    // operators
    a++;
    a++;
    // System.out.println(a);
    // declaration je iba ze aky ma typ a ze aky ma nazov
    double d = 3.5;
    int result = (int) (a + d);
    // System.out.println(result);
    // System.out.println((double) 5);
    double r = Math.random();
    // System.out.println(r);
    int r2 = (int) (r * 100);
    // System.out.println(r2);
    for (int i = 0; i < 10; i++) {
      System.out.println("Toto je " + i + "ta iteracia.");
    }
  }
}
