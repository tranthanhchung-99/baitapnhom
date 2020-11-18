package com.kthn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DenGiaoThong extends JFrame {
	private JPanel panelChinh;

	/** Creates new form GiaoThong */
	public DenGiaoThong() {
		initComponents();
		DenSang th = new DenSang();
		th.start();
		
	}

	class DenSang extends Thread {// tao lop MoveThread1 ke thua lop thread

		public void run() {
			Graphics g = (Graphics) panelChinh.getGraphics();
			Boolean turn1 = true;
			for (int i = 7; i >= 0; i--) {
				try {
					sleep(1000);// moi lan thuc hien vong lap se ngu 1s
					System.out.println(i);
				} catch (InterruptedException ex) {
					Logger.getLogger(DenGiaoThong.class.getName()).log(Level.SEVERE, null, ex);
				}
				g.setColor(Color.lightGray);
				g.fillOval(10, 10, 100, 100);// den 1 xanh
				g.fillOval(150, 10, 100, 100);// den 2 vang
				g.fillOval(290, 10, 100, 100);// den 3 do
				g.fillOval(10, 110, 100, 100);// den 4 xanh
				g.fillOval(150, 110, 100, 100);// den 5 vang
				g.fillOval(290, 110, 100, 100);// den 6 do
				Font font= new Font(Font.SERIF, Font.BOLD, 30);
				if (i > 2) {// tu giay thu 7 -> 3 se xuat hien den 1 xanh, den 6 do hoac( 4 xanh ,3 do)
					if (turn1) {
						g.setFont(font);
						g.setColor(Color.green);
						g.fillOval(10, 10, 100, 100);
						g.setColor(Color.red);
						g.fillOval(290, 110, 100, 100);
						g.drawString(String.valueOf(i), 55,65);
						
						g.setColor(Color.green);
						g.drawString(String.valueOf(i), 335,165);
						
					} else {
						g.setColor(Color.green);
						g.fillOval(10, 110, 100, 100);
						g.setColor(Color.red);
						g.fillOval(290, 10, 100, 100);
						g.drawString(String.valueOf(i), 55,165);
						g.setColor(Color.green);
						g.drawString(String.valueOf(i), 335,65);
					}

				} else if (i >= 0) {// tu giay thu 2 ->0 se xuat hien den 2 vang , den 6 do hoac (5 vang ,3 do)
					if (turn1) {
						
						g.setColor(Color.yellow);
						g.fillOval(150, 10, 100, 100);
						g.setColor(Color.red);
						g.fillOval(290, 110, 100, 100);
						g.drawString(String.valueOf(i), 195,65);
						g.setColor(Color.green);
						g.drawString(String.valueOf(i), 335,165);
						
					} else {
						g.setColor(Color.yellow);
						g.fillOval(150, 110, 100, 100);
						g.setColor(Color.red);
						g.fillOval(290, 10, 100, 100);
						g.drawString(String.valueOf(i), 195,165);
						g.setColor(Color.green);
						g.drawString(String.valueOf(i), 335,65);
					}
				}

				if (i - 1 == -1) {
					i = 7;// reset lai gia tri cua i de tiep tuc vong lap moi
					turn1 = !turn1;// doi turn

				}
			}
		}
	}

	private void initComponents() {

		panelChinh = new JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		GroupLayout panelChinhLayout = new GroupLayout(panelChinh);
		panelChinh.setLayout(panelChinhLayout);
		panelChinhLayout.setHorizontalGroup(
				panelChinhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		panelChinhLayout.setVerticalGroup(
				panelChinhLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 266, Short.MAX_VALUE));

		getContentPane().add(panelChinh, BorderLayout.CENTER);

		pack();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new DenGiaoThong().setVisible(true);
			}
		});
	}

}