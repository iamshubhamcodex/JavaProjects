package chess;

import java.util.LinkedList;

public class Pawn extends Piece {
	public Pawn(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> ps, int[][] mat, int ind) {
		super(xp, yp, isWhite, name, ps, mat, ind);
	}

	static Piece p;
	static int mat[][];

	public static int[][] safeOption(Piece p1) {
		mat = ChessBuilder.mat;
		p = p1;
		p.wid = ChessBuilder.setWid();
		int op = p.isWhite ? -1 : 1;

		if ((p.yp == 1 && !p.isWhite) || (p.yp == 6 && p.isWhite)) {
			if (mat[p.xp][p.yp + op * 2] == 0) {
				mat[p.xp][p.yp + op * 2] = 3;
			}
		}
		if (mat[p.xp][p.yp + op] == 0 && p.yp + op >= 0 && p.yp + op < 8) {
			mat[p.xp][p.yp + op] = 3;
		}

		isSafe((p.xp + 1), (p.yp + op));
		isSafe((p.xp - 1), (p.yp + op));
		mat[p.xp][p.yp] = 1;
		return mat;

	}

	public static void isSafe(int x, int y) {
		if (x >= 0 && x < 8) {
			int i = mat[x][y];
			if (mat[x][y] != 0 && y < 8 && y >= 0)
				if (i != mat[p.xp][p.yp])
					mat[x][y] = 3;
		}
	}

}
