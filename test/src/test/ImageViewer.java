package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImageViewer extends JFrame implements ActionListener{
	
	private JLabel label;
	private JMenuItem open, exit;

	public ImageViewer() {
		setSize(600,400);
		setTitle("ImageViewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar mbar = new JMenuBar();
		JMenu m = new JMenu("File");
		open = new JMenuItem("Open");
		open.addActionListener(this);
		m.add(open);
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		m.add(exit);
		mbar.add(m);
		setJMenuBar(mbar);
		
		JPanel panel = new JPanel();
		label = new JLabel();
		panel.add(label);
		add(panel);	
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageViewer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == open) {
			JFileChooser chooser = new JFileChooser();
			int r = chooser.showOpenDialog(this);
			if( r == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getAbsolutePath();
				System.out.println(name);
				System.out.println(chooser.getSelectedFile());
				label.setIcon(new ImageIcon(name));
			}
		} else if(source == exit) {
			System.exit(0);
		}
	}

}
