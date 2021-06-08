package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyPanel extends JPanel{
	int x,y;
	public MyPanel(int a,int b) {
		x=a;
		y=b;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(x, y, 30, 30);
	}
}

public class Test extends JFrame {
	
	public Test() {
		setTitle("DiceGame");
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(new MyPanel(100,100));
		add(new MyPanel(100,200));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
		for(int i=0;i<100;i++) {
			System.out.println((int)(Math.random()*6)+1);
		}
	}

}
