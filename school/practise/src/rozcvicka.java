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

public class rozcvicka {
  public static void main(String[] args) {
    int[][] a = new int[5][5];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = (int) (Math.random() * 2);
      }
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
    task(a);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void task(int[][] arr) {
    int max_sum = Integer.MIN_VALUE;
    int max_idx = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      if (sum > max_sum) {
        max_sum = sum;
        max_idx = i;
      }
    }
    for (int i = 0; i < arr[0].length; i++) {
      swap(arr, i, max_idx, 0);

    }

  }

  public static void swap(int[][] arr, int i, int a, int b) {
    int tmp = arr[a][i];
    arr[a][i] = arr[b][i];
    arr[b][i] = tmp;
  }

}
