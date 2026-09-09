public class Lhw {
  public static void main() {
    for (int i = 1; i < 21; i++) {
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
    // first assigmnet
    for (int i = 0; i < 11; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
    // second assigmnet
    for (int i = 10; i >= 1; i--) {
      System.out.print(i + " ");
    }
    System.out.println();
    // third assignment
    int n = 100;
    int sum = 0;
    for (int i = 1; i < n + 1; i++) {
      sum += i;
    }
    System.out.println(sum);
  }

}
