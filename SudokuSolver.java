package javaclasses;

public class SudokuSolver {
	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println("My sudoku");
		Print(board);
		if (Solve(board)) {
			System.out.println("Find a solution!");
			Print(board);
		} else {
			System.out.println("No solution is found!");
		}

		int[][] board2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 5, 9, 3, 6, 0, 0, 0, 0, 0 }, { 2, 6, 8, 0, 0, 0, 0, 0, 0 },
				{ 4, 0, 1, 0, 0, 0, 3, 0, 0 }, { 0, 0, 0, 4, 0, 0, 0, 9, 2 },
				{ 0, 8, 0, 0, 0, 0, 0, 6, 0 }, { 0, 2, 0, 0, 6, 1, 8, 0, 5 },
				{ 0, 0, 0, 2, 3, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 8, 0, 3, 0 } };
		System.out.println("My sudoku 2");
		Print(board2);

		if (Solve(board2)) {
			System.out.println("Find a solution!");
			Print(board2);
		} else {
			System.out.println("No solution is found!");
		}
	}

	public static void Print(int[][] board) {
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	public static boolean Solve(int[][] board) {
		
		int[][] status = new int[board.length][board[0].length];
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				status[i][j] = board[i][j] > 0 ? 2 : 0;
			}
		}
		
		return Solve(board, status, 0, 0);
	}

	
	public static boolean Solve(int[][] board, int[][] status, int x, int y) {
		
		if (x == 9)
		{
			
			int count = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
				{
					count += status[i][j] > 0 ? 1 : 0;
				}
			}
			if (count == 81)
				return true;
			else
				return false;
		}
		
		if (status[x][y] >= 1)
		{
			
			int nextX = x;
			int nextY = y + 1;
			if (nextY == 9)
			{
				nextX = x + 1;
				nextY = 0;
			}
			
			return Solve(board, status, nextX, nextY);
		} else
		{
			
			boolean[] used = new boolean[9];
			// check row
			for (int i = 0; i < 9; i++) {
				if (status[x][i] >= 1)
					used[board[x][i] - 1] = true;
			}

			// similarly we chck column
			for (int i = 0; i < 9; i++) {
				if (status[i][y] >= 1)
					used[board[i][y] - 1] = true;
			}

			
			for (int i = x - (x % 3); i < x - (x % 3) + 3; i++)
				
				for (int j = y - (y % 3); j < y - (y % 3) + 3; j++)
				{
					if (status[i][j] >= 1)
						used[board[i][j] - 1] = true;
				}

			for (int i = 0; i < used.length; i++) {
				if (!used[i])
				{
					
					status[x][y] = 1;
					board[x][y] = i + 1;
					int nextX = x;
					int nextY = y + 1;
					if (nextY == 9)
					{
						nextX = x + 1;
						nextY = 0;
					}
					
					if (Solve(board, status, nextX, nextY))
						return true;

					
					for (int m = 0; m < 9; m++)
						for (int n = 0; n < 9; n++) {
							
							if (m > x || (m == x && n >= y)) {
								if (status[m][n] == 1)
								{
									status[m][n] = 0;
									board[m][n] = 0;
								}
							}
						}
				}
			}
		}
		return false;
	}
}
