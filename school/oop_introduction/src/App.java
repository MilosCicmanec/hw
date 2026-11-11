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

public class App {
  public static void main(String[] args) {
    Mammal a = new Mammal();
    Dog b = new Dog("husky", 15, "black white");
    Mammal[] m = new Mammal[3];
    m[0] = new Dog();
    m[1] = new Mammal();
    m[2] = new Cat();
    for (Mammal mammal : m) {
      mammal.sound();
    }
  }

}
