import java.util.Scanner;

public class chessboards {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean color = true;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (color) {
          System.out.print("B");
        } else {
          System.out.print("W");
        }
        color = !color;
      }
      color = !color;
      System.out.println();
    }
    sc.close();
  }
}
