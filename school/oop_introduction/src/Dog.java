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

public class Dog extends Mammal {
  public String breed;
  public int legth;
  public String furColour;

  public Dog(String breed, int legth, String furColour) {
    super(); // calls a parent/super class (Mammal) constructor
    this.breed = breed;
    this.legth = legth;
    this.furColour = furColour;
  }

  public Dog(int age, int weight, String name, String breed, int l, int furColour) {
    super(age, weight, Math.random() > 0.5, name);
  }

  public Dog() {
    super();
    this.breed = "";
    this.legth = (int) (Math.random() * 20);
    this.furColour = "brown";
  }
}
