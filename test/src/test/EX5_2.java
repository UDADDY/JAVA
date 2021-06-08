package test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EX5_2 extends JFrame implements ActionListener{
	
	private JTextField result;
	private JButton eraserButton;
	private JButton[][] inputButton;
	
	public EX5_2() {
		setTitle("°è»ê±â");
		setSize(217,320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		result = new JTextField();
		result.setBounds(0,0,200,30);
		result.setEditable(false);
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		add(result);
		
		eraserButton = new JButton("C");
		eraserButton.addActionListener(this);
		eraserButton.setBounds(0, 30, 50, 50);
		add(eraserButton);
				
		
		initButton();
		addButton();

		
		setVisible(true);
	}
	
	public void initButton() {
		inputButton = new JButton[4][4];
		inputButton[0][0] = new JButton("7");		
		inputButton[0][1] = new JButton("8");
		inputButton[0][2] = new JButton("9");
		inputButton[0][3] = new JButton("/");
		inputButton[1][0] = new JButton("4");
		inputButton[1][1] = new JButton("5");
		inputButton[1][2] = new JButton("6");
		inputButton[1][3] = new JButton("*");
		inputButton[2][0] = new JButton("1");
		inputButton[2][1] = new JButton("2");
		inputButton[2][2] = new JButton("3");
		inputButton[2][3] = new JButton("-");
		inputButton[3][0] = new JButton("0");
		inputButton[3][1] = new JButton("+/-");
		inputButton[3][2] = new JButton("=");
		inputButton[3][3] = new JButton("+");

		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				inputButton[i][j].setBounds(j*50,i*50+30+50,50,50);
			}
		}
	}
	public void addButton() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				inputButton[i][j].addActionListener(this);
				add(inputButton[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String prev = result.getText();
		
		if(e.getSource()==eraserButton) { // 7
			result.setText("");
		}
		if(e.getSource()==inputButton[0][0]) { // 7
			result.setText(result.getText()+"7");
		}
		if(e.getSource()==inputButton[0][1]) { // 8
			result.setText(result.getText()+"8");
		}
		if(e.getSource()==inputButton[0][2]) { // 9
			result.setText(result.getText()+"9");
		}
		if(e.getSource()==inputButton[0][3]) { // /
			if(isEmpty(prev))
				return;
			if(isSignLast(prev))
				return;			
			result.setText(result.getText()+"/");
		}
		if(e.getSource()==inputButton[1][0]) { // 4
			result.setText(result.getText()+"4");
		}
		if(e.getSource()==inputButton[1][1]) { // 5
			result.setText(result.getText()+"5");
		}
		if(e.getSource()==inputButton[1][2]) { // 6
			result.setText(result.getText()+"6");
		}
		if(e.getSource()==inputButton[1][3]) { // *
			if(isEmpty(prev))
				return;
			if(isSignLast(prev))
				return;
			result.setText(result.getText()+"*");
		}
		if(e.getSource()==inputButton[2][0]) { // 1
			result.setText(result.getText()+"1");
		}
		if(e.getSource()==inputButton[2][1]) { // 2
			result.setText(result.getText()+"2");
		}
		if(e.getSource()==inputButton[2][2]) { // 3
			result.setText(result.getText()+"3");
		}
		if(e.getSource()==inputButton[2][3]) { // -
			if(isEmpty(prev))
				return;
			if(isSignLast(prev))
				return;
			result.setText(result.getText()+"-");
		}
		if(e.getSource()==inputButton[3][0]) { // 0
			if(isEmpty(prev))
				return;
			result.setText(result.getText()+"0");
		}
		if(e.getSource()==inputButton[3][1]) { // +/-
		}
		if(e.getSource()==inputButton[3][2]) { // =
			if(!isRightForm(prev)) {
				result.setText("");
				return;
			}
			int res = equal(prev);
			result.setText(prev+"="+res);
		}
		if(e.getSource()==inputButton[3][3]) { // +
			if(isEmpty(prev))
				return;
			if(isSignLast(prev))
				return;
			result.setText(result.getText()+"+");
		}
	}	
	
	public String[] findForm(String str) {
		String[] ret = new String[3];
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='/' || str.charAt(i)=='*' || str.charAt(i)=='-' || str.charAt(i)=='+') {
				ret[0] = str.substring(0, i);
				ret[1] = String.valueOf(str.charAt(i));
				ret[2] = str.substring(i+1, str.length());
				return ret;
			}
		}
		return null;
	}
	public int equal(String str) {
		// TODO Auto-generated method stub
		String[] form = findForm(str);
		switch(form[1]) {
		case "/":
			return Integer.parseInt(form[0]) / Integer.parseInt(form[2]);
		case "*":
			return Integer.parseInt(form[0]) * Integer.parseInt(form[2]);
		case "+":
			return Integer.parseInt(form[0]) + Integer.parseInt(form[2]);
		case "-":
			return Integer.parseInt(form[0]) - Integer.parseInt(form[2]);
		}
		return (Integer) null;
	}
	
	public boolean isRightForm(String str) {
		boolean isRight = false;
		if(str.isEmpty())
			return false;
		if(str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-' || str.charAt(str.length()-1)=='/' || str.charAt(str.length()-1)=='*')
			return false;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='=') {
				return false;
			}
			if(str.charAt(i)=='/' ||str.charAt(i)=='+' ||str.charAt(i)=='-' ||str.charAt(i)=='*' && i!=0 && i!=str.length()-1) {
				if(isRight) { // overlap
					return false;
				}
				isRight=true;
			}
		}
		if(isRight)
			return true;
		else
			return false;
	}

	public boolean isEmpty(String str) {
		if(str.equals(""))
			return true;
		else
			return false;
	}
	public boolean isSignLast(String str) {
		char last = str.charAt(str.length()-1);
		if(last=='/' || last=='*' || last=='-' || last=='+')
			return true;
		else
			return false;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX5_2();
	}
}
