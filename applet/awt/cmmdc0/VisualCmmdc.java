import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class VisualCmmdc extends Applet implements ActionListener{
  TextField tm,tn,rez;
   
  public void init(){
    setBackground(Color.yellow);
    GridLayout gl=new GridLayout(3,2,30,20);
    setLayout(gl);
    Label lm=new Label("Primul numar:");
    add(lm);
    tm=new TextField("1",5);
    add(tm);
    Label ln=new Label("Al doilea numar:");
    add(ln);
    tn=new TextField("1",5);
    add(tn);
    Button compute=new Button("Calculeaza");
    compute.addActionListener(this);
    add(compute);
    rez=new TextField("1",5);
    rez.setEditable(false);
    add(rez);
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
