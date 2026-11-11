import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.io.*;

public class SmartDevice {
  public static void main(String[] args) {

  }

  private String deviceId;
  public String name;
  public boolean isOn;

  public SmartDevice() {
    this.deviceId = "";
    this.name = "Nameless";
    this.isOn = false;
  }

  public SmartDevice(String di, String name, boolean io) {
    this.deviceId = di;
    this.name = name;
    this.isOn = io;
  }

  public void turnOn() {
    isOn = true;
    System.out.println("Light is on");
  }

  public void turnOff() {
    isOn = false;
    System.out.println("Light is off");
  }
}
