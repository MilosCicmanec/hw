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
import Animals.Swimmable;
public class Fish implements Swimmable {
    public void swim(){
        System.out.println("Fish is swimming");
    }

    @Override
    public void dive(int d) {
        System.out.println("Fish dives");
    }

    @Override
    public void resurface() {
        System.out.println("Fish resurfaced");
    }
}
