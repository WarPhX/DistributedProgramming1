import java.awt.TextField;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Color;
import java.applet.Applet;
import netscape.javascript.JSObject;

public class VisualCmmdc extends Applet{
  String mField,nField;
  TextField rez=new TextField();
  JSObject window;
  
  public void init(){
	  window=JSObject.getWindow(null);
    window.call("apel",null);
    mField=(String)window.getMember("mField");
    nField=(String)window.getMember("nField");
    GridLayout gl=new GridLayout(1,1,10,30);
    setLayout(gl);
    rez.setEditable(false);
    add(rez);
	}

	public void paint(Graphics g){
    /*
    window.call("apel",null);
    mField=(String)window.getMember("mField");
    nField=(String)window.getMember("nField");
    */
  	long m=Long.parseLong(mField);
  	long n=Long.parseLong(nField);
  	long c=cmmdc(m,n);
    String s="Cmmdc ( "+mField+" , "+nField+" ) = ";
  	rez.setText(s+((new Long(c)).toString()));
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
