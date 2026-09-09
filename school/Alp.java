public class Alp {
  public static void main() {
    // char c = 'a';
    // System.out.println(c);
    char c2 = 'b';
    // System.out.println(c + c2);
    for (char c = 'a'; c <= 'z'; c++) {
      System.out.println(c);
    }
    System.out.println((int) (85));
    for (char c = 'Z'; c > 'A'; c--) {
      System.out.println(c);
    }
    for (int i = 90; i >= 65; i--) {
      System.out.println((char) (i));
    }
    System.out.println();
    System.out.println();
    for (int i = 65; i < 91; i++) {
      if (i % 2 == 0) {
        System.out.print((char) (i) + " ");
      }
    }
    System.out.println();

    for (int i = 1; i < 11; i++) {
      System.out.print(i * i + " ");
    }
    System.out.println();
    int res = 1;
    for (int i = 0; i < 11; i++) {
      System.out.print(res + " ");
      res *= 2;
    }
    System.out.println();

  }
}
