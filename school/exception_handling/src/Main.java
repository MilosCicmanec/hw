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
    try {
      int[] a = { 1, 2, 3 };
      int divisor = (int) (Math.random() * 4);
      System.out.println(10 / divisor);
    } catch (ArithmeticException e) {
      System.out.println("Cant divide by zero");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Outside of the allowed range");
    } catch (Exception e) {
      System.out.println("Some unknown Exception occured");
    } finally {
      System.out.println("finally");
    }

  }
}
