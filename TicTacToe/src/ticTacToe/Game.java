package ticTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel pn;
	JLabel heading, time;
	JButton[] btns = new JButton[9];
	Font font;
	int gameChances[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
	int[][] wps = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
			{ 2, 4, 6 } };
	int activeP = 0;
	int winner;

	public Game() {
		font = new Font("", Font.BOLD, 30);
		setBounds(100, 100, 500, 650);
		createGUI();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createGUI() {
		this.getContentPane().setBackground(Color.decode("#2196f3"));
		this.setLayout(new BorderLayout());

		heading = new JLabel("TIC TAC TOE");
		heading.setForeground(Color.WHITE);
		heading.setFont(font);
		heading.setHorizontalAlignment(0); // 0 or SwingConstant.CENTER
		this.add(heading, BorderLayout.NORTH);

		pn = new JPanel();
		pn.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			JButton btn = new JButton(i + 1 + "");
			btn.setBackground(Color.decode("#90caf9"));
			btn.setFont(font);
			pn.add(btn);
			btns[i] = btn;
			btn.addActionListener(this);
			btn.setName(i + "");
		}
		this.add(pn, BorderLayout.CENTER);

		showTime();
		this.add(time, BorderLayout.SOUTH);
	}

	public void showTime() {
		time = new JLabel("Clock");
		time.setFont(new Font("", Font.PLAIN, 20));
		time.setHorizontalAlignment(0);
		time.setForeground(Color.white);

		Thread t = new Thread() {
			public void run() {
				try {
					while (true) {
						@SuppressWarnings("deprecation")
						String dateTime = new Date().toLocaleString();
						time.setText(dateTime);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton curB = (JButton) e.getSource();
		String name = curB.getName();
		int nameI = Integer.parseInt(name);
		if (gameChances[nameI] == 2) {
			if (activeP == 1) {
				curB.setIcon(new ImageIcon("src/img/1.png"));
			} else {
				curB.setIcon(new ImageIcon("src/img/0.png"));
			}
			gameChances[nameI] = activeP == 0 ? 0 : 1;
			activeP = activeP == 0 ? 1 : 0;

			for (int[] temp : wps) {
				if (gameChances[temp[0]] == gameChances[temp[1]] && gameChances[temp[1]] == gameChances[temp[2]]
						&& gameChances[temp[1]] != 2) {
					winner = gameChances[temp[0]];
					JOptionPane.showMessageDialog(this, "Player " + winner + " has won the Game");
					dispose();
					break;
				}
			}
			if (checkDraw()) {
				dispose();
			}

		} else {
			JOptionPane.showMessageDialog(this, "Position already Occupied");
		}
	}

	public boolean checkDraw() {
		for (int i : gameChances) {
			if (i == 2)
				return false;
		}
		return true;
	}

	public void dispose() {
		int i = JOptionPane.showConfirmDialog(this, "Do You want to PLAY MORE??");
		if (i == 0) {
			this.setVisible(false);
			new Game();
		} else if (i == 1) {
			System.exit(400);
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
