package javaclasses;

enum Piece {
	X, Y, Empty;
}

public class Tictactoe {
	static Piece tictactoe(Piece[][] matrix, int N) {
		int scoreX = 0;
		int Xnum = 0;
		int Ynum = 0;
		int scoreY = 0;
		Piece preX = Piece.Empty;
		Piece preY = Piece.Empty;
		for (int i = 0; i < N; i++) {
			// row
			for (int j = 0; j < N; j++) {
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
				if (matrix[i][j] == Piece.X) {
					if (preX == Piece.X) {
						Xnum++;
					} else {
						Xnum = 1;
						preX = Piece.X;
					}
				} else if (matrix[i][j] == Piece.Y) {
					if (preY == Piece.Y) {
						Ynum++;
					} else {
						Ynum = 1;
						preY = Piece.Y;
					}
				}
			}
			if (Xnum == 6) {
				scoreX += 3;
				preX = Piece.Empty;
				Xnum = 0;
			} else if (Xnum == 3 && preX == Piece.Empty) {
				scoreX += 1;
				Xnum = 0;
			}
			if (Ynum == 8) {
				scoreY += 6;
				preY = Piece.Empty;
				Ynum = 0;
			} else if (Ynum == 3 && preY == Piece.Empty) {
				scoreY += 1;
				Ynum = 0;
			}
			Xnum = 0;
			Ynum = 0;
			preX = Piece.Empty;
			preY = Piece.Empty;

			// col
			for (int j = 0; j < N; j++) {
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
				if (matrix[j][i] == Piece.X) {
					if (preX == Piece.X) {
						Xnum++;
					} else {
						Xnum = 1;
						preX = Piece.X;
					}
				} else if (matrix[j][i] == Piece.Y) {
					if (preY == Piece.Y) {
						Ynum++;
					} else {
						Ynum = 1;
						preY = Piece.Y;
					}
				}
			}
			if (Xnum == 6) {
				scoreX += 3;
				preX = Piece.Empty;
				Xnum = 0;
			} else if (Xnum == 3 && preX == Piece.Empty) {
				scoreX += 1;
				Xnum = 0;
			}
			if (Ynum == 8) {
				scoreY += 6;
				preY = Piece.Empty;
				Ynum = 0;
			} else if (Ynum == 3 && preY == Piece.Empty) {
				scoreY += 1;
				Ynum = 0;
			}
			Xnum = 0;
			Ynum = 0;
			preX = Piece.Empty;
			preY = Piece.Empty;
			// diag
			if (matrix[i][i] == Piece.X) {
				if (preX == Piece.X) {
					Xnum++;
				} else {
					Xnum = 1;
					preX = Piece.X;
				}
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
			} else if (matrix[i][i] == Piece.Y) {
				if (preY == Piece.Y) {
					Ynum++;
				} else {
					Ynum = 1;
					preY = Piece.Y;
				}
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
			}
			Xnum = 0;
			Ynum = 0;
			preX = Piece.Empty;
			preY = Piece.Empty;
			// diaother

			if (matrix[i][N - i - 1] == Piece.X) {
				if (preX == Piece.X) {
					Xnum++;
				} else {
					Xnum = 1;
					preX = Piece.X;
				}
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
			} else if (matrix[i][N - i - 1] == Piece.Y) {
				if (preY == Piece.Y) {
					Ynum++;
				} else {
					Ynum = 1;
					preY = Piece.Y;
				}
				if (Xnum == 6) {
					scoreX += 3;
					preX = Piece.Empty;
					Xnum = 0;
				} else if (Xnum == 3 && preX == Piece.Empty) {
					scoreX += 1;
					Xnum = 0;
				}
				if (Ynum == 8) {
					scoreY += 6;
					preY = Piece.Empty;
					Ynum = 0;
				} else if (Ynum == 3 && preY == Piece.Empty) {
					scoreY += 1;
					Ynum = 0;
				}
			}

		}
		if (scoreX > scoreY)
			return Piece.X;
		if (scoreX < scoreY)
			return Piece.Y;
		else
			return Piece.Empty;
	}

	public static void main(String[] args) {
		Piece[][] matrix = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 2) {
					matrix[i][j] = Piece.X;
				}
				if (j == 4) {
					matrix[i][j] = Piece.Y;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(tictactoe(matrix, 8));

	}
}
