import java.util.Scanner;
import java.util.Arrays;

public class tr {
  public static void main(String[] args) {
    int[] a = { 0, 0, 1, 2, 1, 1 };
    System.out.println(Arrays.toString(inPlaceSort(a)));
  }

  public static int[] inPlaceSort(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    int mid = 0;
    while (mid <= high) {
      if (arr[mid] == 0) {
        arr[mid] = arr[low];
        arr[low] = 0;
        low++;
        mid++;
      } else if (arr[mid] == 2) {
        arr[mid] = arr[high];
        arr[high] = 2;
        high--;
      } else {
        mid++;
      }
    }
    return arr;
  }
}
