package chess;

public class King {
	static Piece p;
	static int[][] mat;

	public static int[][] safeOption(Piece p1) {
		mat = ChessBuilder.mat;
		p = p1;
		p.wid = ChessBuilder.setWid();

		for (int i = p.xp - 1; i <= p.xp + 1 && i < 8 && i >= 0; i++)
			for (int j = p.yp - 1; j <= p.yp + 1 && j < 8 && j >= 0; j++)
				put(i, j);
		
		mat[p.xp][p.yp] = 1;
		return mat;
	}

	public static Piece cgp(int x, int y) {
		return ChessBuilder.getPiece(x, y);
	}

	public static void put(int x, int y) {
		if (mat[x][y] == 0)
			mat[x][y] = 3;
		else if (mat[x][y] != mat[p.xp][p.yp])
			mat[x][y] = 3;

	}
}
