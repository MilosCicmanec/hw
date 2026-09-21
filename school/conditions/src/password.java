import java.util.Scanner;

public class p {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pas = "ssk23";
    String input;
    for (int i = 0; i < 3; i++) {
      System.out.println("[input password]");

      input = sc.nextLine();
      if (input.equals(pas)) {
        System.out.println("correct pasword");
        break;
      } else {
        System.out.println("incorrect password");
      }
    }
    sc.close();
  }
}
