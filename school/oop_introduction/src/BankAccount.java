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

public class BankAccount {
  String accountNumber, name;
  private String password;
  private double balance;

  public BankAccount() {
    this.accountNumber = "0";
    this.name = "Nameless";
    this.password = "1234";
    this.balance = 0;
  }

  public BankAccount(String an, String n, String p, double b) {
    this.accountNumber = an;
    this.name = n;
    this.password = p;
    this.balance = b;
  }

  public void deposit(String pass, double amount) {
    if (amount < 0) {
      System.out.println("invalid amount");
      return;
    }
    if (pass.equals(this.password)) {
      this.balance += amount;
      System.out.println("New balance is " + this.balance);
      return;
    }
    System.out.println("Wrong password");
  }

  public void withdrawal(String pass, double amount) {
    if (amount < 0) {
      System.out.println("invalid amount");
      return;
    }
    if (pass.equals(this.password)) {
      if (this.balance >= amount) {
        this.balance -= amount;
        System.out.println("New balance is " + this.balance);
        return;
      } else {
        System.out.println("Insufficient balance");
        return;
      }
    }
    System.out.println("Wrong password");
  }

  public double getBalance(String pass) {
    if (pass.equals(this.password)) {
      return this.balance;
    }
    System.out.println("Wrong password");
    return -1.0;
  }

  public void transfer(String pass, BankAccount other, double amount) {
    if (amount < 0) {
      System.out.println("invalid amount");
      return;
    }
    if (pass.equals(this.password)) {
      if (this.balance >= amount) {
        other.balance += amount;
        this.balance -= amount;
        return;
      } else {
        System.out.println("Insufficient balance");
        return;
      }
    }
    System.out.println("Wrong passwrod");
  }

  public static void main(String[] args) {

  }

}
