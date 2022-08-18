package chess;

public class Rook {
	static Piece p;
	static int[][] mat;

	public static int[][] safeOption(Piece p1) {
		mat = ChessBuilder.mat;
		p = p1;
		p.wid = ChessBuilder.setWid();

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
		mat[p.xp][p.yp] = 1;
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
