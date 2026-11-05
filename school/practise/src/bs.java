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

public class bs {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
    Vector<Integer> b = new Vector<>(10);
    for (int i = 0; i < 10; i++) {
      b.add(i + 1);
    }
    System.out.println(bs_arr(a, 2));
    System.out.println(bs_vec(b, 2));
  }

  public static int bs_arr(int[] arr, int target) {
    int l, h, m;
    l = 0;
    h = arr.length - 1;
    while (l < h) {
      m = (int) ((l + h) / 2);
      if (arr[m] == target)
        return m;
      if (arr[m] > target)
        h = m;
      if (arr[m] < target)
        l = m;
    }
    return -1;
  }

  public static int bs_vec(Vector<Integer> vec, int target) {
    int l, h, m;
    l = 0;
    h = vec.size() - 1;
    while (l < h) {
      m = (int) ((l + h) / 2);
      if (vec.elementAt(m) == target)
        return m;
      if (vec.elementAt(m) > target)
        h = m;
      if (vec.elementAt(m) < target)
        l = m;
    }
    return -1;

  }
}
