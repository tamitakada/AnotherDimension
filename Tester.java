import java.util.Random;


public class Tester {

  public static ArrayOps arrayOps = new ArrayOps();

  public static int[] testOne = new int[] {
    1, 2, 3, 4
  };

  public static int[] testTwo = new int[] {
    -10, 0, 33, 1218, -9, -12345
  };

  public static int[] testThree = new int[8];
  public static int[] testFour = new int[0];

  public static void main(String[] args) {
    System.out.println(testSum());
    System.out.println(testLargest());
  }

  public static boolean testSum() {
    if (arrayOps.sum(testOne) != (1 + 2 + 3 + 4)) return false;
    if (arrayOps.sum(testTwo) != (-10 + 33 + 1218 - 9 - 12345)) return false;
    if (arrayOps.sum(testThree) != 0) return false;
    if (arrayOps.sum(testFour) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[] test = createNewArray();

      int sum = 0;
      for (int j = 0; j < test.length; j++) {
        sum += test[j];
      }

      if (arrayOps.sum(test) != sum) return false;
    }

    return true;
  }

  public static boolean testLargest() {
    if (arrayOps.largest(testOne) != 4) return false;
    if (arrayOps.largest(testTwo) != 1218) return false;
    if (arrayOps.largest(testThree) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[] test = createNewArray();

      int largest = 0;
      for (int j = 0; j < test.length; j++) {
        if (test[j] > largest) largest = test[j];
      }

      if (arrayOps.largest(test) != largest) return false;
    }

    return true;
  }

  public static int[] createNewArray() {
    Random rng = new Random();
    int[] newArray = new int[Math.abs(rng.nextInt(101))];

    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = rng.nextInt();
    }

    return newArray;
  }

}
