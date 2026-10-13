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

public class Main {
  public static void main(String[] args) {
    Vector<Integer> nums = new Vector<>(5);
    nums.add(5);
    nums.add(4);
    nums.add(3);
    nums.add(2);
    nums.add(1);
    selecion_sort(nums);
    System.out.println(nums);
  }

  public static void bubble_sort(Vector<Integer> numbers) {
    boolean not_sorted = true;
    int tmp;
    while (not_sorted) {
      not_sorted = false;
      for (int i = 0; i < numbers.size() - 1; i++) {
        if (numbers.elementAt(i) > numbers.elementAt(i + 1)) {
          tmp = numbers.elementAt(i);
          numbers.set(i, numbers.elementAt(i + 1));
          numbers.set(i + 1, tmp);
          not_sorted = true;
        }
      }
    }
  }

  public static void swap(Vector<Integer> numbers, int a, int b) {
    int tmp = numbers.elementAt(a);
    numbers.set(a, numbers.elementAt(b));
    numbers.set(b, tmp);
  }

  public static void selecion_sort(Vector<Integer> numbers) {
    int min = 0;
    for (int i = 0; i < numbers.size(); i++) {
      min = i;
      for (int j = i + 1; j < numbers.size(); j++) {
        if (numbers.elementAt(j) < numbers.elementAt(min))
          min = j;
      }
      swap(numbers, i, min);
    }
  }
}
