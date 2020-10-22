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

  public static int[][] testFive = new int[][] {
    {0, 1, 2, 3, 4},
    {5, 6, 7, 8, 9, 10, 11, 12},
    {-1, -2, -5, 2},
    {-80}
  };
  public static int[][] testSix = new int[4][4];

  public static void main(String[] args) {
    System.out.println(testSum());
    System.out.println(testLargest());
    System.out.println(testSumRows());
    System.out.println(testLargestInRows());
    System.out.println(testSum2D());
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

      int largest = test[0];
      for (int j = 0; j < test.length; j++) {
        if (test[j] > largest) largest = test[j];
      }

      if (arrayOps.largest(test) != largest) return false;
    }

    return true;
  }

  public static boolean testSumRows() {
    int[] fiveResult = arrayOps.sumRows(testFive);
    if (fiveResult[0] != 10) return false;
    if (fiveResult[1] != 68) return false;
    if (fiveResult[2] != -6) return false;
    if (fiveResult[3] != -80) return false;

    for (int i = 0; i < testSix.length; i++) {
      if (arrayOps.sumRows(testSix)[i] != 0) return false;
    }

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();
      int[] result = arrayOps.sumRows(test);

      for (int j = 0; j < test.length; j++) {
        if (result[j] != arrayOps.sum(test[j])) return false;
      }
    }

    return true;
  }

  public static boolean testLargestInRows() {
    int[] fiveResult = arrayOps.largestInRows(testFive);
    if (fiveResult[0] != 4) return false;
    if (fiveResult[1] != 12) return false;
    if (fiveResult[2] != 2) return false;
    if (fiveResult[3] != -80) return false;

    for (int i = 0; i < testSix.length; i++) {
      if (arrayOps.largestInRows(testSix)[i] != 0) return false;
    }

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();
      int[] result = arrayOps.largestInRows(test);

      for (int j = 0; j < test.length; j++) {
        if (result[j] != arrayOps.largest(test[j])) return false;
      }
    }

    return true;
  }

  public static boolean testSum2D() {
    int[][] testSeven = new int[0][0];

    if (arrayOps.sum(testFive) != -8) return false;
    if (arrayOps.sum(testSix) != 0) return false;
    if (arrayOps.sum(testSeven) != 0) return false;

    for (int i = 0; i < 100; i++) {
      int[][] test = createNew2DArray();

      int sum = 0;
      for (int j = 0; j < test.length; j++) {
        sum += arrayOps.sum(test[j]);
      }

      if (sum != arrayOps.sum(test)) return false;
    }

    return true;
  }

  public static int[] createNewArray() {
    Random rng = new Random();
    int[] newArray = new int[Math.abs(rng.nextInt(101)) + 1];

    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = rng.nextInt();
    }

    return newArray;
  }

  public static int[][] createNew2DArray() {
    Random rng = new Random();
    int rows = Math.abs(rng.nextInt(101)) + 1;
    int[][] toReturn = new int[rows][];

    for (int i = 0; i < rows; i++) {
      toReturn[i] = createNewArray();
    }

    return toReturn;
  }

}
