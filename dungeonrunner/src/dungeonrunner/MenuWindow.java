package dungeonrunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuWindow extends JFrame implements ActionListener {

//Booleans
private boolean  whichwindow[];	
	
//JButtons
private JButton selectmap;
private JButton loadcharacter;
private JButton createcharacter;

//JPanels
private JPanel buttonpanel;

public MenuWindow() {
super("Dungeon Runner");
setLayout(new GridLayout(3,1));
	
//JPanels
buttonpanel = new JPanel();	
//JButtons
selectmap = new JButton("Select map");
loadcharacter = new JButton("Load Character");
createcharacter = new JButton("Create Character");
//Booleans
whichwindow = new boolean[3];
whichwindow[0]=false; // Select Map
whichwindow[1]=false; // Create Character
whichwindow[2]=false; // Load Character
//Add listeners
selectmap.addActionListener(this);
loadcharacter.addActionListener(this);
createcharacter.addActionListener(this);

//Add stuff
buttonpanel.add(selectmap);
buttonpanel.add(createcharacter);
buttonpanel.add(loadcharacter);
buttonpanel.setLayout(new GridLayout(3,1));
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
if(e.getSource() ==selectmap) {
	 whichwindow[0] = true;
this.dispose();	
}
else if (e.getSource()==createcharacter) {
	 whichwindow[1]=true;
this.dispose();	 
}	
else if(e.getSource()==loadcharacter) {
	 whichwindow[2]=true;
	 this.dispose();
}
}


public boolean getWindow(int n) {
return whichwindow[n];	
}
}
