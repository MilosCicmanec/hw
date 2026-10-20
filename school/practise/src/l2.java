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

public class l2 {
  public static void main(String[] args) {
    int[][] a = create_arr();
    System.out.println(Arrays.toString(a));
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    search_arr(a, 2);
    column_sum(a);
    transpose(a);
    students();
    even_odd(a);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void even_odd(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] % 2 == 0) {
          arr[i][j] = 0;
        } else {
          arr[i][j] = 1;
        }
      }
    }

  }

  public static void search_arr(int[][] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == target)
          System.out.println(i + " " + j + " ");
      }
    }
  }

  public static void students() {
    int[][] arr = new int[5][4];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = (int) (Math.random() * 6);
      }
    }
    System.out.println(Arrays.deepToString(arr));
    double avg = 0;
    double sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      avg = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      avg = (double) (sum / arr[i].length);
      System.out.println("The average of student " + i + " " + avg);
    }

  }

  public static void column_sum(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr[0].length; i++) {
      sum = 0;
      for (int j = 0; j < arr.length; j++) {
        sum += arr[j][i];
      }
      System.out.println("column " + i + " " + sum);
    }
  }

  public static void transpose(int[][] arr) {
    int[][] res = new int[3][2];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        res[j][i] = arr[i][j];
      }
    }
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] create_arr() {
    int[][] arr = new int[2][3];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = (int) (Math.random() * 11);
      }
    }
    return arr;
  }

}
