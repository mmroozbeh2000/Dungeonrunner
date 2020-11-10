package dungeonrunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuWindow extends JFrame implements ActionListener {

//Booleans
private boolean  whichwindow[];	
	
//JButtons
private JButton selectmap;
private JButton loadcharacter;
private JButton createcharacter;
private JButton startgame;


//Object
private Hanteraren handler;

//JPanels
private JPanel buttonpanel;

//Imageicon
private ImageIcon image;

//Status
boolean gamestatus;  //start the game
boolean playerstatus; //If a player exists;

//JLabel
private JLabel imagelabel;

public MenuWindow() {
super("Dungeon Runner");
setLayout(new GridLayout(4,1));
setPreferredSize(new Dimension(350,350));
setContentPane(new BackgroundPanel());
handler = new Hanteraren();
//JPanels
buttonpanel = new JPanel();
//JButtons
selectmap = new JButton("Select map");
loadcharacter = new JButton("Load Character");
createcharacter = new JButton("Create Character");
startgame = new JButton("Start Game");
//Booleans
whichwindow = new boolean[3];
whichwindow[0]=false; // Select Map
whichwindow[1]=false; // Create Character
whichwindow[2]=false; // Load Character
playerstatus=true;	


//Images
image = new ImageIcon("C:/Javafiler/Main.jpg");
imagelabel = new JLabel(image);
imagelabel.setSize(350,350);

//Add listeners
selectmap.addActionListener(this);
loadcharacter.addActionListener(this);
createcharacter.addActionListener(this);
startgame.addActionListener(this);

//Random


//Add stuff
this.getContentPane().add(selectmap);
this.getContentPane().add(createcharacter);
this.getContentPane().add(loadcharacter);
this.getContentPane().add(startgame);
this.getContentPane().setLayout(new GridLayout(4,1));
selectmap.setBackground(Color.BLACK);
createcharacter.setBackground(Color.BLACK);
loadcharacter.setBackground(Color.BLACK);
startgame.setBackground(Color.BLACK);
startgame.setOpaque(false);
startgame.setContentAreaFilled(false);
selectmap.setOpaque(false);
selectmap.setContentAreaFilled(false);
loadcharacter.setOpaque(false);
loadcharacter.setContentAreaFilled(false);
createcharacter.setOpaque(false);
createcharacter.setContentAreaFilled(false);
selectmap.setForeground(Color.ORANGE);
startgame.setForeground(Color.ORANGE);
loadcharacter.setForeground(Color.ORANGE);
createcharacter.setForeground(Color.ORANGE);
//Colors
pack();
this.setBackground(Color.BLACK);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

}

@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource() ==selectmap) {
whichwindow[0] = true;
this.dispose();	
}
else if (e.getSource()==createcharacter) {
whichwindow[1]=true;
startgame.setEnabled(true);
this.dispose();	 
}	
else if(e.getSource()==loadcharacter) {
 whichwindow[2]=true;
this.dispose();
}

else if(e.getSource()==startgame && handler.checkPlayer()==false) {
JOptionPane.showMessageDialog(null, "You must create a character first!");	
}

else if(e.getSource()==startgame && handler.checkPlayer()==true) {
gamestatus=true;
this.dispose();	
}
}
public void setWindow(int n, boolean b) {
whichwindow[n]=b;	
}

public boolean getWindow(int n) {
return whichwindow[n];	
}

public boolean getStatus() {
return gamestatus;	
}

}
