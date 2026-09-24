import java.util.Scanner;

public class as {
  public static void main() {
    // as1
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    System.out.println("Number of characters a is " + a1(input));
    // as2
    System.out.println("reverse string:");
    a2(input);
    // as3
    System.out.println("a3");
    a3(input);
    // as4
    System.out.println("Is the string a palindrome ? " + a4(input));
    sc.close();
    // as5
    System.out.println("how strong is your password from 0-4");
    System.out.println("password strenght: " + a5(input));
  }

  public static int a1(String s) {
    int l = s.length();
    int res = 0;
    for (int i = 0; i < l; i++) {
      res += (s.charAt(i) == 'a' || s.charAt(i) == 'A') ? 1 : 0;
    }
    return res;
  }

  public static void a2(String s) {
    int l = s.length();
    for (int i = l - 1; i >= 0; i--) {
      System.out.print(s.charAt(i));
    }
    System.out.println();
  }

  public static void a3(String s) {
    int c = 0;
    int v = 0;
    char ch;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      switch (ch) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
          v++;
          break;
        default:
          c++;
          break;
      }
    }
    System.out.println("Number of Vowels is " + v);
    System.out.println("Number of Consonants " + c);
  }

  public static boolean a4(String s) {
    int p1 = 0;
    int p2 = s.length() - 1;
    while (p1 < p2) {
      if (s.charAt(p1) != s.charAt(p2))
        return false;
      p1++;
      p2--;
    }
    return true;
  }

  public static int a5(String s) {
    int res = 0;
    if (s.length() > 5)
      res++;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        res++;
        break;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
        res++;
        break;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        res++;
        break;
      }
    }
    return res;
  }
}
