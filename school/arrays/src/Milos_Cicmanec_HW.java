import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.io.*;

public class Milos_Cicmanec_HW {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    String[] words = { "1", "2", "3", "4" };
    System.out.println("ass 1");
    System.out.println(Arrays.toString(words));
    swap(words, 0, 3);
    System.out.println(Arrays.toString(words));

    System.out.println("ass 2");
    classTestResults(nums);
    System.out.println("ass 3");
    int[] numbers = { 4, 7, 4, 2, 7, 9, 2, 5 };
    uniqueNumbers(numbers);
    int[] week1 = { 18, 20, 17, 22, 19, 21, 16 };
    int[] week2 = { 23, 19, 24, 20, 22, 18, 25 };
    System.out.println("ass 4");
    tempAnalysis(week1, week2);

  }

  // Assigment 1
  public static void swap(String[] words, int a, int b) {
    if (a >= words.length || a < 0 || b >= words.length || b < 0) {
      System.out.println("invalid indexes");
      return;
    }
    String tmp = "";
    tmp = words[a];
    words[a] = words[b];
    words[b] = tmp;
  }

  // Assigment 2
  public static void classTestResults(int[] scores) {
    // 1
    double sum = 0;
    double counter = (double) (scores.length);
    for (int i : scores) {
      sum += (double) (i);
    }
    double avg = sum / counter;
    System.out.println(avg);
    // 2
    Vector<Integer> nums = new Vector<>(5);
    int maximum = -1;
    for (int integer : scores) {
      if (integer >= avg) {
        nums.add(integer);
      }
      if (integer > maximum)
        maximum = integer;
    }
    System.out.println(nums);
    System.out.println(maximum);

  }

  // Assigment 3
  public static void uniqueNumbers(int[] numbers) {
    Vector<Integer> nums = new Vector<>(numbers.length);
    for (int n : numbers) {
      if (!nums.contains(n)) {
        nums.add(n);
      }
    }
    System.out.println(nums);
    System.out.println(numbers.length - nums.size());
    int maximum = -1;
    int target = -1;
    for (Integer integer : nums) {
      if (integer > maximum) {
        target = maximum;
        maximum = integer;

      } else if (integer > target) {
        target = integer;
      }
    }
    System.out.println(target);

  }

  public static void tempAnalysis(int[] first, int[] second) {
    int[] merged = Arrays.copyOf(first, first.length + second.length);
    for (int i = first.length; i < merged.length; i++) {
      merged[i] = second[i - first.length];
    }
    double sum = 0;
    for (int i : merged) {
      sum += i;
    }
    double avg = (double) (sum / merged.length);
    System.out.println(Arrays.toString(merged));
    System.out.println(avg);
    Vector<Double> above = new Vector<>(merged.length);
    for (int n : merged) {
      if (n > avg) {
        above.add((double) (n));
      }
    }

    int max_len = 0;
    int len = 0;
    for (int n : merged) {
      if (n > 20)
        len++;
      if (n <= 20) {
        max_len = Math.max(len, max_len);
        len = 0;
      }
    }
    max_len = Math.max(len, max_len);
    System.out.println(above);
    System.out.println(max_len);

  }

}
