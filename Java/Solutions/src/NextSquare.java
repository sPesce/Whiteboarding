public class NextSquare {
  public static long findNextSquare(long sq) {
    final double root = Math.sqrt(sq);
    return (root % 1 == 0) ? (long)Math.pow(root + 1, 2) : -1;
  }
}
