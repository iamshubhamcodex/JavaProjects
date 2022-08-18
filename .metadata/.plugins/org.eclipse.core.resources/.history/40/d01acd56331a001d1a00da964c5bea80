package chess;

import java.util.LinkedList;

public class Piece {
	int xp;
	int yp;
	int x;
	int y;
	int ind;
	int wid = ChessBuilder.wid;

	boolean isWhite;
	LinkedList<Piece> ps;
	String name;
	int[][] mat;
	int[][] posMat;

	public Piece(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> ps, int[][] mat, int ind) {
		super();
		this.xp = xp;
		this.yp = yp;
		this.x = xp * wid;
		this.y = yp * wid;
		this.isWhite = isWhite;
		this.ps = ps;
		this.name = name;
		this.mat = mat;
		this.ind = ind;
		mat[xp][yp] = isWhite ? 4: 5;	// 4 for white and 5 for black
		ps.add(this);

	}

	public void move(int xp, int yp, boolean isWhite) {
		this.wid = ChessBuilder.setWid();
		ChessBuilder.setPiece();
		Piece tR = null;
		for (Piece p : ps) {
			if (p.xp == xp && p.yp == yp && p.isWhite != isWhite) {
				tR = p;
			}
		}
		this.xp = xp;
		this.yp = yp;
		this.x = (xp * wid);
		this.y = (yp * wid);
		ps.remove(tR);
	}

	public void kill() {
		ps.remove(this);
	}

	public int[][] safeOption() {

		switch (this.name) {
		case "pawn":
			return Pawn.safeOption(this);
		case "rook":
			return Rook.safeOption(this);
		case "bishop":
			return Bishop.safeOption(this);
		case "queen":
			return Queen.safeOption(this);
		case "king":
			return King.safeOption(this);
		case "knight":
			return Knight.safeOption(this);
		}
		return null;
	}

}
