import java.util.Vector;
import java.util.Collection;

public class t {
  public static void main() {
    Vector<Integer> grades = new Vector<>(10);
    grades.add(10);
    grades.add(10);
    grades.add(10);
    grades.add(10);
    increment(grades);
    Vector<Integer> inc = incrementCopy(grades);
    Vector<String> words = new Vector<>(10);
    words.add("1");
    words.add("2");
    words.add("3");
    words.add("4");
    words.add("5");
    words.add("6");
    swap(words, 3, 5);
    Vector<Integer> z = new Vector<>(10);
    z.add(1);
    z.add(2);
    z.add(3);
    z.add(4);
    z.add(1);
    z.add(1);
    z = a2(z);
    System.out.println(z.toString());
  }

  public static void increment(Vector<Integer> nums) {
    for (int i = 0; i < nums.size(); i++) {
      nums.set(i, nums.elementAt(i) + 1);
    }
  }

  public static Vector<Integer> incrementCopy(Vector<Integer> nums) {
    Vector<Integer> result = new Vector<>(nums);
    for (int i = 0; i < result.size(); i++) {
      result.set(i, result.elementAt(i) + 1);
    }
    return result;
  }

  public static void swap(Vector<String> s, int i, int j) {
    if (i == j || i >= s.size() || j >= s.size())
      return;
    String a = s.elementAt(i);
    s.set(i, s.elementAt(j));
    s.set(j, a);

  }

  public static Vector<Integer> a1(Vector<Integer> nums) {
    Vector<Integer> res = new Vector<>(10);
    for (Integer integer : nums) {
      if (integer % 2 == 0 && integer >= 50 && integer <= 100)
        res.add(integer);
    }
    return res;
  }

  public static Vector<Integer> a2(Vector<Integer> nums) {
    Vector<Integer> inter = new Vector<>(nums.size());
    for (Integer integer : nums) {
      if (!inter.contains(integer))
        inter.add(integer);
    }
    return inter;

  }

}
