public class Main {
  public static void main() {
    int[] numbers = { 51, 30, 42, 13, 8 };
    int[] randomNumbers = new int[20];
    for (int i = 0; i < randomNumbers.length; i++) {
      randomNumbers[i] = i + 1;
    }
    int sum = 0;
    for (int i : randomNumbers) {
      sum += i;
    }
    int maximum = Integer.MIN_VALUE;
    for (int i : randomNumbers)
      if (maximum < i)
        maximum = i;
    int even = 0;
    for (int i : randomNumbers)
      if (i % 2 == 0)
        even++;
    System.out.println(even);
  }
}
