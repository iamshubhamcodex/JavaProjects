package chess;

public class Queen {
	static int[][] mat;
	static Piece p;

	public static int[][] safeOption(Piece piece) {
		mat = ChessBuilder.mat;
		p = piece;

		for (int x = p.xp + 1, y = p.yp + 1; x < 8 && y < 8; x++, y++)
			if (put(x, y) == -1)
				break;
		for (int x = p.xp - 1, y = p.yp + 1; x >= 0 && y < 8; x--, y++)
			if (put(x, y) == -1)
				break;

		for (int x = p.xp + 1, y = p.yp - 1; x < 8 && y >= 0; x++, y--)
			if (put(x, y) == -1)
				break;

		for (int x = p.xp - 1, y = p.yp - 1; x >= 0 && y >= 0; x--, y--)
			if (put(x, y) == -1)
				break;
		
		for (int x = p.xp + 1; x < 8; x++) {
			if (put(x, p.yp) == -1)
				break;
		}
		for (int y = p.yp + 1; y < 8; y++) {
			if (put(p.xp, y) == -1)
				break;
		}
		for (int x = p.xp - 1; x >= 0; x--) {
			if (put(x, p.yp) == -1)
				break;
		}
		for (int y = p.yp - 1; y >= 0; y--) {
			if (put(p.xp, y) == -1)
				break;
		}

		mat[piece.xp][piece.yp] = 1;
		return mat;
	}

	public static int put(int x, int y) {
		if (mat[x][y] == 0) {
			mat[x][y] = 3;
			return 0;
		} else if (mat[x][y] != mat[p.xp][p.yp])
			mat[x][y] = 3;
		return -1;
	}

}
