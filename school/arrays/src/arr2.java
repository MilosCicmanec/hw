import java.util.Arrays;

public class arr2 {
  public static void main(String[] args) {
    int[] x = { 1, 3, 5, 7 };
    int[] n = { 2, 4, 6 };
    int[] res = sortedMerge(x, n);

    for (int i : res) {
      System.out.println(i);
    }

  }

  public static void stringLenght(String[] strings) {
    for (String string : strings) {
      System.out.print(string.length() + " ");
    }
    System.out.println();
  }

  public static int countWordsInString(String sentence) {
    String[] words = sentence.split(" ");
    return words.length;
  }

  public static int endingA(String[] words) {
    int res = 0;
    for (int i = 0; i < words.length; i++) {
      if (words[i].charAt(words[i].length() - 1) == 'a')
        res++;
    }
    return res;
  }

  public static void printingWords(String sentence) {
    String[] words = sentence.split(" ");

    for (int i = 0; i < words.length; i++) {
      if (i * 2 < words.length)
        System.out.print(words[i] + " ");
      if (i * 2 < words.length && (i + 1) * 2 >= words.length)
        System.out.println();
      if (i * 2 >= words.length)
        System.out.print(words[i] + " ");
    }
    System.out.println();
  }

  public static int[] sortedMerge(int[] a, int[] b) {
    int p1 = 0;
    int p2 = 0;
    int[] c = new int[a.length + b.length];
    while (p1 < a.length && p2 < b.length) {
      if (a[p1] > b[p2]) {
        c[p1 + p2] = b[p2];
        p2++;
      } else {
        c[p1 + p2] = a[p1];
        p1++;
      }
      if (p1 == a.length) {
        while (p2 < b.length) {
          c[p1 + p2] = b[p2];
          p2++;
        }
      } else if (p2 == b.length) {
        while (p1 < a.length) {
          c[p1 + p2] = a[p1];
          p1++;
        }
      }
    }
    return c;
  }
}
