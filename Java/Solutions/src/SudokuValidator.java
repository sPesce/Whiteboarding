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
          if (sudoku[row][col] < 1 || sudoku[row][col] > 9)
            return false;
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
              return false;
          }          
        }
        if(horizontal.size() < 9 || vertical.size() < 9)
          return false;
      }
      return true;
  }
  
}