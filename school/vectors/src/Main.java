import java.util.Vector;

public class Main {
  public static void main() {
    Vector<String> names = new Vector<>(10);
    names.add("Daniel");
    names.add("lea");
    names.add("george");
    System.out.println(names.size());
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.elementAt(i));
    }
    names.set(0, "David");
    System.out.println(names.elementAt(0));

    Vector<Integer> grades = new Vector<>(10);
    grades.add(7);
    grades.add(9);
    grades.add(2);
    grades.add(0);
    grades.add(2);
    for (int integer : grades) {
      System.out.println(integer);
    }

  }
}
