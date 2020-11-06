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

//Jtextarea
private JTextArea textarea;

//JLabels
private JLabel imagelabels[];
private JLabel playerlabel;
private JLabel spiderlabel;

//Progressbar
JProgressBar spiderbar;
JProgressBar playerbar;


//JPanels
private JPanel imagepanel;
private JPanel buttonpanel;
private JPanel textpanel;
private JPanel barpanel;


//Constructor
public AttackWindow(boolean b[], int n, Hanteraren handler){
super("Battle!");
super.setBackground(Color.BLACK);
this.getContentPane().setBackground(Color.BLACK);

setLayout(new GridLayout(3,1));
this.handler=handler;

//Buttons
attack = new JButton("Attack");
flee = new JButton("Flee");
flee.addActionListener(this);
attack.addActionListener(this);
//Images
imageicons = new ImageIcon[4];
imageicons[0]=new ImageIcon("C:/Javafiler/Spider.png");

//ProgressBars
spiderbar = new JProgressBar();
playerbar = new JProgressBar();
spiderbar.setValue(100);
playerbar.setValue(100);


//JLabels
imagelabels = new JLabel[4];	
imagelabels[0]= new JLabel(imageicons[0]);
imagelabels[1]= new JLabel(imageicons[1]);
imagelabels[2]= new JLabel(imageicons[2]);
imagelabels[3]= new JLabel(imageicons[3]);

playerlabel = new JLabel();
playerlabel.setText("Player Endurance:" + Integer.toString(handler.getPlayer().getEndurance()));
spiderlabel = new JLabel("Spider Endurance" + Integer.toString(handler.getSpider().getEndurance()));

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
attack.setBackground(Color.WHITE);
flee.setBackground(Color.WHITE);


//Add stuff
textpanel.add(textarea);


if(b[n]==true&& n==0) {
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
beginBattle(this.handler.getSpider(),this.handler.getPlayer());
pack();
}


	
}
@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==flee) {
this.dispose();	
}

else if(e.getSource()==attack) {	
try {	
playerAttack(handler.getSpider(), handler.getPlayer());	
buttonpanel.remove(attack);
buttonpanel.remove(flee);
revalidate();
monsterAttack(handler.getSpider(), handler.getPlayer());
revalidate();

if(handler.getSpider().getEndurance()<=0) {
Thread.sleep(500);
JOptionPane.showMessageDialog(null, "You've slayed the beast!");
Thread.sleep(500);
this.dispose();
}
}
catch(Exception ex) {
ex.printStackTrace();	
}
}
	
}	

//Begin the battle
public void beginBattle(Entity spider, Entity player) {
try {	
if(player.rollTurnOrder()>=spider.rollTurnOrder()) {
textarea.setText("It's your turn to attack!");
buttonpanel.add(attack);	
buttonpanel.add(flee);
revalidate();
}
else {
textarea.setText("Spider begins to attack!");	
buttonpanel.remove(attack);
buttonpanel.remove(flee);
monsterAttack(spider, player);	
revalidate();
}
}
catch(Exception e) {
e.printStackTrace();	
}

}
public void monsterAttack(Entity spider, Entity player) {
try {
if(spider.attackAttempt()>player.dodgeAttempt()) {
textarea.setText("Spider attack player for:" + spider.getAttack() + " " + "Damage!");	
player.setEndurance(player.getEndurance()-spider.getAttack());
playerbar.setValue(playerbar.getValue()-20); // Ska uppdateras
playerlabel.setText("Player Endurance:" + Integer.toString(player.getEndurance()));
buttonpanel.add(attack);
buttonpanel.add(flee);
revalidate();
}	
else {
textarea.setText("The spider missed it's attack!");
beginBattle(handler.getSpider(), handler.getPlayer());
}
}
catch(Exception e) {
e.printStackTrace();	
}
}
public void playerAttack(Entity spider, Entity player) {
try {	
if(player.attackAttempt()>spider.dodgeAttempt()) {
textarea.setText("Player attacked spider for " + player.getAttack() + " " + "Damage");	
spider.setEndurance(spider.getEndurance()-1);	
spiderlabel.setText("Spider Endurance:" +  Integer.toString(spider.getEndurance()));
spiderbar.setValue(spider.getEndurance());
buttonpanel.remove(attack);
buttonpanel.remove(flee);
revalidate();
}
else {
textarea.setText("The player missed!");
JOptionPane.showMessageDialog(null, "You missed!");
Thread.sleep(1000);
monsterAttack(spider,player);	
}
}
catch(Exception e) {
e.printStackTrace();	
}
}


}
