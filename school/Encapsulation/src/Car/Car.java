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

public class Car {
  Engine engine;
  public String manufacturer;
  public int seats;
  public int current_speed;
  int max_speed;

  private Person[] passengers;
  private Person driver = null;

  public Car() {
  }

  public Car(String m, int s) {
    manufacturer = m;
    seats = s;
    current_speed = 0;
    max_speed = 100;
    passengers = new Person[seats - 1];

  }
  public Car(int c, Engine.FuelType f, int v, int hp, String m, int s) {
    engine = new Engine(v, c, f, hp);
    manufacturer = m;
    seats = s;
    current_speed = 0;
    max_speed = 150;
    passengers = new Person[seats - 1];

  }

  public boolean legalState(Person p) {
    if (p == null) {
      return true;
    } else {
      return p.getLicence();
    }
  }

  public Person getDriver() {
    return this.driver;
  }

  public void start() {
    if (driver != null) {
      engine.start();
      System.out.println("Car started");
    } else {
      System.out.println("There is no driver");
    }
  }

  public int numberOfPassengers() {
    int n = 0;
    for (Person p : passengers) {
      if (p != null)
        n++;
    }
    if (driver == null)
      return n;
    return n + 1;
  }

  public void setDriver(Person d) {
    this.driver = d;
  }

  public void passengerIn(Person p) {
    for (int i = 0; i < passengers.length; i++) {
      if (passengers[i] == null) {
        passengers[i] = p;
        return;
      }
    }
    System.out.println("No place found");
  }

  public void passengerOut(int idx) {
    passengers[idx] = null;
  }

  public void stop() {
    engine.stop();
    System.out.println("Car stopped");
  }

  public void accelerate(int diff) {
    engine.acceleration();
    if (engine.started) {
      current_speed += diff;
    }
  }
}

class Engine {
  double volume;
  int cyllinders;

  static enum FuelType {
    DIESEL, PETROL, ELECTRIC
  }

  FuelType ft;
  int horsePower;
  boolean started;

  Engine() {
    volume = 1.5;
    cyllinders = 4;
    ft = FuelType.PETROL;
    horsePower = 150;
    started = false;
  }

  Engine(double v, int c, FuelType f, int hp) {
    this.volume = v;
    this.cyllinders = c;
    this.ft = f;
    this.horsePower = hp;
    started = false;
  }

  void start() {
    if (started) {
      System.out.println("Engine is already running");
    } else {
      System.out.println("Engine is running");
    }
  }

  void stop() {
    if (!started) {
      System.out.println("Engine is already stopped");
    } else {
      System.out.println("Engine stopped");
    }
  }

  void acceleration() {
    if (!started) {
      System.out.println("The car is turned off");
    } else {
      System.out.println("Car accelerates");
    }
  }

}
