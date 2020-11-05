package dungeonrunner;



import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AttackWindow extends JFrame implements ActionListener{

//Imageicons
private ImageIcon imageicons[];

//JButtons
private JButton attack;
private JButton flee;

//Jtextarea
private JTextArea textarea;

//JLabels
private JLabel imagelabels[];


//JPanels
private JPanel imagepanel;
private JPanel buttonpanel;
private JPanel textpanel;


//Constructor
public AttackWindow(){
super("Battle!");
setLayout(new GridLayout(3,1));



//Images
imageicons = new ImageIcon[3];



//JLabels
imagelabels = new JLabel[3];	
imagelabels[0]= new JLabel(imageicons[0]);
imagelabels[1]= new JLabel(imageicons[1]);
imagelabels[2]= new JLabel(imageicons[2]);

//Textarea
textarea = new JTextArea(5,5);
/* lägg till strings från monsterklasserna
 * t.ex "Spider attacked for x damage" eller "Player lost x hp"
 * Förslagsvis lägg in som methods i Entityklassen "attackMessage()";
 */
setPreferredSize(new Dimension(300,300));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

//Panels
imagepanel = new JPanel();
buttonpanel = new JPanel();
textpanel = new JPanel();



//Add stuff
buttonpanel.add(attack);
buttonpanel.add(flee);
textpanel.add(textarea);


	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}	

}
