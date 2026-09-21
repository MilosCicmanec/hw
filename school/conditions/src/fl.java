import java.util.Scanner;

public class fl {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.println("Guess a number ");
    int res = (int) (Math.random() * 100) + 1;
    System.out.println(res);
    int guess = inp.nextInt();
    while (res != guess) {
      System.out.println("Wrong try again.");
      if (guess > 100 || guess < 1)
        System.out.println("Not in range 1-100.");
      if (guess < res) {
        System.out.println("The answer is bigger.");
      } else {
        System.out.println("The answer is smaller");
      }
      guess = inp.nextInt();
    }
    System.out.println("Youd found the number!");

    inp.close();

  }
}
