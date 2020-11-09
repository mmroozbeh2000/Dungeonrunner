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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class AttackWindow extends JFrame implements ActionListener{
	
private Hanteraren handler;	

//Imageicons
private ImageIcon imageicons[];

//JButtons
private JButton attack;
private JButton flee;
private JButton battle;

//Boolean
private boolean knightblock = false;

//Jtextarea
private JTextArea textarea;

//JLabels
private JLabel imagelabels[];
private JLabel playerlabel;
private JLabel spiderlabel;
private JLabel orclabel;

//Progressbar
JProgressBar spiderbar;
JProgressBar playerbar;
JProgressBar orcbar;

//JPanels
private JPanel imagepanel;
private JPanel buttonpanel;
private JPanel textpanel;
private JPanel barpanel;

//MonsterID
int monsterID;
//Constructor
public AttackWindow() {
	
}

public AttackWindow(int n, Hanteraren handler){
super("Battle!");
super.setBackground(Color.BLACK);
this.getContentPane().setBackground(Color.BLACK);
setLayout(new GridLayout(3,1));
this.handler=handler;

//Buttons
attack = new JButton("Attack");
flee = new JButton("Flee");
battle = new JButton("Battle");
flee.addActionListener(this);
attack.addActionListener(this);
battle.addActionListener(this);
//Images
imageicons = new ImageIcon[4];
imageicons[0]=new ImageIcon("C:/Javafiler/Spider.jpg");
imageicons[1]=new ImageIcon("C:/Javafiler/Orc.png");
//Monster ID
monsterID = n;

//ProgressBars
spiderbar = new JProgressBar();
orcbar = new JProgressBar();
playerbar = new JProgressBar();
spiderbar.setValue(100);
playerbar.setValue(100);
orcbar.setValue(100);


//JLabels
imagelabels = new JLabel[4];	
imagelabels[0]= new JLabel(imageicons[0]);
imagelabels[1]= new JLabel(imageicons[1]);
imagelabels[2]= new JLabel(imageicons[2]);
imagelabels[3]= new JLabel(imageicons[3]);

playerlabel = new JLabel();
playerlabel.setText("Player Endurance:" + Integer.toString(handler.getPlayer().getEndurance()));



//Textarea
textarea = new JTextArea(5,10);
textarea.setEditable(false);
/* lägg till strings från monsterklasserna
 * t.ex "Spider attacked for x damage" eller "Player lost x hp"
 * Förslagsvis lägg in som methods i Entityklassen "attackMessage()";
 */
setPreferredSize(new Dimension(400,400));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);


//Panels
imagepanel = new JPanel();
imagepanel.setSize(200,200);
buttonpanel = new JPanel();
textpanel = new JPanel();
barpanel = new JPanel();

textpanel.setBackground(Color.BLACK);
barpanel.setBackground(Color.BLACK);
buttonpanel.setBackground(Color.BLACK);
imagepanel.setBackground(Color.BLACK);
attack.setBackground(Color.ORANGE);
flee.setBackground(Color.ORANGE);
battle.setBackground(Color.ORANGE);

//Add stuff
textpanel.add(textarea);
setLocationRelativeTo(null);
pack();

if(n==0) {
spiderlabel = new JLabel("Spider Endurance" + Integer.toString(handler.getSpider().getEndurance()));	
imagepanel.add(imagelabels[0]);
barpanel.add(playerlabel);
barpanel.add(playerbar);
barpanel.add(spiderlabel);
barpanel.add(spiderbar);

add(imagepanel, BorderLayout.NORTH);
add(textpanel, BorderLayout.CENTER);
add(buttonpanel, BorderLayout.SOUTH);
add(barpanel, BorderLayout.WEST);
//Start the battle with spider
buttonpanel.add(battle);
buttonpanel.add(flee);
pack();
}

if(n==1) {
orclabel = new JLabel("Orc Endurance" + Integer.toString(handler.getOrc().getEndurance()));
imagepanel.add(imagelabels[1]);
barpanel.add(playerlabel);
barpanel.add(playerbar);
barpanel.add(orclabel);
barpanel.add(orcbar);

add(imagepanel, BorderLayout.NORTH);
add(textpanel, BorderLayout.CENTER);
add(buttonpanel, BorderLayout.SOUTH);
add(barpanel, BorderLayout.WEST);
//Start the battle with orc
buttonpanel.add(battle);
buttonpanel.add(flee);
pack();
}


	
}
@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==flee) {
this.dispose();	
}

else if(e.getSource()==battle) {
try {	
buttonpanel.remove(battle);		
if(monsterID==1) {	
beginBattle(handler.getOrc(),handler.getPlayer());
}
else if(monsterID==0) {
buttonpanel.remove(battle);		
beginBattle(handler.getSpider(),handler.getPlayer());	
}
}
catch(Exception ex) {
ex.printStackTrace();	
}
}

else if(e.getSource()==attack&&monsterID ==0) {	
attack.setEnabled(false);
flee.setEnabled(false);	
revalidate();
try {	
playerAttack(handler.getSpider(), handler.getPlayer(), monsterID);	
Thread.sleep(500);	
beginBattle(handler.getSpider(),handler.getPlayer());
Thread.sleep(500);
revalidate();

if(handler.getSpider().getEndurance()<=0&&handler.checkPlayer()==true) {
JOptionPane.showMessageDialog(null, "You've slayed the beast!");
monsterID=-1;
this.dispose();
}
}
catch(Exception ex) {
ex.printStackTrace();	
}
}



else if(e.getSource()==attack&&monsterID ==1) {	
attack.setEnabled(false);
flee.setEnabled(false);	
revalidate();	
try {	
Thread.sleep(500);	
playerAttack(handler.getOrc(), handler.getPlayer(), monsterID);	
Thread.sleep(500);
revalidate();
Thread.sleep(500);
beginBattle(handler.getOrc(), handler.getPlayer());
attack.setEnabled(true);
flee.setEnabled(true);
revalidate();

if(handler.getOrc().getEndurance()<=0&&handler.checkPlayer()==true) {
JOptionPane.showMessageDialog(null, "You've slayed the beast!");
handler.getPlayer().setspecialAbility(true);
monsterID=-1;
//Restore block to knight
handler.getPlayer().setspecialAbility(true);
this.dispose();
}
}
catch(Exception ex) {
ex.printStackTrace();	
}
}
	
	
}	

//Begin the battle
public void beginBattle(Entity monster, Entity player) {
buttonpanel.add(attack);
buttonpanel.add(flee);	
try {	
if(player.rollTurnOrder()>=monster.rollTurnOrder()) {
textarea.setText("It's your turn to attack!");
attack.setEnabled(true);
flee.setEnabled(true);
revalidate();
}
else {  //If monster is faster than player, player can't attack
if(monsterID==0) {	
textarea.setText("Spider begins to attack!");	
revalidate();
monsterAttack(monster,player, monsterID);
}
else if(monsterID==1) {
textarea.setText("Orc begins to attack!");	
revalidate();
monsterAttack(monster,player, monsterID);
}
}
}
catch(Exception e) {
e.printStackTrace();	
}

}
public void monsterAttack(Entity monster, Entity player, int monsterID) {
try {
attack.setEnabled(false);
flee.setEnabled(false);
revalidate();

if(monster.attackAttempt()>player.dodgeAttempt()) {

if(monsterID==0) {	
textarea.setText("Spider attacks player for:" + monster.getAttack() + " " + "Damage!");	
attack.setEnabled(true);
flee.setEnabled(true);
}
else if(monsterID==1) {
textarea.setText("Orc attacks player for "+ monster.getAttack() + " " + "Damage!");	
attack.setEnabled(true);
flee.setEnabled(true);
}

//If knight have already blocked
if(player.specialAbility()!=true) {
player.setEndurance(player.getEndurance()-1);
playerbar.setValue(playerbar.getValue()-20); // Ska uppdateras
playerlabel.setText("Player Endurance:" + Integer.toString(player.getEndurance()));
attack.setEnabled(true);
flee.setEnabled(true);
revalidate();
if(player.getEndurance()<=0) {
JOptionPane.showMessageDialog(null, "You've died!");	
handler.setplayerStatus(false);
this.dispose();	  //Stäng ner rutan när man inte har någon tålighet kvar.
}
}

else if(player.getRole()==ROLE.KNIGHT&&player.specialAbility()==true) {
textarea.setText("The player blocked the attack!");
//Remove block from knight
player.setspecialAbility(false);
revalidate();
}


}	
//#    If Attack attempt is smaller than playerdodge
else {
	
if(monsterID==0) {	
textarea.setText("The spider missed it's attack!");
attack.setEnabled(true);
flee.setEnabled(true);
revalidate();
}
else if(monsterID==1) {
textarea.setText("Orc missed it's attack!");	
attack.setEnabled(true);
flee.setEnabled(true);
revalidate();
}

}
///#

}
catch(Exception e) {
e.printStackTrace();	
}

}
//End of monster attack method.

public void playerAttack(Entity monster, Entity player,int monsterID) {
try {	
if(player.attackAttempt()>monster.dodgeAttempt()) {
if(monsterID==0) {	
textarea.setText("Player attacked spider for " + player.getDamage() + " " + "Damage");	
monster.setEndurance(monster.getEndurance()-player.getDamage());
spiderlabel.setText("Spider Endurance:" +  Integer.toString(monster.getEndurance()));
spiderbar.setValue(monster.getEndurance());
revalidate();

}
else if(monsterID==1) {
textarea.setText("Player attacked orc for" + player.getDamage() + " " + "Damage");
monster.setEndurance(monster.getEndurance()-player.getDamage());
orclabel.setText("Orc Endurance:" + Integer.toString(monster.getEndurance()));
orcbar.setValue(monster.getEndurance());
revalidate();
}
revalidate();
}
else {
textarea.setText("The player missed!");
attack.setEnabled(false);
flee.setEnabled(false);
monsterAttack(monster, player,monsterID);
revalidate();

}
}
catch(Exception e) {
e.printStackTrace();	
}
}


}
