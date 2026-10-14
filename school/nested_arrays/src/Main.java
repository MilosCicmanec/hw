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
    int[][] grades = new int[3][4];
    fill(grades);
    System.out.println(average(grades));
    System.out.println(biggest(grades));
    System.out.println(Arrays.deepToString(grades));
  }

  public static int biggest(int[][] nums) {
    int maximum = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int x : nums[i]) {
        maximum = Math.max(maximum, x);
      }
    }
    return maximum;
  }

  public static double average(int[][] nums) {
    double sum = 0;
    double divisor = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int integer : nums[i]) {
        sum += integer;
        divisor++;
      }
    }
    return sum / divisor;
  }

  public static void fill(int[][] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++) {
        nums[i][j] = (int) (Math.random() * 101);
      }
    }
  }

}
