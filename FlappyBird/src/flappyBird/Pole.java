package flappyBird;

import java.util.ArrayList;

public class Pole {
	static int polew = 50;
	static int poleg = 120;
	static int initWid = 250;
	static ArrayList<int[]> poles = new ArrayList<>(); // random xposition

	public static void startPole() {
		Thread t = new Thread() {
			public void run() {
				try {
					while (Game.play) {
						int rand = 200 + (int) (Math.random() * 500);
						int i[] = { rand, initWid };
						initWid += 220;
						poles.add(i);
						int rand1 = 200 + (int) (Math.random() * 500);
						int i1[] = { rand1, initWid };
						poles.add(i1);
//						initWid += 150;

						Thread.sleep(4000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}
