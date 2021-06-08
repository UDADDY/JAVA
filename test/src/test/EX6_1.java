package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Dice{
	private int x,y;
	private int num;
	Color color;
	
	public Dice(int X,int Y, Color color,int startNum) {
		this.x=X;
		this.y=Y;
		this.color=color;
		this.num=startNum;
	}
	public void changeNum() {
		num=(int)(Math.random()*6)+1;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getNum() {
		return num;
	}
}

class DicePanel extends JPanel{
	private Dice d1,d2;
	public DicePanel(Dice d1, Dice d2) {
		this.d1=d1;
		this.d2=d2;
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				d1.changeNum();
				d2.changeNum();
				repaint();
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// D1
		g.setColor(Color.WHITE);
		g.fillRect(d1.getX(), d1.getY(), 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(d1.getX(), d1.getY(), 50, 50);
		
		paintDice(d1, g);
		
		// D2
		g.setColor(Color.WHITE);
		g.fillRect(d2.getX(), d1.getY(), 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(d2.getX(), d1.getY(), 50, 50);
	
		paintDice(d2, g);
	}
	
	public void paintDice(Dice d, Graphics g) {
		g.setColor(Color.BLACK);
		switch(d.getNum()) {
		case 1:
			g.fillRect(d.getX()+20, d.getY()+20, 10, 10);
			break;
		case 2:
			g.fillRect(d.getX()+5, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+35, 10, 10);
			break;
		case 3:
			g.fillRect(d.getX()+5, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+20, d.getY()+20, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+35, 10, 10);
			break;
		case 4:
			g.fillRect(d.getX()+5, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+35, 10, 10);
			g.fillRect(d.getX()+5, d.getY()+35, 10, 10);
			break;
		case 5:
			g.fillRect(d.getX()+20, d.getY()+20, 10, 10);
			g.fillRect(d.getX()+5, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+35, 10, 10);
			g.fillRect(d.getX()+5, d.getY()+35, 10, 10);
			break;
		case 6:
			g.fillRect(d.getX()+5, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+5, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+35, 10, 10);
			g.fillRect(d.getX()+5, d.getY()+35, 10, 10);
			g.fillRect(d.getX()+5, d.getY()+20, 10, 10);
			g.fillRect(d.getX()+35, d.getY()+20, 10, 10);
			break;
	}
	}
}

public class EX6_1 extends JFrame{
	public EX6_1() {
		setTitle("DiceGame");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Dice d1 = new Dice(100,30,Color.BLACK,1);
		Dice d2 = new Dice(200,30,Color.BLACK,6);
		
		DicePanel dp = new DicePanel(d1,d2);
		add(dp);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX6_1();
	}
}
