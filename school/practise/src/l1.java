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

public class l1 {
  public static void main(String[] args) {
    int[][] a = create_arr();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(sum_arr(a));
    count_nums(a);
    biggest(a);
    row_sum(a);
  }

  public static int[][] create_arr() {
    int[][] arr = new int[3][4];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = (int) (Math.random() * 11 - 6);
      }
    }
    return arr;
  }

  public static int sum_arr(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }

  public static void count_nums(int[][] arr) {
    int pos = 0;
    int zeros = 0;
    int neg = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0) {
          zeros++;
        } else if (arr[i][j] > 0) {
          pos++;
        } else {
          neg++;
        }
      }
    }
    System.out.println("positive " + pos);
    System.out.println("negative " + neg);
    System.out.println("zeros " + zeros);
  }

  public static void biggest(int[][] arr) {
    int maxx = 0;
    int maxy = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] > arr[maxx][maxy]) {
          maxx = i;
          maxy = j;
        }
      }
    }
    System.out.println(maxx + " " + maxy + " " + arr[maxx][maxy]);
  }

  public static void row_sum(int[][] arr) {
    int sum;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      System.out.println("row number " + i + " " + sum);
    }
  }
}
