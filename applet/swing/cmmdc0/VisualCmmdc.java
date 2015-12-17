import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VisualCmmdc extends JApplet implements ActionListener{
  JTextField tm,tn,rez;
 
  public void init() {
    Container content = getContentPane();
    content.setBackground(Color.yellow);
    setLayout(new GridLayout(3,2,30,20)); 
    JLabel lm=new JLabel("Primul numar:");
    content.add(lm);
    tm=new JTextField("1",5);
    content.add(tm);
    JLabel ln=new JLabel("Al doilea numar:");
    content.add(ln);
    tn=new JTextField("1",5);
    content.add(tn);
    JButton compute=new JButton("Calculeaza");
    compute.addActionListener(this);
    content.add(compute);
    rez=new JTextField("1",5);
    rez.setEditable(false);
    content.add(rez);
    setVisible(true);
	}

	public void paint(Graphics g){
  	String sm=tm.getText();
  	long m=Long.parseLong(sm);
  	String sn=tn.getText();
  	long n=Long.parseLong(sn);
  	long c=cmmdc(m,n);
  	rez.setText((new Long(c)).toString());
	}

	public void actionPerformed(ActionEvent ae){
    repaint();
  }

  long cmmdc(long m, long n){
    long c,r;
    do{
      c=n;
      r=m % n;
      m=n;
      n=r;
    }
    while (r!=0);
    return c;
  }
}
