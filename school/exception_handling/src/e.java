import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.*;

public class e {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    try {
      n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        System.out.println("Iteration" + (i + 1));
      }
    } catch (InputMismatchException e) {
      System.out.println("incorrect input");
    } finally {
      sc.close();
    }
  }
}
