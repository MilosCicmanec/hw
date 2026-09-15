public class Main {
  public static void main() {
    int age = 12;
    if (age >= 14) {
      System.out.println("You can watch this movie.");
    } else if (age >= 12) {
      System.out.println("You can watch it but it is not recommended.");
    } else {
      System.out.println("You are not allowed to watch this movie.");
    }
    // formative assesment
    int score = 82;
    if (score > 100) {
      System.out.println("score cant be bigger than 100");
    } else if (score >= 85) {
      System.out.println("grade 7");
    } else if (score >= 70) {
      System.out.println("grade 6");
    } else if (score >= 55) {
      System.out.println("grade 5");
    } else if (score >= 40) {
      System.out.println("grade 4");
    } else if (score >= 25) {
      System.out.println("grade 3");
    } else if (score >= 10) {
      System.out.println("grade 2");
    } else if (score >= 0) {
      System.out.println("grade 1");
    } else {
      System.out.println("the score cant be negative");
    }
    for (int i = -1; i < 102; i++) {
      score = i;
      if (score > 100) {
        System.out.println("score cant be bigger than 100");
      } else if (score >= 85) {
        System.out.println("grade 7");
      } else if (score >= 70) {
        System.out.println("grade 6");
      } else if (score >= 55) {
        System.out.println("grade 5");
      } else if (score >= 40) {
        System.out.println("grade 4");
      } else if (score >= 25) {
        System.out.println("grade 3");
      } else if (score >= 10) {
        System.out.println("grade 2");
      } else if (score >= 0) {
        System.out.println("grade 1");
      } else {
        System.out.println("the score cant be negative");
      }
    }
    int a = 55;
    int b = 34;
    int c = 45;
    if (a > b && a > c) {

      System.out.println(a);
    } else if (b > a && b > c) {
      System.out.println(b);
    } else {
      System.out.println(c);
    }
  }
}
