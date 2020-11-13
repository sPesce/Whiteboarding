import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestGOL {

  public static int[][] getGeneration(int[][] cells, int generations) {
    Set<Cell> world = convert(cells);
    for (int i = 0; i < generations; i++) {
      world = step(world);
    }
    return convert(world);
  }

  private static Set<Cell> step(Set<Cell> oldWorld) {
    Set<Cell> alive = oldWorld.stream()
        .filter(c -> livesAnotherDay(c, oldWorld))
        .collect(Collectors.toSet());

    Set<Cell> newborns = getDead(oldWorld).stream()
        .filter(c -> bornTomorrow(c, oldWorld))
        .collect(Collectors.toSet());

    alive.addAll(newborns);
    return alive;
  }

  private static Set<Cell> getDead(Set<Cell> world) {
    Set<Cell> deadOnes = new HashSet<>();
    world.forEach(c -> deadOnes.addAll(getDeadNeighbours(c, world)));
    return deadOnes;
  }

  private static Set<Cell> getDeadNeighbours(Cell cell, Set<Cell> world) {
    return cell.getNeighbours().stream()
        .filter(n -> !world.contains(n))
        .collect(Collectors.toSet());
  }

  private static boolean bornTomorrow(Cell cell, Set<Cell> world) {
    return countAlive(cell.getNeighbours(), world) == 3;
  }

  private static boolean livesAnotherDay(Cell cell, Set<Cell> world) {
    long aliveNeighbours = countAlive(cell.getNeighbours(), world);
    return aliveNeighbours >= 2 && aliveNeighbours <= 3;

  }

  private static long countAlive(Set<Cell> cells, Set<Cell> world) {
    return cells.stream().filter(world::contains).count();
  }

  private static int[][] convert(Set<Cell> world) {
    int maxX = world.stream().mapToInt(Cell::getX).max().getAsInt();
    int minX = world.stream().mapToInt(Cell::getX).min().getAsInt();
    int maxY = world.stream().mapToInt(Cell::getY).max().getAsInt();
    int minY = world.stream().mapToInt(Cell::getY).min().getAsInt();

    int rows = maxX - minX + 1;
    int columns = maxY - minY + 1;

    int[][] cells = new int[rows][columns];
    world.forEach(c -> cells[c.getX() - minX][c.getY() - minY] = 1);
    return cells;
  }

  private static Set<Cell> convert(int[][] cells) {
    Set<Cell> world = new HashSet<>(cells.length + cells[0].length);
    for (int x = 0; x < cells.length; x++) {
      for (int y = 0; y < cells[x].length; y++) {
        if (cells[x][y] == 1) {
          world.add(new Cell(x, y));
        }
      }
    }

    return world;
  }

  private static class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Cell cell = (Cell) o;

      if (x != cell.x) return false;
      return y == cell.y;

    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

    public Set<Cell> getNeighbours() {
      Set<Cell> neighbours = new HashSet<>(8);
      neighbours.add(new Cell(x, y + 1));
      neighbours.add(new Cell(x, y - 1));
      neighbours.add(new Cell(x + 1, y));
      neighbours.add(new Cell(x + 1, y + 1));
      neighbours.add(new Cell(x + 1, y - 1));
      neighbours.add(new Cell(x - 1, y));
      neighbours.add(new Cell(x - 1, y + 1));
      neighbours.add(new Cell(x - 1, y - 1));
      return neighbours;
    }
  }
}