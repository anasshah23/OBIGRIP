package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Which state has approved the proposal to replace paper ballots with Electronic Voting Machines (EVMs) in Local polls?");
			radioButton[0].setText("Assam");
			radioButton[1].setText("Bihar");
			radioButton[2].setText("West Bengal");
			radioButton[3].setText("Sikkim");
		}
		if (current == 1) {
			label.setText("Que2:  ‘ULPIN’, which was seen in the news, is a unique identification number related to which field?");
			radioButton[0].setText("axation");
			radioButton[1].setText("Land Resources");
			radioButton[2].setText("MSME");
			radioButton[3].setText("Drone Registration");
		}
		if (current == 2) {
			label.setText("Que3: Which is the only inland river in the recent project proposed by Environment Ministry for rejuvenation of 13 major rivers?");
			radioButton[0].setText("Cauvery");
			radioButton[1].setText("Luni");
			radioButton[2].setText("Beas");
			radioButton[3].setText("Jhelum");
		}
		if (current == 3) {
			label.setText("Que4: ‘Narasingapettai Nagaswaram’, which got the GI Tag recently, is from which Indian state?");
			radioButton[0].setText("Kerala");
			radioButton[1].setText("Tamil Nadu");
			radioButton[2].setText("Karnataka");
			radioButton[3].setText("West Bengal");
		}
		if (current == 4) {
			label.setText("Que5:  Which Indian company has been named as an official sponsor of the FIFA World Cup Qatar 2022?");
			radioButton[0].setText("Tata");
			radioButton[1].setText("PayTm");
			radioButton[2].setText("BYJU’s");
			radioButton[3].setText("Zomato");
		}
		if (current == 5) {
			label.setText("Que6: ‘Decentralised Waste Management Technology Park’ has been inaugurated at which state/UT?");
			radioButton[0].setText("New Delhi");
			radioButton[1].setText(" Madhya Pradesh");
			radioButton[2].setText("Tamil Nadu");
			radioButton[3].setText("Rajasthan");
		}
		if (current == 6) {
			label.setText("Que7:  India signed a MoU with which country to set up Maritime Rescue Co-ordination Centre (MRCC)?");
			radioButton[0].setText("Japan");
			radioButton[1].setText("Nepal");
			radioButton[2].setText("Sri Lanka");
			radioButton[3].setText("Bangladesh");
		}
		if (current == 7) {
			label.setText("Que8:  Which state-run company has partnered with L&T and ReNew Power, for a joint venture for Green hydrogen?");
			radioButton[0].setText("ONGC");
			radioButton[1].setText("IOC");
			radioButton[2].setText("REC");
			radioButton[3].setText("GAIL");
		}
		if (current == 8) {
			label.setText("Que9: Which Union Ministry organised the ‘Exhibition on India’s Freedom struggle from 1757 to 1947’?");
			radioButton[0].setText("Ministry of Culture");
			radioButton[1].setText("Ministry of Education");
			radioButton[2].setText("Ministry of Tourism");
			radioButton[3].setText("Ministry of External Affairs");
		}
		if (current == 9) {
			label.setText("Que10: After Air India disinvestment, Alliance Air works under the control of which institution/ company?");
			radioButton[0].setText("Air India");
			radioButton[1].setText("Ministry of Civil Aviation");
			radioButton[2].setText("IndiGo");
			radioButton[3].setText("SpiceJet");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Examination System Project OasisInfobyte");
	}

}
