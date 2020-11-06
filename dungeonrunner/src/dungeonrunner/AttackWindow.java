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
setLayout(new GridLayout(3,1));
this.handler=handler;

//Buttons
attack = new JButton("Attack");
flee = new JButton("Flee");
flee.addActionListener(this);

//Images
imageicons = new ImageIcon[4];
imageicons[0]=new ImageIcon("C:/Javafiler/Spider.png");

//ProgressBars
spiderbar = new JProgressBar();
playerbar = new JProgressBar();
spiderbar.setValue(handler.getSpider().getEndurance());
playerbar.setValue(handler.getPlayer().getEndurance());

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
setBackground(Color.BLACK);
setVisible(true);


//Panels
imagepanel = new JPanel();
imagepanel.setSize(200,200);
buttonpanel = new JPanel();
textpanel = new JPanel();
barpanel = new JPanel();



//Add stuff
buttonpanel.add(attack);
buttonpanel.add(flee);
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
pack();
}
else if(b[n]==true & n==1) {
	
}

	
}
@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==flee) {
this.dispose();	
}
	
}	

}
