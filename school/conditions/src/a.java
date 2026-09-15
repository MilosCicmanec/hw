import java.util.Scanner;

public class a {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // sc is a variable that currently has a scanner object assigned scanner helps
    // us read inputs: integers strings etc.
    System.out.println("how old are you ");
    int age = sc.nextInt();
    if (age > 18) {
      System.out.println("a");
    } else {
      System.out.println("b");
    }
    System.out.println("whats your name ");
    Scanner sc2 = new Scanner(System.in);
    String name = sc2.nextLine();
    if (name.equals("Andreas") || name.equals("Matus")) {
      System.out.println("go away");
    } else if (name.equals("Milos")) {
      System.out.println("amazing");
    } else {
      System.out.println("hello" + " " + name);
    }
  }
}
