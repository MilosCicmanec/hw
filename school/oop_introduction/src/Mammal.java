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

public class Mammal {
  // private access modifier means the variables are
  // directly accessible only from this class
  private int age, weight;
  private boolean sex;
  String name;

  public Mammal() {
    age = 0;
    weight = (int) (Math.random() * 5);
    name = "Nameless";
    sex = Math.random() > 0.512;
  }

  // Constructor(method) overload
  public Mammal(int age, int weight, boolean sex, String name) {
    this.age = age;
    this.weight = weight;
    this.sex = sex;
    this.name = name;
  }

  public void sound() {
    System.out.println("Mammal sound");
  }

  public void movement() {
    System.out.println("Mammal movement");
  }

  // SETTERS (MODIFIERS)
  public void setAge(int age) {
    this.age = age;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  // GETTERS (ACCESSORS)
  public int getAge() {
    return age;
  }

  public int getWeight(String pass) {
    if (pass.equals("1234"))
      return weight;
    System.out.println("Invalid password");
    return -1; // Return -1 if the password is incorrect
  }

  public boolean getSex() {
    return sex;
  }
}
