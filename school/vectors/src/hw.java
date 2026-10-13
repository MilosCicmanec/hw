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

public class hw {
  public static void main(String[] args) {

  }

  public static void swap(String[] words, int a, int b) {
    if (a >= words.length || a < 0 || b >= words.length || b < 0)
      System.out.println("invalid indexes");
    String tmp;
    tmp = words[a];
    words[a] = words[b];
    words[b] = tmp;
  }

  public static double average_score(int[] scores) {
    double res = 0;
    for (int i : scores) {
      res += (double) i;
    }
    double divisors = (double) scores.length;
    return res / divisors;
  }
}
