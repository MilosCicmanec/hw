public class Main {
  public static void main(String[] args) {
    int i = (int) (Math.random() * 5) + 1;
    switch (i) {
      case 1:
        System.out.println("quarter 1");
        break;
      case 2:
        System.out.println("quarter 2");
        break;
      case 3:
        System.out.println("quarter 3");
        break;
      case 4:
        System.out.println("quarter 4");
        break;
      default:
        System.out.println("invalid quarter");
        break;
    }

    int half = (int) (Math.random() * 2);
    String value = switch (half) {
      case 0 -> "First half";
      case 1 -> "Second half";
      default -> "Invalid half";
    };
    System.out.println(value);
  }
}
