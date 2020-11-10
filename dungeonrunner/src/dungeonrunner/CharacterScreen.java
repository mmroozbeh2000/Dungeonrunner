package dungeonrunner;


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
private JButton ok;
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
setMinimumSize(new Dimension(350,350));
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//Objecthandler
handler= new Hanteraren();

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
ok = new JButton("Ok");
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
textarea.setBackground(Color.BLACK);
textarea.setForeground(Color.WHITE);
textpanel.add(textarea);
Chartext = new JTextField(15);
Charname = new JLabel("Please enter your name");

//Colors
charpanel.setBackground(Color.BLACK);
create.setBackground(Color.ORANGE);
buttonpanel.setBackground(Color.BLACK);
Charname.setBackground(Color.WHITE);
textpanel.setBackground(Color.BLACK);
Charname.setForeground(Color.ORANGE);
setLocationRelativeTo(null);
create.setContentAreaFilled(false);
create.setOpaque(false);
create.setForeground(Color.ORANGE);
add(charpanel);

//Add buttons


//Add listeners
create.addActionListener(this);
ok.addActionListener(this);
Thief.addActionListener(this);
Knight.addActionListener(this);
Mage.addActionListener(this);
buttonpanel.setMaximumSize(new Dimension(10,10));




//Add stuff
add(textpanel);
Thief.setSelected(true);
buttonpanel.add(Charname);
buttonpanel.add(Chartext);
buttonpanel.add(create);
add(buttonpanel,BorderLayout.CENTER);
pack();



}

@Override
public void actionPerformed(ActionEvent e) {
//When you press Create
if(e.getSource()==create) {
handler.getPlayer().setName(Chartext.getText());		
System.out.println(handler.getPlayer().getName());
Chartext.setText(handler.getPlayer().getName());
JOptionPane.showMessageDialog(null, "Character Created!" + " " + handler.getPlayer().getName() +"\n" + "Profession:" +handler.getPlayer().getRole());	
revalidate();
dispose();
}	


//Create Thief	
else if(Thief.isSelected()) {	
handler.setThief();
textarea.setText("Class:Thief" +"\n" + "Attack:" + handler.getPlayer().getAttack() +"\n" + "Endurance:"+handler.getPlayer().getEndurance() +"\n" + "Flexibility:" + handler.getPlayer().getFlexibility()+"\n" + "Initiative:"+ handler.getPlayer().getInitiative());
textarea.setEditable(false);
pack();
}
//Create Knight
else if(Knight.isSelected()) {
handler.setKnight();
revalidate();
textarea.setText("Class:Knight" +"\n" +"Attack:" + handler.getPlayer().getAttack() +"\n" + "Endurance:"+handler.getPlayer().getEndurance() +"\n" + "Flexibility:" + handler.getPlayer().getFlexibility()+"\n" + "Initiative:"+ handler.getPlayer().getInitiative());
textarea.setEditable(false);
pack();
}
//Create Mage
else if(Mage.isSelected()) {
handler.setMage();
textarea.setText("Class:Mage" +"\n" +"Attack:" + handler.getPlayer().getAttack() +"\n" + "Endurance:"+handler.getPlayer().getEndurance() +"\n" + "Flexibility:" + handler.getPlayer().getFlexibility()+"\n" + "Initiative:"+ handler.getPlayer().getInitiative());
pack();
}

	
}

public void setName(String str) {	
handler.getPlayer().setName(str);
}

public boolean getClosed() {
return closed;	
}

public Hanteraren getHandler() {
return handler;	
}

public Entity getPlayer() {
return Player;	
}






}