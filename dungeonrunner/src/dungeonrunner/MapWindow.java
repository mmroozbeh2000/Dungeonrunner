package dungeonrunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapWindow extends JFrame implements ActionListener{
	//Booleans
	private int whichMap;	
	
	
	private TryIt tryit;
	//JButtons
	private JButton smallMap;
	private JButton mediumMap;
	private JButton largeMap;

	//JPanels
	private JPanel buttonpanel;

	//Imageicon
	private ImageIcon image;

	//JLabel
	private JLabel imagelabel;

	
	//Constructor
	public MapWindow() {
	super("Dungeon Runner");
	setLayout(new GridLayout(3,1));
	this.getContentPane().setBackground(Color.BLACK);	
	//JPanels
	buttonpanel = new JPanel();	
	buttonpanel.setBackground(Color.BLACK);
	BackgroundPanel background;
	//JButtons
	smallMap = new JButton("Small" + "" +"4x4");
	mediumMap = new JButton("Medium" +"" + "5x5");
    largeMap = new JButton("Large" + "" + "8x8");
    smallMap.setBackground(Color.GREEN);
    mediumMap.setBackground(Color.CYAN);
    largeMap.setBackground(Color.RED);
	//Booleans
	whichMap =0;
	

	//Images
	image = new ImageIcon("C:/Javafiler/Main.jpg");
	imagelabel = new JLabel(image);
	imagelabel.setSize(350,350);

	//Add listeners
	smallMap.addActionListener(this);
	mediumMap.addActionListener(this);
	largeMap.addActionListener(this);

	//Add stuff
	buttonpanel.add(smallMap);
	buttonpanel.add(mediumMap);
	buttonpanel.add(largeMap);
	buttonpanel.setLayout(new GridLayout(3,1));
	background = new BackgroundPanel();
	add(buttonpanel, BorderLayout.CENTER);

	//Colors

	setPreferredSize(new Dimension(350,350));
	this.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
	setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() ==smallMap) {
		 whichMap= 4;
	this.dispose();	
	}
	else if (e.getSource()==mediumMap) {
	whichMap=5;
	this.dispose();	 
	}	
	else if(e.getSource()==largeMap) {
		 whichMap=8;
		 this.dispose();
	}
	}


	public int getMap() {
	return whichMap;	
	}

}
