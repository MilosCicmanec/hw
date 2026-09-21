import java.util.Scanner;

public class wl {
  public static void main(String[] args) {
    System.out.println("Guess a number from 1 to 10");
    Scanner inp = new Scanner(System.in);
    int res = 4;
    int guess = inp.nextInt();
    while (res != guess) {
      if (guess >= 11 || guess <= 0)
        System.out.println("you are out of range");
      System.out.println("Its not " + guess);
      guess = inp.nextInt();
    }
    System.out.println("You guessed it amazing! ");
    inp.close();

  }
}
