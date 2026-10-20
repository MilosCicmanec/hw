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

public class l3 {
  public static void main(String[] args) {
    int[][] a = create_arr();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(Arrays.toString(main_diag(a)));
    System.out.println(magic_square(a));
    int[][] b = new int[5][6];
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        b[i][j] = (int) (Math.random() * 2);
      }
    }
    cinema(b);
    int[][] m1 = { { 5, 7, 3 }, { 2, 1, 4 } };
    int[][] m2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    matrix_mul(m1, m2);
  }

  public static void cinema(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    if (n >= arr.length || n < 0)
      return;
    if (m >= arr[n].length || m < 0)
      return;

    if (arr[n][m] != 1) {
      arr[n][m] = 1;
      System.out.println("seat resserved");
    } else {
      System.out.println("seat full");
    }

    sc.close();
  }

  public static int[] main_diag(int[][] arr) {
    int[] res = new int[2];
    res[0] = 0;
    res[1] = 0;
    for (int i = 0; i < arr.length; i++) {
      res[0] = res[0] + arr[i][i];
    }
    for (int i = 0; i < arr.length; i++) {
      res[1] = res[1] + arr[i][arr.length - 1 - i];
    }
    return res;
  }

  public static int[][] create_arr() {
    int[][] arr = new int[3][3];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = (int) (Math.random() * 11);
      }
    }
    return arr;
  }

  public static boolean magic_square(int[][] arr) {
    int[] diag = main_diag(arr);
    if (diag[0] != diag[1])
      return false;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = 0;
      for (int j = 0; j < arr[i].length; j++) {
        sum += arr[i][j];
      }
      if (sum != diag[0])
        return false;
    }
    for (int i = 0; i < arr[0].length; i++) {
      sum = 0;
      for (int j = 0; j < arr.length; j++) {
        sum += arr[j][i];
      }
      if (sum != diag[0])
        return false;
    }
    return true;
  }

  public static void living_dead(int[][] arr) {
    int[][] res = new int[5][5];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sum = 0;
        if (j > 0 && arr[i][j - 1] == 1) {
          sum++;
        }
        if (j < arr[i].length - 1 && arr[i][j + 1] == 1) {
          sum++;
        }
        if (i > 0 && arr[i - 1][j] == 1) {
          sum++;
        }
        if (i < arr.length - 1 && arr[i + 1][j] == 1) {
          sum++;
        }
        if (arr[i][j] == 0) {
          if (sum == 3) {
            res[i][j] = 1;
          } else {
            res[i][j] = 0;
          }
        } else {
          if (sum == 3 || sum == 2) {
            res[i][j] = 1;
          } else {
            res[i][j] = 0;
          }
        }

      }
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void transposition(int[][] arr) {
    int[][] res = new int[arr[0].length][arr.length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
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

  public static void matrix_mul(int[][] a, int[][] b) {
    int[][] res = new int[2][2];
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[0].length; j++) {
        res[i][j] = 0;
      }
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++)
          res[i][j] += a[i][k] * b[k][j];
      }
    }
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}
