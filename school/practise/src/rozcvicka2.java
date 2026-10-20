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

public class rozcvicka2 {
  public static void main(String[] args) {
    int[][] a = new int[4][4];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = (int) (Math.random() * 4);
      }
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a[i].length; j++) {
        swap(a, i, j);
      }
    }
    int tmp = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j * 2 < a[i].length; j++) {
        tmp = a[i][j];
        a[i][j] = a[i][a[i].length - 1 - j];
        a[i][a[i].length - 1 - j] = tmp;
      }
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void swap(int[][] arr, int i, int j) {
    int tmp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = tmp;
  }
}
