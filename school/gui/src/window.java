import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class window extends JFrame implements ActionListener {
  JButton hello;
  JPanel north, center, south;
  int a = 0;
  JTextField entry;
  JLabel label;

  public window(String title, int width, int height) {
    // constructor function has the same name as class

    // basics title an dimensions
    this.setSize(width, height);
    this.setTitle(title);

    // layout
    this.setLayout(new BorderLayout());

    north = new JPanel(); // define the panel
    add(north, BorderLayout.NORTH); // position it at a .NORTH location of the BorderLayout

    hello = new JButton("Separ=super");
    north.add(hello);
    hello.addActionListener(this);

    label = new JLabel("Enter your name");
    north.add(label);

    entry = new JTextField(15);
    north.add(entry);

    // center panel
    center = new JPanel();
    add(center, BorderLayout.CENTER);

    south = new JPanel();
    add(south, BorderLayout.SOUTH);

    // final touches
    this.setVisible(true);
    this.setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {

    window w = new window("First GUI", 800, 600);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    a++;
    System.out.println("entry number " + a);
    System.out.println("Hello, " + entry.getText());
    System.out.println(getFirstLetter(entry.getText()));
  }

  public char getFirstLetter(String a) {
    return a.charAt(0);
  }

}
