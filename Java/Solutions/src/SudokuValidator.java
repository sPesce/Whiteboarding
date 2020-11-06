import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
  public static boolean check(int[][] sudoku) {
    boolean valid = true;
      for(int row = 0; row < 9; row++)
      {
        Set<Integer> horizontal = new HashSet<Integer>();     
        Set<Integer> vertical = new HashSet<Integer>();     
        for(int col = 0; col < 9; col++)
        {
          horizontal.add(sudoku[row][col]);
          vertical.add(sudoku[col][row]);
          
          if(row % 3 == 0 && col % 3 == 0) 
          {
            Set<Integer> square = new HashSet<Integer>();     
            for(int i = row; i <= row + 2; i++)
            {
              for(int j = col; j <= col + 2; j ++)
                square.add(sudoku[i][j]);
            }
            if(square.size() < 9 )
            {
              System.out.println("Failed square set size test:");
              System.out.println("\tSquare: " + square.size());
              System.out.println(square.toString());
              System.out.println("\tSquare top corner: (" + row + "," + col + ")");
              valid = false;
            } 
          }          
        }
        if(horizontal.size() < 9 || vertical.size() < 9)
        {
          System.out.println("Failed set size test: ");
          System.out.println("\tVertical: " + vertical.size());
          System.out.println("\tHorizontal: " + horizontal.size());
          valid = false;
        }
      }
      return valid;
  }
  
}