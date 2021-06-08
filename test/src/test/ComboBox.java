package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboBox extends JFrame implements ActionListener{
	
	private JLabel label;
	
	public ComboBox() {
		setSize(400,300);
		setTitle("FUCK");
		
		String[] animals = {"cat","dog","turtle","rabbit"};
		JComboBox animalList = new JComboBox(animals);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		
		label = new JLabel("FUCK");
		
		add(animalList,BorderLayout.NORTH);
		add(label);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String name = (String)cb.getSelectedItem();
		changePicture(name);
	}
	
	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon(name+".png");
		System.out.println(icon);
		label.setIcon(icon);
		if(icon!=null) {
			label.setText("Find");
		} else {
			label.setText("Cant FInd");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboBox();
	}


}
