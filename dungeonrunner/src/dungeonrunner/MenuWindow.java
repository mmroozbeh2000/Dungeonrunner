package dungeonrunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

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
setLayout(new GridLayout(3,1));
this.getContentPane().setBackground(Color.BLACK);	
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
buttonpanel.add(selectmap);
buttonpanel.add(createcharacter);
buttonpanel.add(loadcharacter);
buttonpanel.add(startgame);
buttonpanel.setLayout(new GridLayout(4,1));
buttonpanel.setBackground(Color.BLACK);
selectmap.setBackground(Color.ORANGE);
createcharacter.setBackground(Color.ORANGE);
loadcharacter.setBackground(Color.YELLOW);
startgame.setBackground(Color.WHITE);
add(buttonpanel, BorderLayout.CENTER);

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
