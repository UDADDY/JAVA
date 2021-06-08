package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EX5_3 extends JFrame implements ActionListener{
	
	// Bottom
	private JButton submit;
	private JButton exit;
	private JTextField price;
	// kind
	ButtonGroup kindGroup;
	JRadioButton kindCombo;
	JRadioButton kindPotato;
	JRadioButton kindBulgogi;
	// topping
	ButtonGroup toppingGroup;
	JRadioButton toppingPimento;
	JRadioButton toppingCheese;
	JRadioButton toppingPepperoni;
	JRadioButton toppingBacon;
	// size
	ButtonGroup sizeGroup;
	JRadioButton sizeSmall;
	JRadioButton sizeMedium;
	JRadioButton sizeLarge;
	
	public EX5_3() {
		setSize(600,400);
		setTitle("���� �ֹ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top = new JPanel();
		JPanel kind = new JPanel();
		JPanel topping = new JPanel();
		JPanel size = new JPanel();
		JPanel bottom = new JPanel();
		
		// Top
		JLabel topLabel = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
		top.add(topLabel);
		
		// Kind
		Box kindBox = Box.createVerticalBox();
		kindCombo = new JRadioButton("�޺�(10,000)��");
		kindPotato = new JRadioButton("������Ʈ(11,000)��");
		kindBulgogi = new JRadioButton("�Ұ��(12,000)��");
		kindGroup = new ButtonGroup();
		kindGroup.add(kindCombo);
		kindGroup.add(kindPotato);
		kindGroup.add(kindBulgogi);
		kindBox.add(kindCombo);
		kindBox.add(kindPotato);
		kindBox.add(kindBulgogi);
		kind.setBorder(new TitledBorder(new EtchedBorder(),"����"));
		kind.add(kindBox);
		
		
		// Topping
		Box toppingBox = Box.createVerticalBox();
		toppingPimento = new JRadioButton("�Ǹ�(1,000)��");
		toppingCheese = new JRadioButton("ġ��(2,000)��");
		toppingPepperoni = new JRadioButton("���۷δ�(3,000)��");
		toppingBacon = new JRadioButton("������(4,000)��");
		toppingGroup = new ButtonGroup();
		toppingGroup.add(toppingPimento);
		toppingGroup.add(toppingCheese);
		toppingGroup.add(toppingPepperoni);
		toppingGroup.add(toppingBacon);
		toppingBox.add(toppingPimento);
		toppingBox.add(toppingCheese);
		toppingBox.add(toppingPepperoni);
		toppingBox.add(toppingBacon);
		topping.setBorder(new TitledBorder(new EtchedBorder(),"�߰� ����"));
		topping.add(toppingBox);
		
		// Size
		Box sizeBox = Box.createVerticalBox();
		sizeSmall = new JRadioButton("Small(5,000��)");
		sizeMedium = new JRadioButton("Medium(6,000��)");
		sizeLarge = new JRadioButton("Large(7,000��)");
		sizeGroup = new ButtonGroup();
		sizeGroup.add(sizeSmall);
		sizeGroup.add(sizeMedium);
		sizeGroup.add(sizeLarge);
		sizeBox.add(sizeSmall);
		sizeBox.add(sizeMedium);
		sizeBox.add(sizeLarge);
		size.setBorder(new TitledBorder(new EtchedBorder(),"ũ��"));
		size.add(sizeBox);
		
		// Bottom
		submit = new JButton("����");
		exit = new JButton("���");
		submit.addActionListener(this);
		exit.addActionListener(this);
		price = new JTextField();
		price.setEnabled(false);
		price.setPreferredSize(new Dimension(70,20));
		bottom.add(submit);
		bottom.add(exit);
		bottom.add(price);
		
		
		// Add Panel
		add(top,BorderLayout.NORTH);
		add(kind,BorderLayout.WEST);
		add(topping,BorderLayout.CENTER);
		add(size,BorderLayout.EAST);
		add(bottom,BorderLayout.SOUTH);
		
		// Last
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int sum = 0;
		boolean isKind = false;
		boolean isTopping = false;
		boolean isSize = false;
		if(e.getSource()==submit) { // Submit Button
			if(kindCombo.isSelected()) {
				sum+=10000;
				isKind=true;
			}
			if(kindPotato.isSelected()) {
				sum+=11000;
				isKind=true;
			}
			if(kindBulgogi.isSelected()) {
				sum+=12000;
				isKind=true;
			}
			if(toppingPimento.isSelected()) {
				sum+=1000;
				isTopping=true;
			}
			if(toppingCheese.isSelected()) {
				sum+=2000;
				isTopping=true;
			}
			if(toppingPepperoni.isSelected()) {
				sum+=3000;
				isTopping=true;
			}
			if(toppingBacon.isSelected()) {
				sum+=4000;
				isTopping=true;
			}
			if(sizeSmall.isSelected()) {
				sum+=5000;
				isSize=true;
			}
			if(sizeMedium.isSelected()) {
				sum+=6000;
				isSize=true;
			}
			if(sizeLarge.isSelected()) {
				sum+=7000;
				isSize=true;
			}
			if(isKind&&isTopping&&isSize) {
				price.setText(""+sum+"��");
			}
		} else if(e.getSource()==exit) { // Button
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EX5_3();
	}

}
