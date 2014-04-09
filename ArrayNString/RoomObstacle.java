package javaclasses;

public class RoomObstacle {

	public static void main(String[] args) {
		char[][] mat = { { '0', '0', '0' }, { 'B', 'G', 'G' },
				{ 'B', '0', '0' } };

		int row = mat.length;
		int col = mat[0].length;

		char[][] res = null;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 'B')
					res[i][j] = 'B';
				if (mat[i][j] == 'G')
					res[i][j] = 'G';

				if (mat[i][j] == '0') {
					int step = 0;
					int min = 0;
					for (int ii = 0; i < row; i++) {
						for (int jj = 0; j < col; j++) {
							if (mat[i][j] != 'G') {
								step++;
								if(min > step)
									min = step;
							} else {
								step++;
							}
						}
					}
					mat[i][j] = (char) min;
				}
			}
		}

		System.out.println(res);
	}

}
