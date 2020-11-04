package DungeonRunner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CharacterScreen extends JFrame implements ActionListener{
	
private JButton add;
private JButton complete;
private JButton create;
private JRadioButton Thief;
private JRadioButton Knight;
private JRadioButton Mage;
private ButtonGroup jbg;
private JPanel charpanel;
private JPanel imagepanel;
private JPanel buttonpanel;
private JPanel textpanel;
private JLabel Charname;
private JTextField Chartext;
private JTextArea textarea;

Entity Player;
Entity Monster;

private boolean closed;





ImageIcon [] imagelist;

//Labels
private JLabel [] imagelabel;

//Objecthandler
private Hanteraren handler;

public CharacterScreen() {
super("Welcome to the character creator!");
setLayout(new GridLayout(4,4));
getContentPane().setBackground(Color.BLACK);
setMinimumSize(new Dimension(400,400));
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Objecthandler
handler = new Hanteraren();

//Boolean
closed = false;

//Panel
imagepanel = new JPanel();
charpanel = new JPanel();
textpanel = new JPanel();
buttonpanel = new JPanel();
//Color
//Images
imagelist = new ImageIcon[3];
imagelabel = new JLabel [3];
imagelist[0] = new ImageIcon("C:/Javafiler/Warrior.png");
imagelist[1] = new ImageIcon("C:/Javafiler/Thief.png");
imagelist[2] = new ImageIcon("C:/Javafiler/Mage.png");
imagelabel[0]= new JLabel(imagelist[0]);
imagelabel[1] = new JLabel(imagelist[1]);
imagelabel[2] = new JLabel(imagelist[2]);

//Buttons
complete = new JButton("Complete");
create = new JButton("Create");
jbg = new ButtonGroup();
Thief = new JRadioButton("Thief",imagelist[1]);
Knight = new JRadioButton("Knight",imagelist[0]);
Mage = new JRadioButton("Mage", imagelist[2]);


Thief.setBackground(Color.RED);
Knight.setBackground(Color.BLUE);
Mage.setBackground(Color.YELLOW);
///RadioButtons
jbg.add(Thief);
jbg.add(Knight);
jbg.add(Mage);

charpanel.add(Thief);
charpanel.add(Knight);
charpanel.add(Mage);



//Add Text
textarea = new JTextArea(3,3);
textpanel.add(textarea);
Chartext = new JTextField(15);
Charname = new JLabel("Please enter your name");

//Colors
charpanel.setBackground(Color.BLACK);
create.setBackground(Color.GREEN);
buttonpanel.setBackground(Color.BLACK);
Charname.setBackground(Color.WHITE);
textpanel.setBackground(Color.BLACK);


add(charpanel);
pack();
//Add buttons


//Add listeners
create.addActionListener(this);
Thief.addActionListener(this);
Knight.addActionListener(this);
Mage.addActionListener(this);
buttonpanel.setMaximumSize(new Dimension(10,10));
buttonpanel.add(Charname);
buttonpanel.add(Chartext);
buttonpanel.add(create);




}

@Override
public void actionPerformed(ActionEvent e) {
//When you press Create
if(e.getSource()==create) {
createCharacter(Chartext.getText());	
JOptionPane.showMessageDialog(null, "Character Created!" + " " + handler.getEntity(0).getName() +"\n" + "Profession:" +handler.getEntity(0).getRole());	
closed=true;
this.dispose();
}	
//Create Thief	
if(Thief.isSelected()) {	
add(textpanel);
add(buttonpanel,BorderLayout.CENTER);
handler.Entitylist.add(new Thief());
textarea.setText("Attack:" + handler.Entitylist.get(0).getAttack() +"\n" + "Endurance:"+handler.getEntity(0).getEndurance() +"\n" + "Flexibility:" + handler.getEntity(0).getFlexibility()+"\n" + "Initiative:"+ handler.getEntity(0).getInitiative());
textarea.setEditable(false);
pack();
}
//Create Knight
else if(Knight.isSelected()) {
add(textpanel);
add(buttonpanel,BorderLayout.CENTER);
handler.Entitylist.add(new Knight());
textpanel.setLocation(100, 100);	
revalidate();
textarea.setText("Attack:" + handler.Entitylist.get(0).getAttack() +"\n" + "Endurance:"+handler.getEntity(0).getEndurance() +"\n" + "Flexibility:" + handler.getEntity(0).getFlexibility()+"\n" + "Initiative:"+ handler.getEntity(0).getInitiative());
textarea.setEditable(false);
pack();
}
//Create Mage
else if(Mage.isSelected()) {
add(textpanel);
add(buttonpanel,BorderLayout.CENTER);
handler.Entitylist.add(new Mage());
textpanel.setLocation(50, 40);
textarea.setText("Attack:" + handler.Entitylist.get(0).getAttack() +"\n" + "Endurance:"+handler.getEntity(0).getEndurance() +"\n" + "Flexibility:" + handler.getEntity(0).getFlexibility()+"\n" + "Initiative:"+ handler.getEntity(0).getInitiative());;
pack();
}

	
}

public void createCharacter(String str) {	
handler.Entitylist.get(0).setName(str);
}

public boolean getClosed() {
return closed;	
}

//Returns the created player.
public Entity getPlayer() {
return Player;	
}




}