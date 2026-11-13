package Car;

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

public class Person {

  public String name;
  private int age;
  private boolean driversLicense;

  public Person() {
    this.name = "Nameless";
    this.age = 0;
    this.driversLicense = false;
  }

  public Person(String n, int a, boolean driversLicense) {
    this.name = n;
    this.age = a;
    this.driversLicense = driversLicense;
  }

  public int getAge() {
    return this.age;
  }

  public boolean getLicence() {
    return driversLicense;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setLicence(boolean l) {
    this.driversLicense = l;
  }
}
