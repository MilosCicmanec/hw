import java.util.Arrays;
import java.util.Scanner;

public class pr {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] n = { 1, 2, 3, 4, 5 };
    System.out.println(Arrays.toString(doubler(n)));

    sc.close();
  }

  public static int[] doubler(int[] original) {
    int[] result = Arrays.copyOf(original, original.length * 2);
    for (int i = 0; i < original.length; i++) {
      result[i + original.length] = result[i] * 2;
    }
    return result;
  }

  public static int[] appendToArr(int[] original, int value) {
    int[] result = Arrays.copyOf(original, original.length + 1);
    result[result.length - 1] = value;
    return result;
  }

}
