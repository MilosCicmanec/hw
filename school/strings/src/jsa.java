import java.util.Scanner;

public class jsa {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println(a7(sc.nextLine()));

    sc.close();
  }

  public static char[] a1(String s) {
    char[] res = { ' ', ' ' };
    if (s.length() < 2)
      return res;
    char ch1 = s.charAt(0);
    char ch2 = s.charAt(s.length() - 1);
    res[0] = ch1;
    res[1] = ch2;
    return res;
  }

  public static int a2(String s, char c) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c)
        res++;
    }
    return res;
  }

  public static String a7(String s) {
    String[] input = new String[s.length()];
    int idx = 0;
    for (int i = 0; i < input.length; i++) {
      if (s.charAt(i) == ' ') {
        idx++;
      } else {
        if (input[idx] == null)
          input[idx] = "";
        input[idx] = input[idx] + s.charAt(i);
      }
    }
    int res = 0;
    String f = " ";
    String string;
    for (int i = 0; i < idx + 1; i++) {
      string = input[i];
      if (string.length() > res) {
        res = string.length();
        f = string;
      }
    }
    return f + " " + res;
  }

  public static int a8(String s, char c) {
    s = s.toLowerCase();
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c)
        res++;
    }
  }
}
