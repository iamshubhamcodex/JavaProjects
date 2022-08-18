package chess;

public class Knight {
	static int[][] mat;
	static Piece p;

	public static int[][] safeOption(Piece p1) {
		mat = ChessBuilder.mat;
		p = p1;
		p.wid = ChessBuilder.setWid();

		check((p.xp - 1 >= 0 && p.yp + 2 < 8) && isSafe(p.xp - 1, p.yp + 2), p.xp - 1, p.yp + 2);
		check((p.xp + 1 < 8 && p.yp + 2 < 8) && isSafe(p.xp + 1, p.yp + 2), p.xp + 1, p.yp + 2);

		check((p.xp - 1 >= 0 && p.yp - 2 >= 0) && isSafe(p.xp - 1, p.yp - 2), p.xp - 1, p.yp - 2);
		check((p.xp + 1 < 8 && p.yp - 2 >= 0) && isSafe(p.xp + 1, p.yp - 2), p.xp + 1, p.yp - 2);

		check((p.xp - 2 >= 0 && p.yp + 1 < 8) && isSafe(p.xp - 2, p.yp + 1), p.xp - 2, p.yp + 1);
		check((p.xp - 2 >= 0 && p.yp - 1 >= 0) && isSafe(p.xp - 2, p.yp - 1), p.xp - 2, p.yp - 1);

		check((p.xp + 2 < 8 && p.yp + 1 < 8) && isSafe(p.xp + 2, p.yp + 1), p.xp + 2, p.yp + 1);
		check((p.xp + 2 < 8 && p.yp - 1 >= 0) && isSafe(p.xp + 2, p.yp - 1), p.xp + 2, p.yp - 1);

		mat[p.xp][p.yp] = 1;
		return mat;
	}

	public static void check(boolean b, int x, int y) {
		if (b)
			mat[x][y] = 3;
	}

	public static boolean isSafe(int x, int y) {
		return mat[x][y] == 0 || mat[x][y] != mat[p.xp][p.yp];
	}
}
