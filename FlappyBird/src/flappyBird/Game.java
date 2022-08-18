package flappyBird;

public class Game {
	public static boolean play = true;
	static int score = 0;
	
	public static void main(String[] args) {
		new Graphic();
	}

	public static void startThread() {
		Thread t = new Thread() {
			public void run() {
				try {
					while (play) {
						if ((Ball.yD > Graphic.pn.getHeight() && Ball.yD >= 50) || Ball.yD < 0)
							play = false;

						Ball.setYD(Ball.yD += Gravity.getDist());
						boolean toRemove = false;
						for (int[] li : Pole.poles) {
							if ((li[1] <= Ball.ballx + Ball.ballw) && (Ball.yD <= li[0] || Ball.yD + 25 >= li[0] + 150)) // 51(x) +
																										// 25(width) 76
								play = false;
							li[1] -= 2;
							if (li[1] < 0) {
								toRemove = true;
								score++;
							}
						}
						if (toRemove)
							Pole.poles.remove(0);
						Graphic.pn.repaint();
						Thread.sleep(33);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

}
