package chess;

import java.util.LinkedList;

public class Check {
	static int[][] mat = ChessBuilder.refreshMat();
	static LinkedList<Piece> ps = ChessBuilder.ps;
	static Piece sp = null;
	static int wid = ChessBuilder.setWid();
	static boolean isWhite;

	public static boolean check(boolean isWhite1) {
		isWhite = isWhite1;
		for (Piece p : ps)
			if (p.name == "king" && p.isWhite == isWhite) {
				sp = p;
				break;
			}
		boolean tr = checkP();
		return tr;
	}

	public static Piece cgp(int x, int y) {
		return ChessBuilder.getPiece(x * wid, y * wid);
	}

	public static boolean isVoid(int x, int y) {
		return mat[x][y] == 0;
	}

	public static boolean checkP() {
		mat = ChessBuilder.refreshMat();

		for (int x = sp.xp + 1; x < 8; x++) {
			if (!isVoid(x, sp.yp)) {
				Piece temp = cgp(x, sp.yp);
				if (mat[x][sp.yp] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "rook")) {
					System.out.println("Check " + (isWhite ? "White" : "Black") + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		for (int x = sp.xp - 1; x >= 0; x--) {
			if (!isVoid(x, sp.yp)) {
				Piece temp = cgp(x, sp.yp);
				if (mat[x][sp.yp] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "rook")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		for (int y = sp.yp + 1; y < 8; y++) {
			if (!isVoid(sp.xp, y)) {
				Piece temp = cgp(sp.xp, y);
				if (mat[sp.xp][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "rook")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		for (int y = sp.yp - 1; y >= 0; y--) {
			if (!isVoid(sp.xp, y)) {
				Piece temp = cgp(sp.xp, y);
				if (mat[sp.xp][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "rook")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		for (int x = sp.xp + 1, y = sp.yp + 1; x < 8 && y < 8; x++, y++) {
			if (!isVoid(x, y)) {
				Piece temp = cgp(x, y);
				if (mat[x][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "bishop")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		for (int x = sp.xp - 1, y = sp.yp + 1; x >= 0 && y < 8; x--, y++) {
			if (!isVoid(x, y)) {
				Piece temp = cgp(x, y);
				if (mat[x][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "bishop")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}

		for (int x = sp.xp + 1, y = sp.yp - 1; x < 8 && y >= 0; x++, y--) {
			if (!isVoid(x, y)) {
				Piece temp = cgp(x, y);
				if (mat[x][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "bishop")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}

		}
		for (int x = sp.xp - 1, y = sp.yp - 1; x >= 0 && y >= 0; x--, y--) {
			if (!isVoid(x, y)) {
				Piece temp = cgp(x, y);
				if (mat[x][y] != mat[sp.xp][sp.yp] && (temp.name == "queen" || temp.name == "bishop")) {
					System.out.println("Check " + (isWhite ? "White" : "Black"));
					return true;
				}
				break;
			}
		}
		if ((sp.xp - 1 >= 0 && sp.yp + 2 < 8) && isSafe(sp.xp - 1, sp.yp + 2)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp + 1 < 8 && sp.yp + 2 < 8) && isSafe(sp.xp + 1, sp.yp + 2)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp - 1 >= 0 && sp.yp - 2 >= 0) && isSafe(sp.xp - 1, sp.yp - 2)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp + 1 < 8 && sp.yp - 2 >= 0) && isSafe(sp.xp + 1, sp.yp - 2)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp - 2 >= 0 && sp.yp + 1 < 8) && isSafe(sp.xp - 2, sp.yp + 1)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp - 2 >= 0 && sp.yp - 1 >= 0) && isSafe(sp.xp - 2, sp.yp - 1)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}

		if ((sp.xp + 2 < 8 && sp.yp + 1 < 8) && isSafe(sp.xp + 2, sp.yp + 1)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}
		if ((sp.xp + 2 < 8 && sp.yp - 1 >= 0) && isSafe(sp.xp + 2, sp.yp - 1)) {
			System.out.println("Check " + (isWhite ? "White" : "Black"));
			return true;
		}

		return false;
	}

	public static boolean isSafe(int x, int y) {
		if (!isVoid(x, y)) {
			Piece temp = cgp(x, y);
			if (mat[x][y] != mat[sp.xp][sp.yp] && (temp.name == "knight")) {
				return true;
			}
		}
		return false;
	}
}
