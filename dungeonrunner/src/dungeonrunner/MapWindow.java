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
	setContentPane(new BackgroundPanel());	
	//JPanels
	buttonpanel = new JPanel();	
	//JButtons
	smallMap = new JButton("Small" + "" +"4x4");
	mediumMap = new JButton("Medium" +"" + "5x5");
    largeMap = new JButton("Large" + "" + "8x8");
    smallMap.setOpaque(false);
    smallMap.setContentAreaFilled(false);
    mediumMap.setOpaque(false);
    mediumMap.setContentAreaFilled(false);
    smallMap.setContentAreaFilled(false);
    largeMap.setOpaque(false);
    largeMap.setContentAreaFilled(false);
    smallMap.setForeground(Color.WHITE);
    mediumMap.setForeground(Color.CYAN);
    largeMap.setForeground(Color.GREEN);
	//Booleans
	whichMap =0;

	//Add listeners
	smallMap.addActionListener(this);
	mediumMap.addActionListener(this);
	largeMap.addActionListener(this);

	//Add stuff
	this.getContentPane().setLayout(new GridLayout(3,1));
	this.getContentPane().add(smallMap);
	this.getContentPane().add(mediumMap);
	this.getContentPane().add(largeMap);;
	//Colors

	setPreferredSize(new Dimension(350,350));
	this.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
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
