package com.kthn;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MayTinh extends JFrame implements ActionListener {

	private JPanel panelcalculator, mainPanel, panelOUTPUT;
	private JTextArea textarea;
	private String btnName[] = { "()", "C", "Del", "+", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-",
			"neg", "0", ".", "=" };
	private JButton btn;
	private Boolean turn1 = true;

	public MayTinh() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {// thay đổi giao diện
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
				// System.out.println(info.getName());
			}
		} catch (Exception e) {
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(240, 330);
		setLocationRelativeTo(null);
		setResizable(false);
		add(createmainFrame());

	}

	/* Hàm tạo panel chính */
	public JPanel createmainFrame() {
		setTitle("Calculator");

		mainPanel = new JPanel(new BorderLayout(5, 5));
		mainPanel.add(createButtonofCalculator(), BorderLayout.CENTER);// các nút bấm ở giữa
		mainPanel.add(createTextArea(), BorderLayout.NORTH);// màn hình hiển thị của máy tính hướng bắc
		mainPanel.setBackground(Color.white);
		return mainPanel;
	}

	/* Khởi tạo jbutton */
	private JButton myButton(String btnname) {
		btn = new JButton(btnname);
		btn.setBackground(Color.white);
		btn.setForeground(Color.red);
		btn.addActionListener(this);
		return btn;

	}

	/* Add các jbutton vào panel */
	public JPanel createButtonofCalculator() {
		panelcalculator = new JPanel(new GridLayout(5, 4));// hàng ,cột
		for (int i = 0; i < btnName.length; i++) {
			panelcalculator.add(myButton(btnName[i]));
		}
		panelcalculator.setBackground(Color.white);
		return panelcalculator;

	}

	/* Khởi tạo jtextarea */
	private JPanel createTextArea() {
		panelOUTPUT = new JPanel(new GridLayout(1, 1));
		textarea = new JTextArea(3, 3);
		JScrollPane scrollPane = new JScrollPane(textarea);
		textarea.setBackground(Color.WHITE);
		textarea.setForeground(Color.DARK_GRAY);
		panelOUTPUT.add(scrollPane);
		textarea.setEditable(false);
		return panelOUTPUT;

	}

	public void actionPerformed(ActionEvent e) {
// bắt sự kiến cho từng nút
		if (e.getActionCommand() == "1")
			textarea.append("1");
		if (e.getActionCommand() == "2")
			textarea.append("2");
		if (e.getActionCommand() == "3")
			textarea.append("3");
		if (e.getActionCommand() == "4")
			textarea.append("4");
		if (e.getActionCommand() == "5")
			textarea.append("5");
		if (e.getActionCommand() == "6")
			textarea.append("6");
		if (e.getActionCommand() == "7")
			textarea.append("7");
		if (e.getActionCommand() == "8")
			textarea.append("8");
		if (e.getActionCommand() == "9")
			textarea.append("9");
		if (e.getActionCommand() == "0")
			textarea.append("0");
		if (e.getActionCommand() == ".")
			textarea.append(".");
		if (e.getActionCommand() == "neg")// Dấu âm (negative)
			textarea.append("-");

		if (e.getActionCommand() == "+") {
			textarea.append("+");
		}
		if (e.getActionCommand() == "-") {
			textarea.append("-");
		}

		if (e.getActionCommand() == "*") {
			textarea.append("*");
		}

		if (e.getActionCommand() == "/") {
			textarea.append("/");
		}
		if (e.getActionCommand() == "()") {
			if (turn1) {
				textarea.append("(");
				turn1 = !turn1;
			} else {
				textarea.append(")");
				turn1 = !turn1;
			}
		}

		if (e.getActionCommand() == "=") {

			ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

			try {
				// Evaluate the expression
				Object result = engine.eval(textarea.getText());

				System.out.println(textarea.getText() + " = " + result);
				textarea.setText(String.valueOf(result));
			} catch (ScriptException exception) {
				JOptionPane.showMessageDialog(null, "Nhập sai biểu thức , yêu cầu nhập đầy đủ các toán tử");
				;
			}

		}

		if (e.getActionCommand() == "Del") {
			String s = textarea.getText();
			textarea.setText("");
			for (int i = 0; i < s.length() - 1; i++) {
				textarea.setText(textarea.getText() + s.charAt(i));
			}

		}
		if (e.getActionCommand() == "C")
			textarea.setText("");
	}

	public static void main(String[] args) {
		new MayTinh().setVisible(true);
	}
}