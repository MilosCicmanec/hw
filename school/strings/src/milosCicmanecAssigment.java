import java.util.Scanner;

public class milosCicmanecAssigment {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a sentece");
    System.out.println(a7(sc.nextLine()));

    System.out.println("Enter a word and then a character");
    System.out.println(a8(sc.nextLine(), sc.nextLine().charAt(0)));

    System.out.println("Enter a sentence then a character and then another one");
    System.out.println(a9(sc.nextLine(), sc.nextLine().charAt(0), sc.nextLine().charAt(0)));

    System.out.println("Enter a sentence");
    System.out.println(a10(sc.nextLine()));
    sc.close();

  }

  public static String a7(String sentence) {
    String cur = "";
    String best = "";
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == ' ') {
        if (cur.length() > best.length()) {
          best = cur;
        }
        cur = "";
      } else {
        cur += sentence.charAt(i);
      }

    }
    if (cur.length() > best.length()) {
      best = cur;
    }
    return best + " (" + best.length() + ")";
  }

  public static int a8(String sentence, char c) {
    sentence = sentence.toLowerCase();
    c = Character.toLowerCase(c);
    int res = 0;
    for (int i = 0; i < sentence.length(); i++) {
      res += (sentence.charAt(i) == c) ? 1 : 0;
    }
    return res;
  }

  public static String a9(String sentence, char c, char a) {
    String res = "";
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == c) {
        res += a;
      } else {
        res += sentence.charAt(i);
      }
    }
    return res;
  }

  public static String a10(String sentence) {
    int numberOfspaces = 0;
    int numberOfDigits = 0;
    int numberOfUpper = 0;
    int numberOfVovels = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == ' ')
        numberOfspaces++;
      if (Character.isDigit(sentence.charAt(i)))
        numberOfDigits++;
      if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z')
        numberOfUpper++;
      if (sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e'
          || sentence.charAt(i) == 'i'
          || sentence.charAt(i) == 'o'
          || sentence.charAt(i) == 'u' || sentence.charAt(i) == 'A' || sentence.charAt(i) == 'E'
          || sentence.charAt(i) == 'I'
          || sentence.charAt(i) == 'O'
          || sentence.charAt(i) == 'U')
        numberOfVovels++;
    }
    int numberOfWords = numberOfspaces + 1;
    int numberofcharacters = sentence.length() - numberOfspaces;
    return "Characters " + numberofcharacters + " Words " + numberOfWords + " Vowels " + numberOfVovels + " digits "
        + numberOfDigits + " number of uppercase " + numberOfUpper;
  }
}
